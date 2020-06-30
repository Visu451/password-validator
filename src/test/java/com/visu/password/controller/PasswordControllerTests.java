package com.visu.password.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PasswordControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void passwordInvalidTest() throws Exception {

		this.mockMvc.perform(post("/validate").param("userid", "visu")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"credential\":\"visu1234567890\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isBadRequest());
	}
	
	@Test
	public void passwordInvalid2Test() throws Exception {

		this.mockMvc.perform(post("/validate").param("userid", "visu")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"credential\":\"Visu123\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isBadRequest());
	}
	
	@Test
	public void passwordInvalid3Test() throws Exception {

		this.mockMvc.perform(post("/validate").param("userid", "visu")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"credential\":\"Visu@123\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isBadRequest());
	}
	
	@Test
	public void passwordInvalid4Test() throws Exception {

		this.mockMvc.perform(post("/validate").param("userid", "visu")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"credential\":\"visu\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isBadRequest());
	}
	
	@Test
	public void passwordInvalid5Test() throws Exception {

		this.mockMvc.perform(post("/validate").param("userid", "visu")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"credential\":\"visuvisu\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isBadRequest());
	}
	
	@Test
	public void passwordInvalid6Test() throws Exception {

		this.mockMvc.perform(post("/validate").param("userid", "visu")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"credential\":\"123456789\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isBadRequest());
	}
	
	@Test
	public void passwordInvalid7Test() throws Exception {

		this.mockMvc.perform(post("/validate").param("userid", "visu")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"credential\":\"visu123123\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isBadRequest());
	}
	
	@Test
	public void passwordInvalid8Test() throws Exception {

		this.mockMvc.perform(post("/validate").param("userid", "visu")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"credential\":\"vissu123\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isBadRequest());
	}
	
	@Test
	public void passwordInvalid9Test() throws Exception {

		this.mockMvc.perform(post("/validate").param("userid", "visu")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"credential\":\"Vissu@1231234567890\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isBadRequest());
	}
	
	@Test
	public void passwordPassTest() throws Exception {

		this.mockMvc.perform(post("/validate").param("userid", "visu")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"credential\":\"visu123\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.authenticationStatus").value("pass"));
	}

	@Test
	public void passwordFailTest() throws Exception {

		this.mockMvc.perform(post("/validate").param("userid", "visu")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"credential\":\"visu1234\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.authenticationStatus").value("fail"));
	}
	
	@Test
	public void passwordNotAvailableTest() throws Exception {

		this.mockMvc.perform(post("/validate").param("userid", "testing")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"credential\":\"testing123\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.authenticationStatus").value("notAvailable"));
	}
}
