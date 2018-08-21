package main;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.inheritance.BookItem;
import model.inheritance.BookItem1;
import model.inheritance.BookItem2;
import model.inheritance.BookItem3;
import model.inheritance.BookItem4;
import model.inheritance.BookItem5;
import model.inheritance.CDItem;
import model.inheritance.CDItem1;
import model.inheritance.CDItem2;
import model.inheritance.CDItem3;
import model.inheritance.RootItem;
import model.inheritance.RootItem1;
import model.inheritance.RootItem2;
import model.inheritance.RootItem3;

public class MainInheritance {
	public static void main(String[] args) {
		// Generate schema
		Persistence.generateSchema("chapter05PU_1", new HashMap<Object, Object>());

		// 1-Creates instances of objects to persist
		RootItem rootItem = new RootItem();
		rootItem.setTitle("Pen");
		rootItem.setDescription("This is a pen");
		rootItem.setPrice(1f);

		BookItem bookItem = new BookItem();
		bookItem.setTitle("The Adventures of Tom Sawyer");
		bookItem.setDescription("Famous Mark Twain's book");
		bookItem.setIllustrations(false);
		bookItem.setNbOfPage(300);
		bookItem.setPublisher("American Publishing Company");
		bookItem.setIsbn("TS-ABCD-12345");
		bookItem.setPrice(35f);

		CDItem cdItem = new CDItem();
		cdItem.setGenre("Classical");
		cdItem.setTitle("Beethoven Master Serie");
		cdItem.setDescription("Compositions for Piano in Their Original Versions");
		cdItem.setMusicCompany("G. Schirmer, Inc., New York");
		cdItem.setNumberOfCDs(1);
		cdItem.setPrice(50f);
		cdItem.setTotalDuration(2f);

		RootItem1 rootItem1 = new RootItem1();
		rootItem1.setTitle("Pen");
		rootItem1.setDescription("This is a pen");
		rootItem1.setPrice(1f);

		BookItem1 bookItem1 = new BookItem1();
		bookItem1.setTitle("The Adventures of Tom Sawyer");
		bookItem1.setDescription("Famous Mark Twain's book");
		bookItem1.setIllustrations(false);
		bookItem1.setNbOfPage(300);
		bookItem1.setPublisher("American Publishing Company");
		bookItem1.setIsbn("TS-ABCD-12345");
		bookItem1.setPrice(35f);

		CDItem1 cdItem1 = new CDItem1();
		cdItem1.setGenre("Classical");
		cdItem1.setTitle("Beethoven Master Serie");
		cdItem1.setDescription("Compositions for Piano in Their Original Versions");
		cdItem1.setMusicCompany("G. Schirmer, Inc., New York");
		cdItem1.setNumberOfCDs(1);
		cdItem1.setPrice(50f);
		cdItem1.setTotalDuration(2f);

		RootItem2 rootItem2 = new RootItem2();
		rootItem2.setTitle("Pen");
		rootItem2.setDescription("This is a pen");
		rootItem2.setPrice(1f);

		BookItem2 bookItem2 = new BookItem2();
		bookItem2.setTitle("The Adventures of Tom Sawyer");
		bookItem2.setDescription("Famous Mark Twain's book");
		bookItem2.setIllustrations(false);
		bookItem2.setNbOfPage(300);
		bookItem2.setPublisher("American Publishing Company");
		bookItem2.setIsbn("TS-ABCD-12345");
		bookItem2.setPrice(35f);

		CDItem2 cdItem2 = new CDItem2();
		cdItem2.setGenre("Classical");
		cdItem2.setTitle("Beethoven Master Serie");
		cdItem2.setDescription("Compositions for Piano in Their Original Versions");
		cdItem2.setMusicCompany("G. Schirmer, Inc., New York");
		cdItem2.setNumberOfCDs(1);
		cdItem2.setPrice(50f);
		cdItem2.setTotalDuration(2f);
		
		RootItem3 rootItem3 = new RootItem3();
		rootItem3.setTitle("Pen");
		rootItem3.setDescription("This is a pen");
		rootItem3.setPrice(1f);

		BookItem3 bookItem3 = new BookItem3();
		bookItem3.setTitle("The Adventures of Tom Sawyer");
		bookItem3.setDescription("Famous Mark Twain's book");
		bookItem3.setIllustrations(false);
		bookItem3.setNbOfPage(300);
		bookItem3.setPublisher("American Publishing Company");
		bookItem3.setIsbn("TS-ABCD-12345");
		bookItem3.setPrice(35f);

		CDItem3 cdItem3 = new CDItem3();
		cdItem3.setGenre("Classical");
		cdItem3.setTitle("Beethoven Master Serie");
		cdItem3.setDescription("Compositions for Piano in Their Original Versions");
		cdItem3.setMusicCompany("G. Schirmer, Inc., New York");
		cdItem3.setNumberOfCDs(1);
		cdItem3.setPrice(50f);
		cdItem3.setTotalDuration(2f);
		
		BookItem4 bookItem4 = new BookItem4();
		bookItem4.setTitle("The Adventures of Tom Sawyer");
		bookItem4.setDescription("Famous Mark Twain's book");
		bookItem4.setIllustrations(false);
		bookItem4.setNbOfPage(300);
		bookItem4.setPublisher("American Publishing Company");
		bookItem4.setIsbn("TS-ABCD-12345");
		bookItem4.setPrice(35f);
		
		BookItem5 bookItem5 = new BookItem5();
		bookItem5.setTitle("The Adventures of Tom Sawyer");
		bookItem5.setDescription("Famous Mark Twain's book");
		bookItem5.setIllustrations(false);
		bookItem5.setNbOfPage(300);
		bookItem5.setPublisher("American Publishing Company");
		bookItem5.setIsbn("TS-ABCD-12345");
		bookItem5.setPrice(35f);
		
		// 2-Obtains an entity manager and a transaction
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter05PU_1");
		EntityManager em = emf.createEntityManager();

		// 3-Persists the objects to the database
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(rootItem);
		em.persist(bookItem);
		em.persist(cdItem);

		em.persist(rootItem1);
		em.persist(bookItem1);
		em.persist(cdItem1);

		em.persist(rootItem2);
		em.persist(bookItem2);
		em.persist(cdItem2);
		
		em.persist(rootItem3);
		em.persist(bookItem3);
		em.persist(cdItem3);
		
		em.persist(bookItem4);
		
		em.persist(bookItem5);
		
		tx.commit();

		// 4-Reads the objects from the database
		em.close();
		em = emf.createEntityManager();

		BookItem theBookItem = em.find(BookItem.class, bookItem.getId());
		System.out.println(theBookItem);
		
		// 5-Closes the entity manager and the factory
		em.close();
		emf.close();

		System.exit(0);
	}
}
