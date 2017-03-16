package vn.framgia.service;

import java.io.Serializable;
import java.util.List;

import vn.framgia.bean.UserBean;
import vn.framgia.security.CustomUserDetail;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public interface IUserService extends Serializable{

    public List<UserBean> findAll();
    public void createUser(UserBean userBean);
    public boolean deleteUser(long id);
    public CustomUserDetail getUserByAcount(String username);
    public UserBean getUserById(long id);
    public boolean updateUser(UserBean userBean);
}
