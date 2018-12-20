package com.mobilenoc.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobilenoc.task.entity.TaskDefinitionMirror;

@Repository
public interface TaskDefinitionMirrorRepository extends JpaRepository<TaskDefinitionMirror, Integer>{

}
