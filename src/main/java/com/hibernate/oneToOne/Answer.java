package com.hibernate.oneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {
	
	@Id
	private int aId;
	
	private String ans;
	
	@OneToOne(mappedBy = "answer")         // Mapping done by Question Table, field = answer 
	private Question que;			        // dont create column

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public Question getQue() {
		return que;
	}

	public void setQue(Question que) {
		this.que = que;
	}

}
