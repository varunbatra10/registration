package com.digilytics.registration.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.digilytics.registration.Dto.ResponseDto;
import com.digilytics.registration.service.RegService;

/**
 * 
 * @author vabatra
 *
 */
@RestController
@RequestMapping(value = "")
public class RegController {

	static Logger log = Logger.getLogger(RegController.class.getName());
	
	@Autowired
	RegService regService;

	/**
	 * 
	 * @param users
	 * @return
	 */
	@PostMapping(value = "/register")
	public ResponseDto register(@RequestParam MultipartFile users) {
		log.info("RegController:register() started");
		return regService.register(users);
	}

	/**
	 * 
	 * @param fileName
	 * @param response
	 * @throws IOException
	 */
	@GetMapping(value = "download/{fileName}")
	public void downloadErrorFile(@PathVariable String fileName, HttpServletResponse response) throws IOException {
		log.info("RegController:downloadErrorFile() started");
		regService.downloadErrorFile(fileName, response);
	}

}