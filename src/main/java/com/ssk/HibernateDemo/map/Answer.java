package com.ssk.HibernateDemo.map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Answer {
	@Id
	@Column(name = "answer_id")
	private int answerId;
	private String answer;
	@ManyToOne
	private Question question;
}
