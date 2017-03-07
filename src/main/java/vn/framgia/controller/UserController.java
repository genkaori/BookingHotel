package vn.framgia.controller;

import org.mvel2.sh.command.basic.Help;
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

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView index() {
		logger.info("Welcome index page! The client locale");
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("attributes", "Xin chao cac ban!");

		List<UserBean> userInfoList = userService.findAll();
		if (!Helpers.isEmpty(userInfoList)) {
			for (UserBean userInfo : userInfoList) {
				logger.info("id---------------:" + userInfo.getEmail());
			}
		}

		return new ModelAndView("index", model);
	}

	@RequestMapping(value = "/newUser")
	public String addUser(Model model) {
		UserBean user = new UserBean();
		model.addAttribute("userForm", user);
		return "newUser";
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public ModelAndView addUser(Model model, @ModelAttribute(value = "userForm") UserBean userForm,
			BindingResult result) {
		boolean checkEmptry = true;
		if (Helpers.isEmpty(userForm.getUsername()) || Helpers.isEmpty(userForm.getPassword())) {

		}
		if (!checkEmptry) {
			return new ModelAndView("newUser");
		}
		System.out.println("add userr............");
		userService.addUser(userForm);
		System.out.println("add userr success............");
		return new ModelAndView("redirect:index");

	}

}
