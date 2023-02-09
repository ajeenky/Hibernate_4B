package many.to.one.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Answer ans1 = new Answer();
		ans1.setAnswer("Programming language");
		
		Answer ans2 = new Answer();
		ans2.setAnswer("Laptop");
		
		Answer ans3 = new Answer();
		ans3.setAnswer("RAM");
		
		Question question = new Question();
		question.setQuestion("What is JAVA?");
		
		ans1.setQuestion(question);
		ans2.setQuestion(question);
		ans3.setQuestion(question);
		
//		saving the multiple answers in a list
		List<Answer> list = new ArrayList<Answer>();
		list.add(ans1);
		list.add(ans2);
		list.add(ans3);
		
//		setter method of answers list
		question.setAnswer(list);
		
		session.save(question);
		session.save(ans1);
		session.save(ans2);
		session.save(ans3);
		transaction.commit();
		session.close();
	}
}
