package vn.framgia.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.framgia.bean.UserBean;
import vn.framgia.service.IUserService;
import vn.framgia.util.Helpers;
import vn.framgia.util.InputCondition;

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
        System.out.println("--X--"+userInfoList);
        if (!Helpers.isEmpty(userInfoList)) {
            for (UserBean userInfo : userInfoList) {
                System.out.println("id---------------:"+userInfo.getEmail());
            }
        }
        return new ModelAndView("index",	model);
    }
    
	@RequestMapping(value = "/listUser", method = RequestMethod.GET)
	public ModelAndView showListUsers() {
		ModelAndView model = new ModelAndView("listUser");
		List<UserBean> listUser = userService.findAll();
		if (listUser == null)
			model.addObject("listUsersIsEmpty", "List users is empty");
		else
			model.addObject("listUser", listUser);
		return model;
	}
    
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(@RequestParam int id) {
		boolean check = true;
		check = userService.deleteUser(id);
		ModelAndView model = new ModelAndView();
		if (!check) {
			model.setViewName("listUser");
			model.addObject("errDeleteUser", "delete user has error");
			return model;
		}
		return new ModelAndView("redirect:listUser");
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String createUser(Model model, @ModelAttribute(value = "userForm") UserBean userForm) {
		UserBean user = new UserBean();
		model.addAttribute("userForm", user);
		return "newUser";
	}
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public ModelAndView createUser(Model model, @ModelAttribute(value = "userForm") UserBean userForm,
			BindingResult result, HttpServletRequest request) {
		boolean check = true;
		String phone = userForm.getPhone();
		String email = userForm.getEmail();
		String role = request.getParameter("role");
		if (Helpers.isEmpty(userForm.getFullname())) {
			result.reject("fullname", "Please enter Full Name!");
			check = false;
		}
		if (Helpers.isEmpty(userForm.getUsername())) {
			result.reject("username", "Please enter Username!");
			check = false;
		}
		if (Helpers.isEmpty(userForm.getPassword())) {
			result.reject("password", "Please enter Password!");
			check = false;
		}
		if (Helpers.isEmpty(email)) {
			result.reject("email", "Please enter your Email!");
			check = false;
		} else {
			if (!InputCondition.isEmailValid(email)) {
				result.reject("email", "Format email invalid!");
				check = false;
			}
		}
		if (Helpers.isEmpty(phone)) {
			result.reject("phone", "Please enter your phone!");
			check = false;
		} else {
			if (!InputCondition.isPhoneNumberValid(phone)) {
				result.reject("phone", "Phone number input invalid!");
				check = false;
			}
		}
		if (!check) {
			return new ModelAndView("newUser");
		}
		userForm.setRole(role);
		userService.createUser(userForm);
		logger.info("add userr success............");
		return new ModelAndView("redirect:index");
	}
}
