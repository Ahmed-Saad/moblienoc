package com.mobilenoc.task.service;

import java.util.List;

import com.mobilenoc.task.entity.TaskDefinitionMirror;

public interface TaskDefinitionMirrorService {

	public void saveAndUpdate(TaskDefinitionMirror mirror);
	
	public void delete(TaskDefinitionMirror mirror);
	
	public void deleteAll();
	
	public List<TaskDefinitionMirror> findAll();
}
