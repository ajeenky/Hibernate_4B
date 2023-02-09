package many.to.one.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ques")
public class Question {
	@Id
	@GeneratedValue (strategy =GenerationType.IDENTITY)
	private int q_Id;
	
	@Column
	private String Question;
	
	public int getQ_Id() {
		return q_Id;
	}
	public void setQ_Id(int q_Id) {
		this.q_Id = q_Id;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	
	@Override
	public String toString() {
		return "Question [q_Id=" + q_Id + ", Question=" + Question + "]";
	}
}