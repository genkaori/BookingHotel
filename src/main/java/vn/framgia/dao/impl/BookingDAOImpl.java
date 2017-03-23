package vn.framgia.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import vn.framgia.dao.GenericDAO;
import vn.framgia.dao.IBookingDAO;
import vn.framgia.model.Booking;

public class BookingDAOImpl extends GenericDAO<Booking, Integer> implements IBookingDAO{
	public BookingDAOImpl(){
		super.setPersistentClass(Booking.class);
	}

	@Override
	public List<Booking> findAllOrderClientId() {
		Criteria criteria = getSession().createCriteria(Booking.class);
		criteria.addOrder(Order.desc("client.id"));
		return criteria.list();
	}
	
	@Override
	public List<Booking> findBillByNameClient(String stringSearch) {
		Criteria criteria = getSession().createCriteria(Booking.class);
		criteria.createAlias("client", "client");
		Criterion criterionName = Restrictions.like("client.fullName", "%"+stringSearch+"%");
		Criterion criterionCMT = Restrictions.eq("client.cardNumber", stringSearch);
		Criterion criterionPhone = Restrictions.eq("client.phone", stringSearch);
		Criterion criterionAddress = Restrictions.like("client.address", "%"+stringSearch+"%");
		
		criteria.add(Restrictions.or(
				Restrictions.or(criterionCMT, criterionPhone),
				Restrictions.or(criterionName, criterionAddress)));

		return criteria.list();
	}
}
