package com.ssk.HibernateDemo.map;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {
	@Id
	@Column(name="question_id")
	private int questionId;
	private String question;
	@OneToMany(mappedBy = "question")
	private List<Answer> answers;
}
