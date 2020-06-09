package com.digilytics;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.digilytics.registration.controller.RegController;
import com.digilytics.registration.service.RegService;

@RunWith(SpringRunner.class)
@ContextConfiguration
@AutoConfigureMockMvc
public class RegApplicationTest {
	// bind the above RANDOM_PORT
	@LocalServerPort
	private int port;


	private MockMvc mockMvc;

	@Mock
	private RegService regService;

	@InjectMocks
	private RegController regController;

	@Test
	public void testFileUpload() throws Exception {
		try {
			MockMultipartFile file = new MockMultipartFile("users", "abc.csv", "text/csv", "users".getBytes());

			MockitoAnnotations.initMocks(this);
			mockMvc = MockMvcBuilders.standaloneSetup(regController).build();

			this.mockMvc.perform(MockMvcRequestBuilders.multipart("/register").file(file).header("content-type",
					"application/*+json")).andExpect(status().is(200));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 @Test
	    public void testDownloadFile() throws Exception {
			MockitoAnnotations.initMocks(this);
			mockMvc = MockMvcBuilders.standaloneSetup(regController).build();
	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/download/error.csv").contentType(MediaType.APPLICATION_OCTET_STREAM)).andExpect(MockMvcResultMatchers.status().is(200)).andReturn();
	        Assert.assertEquals(200, result.getResponse().getStatus());
	    }


}
