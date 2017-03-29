package vn.framgia.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.mvel2.sh.command.basic.Help;

import vn.framgia.bean.BillBean;
import vn.framgia.bean.PaymentBean;
import vn.framgia.bean.PaymentDetail;
import vn.framgia.model.Bill;
import vn.framgia.model.Booking;
import vn.framgia.model.UsedItem;
import vn.framgia.model.User;
import vn.framgia.service.IPaymentService;
import vn.framgia.util.Helpers;

public class PaymentServiceImpl extends BaseserviceImpl implements IPaymentService {
	private static final Logger logger = Logger.getLogger(PaymentServiceImpl.class);
			
	@Override
	public PaymentBean getinfoPayment(Integer bookingId) {
		PaymentBean paymentBean = new PaymentBean();
		try{
			Booking booking = bookingDAO.findById(bookingId);
			if(booking == null){
				return paymentBean;
			}
			paymentBean.setBookingId(bookingId);
			paymentBean.setNameClient(booking.getClient().getFullName());
			int total = (int)(float)(booking.getTotalPrice());
			int refunded = getTotalPaymentAmountByBooking(bookingId);
			paymentBean.setRefunded(refunded);
			if (refunded >= total) {
				paymentBean.setRemain(PaymentBean.ZERO_NUMBER);
			} else {
				paymentBean.setRemain(total - refunded);
			}
			paymentBean.setRoom(booking.getRoom().getName());
			paymentBean.setTotal(total);
			paymentBean.setPaymentDetails(getpaymentDetail(bookingId, booking.getRoom().getPrice()));
			paymentBean.setHistoryPayment(getHistoryPaymentbyBooking(String.valueOf(bookingId)));
		}catch(Exception e){
			logger.error("ERROR GET INFO PAYMENT: ", e);
		}
		return paymentBean;
	}

	@Override
	public boolean savePayment(BillBean billBean) {
		try{
			Bill bill = new Bill();
			bill.setBooking(new Booking(billBean.getBookingId()));
			bill.setPaymentDate(new Date());
			bill.setPaymentAmount((float)(int)billBean.getPaymentAmount());
			bill.setNote(billBean.NOTE);
			bill.setUser(new User(billBean.getUserId()));
			billDAO.save(bill);
			return true;
		}catch(Exception e){
			logger.info("ERROR SAVE PAYMENT: ", e); 
		}
		return false;
	}
	
	public int getTotalPaymentAmountByBooking(Integer bookingId){
		int result = 0;
		try{
			List<Bill> lstbill = billDAO.findBillByBooKing(String.valueOf(bookingId));
			if(Helpers.isEmpty(lstbill)){
				return result;
			}
			for(Bill bill : lstbill){
				result += bill.getPaymentAmount();
			}
		}catch(Exception e){
			logger.error("ERROR GET PAYMENT AMOUNT: ", e);
		}
		return result;
	}
	
	public int getTotalPriceService(Integer bookingId){
		int totalPrice = 0;
		try{
			List<UsedItem> lstUsedItems = userServiceDAO.findServiceByBookingId(bookingId);
			if(Helpers.isEmpty(lstUsedItems)){
				return totalPrice;
			}
			for(UsedItem userItem : lstUsedItems){
				totalPrice += userItem.getItem().getPrice();
			}
		}catch(Exception e){
			logger.error("ERROR GET TOTAL PRICE: ",e);
		}
		return totalPrice;
	}
	
	public List<PaymentDetail> getpaymentDetail(Integer bookingId, Float priceRoom) {
		List<PaymentDetail> lstPaymentDetail = new ArrayList<PaymentDetail>();
		try {
			List<UsedItem> lstUserItems = userServiceDAO.findServiceByBookingId(bookingId);
			if (Helpers.isEmpty(lstUserItems)) {
				return lstPaymentDetail;
			}
			lstPaymentDetail.add(new PaymentDetail("Room", (int)(float)priceRoom));
			for (UsedItem userItem : lstUserItems) {
				lstPaymentDetail.add(new PaymentDetail(userItem.getItem()
						.getName(), (int)userItem.getItem().getPrice()));
			}
		} catch (Exception e) {
			logger.error("ERROR GET PAYMENT DETAIL: ", e);
		}
		return lstPaymentDetail;
	}
	
	public List<BillBean> getHistoryPaymentbyBooking(String bookingId){
		List<BillBean> lstHistory = new ArrayList<BillBean>();
		try{
			List<Bill> lstBill = billDAO.findBillByBooKing(bookingId);
			if(Helpers.isEmpty(lstBill)){
				return lstHistory;
			}
			for(Bill bill : lstBill){
				lstHistory.add(new BillBean(Helpers.convertDatetoString(bill
						.getPaymentDate()), (int)(float)bill.getPaymentAmount(), bill
						.getNote(), bill.getUser().getFullname()));
			}
		}catch(Exception e){
			logger.error("ERROR GET HISTORY PAYMENT BY BOOKINGID: ", e);
		}
		return lstHistory;
	}

}
