package com.mobilenoc.task.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobilenoc.task.entity.TaskDefinitionMirror;
import com.mobilenoc.task.service.TaskDefinitionMirrorService;

@Component
public class JdbcMessageHandler {

	@Autowired
	private TaskDefinitionMirrorService service;

	public void handleJdbcMessage(List<Map<String, Object>> message) {
		TaskDefinitionMirror tdm = new TaskDefinitionMirror();
		List<TaskDefinitionMirror> mirrorTableList = service.findAll();
		boolean firstRun = false;
		for (int i = 0; i < message.size(); i++) {
			Map<String, Object> resultMap = message.get(i);
			if (mirrorTableList.isEmpty() || mirrorTableList == null) {
				firstRun = true;
				mirroTableHandling(resultMap, tdm);
			} else {
				if (message.size() != mirrorTableList.size() && !firstRun) {
					service.deleteAll();
					mirrorTableList.clear();
					i = -1;

				} else {
					mirroTableUpdateHandling(resultMap, tdm, mirrorTableList);
				}
			}
		}
	}

	private void mirroTableHandling(Map<String, Object> resultMap, TaskDefinitionMirror tdm) {
		for (String column : resultMap.keySet()) {
			System.out.println("column: " + column + " value: " + resultMap.get(column));
			switch (column) {
			case "ID":
				tdm.setId(Integer.parseInt(resultMap.get(column).toString()));
				break;
			case "NAME":
				tdm.setName(resultMap.get(column).toString());
				break;
			case "DESCRIPTION":
				tdm.setDescription(resultMap.get(column).toString());
				break;
			}
		}
		service.saveAndUpdate(tdm);
	}

	private void mirroTableUpdateHandling(Map<String, Object> resultMap, TaskDefinitionMirror tdm,
			List<TaskDefinitionMirror> mirrorTableList) {

		int index = 0;
		int counter = 1;
		int isDifferent = 0;
		for (String column : resultMap.keySet()) {
			switch (column) {
			case "ID":
				if (Integer.parseInt(resultMap.get(column).toString()) != mirrorTableList.get(index).getId()) {
					isDifferent++;
				}
				tdm.setId(Integer.parseInt(resultMap.get(column).toString()));
				break;
			case "NAME":
				if (!resultMap.get(column).toString().equals(mirrorTableList.get(index).getName())) {
					isDifferent++;
				}
				tdm.setName(resultMap.get(column).toString());
				break;
			case "DESCRIPTION":
				if (!resultMap.get(column).toString().equals(mirrorTableList.get(index).getDescription())) {
					isDifferent++;
				}
				tdm.setDescription(resultMap.get(column).toString());
				break;
			}
			if (counter == 3) {
				if (isDifferent > 0) {
					service.saveAndUpdate(tdm);
				}
				index++;
				counter = 0;
				isDifferent = 0;
			}
			counter++;
		}
	}

}