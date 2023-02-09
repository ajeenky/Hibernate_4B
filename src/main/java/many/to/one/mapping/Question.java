package many.to.one.mapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ques")
public class Question {
	@Id
	@GeneratedValue (strategy =GenerationType.IDENTITY)
	private int q_Id;
	
	@Column
	private String Question;
	
//	bi-directional mapping of many to one and one to many
//	it creates 3 tables for bi-directional mapping
//	because we used mapped by thats why it is adding the column in answers table
//	and it is shoeing the same result as unidirectional
//	saved answers in a list because we have many answers and just one question
	@OneToMany (mappedBy = "question")
	private List<Answer> answer;
	
	public List<Answer> getAnswer() {
		return answer;
	}
	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}
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
		return "Question [q_Id=" + q_Id + ", Question=" + Question + ", answer=" + answer + "]";
	}
}