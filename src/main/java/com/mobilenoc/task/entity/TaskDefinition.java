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
@Table(name = "Task_definition")
public class TaskDefinition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4434953944252962504L;
	
	@Id
//	@GeneratedValue
	@Column(name = "Id", nullable = false)
	private int id;
	@Column(name = "Name", nullable = false)
	private String name;
	@Column(name = "Description")
	private String description;

	public TaskDefinition() {
	}

	public TaskDefinition(String name, String description) {
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
