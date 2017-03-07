package vn.framgia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vn.framgia.bean.UserBean;
import vn.framgia.service.IUserService;
import vn.framgia.util.Helpers;

import java.util.HashMap;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		logger.info("Welcome index page! The client locale");
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("attributes", "Xin chao cac ban!");

		List<UserBean> userInfoList = userService.findAll();
		System.out.println("--X--" + userInfoList);
		if (!Helpers.isEmpty(userInfoList)) {
			for (UserBean userInfo : userInfoList) {
				System.out.println("id---------------:" + userInfo.getEmail());
			}
		}

		return new ModelAndView("index", model);
	}

	@RequestMapping(value = "/addUser")
	public String addUser(Model model) {
		UserBean user = new UserBean();
		model.addAttribute("userForm", user);
		return "addUser";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(Model model, @ModelAttribute(value = "userForm") UserBean userForm,
			BindingResult result) {
		boolean check = true;
		if (Helpers.isEmpty(userForm.getFullname())) {
			result.reject("fullname", "full name not emptry");
			check = false;
		}
		if (Helpers.isEmpty(userForm.getPassword())) {

			result.reject("password", "password is not emptry");
			check = false;
		}
		if (Helpers.isEmpty((userForm.getUsername()))) {
			result.reject("username", "username is emptry");
		}
		if (Helpers.isEmpty(userForm.getEmail())) {
			result.reject("email", "email is not emptry");
			check = false;
		}
		if (Helpers.isEmpty(userForm.getPhone())) {
			result.reject("phone", "phone is not emptry");
			check = false;
		}
		if (Helpers.isEmpty(userForm.getRole())) {
			result.reject("role", "not emptry role");
			check = false;
		}
		if (!check) {
			return new ModelAndView("addUser");
		}
		System.out.println("add userr............");
		userService.addUser(userForm);
		System.out.println("add userr success............");
		return new ModelAndView("redirect:index");

	}
}
