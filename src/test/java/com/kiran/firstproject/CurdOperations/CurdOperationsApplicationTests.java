package com.kiran.firstproject.CurdOperations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiran.firstproject.CurdOperations.model.Todo;
import com.kiran.firstproject.CurdOperations.model.TodoStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Timestamp;
import java.util.Date;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CurdOperationsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TodoRepository todoRepository;

	@Test
	public void shouldReturnRepositoryIndex() throws Exception {

		mockMvc.perform(get("/api/v1/todo")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldCreateEntity() throws Exception {
		mockMvc.perform(post("/api/v1/todo")
				.contentType(MediaType.APPLICATION_JSON)
				.content(
				asJsonString( Todo.builder()
						.title("hi kiran")
						.description("Buy eggs from market")
						.todoStatus(TodoStatus.NOT_COMPLETED)
						.dateCreated(Timestamp.valueOf("2022-04-23 7:44:08"))
						.lastModified(Timestamp.valueOf("2022-04-23 7:44:08"))
						.build()))).andExpect(
				status().isCreated()).andExpect(
				header().string("todo", containsString("api/v1/todo/")));
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
