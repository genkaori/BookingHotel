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
}
