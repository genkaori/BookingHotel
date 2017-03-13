package vn.framgia.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import vn.framgia.util.Helpers;
import vn.framgia.bean.UserBean;
import vn.framgia.model.User;

import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class UserService extends Baseservice implements IUserService {
	private static final Logger logger = Logger.getLogger(UserService.class);

	public List<UserBean> findAll() {
		try {
			List<User> userList = userDAO.findAll();
			if (!Helpers.isEmpty(userList)) {
				List<UserBean> userInfoList = new ArrayList<UserBean>();
				for (User user : userList) {
					UserBean userInfo = new UserBean();
					BeanUtils.copyProperties(user, userInfo);
					userInfoList.add(userInfo);
				}
				return userInfoList;
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public boolean deleteUser(int id) {
		try {
			User user = userDAO.findById(id);
			userDAO.delete(user);
			return true;
		} catch (Exception e) {
			logger.debug("delete user excepton: " + e);
		}
		return false;
	}

	@Override
	public UserBean getUserById(int id) {
		try {
			User user = userDAO.findById(id);
			UserBean userBean = new UserBean();
			userBean.setId(user.getId());
			userBean.setFullname(user.getFullname());
			userBean.setUsername(user.getUsername());
			userBean.setPassword(user.getPassword());
			userBean.setEmail(user.getEmail());
			userBean.setPhone(user.getPhone());
			userBean.setRole(user.getRole());

			return userBean;

		} catch (Exception e) {
			logger.debug(e);
		}
		return null;
	}

	@Transactional
	@Override
	public boolean updateUser(UserBean userBean) {
		System.out.println("start update user");
		try {
			System.out.println("try catch");
			User user = userDAO.findById(userBean.getId());
			System.out.println("id update" + userBean.getId());
			user.setFullname(userBean.getFullname());
			user.setUsername(userBean.getUsername());
			user.setPassword(user.getPassword());
			user.setEmail(userBean.getEmail());
			user.setPhone(userBean.getPhone());
			user.setRole(userBean.getRole());
			System.out.println("save user");
			userDAO.save(user);
			System.out.println("user info" + userBean.getId() + ", " + userBean.getUsername());
			return true;
		} catch (Exception e) {
			logger.debug("update user exception: " + e);
		}
		return false;
	}

}
