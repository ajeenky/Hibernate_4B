package many.to.one.mapping;

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
		
//		we have to set multiple answers because we are mapping to many answers for one question
		Answer ans1 = new Answer();
		ans1.setAnswer("Programming language");
		
		Answer ans2 = new Answer();
		ans2.setAnswer("Laptop");
		
		Answer ans3 = new Answer();
		ans3.setAnswer("RAM");
		
//		we have to set question for question table
		Question question = new Question();
		question.setQuestion("What is JAVA?");
		
//		we are passing the same question to each answer in order to achieve many.to.one. relation
		ans1.setQuestion(question);
		ans2.setQuestion(question);
		ans3.setQuestion(question);
		
//		because we are going to use question's primary key in answers table as foreign key
//		thats why we are saving question first and then saving the answers
		session.save(question);
		session.save(ans1);
		session.save(ans2);
		session.save(ans3);
		transaction.commit();
		session.close();
	}
}
