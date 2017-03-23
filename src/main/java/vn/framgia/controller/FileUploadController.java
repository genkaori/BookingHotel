package vn.framgia.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import vn.framgia.service.IFileUploadService;

@Controller
public class FileUploadController {
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private IFileUploadService fileUploadService;

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String showUploadFile(HttpServletRequest request) {
		return "Upload";
	}

	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public String handleFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile[] fileUpload)
			throws Exception {
		if (fileUploadService.saveFile(fileUpload))
			return "index";
		else
			return null;
	}

}
