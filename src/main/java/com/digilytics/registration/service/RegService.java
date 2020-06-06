package com.digilytics.registration.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.digilytics.registration.Dto.ResponseDto;
import com.digilytics.registration.model.User;
import com.digilytics.registration.repository.RoleRepository;
import com.digilytics.registration.repository.UserRepository;
import com.digilytics.registration.util.EmailVerification;
import com.opencsv.CSVWriter;

@Service(value = "regService")
public class RegService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	public ResponseDto register(MultipartFile users) {
		ResponseDto response = new ResponseDto();
		try {
			InputStream is = users.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = "";
			String[] tempArr;
			int count = 0;
			String errorFileName = "error.csv";
			File file;
			FileWriter fileWriter;
			CSVWriter csvWriter = null;
			int countTwo = 0;
			int pass = 0;
			int fail = 0;
			while ((line = br.readLine()) != null) {
				count++;
				if (count > 1) {
					tempArr = line.split(",");
					Boolean emailCheck = EmailVerification.emailValidator(tempArr[0]);
					Boolean roleCheck = roleRepository.findByRoleName(tempArr[2]) != null;
					if (emailCheck && roleCheck) {
						User user = new User();
						user.setEmail(tempArr[0]);
						user.setName(tempArr[1]);
						user.setRoleName(tempArr[2]);
						userRepository.save(user);
						pass++;
					} else {
						if (countTwo < 1) {
							file = new File(errorFileName);
							fileWriter = new FileWriter(file);
							csvWriter = new CSVWriter(fileWriter);
							String[] header = { "Email", "Name", "Roles", "Errors" };
							csvWriter.writeNext(header);
						}
						String[] arr = { tempArr[0], tempArr[1], tempArr[2], null };
						StringBuilder sb = new StringBuilder();
						sb.append(emailCheck ? "": "Invalid Email");
						sb.append(roleCheck ? "":((emailCheck == false ? "#" : "") + "Invalid Role" + tempArr[2]));
						arr[3] = sb.toString();
						csvWriter.writeNext(arr);
						countTwo++;
						fail++;

					}
				}
			}
			response.setNo_of_rows_parsed(pass);
			response.setNo_of_rows_failed(fail);
			response.setError_file_url("localhost:8080/" + errorFileName);
			csvWriter.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public HttpServletResponse downloadErrorFile(String fileName, HttpServletResponse response) throws IOException {
		File file = new File(fileName);
		if (file.exists()) {

			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}
			response.setContentType(mimeType);
			response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

			response.setContentLength((int) file.length());

			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

			FileCopyUtils.copy(inputStream, response.getOutputStream());
		}
		return response;
	}
}
