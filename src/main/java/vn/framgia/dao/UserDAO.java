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
public class UserDAO extends GenericDAO<User, Integer> implements IUserDAO {
	@Autowired
	SessionFactory sessionFactory;

	public UserDAO() {
		super.setPersistentClass(User.class);
	}
}
