//package com.digilytics;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Rule;
//import org.junit.jupiter.api.Test;
//import org.junit.rules.TemporaryFolder;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.mockito.InjectMocks;
//import org.mockito.Spy;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.digilytics.registration.controller.RegController;
//
//@RunWith(MockitoJUnitRunner.class)
//public class RegApplicationTest {
//
//	@LocalServerPort
//	private int port;
//
//	@Autowired
//	private TestRestTemplate restTemplate;
//
//	private InputStream is;
//    private MockMvc mockMvc;
//    
//	@Spy
//    @InjectMocks
//    private RegController  controller = new RegController();
//    @Before
//    public void init() {
//        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//        is = controller.getClass().getClassLoader().getResourceAsStream("abc.csv");
//    }
//	@Test
//	public void a() {
//		MockMultipartFile mockMultipartFile;
//		try {
//			String expectedJson = "{\r\n" + 
//					"    \"no_of_rows_parsed\": 2,\r\n" + 
//					"    \"no_of_rows_failed\": 2,\r\n" + 
//					"    \"error_file_url\": \"localhost:8080/error.csv\"\r\n" + 
//					"}";
//			mockMultipartFile = new MockMultipartFile("users", "abc.csv", "multipart/form-data", is);
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.fileUpload("/upload").file(mockMultipartFile).contentType(MediaType.MULTIPART_FORM_DATA))
//               .andReturn();
//        Assert.assertEquals(200, result.getResponse().getStatus());
//        Assert.assertNotNull(result.getResponse().getContentAsString());
////        Assert.assertEquals("excel.xlsx", result.getResponse().getContentAsString());
//        assertEquals(expectedJson, result.getResponse());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			
//	}
//
//}
