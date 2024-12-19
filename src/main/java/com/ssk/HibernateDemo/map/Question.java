package com.ssk.HibernateDemo.map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	@OneToOne
	@JoinColumn(name = "answer_id")
	private Answer answer;
}
