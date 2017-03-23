package vn.framgia.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import vn.framgia.dao.GenericDAO;
import vn.framgia.dao.IBillDAO;
import vn.framgia.model.Bill;

public class BillDAOImpl extends GenericDAO<Bill, Integer> implements IBillDAO {

	@Override
	public List<Bill> findBillByBooKing(String bookingId) {
		Criteria criterion = getSession().createCriteria(Bill.class);
		criterion.add(Restrictions.eq("bookingId.id", Integer.valueOf(bookingId)));
		return criterion.list();
	}

}
