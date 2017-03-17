package vn.framgia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import vn.framgia.bean.ShowBookingBean;
import vn.framgia.model.Booking;
import vn.framgia.service.IBookingService;
import vn.framgia.util.Helpers;

public class BookingServiceImpl extends BaseserviceImpl implements IBookingService {
	private static final Logger logger = Logger.getLogger(Booking.class);

	public List<List<ShowBookingBean>> showBooking(List<Booking> listBooking) {
		try {
			List<List<ShowBookingBean>> results = new ArrayList<List<ShowBookingBean>>();
			if (!Helpers.isEmpty(listBooking)) {
				List<ShowBookingBean> listObj = null;
				ShowBookingBean bookingBean = null;
				int buffer = 0;
				for (Booking book : listBooking) {
					if(buffer != book.getClientId().getId() && buffer != 0) {
						results.add(listObj);
					}
					if(buffer != book.getClientId().getId()){
						listObj = new ArrayList<ShowBookingBean>();
					}
					bookingBean = new ShowBookingBean();
					bookingBean.setNameClient(book.getClientId().getFullName());
					bookingBean.setNameRoom(book.getRoomId().getName());
					bookingBean.setCheckIn(Helpers.convertDatetoString(book.getCheckIn()));
					bookingBean.setCheckOut(Helpers.convertDatetoString(book.getCheckOut()));
					bookingBean.setPriceRoom(book.getTotalPrice());
					bookingBean.setStatus(false);//TODO
					
					listObj.add(bookingBean);
					buffer = book.getClientId().getId();
				}
				results.add(listObj);
				return results;
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public List<List<ShowBookingBean>> findAllBookingOrderByDesc() {
		try{
			List<Booking> listBooking = bookingDAO.findAllOrderClientId();
			if(!Helpers.isEmpty(listBooking)){
				return showBooking(listBooking);
			}
		}catch(Exception e){
			logger.error(e);
		}
		return null;
	}
	
	@Override
	public List<List<ShowBookingBean>> searchBookingByNameClient(String nameClient) {
		try {
			List<Booking> listBooking = bookingDAO.findBillByNameClient(nameClient);
			if (!Helpers.isEmpty(listBooking)) {
				return showBooking(listBooking);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
}
