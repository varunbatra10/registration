package com.digilytics.registration.controller;

import java.io.IOException;

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

@RestController
@RequestMapping(value = "")
public class RegController {

	@Autowired
	RegService regService;

	@PostMapping(value = "register")
	public ResponseDto register(@RequestParam(value = "users") MultipartFile users) {
		return regService.register(users);
	}

	@GetMapping(value = "download/{fileName}")
	public void downloadErrorFile(@PathVariable String fileName, HttpServletResponse response) throws IOException {
		regService.downloadErrorFile(fileName, response);
	}

}