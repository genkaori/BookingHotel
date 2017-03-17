package vn.framgia.service.impl;

import vn.framgia.dao.IBookingDAO;
import vn.framgia.dao.IHotelDAO;
import vn.framgia.dao.IRoomDAO;
import vn.framgia.dao.IUserDAO;

import java.io.Serializable;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class BaseserviceImpl implements Serializable {

    protected IUserDAO userDAO;
    protected IRoomDAO roomDAO;
    protected IHotelDAO hotelDAO;
    protected IBookingDAO bookingDAO;

    public IUserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public IRoomDAO getRoomDAO() {
        return roomDAO;
    }

    public void setRoomDAO(IRoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public IHotelDAO getHotelDAO() {
        return hotelDAO;
    }

    public void setHotelDAO(IHotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

	public IBookingDAO getBookingDAO() {
		return bookingDAO;
	}

	public void setBookingDAO(IBookingDAO bookingDAO) {
		this.bookingDAO = bookingDAO;
	}
    
}
