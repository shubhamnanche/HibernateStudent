package com.ssk.HibernateDemo.map_many;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {
	@Id
	private int pid;
	@Column(name="project_name")
	private String projectName;
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;
}
