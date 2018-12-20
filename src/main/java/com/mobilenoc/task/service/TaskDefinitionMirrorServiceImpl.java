package com.mobilenoc.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilenoc.task.dao.TaskDefinitionMirrorRepository;
import com.mobilenoc.task.entity.TaskDefinitionMirror;

@Service
public class TaskDefinitionMirrorServiceImpl implements TaskDefinitionMirrorService {

	@Autowired
	private TaskDefinitionMirrorRepository repo;
	
	@Override
	public void saveAndUpdate(TaskDefinitionMirror mirror) {
		repo.save(mirror);
	}

	@Override
	public void delete(TaskDefinitionMirror mirror) {
		repo.delete(mirror);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

	@Override
	public List<TaskDefinitionMirror> findAll() {
		return repo.findAll();
	}

}
