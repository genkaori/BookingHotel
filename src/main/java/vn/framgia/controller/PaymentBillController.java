package vn.framgia.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.framgia.bean.BillBean;
import vn.framgia.bean.PaymentBean;
import vn.framgia.service.IPaymentService;
import vn.framgia.util.Helpers;

@Controller
public class PaymentBillController {
	private static final Logger logger = Logger.getLogger(PaymentBillController.class);
	@Autowired
	private IPaymentService paymentService;
	
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public ModelAndView redirectPaymentPags(@RequestParam("id") Integer bookingId){
		logger.info("------show list booking by client");
		Map<String, Object> model = new HashMap<String, Object>();
		PaymentBean paymentBeans = paymentService.getinfoPayment(bookingId);
		model.put("paymentBean", paymentBeans);
		return new ModelAndView("payment", model);
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public ModelAndView paymentBill(
			@RequestParam("payrefuned") String payrefuned,
			@RequestParam("bookingId") String bookingId) {
		logger.info("------submit payment");
		Map<String, Object> model = new HashMap<String, Object>();
		if(!Helpers.isEmpty(payrefuned) && !Helpers.isEmpty(bookingId)){
			boolean response = paymentService.savePayment(new BillBean(Integer.valueOf(payrefuned), Integer.valueOf(bookingId), Helpers.getIdUser()));
			logger.info("Save payment-------: "+response);
		}
		PaymentBean paymentBeans = paymentService.getinfoPayment(Integer.valueOf(bookingId));
		model.put("paymentBean", paymentBeans);
		return new ModelAndView("payment", model);
	}
}
