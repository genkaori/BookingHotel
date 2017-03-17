package vn.framgia.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Booking implements Serializable {
	private Integer id;
	private Date checkIn;
	private Date checkOut;
	private Float totalPrice;
	private String note;
	private Client clientId;
	private Room roomId;
	private Integer isCheckIn;

	public Booking() {
		super();
	}

	public Booking(Integer id, Date checkIn, Date checkOut, Float totalPrice,
			String note, Client clientId, Room roomId, Integer isCheckIn) {
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.totalPrice = totalPrice;
		this.note = note;
		this.clientId = clientId;
		this.roomId = roomId;
		this.isCheckIn = isCheckIn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Client getClientId() {
		return clientId;
	}

	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}

	public Room getRoomId() {
		return roomId;
	}

	public void setRoomId(Room roomId) {
		this.roomId = roomId;
	}

	public Integer getIsCheckIn() {
		return isCheckIn;
	}

	public void setIsCheckIn(Integer isCheckIn) {
		this.isCheckIn = isCheckIn;
	}

}
