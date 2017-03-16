package vn.framgia.dao.impl;

import vn.framgia.dao.GenericDAO;
import vn.framgia.dao.IUserDAO;
import vn.framgia.model.User;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class UserDAOImpl extends GenericDAO<User, Long> implements IUserDAO {
    public UserDAOImpl() {
        super.setPersistentClass(User.class);
    }

    @Override
    public User getUserByAcount(String username) {
        return null;
    }
}
