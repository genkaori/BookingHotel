package vn.framgia.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Bill implements Serializable {
	private Integer id;
	private Date paymentDate;
	private Float paymentAmount;
	private String note;
	private Booking booking;
	private User user;

	public Bill() {
		super();
	}

	public Bill(int id, Date paymentDate, Float paymentAmount, String note,
			Booking booking, User user) {
		super();
		this.id = id;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
		this.note = note;
		this.booking = booking;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Booking getBookingId() {
		return booking;
	}

	public void setBookingId(Booking bookingId) {
		this.booking = bookingId;
	}

	public User getUserId() {
		return user;
	}

	public void setUserId(User userId) {
		this.user = userId;
	}

}
