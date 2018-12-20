package com.mobilenoc.task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by Ahmed Saad
 */
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mobilenoc.task.handler.JdbcMessageHandler;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TaskApplication.class)
public class TaskApplicationTests {

	@Autowired
	private JdbcMessageHandler handler;
	
	@Test
	public void contextLoads() {
		List<Map<String, Object>> message = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("ID", "1");
		map.put("NAME", "Ahmed");
		map.put("DESCRIPTION", "Test1");
		message.add(map);
		handler.handleJdbcMessage(message);
	}

}

