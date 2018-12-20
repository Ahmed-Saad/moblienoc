package com.mobilenoc.task.entity;

/**
 * created by Ahmed Saad
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Task_definition_mirror")
public class TaskDefinitionMirror implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5054305635666683303L;

	@Id
//	@GeneratedValue
	@Column(name = "Id", nullable = false)
	private int id;
	@Column(name = "Name", nullable = false)
	private String name;
	@Column(name = "Description")
	private String description;

	public TaskDefinitionMirror() {
	}

	public TaskDefinitionMirror(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
