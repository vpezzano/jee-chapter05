package main;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.News2;
import model.NewsId2;

public class Main2 {
	public static void main(String[] args) {
		// Generate schema
		Persistence.generateSchema("chapter05PU_2", new HashMap<Object, Object>());

		// 1-Creates instances of objects to persist
		News2 news = new News2();
		String title = "Richard Wright has died on September 2008";
		String language= "EN";
		news.setTitle(title);
		news.setLanguage(language);
		news.setContent(
				"Richard William Wright was a founder member, keyboardist, and vocalist of the progressive rock band Pink Floyd.");

		// 2-Obtains an entity manager and a transaction
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter05PU_2");
		EntityManager em = emf.createEntityManager();

		// 3-Persists the objects to the database
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(news);
		tx.commit();

		// 4-Reads the objects from the database
		em.close();
		em = emf.createEntityManager();
		NewsId2 pk = new NewsId2(title, language);
		News2 theNews = em.find(News2.class, pk);
		System.out.println("Content: " + theNews.getContent());
		
		// 5-Closes the entity manager and the factory
		em.close();
		emf.close();

		System.exit(0);
	}
}
