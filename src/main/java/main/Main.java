package main;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Book2;
import model.CD;
import model.CreditCard;
import model.CreditCard2;
import model.CreditCardType;
import model.Customer;
import model.News;
import model.NewsId;

public class Main {
	public static void main(String[] args) {
		// Generate schema
		Persistence.generateSchema("chapter05PU_1", new HashMap<Object, Object>());

		// 1-Creates instances of objects to persist
		NewsId pk = new NewsId("Richard Wright has died on September 2008", "EN");
		News news = new News();
		news.setId(pk);
		news.setContent(
				"Richard William Wright was a founder member, keyboardist, and vocalist of the progressive rock band Pink Floyd.");

		Customer customer = new Customer();
		customer.setFirstName("Frank");
		customer.setLastName("Zappa");
		customer.setCreationDate(new GregorianCalendar());
		customer.setDateOfBirth(new GregorianCalendar());
		customer.setAge(20);
		customer.setEmail("frank.zappa@email.it");
		customer.setPhoneNumber("0612345678");

		CreditCard creditCard = new CreditCard();
		creditCard.setControlNumber(12345);
		creditCard.setCreditCardType(CreditCardType.MASTER_CARD);
		creditCard.setExpiryDate(new GregorianCalendar(2022, 1, 1));

		CreditCard2 creditCard2 = new CreditCard2();
		creditCard2.setControlNumber(12345);
		creditCard2.setCreditCardType(CreditCardType.MASTER_CARD);
		creditCard2.setExpiryDate(new GregorianCalendar(2022, 1, 1));

		Book2 book2A = new Book2();
		book2A.setTitle("Scrum Guide");
		book2A.setDescription("Scrum guide with examples");
		book2A.setIllustrations(false);
		book2A.setIsbn("SCR-12-ABCD");
		book2A.setNbOfPage(100);
		book2A.setPrice(30f);
		book2A.setTags(Arrays.asList("Scrum", "Agile"));

		Book2 book2B = new Book2();
		book2B.setTitle("Head First Design Pattern");
		book2B.setDescription("Design patterns extensive guide");
		book2B.setIllustrations(true);
		book2B.setIsbn("HFDP-77-EFGH");
		book2B.setNbOfPage(500);
		book2B.setPrice(50f);
		book2B.setTags(Arrays.asList("Design", "Pattern", "Composition"));

		CD cdA = new CD();
		cdA.setTitle("Saturday Night Fever");
		cdA.setDescription("One of the Bee Gee's greatest cds");
		cdA.setPrice(30f);
		Map<Integer, String> tracksA = new HashMap<Integer, String>();
		tracksA.put(1, "Stayin' Alive");
		tracksA.put(2, "More Than a Woman");
		cdA.setTracks(tracksA);

		CD cdB = new CD();
		cdB.setTitle("La Isla Bonita");
		cdB.setDescription("One famous cd from Madonna");
		cdB.setPrice(30f);
		Map<Integer, String> tracksB = new HashMap<Integer, String>();
		tracksB.put(1, "La Isla Bonita");
		tracksB.put(2, "Who's That Girl");
		cdB.setTracks(tracksB);

		// 2-Obtains an entity manager and a transaction
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter05PU_1");
		EntityManager em = emf.createEntityManager();

		// 3-Persists the objects to the database
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(news);
		em.persist(customer);
		em.persist(creditCard);
		em.persist(creditCard2);
		em.persist(book2A);
		em.persist(book2B);
		em.persist(cdA);
		em.persist(cdB);
		tx.commit();

		// 4-Reads the objects from the database
		em.close();
		em = emf.createEntityManager();

		News theNews = em.find(News.class, pk);
		System.out.println("Content: " + theNews.getContent());

		Book2 book2 = em.find(Book2.class, book2A.getId());
		// By default, the fetch type is LAZY, so we will be
		// able to access the tags only when scanning the list
		System.out.println("Tags: " + book2.getTags());
		for (String tag : book2.getTags()) {
			System.out.println("Tag: " + tag);
		}

		// 5-Closes the entity manager and the factory
		em.close();
		emf.close();

		System.exit(0);
	}
}
