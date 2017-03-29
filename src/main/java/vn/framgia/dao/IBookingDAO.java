package vn.framgia.dao;

import vn.framgia.model.Booking;
import java.util.List;

public interface IBookingDAO extends IGenericDAO<Booking, Integer>{
	public List<Booking> findAllOrderClientId();
	public List<Booking> findBillByNameClient(String nameClient);
}
