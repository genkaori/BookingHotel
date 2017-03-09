package vn.framgia.dao;

import java.io.Serializable;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import vn.framgia.bean.UserBean;
import vn.framgia.model.User;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class UserDAO extends GenericDAO<User, Integer> implements IUserDAO{
	@Autowired
	SessionFactory sessionFactory;
    public UserDAO() {
        super.setPersistentClass(User.class);
    }

	@Override
	public List getListUser() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List userList = session.createQuery("from User").list();
		session.close();
		
		return userList;
	}

	@Override
	public int deleteUser(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction =  session.beginTransaction();
		UserBean userBean = (UserBean)session.load(UserBean.class, id);
		session.delete(userBean);
		transaction.commit();
		Serializable slz = session.getIdentifier(userBean);
		session.close();
		return (Integer)slz;
		
	}
}
