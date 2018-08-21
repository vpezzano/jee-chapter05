package main;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.onetomany.Comment;
import model.onetomany.Comment1;
import model.onetomany.ItemA;
import model.onetomany.ItemB;
import model.onetomany.ItemC;
import model.onetomany.ItemLine;
import model.onetomany.NewsWithComments;
import model.onetomany.NewsWithComments1;

public class MainOneToMany {
	public static void main(String[] args) {
		// Generate schema
		Persistence.generateSchema("chapter05PU_1", new HashMap<Object, Object>());

		// 1-Creates instances of objects to persist
		ItemLine itemLine1A = new ItemLine();
		itemLine1A.setItem("Milk");
		itemLine1A.setQuantity(1);
		itemLine1A.setUnitPrice(1.25);

		ItemLine itemLine2A = new ItemLine();
		itemLine2A.setItem("Tea");
		itemLine2A.setQuantity(2);
		itemLine2A.setUnitPrice(1.15);

		List<ItemLine> itemLinesA = Arrays.asList(itemLine1A, itemLine2A);
		ItemA itemA = new ItemA();
		itemA.setName("ItemA");
		itemA.setCreationDate(new GregorianCalendar());
		itemA.setItemLines(itemLinesA);

		ItemLine itemLine1B = new ItemLine();
		itemLine1B.setItem("Bread");
		itemLine1B.setQuantity(3);
		itemLine1B.setUnitPrice(1.75);

		ItemLine itemLine2B = new ItemLine();
		itemLine2B.setItem("Lentils");
		itemLine2B.setQuantity(2);
		itemLine2B.setUnitPrice(2d);

		List<ItemLine> itemLinesB = Arrays.asList(itemLine1B, itemLine2B);
		ItemB itemB = new ItemB();
		itemB.setName("ItemB");
		itemB.setCreationDate(new GregorianCalendar());
		itemB.setItemLines(itemLinesB);

		ItemLine itemLine1C = new ItemLine();
		itemLine1C.setItem("Salad");
		itemLine1C.setQuantity(3);
		itemLine1C.setUnitPrice(1.95);

		ItemLine itemLine2C = new ItemLine();
		itemLine2C.setItem("Cheese");
		itemLine2C.setQuantity(2);
		itemLine2C.setUnitPrice(3d);

		List<ItemLine> itemLinesC = Arrays.asList(itemLine1C, itemLine2C);
		ItemC itemC = new ItemC();
		itemC.setName("ItemC");
		itemC.setCreationDate(new GregorianCalendar());
		itemC.setItemLines(itemLinesC);

		Calendar calendar1 = new GregorianCalendar(2018, 7, 25);

		Comment comment1 = new Comment();
		comment1.setContent("Comment 1");
		comment1.setNickname("Nickname 1");
		comment1.setPostedDate(calendar1);

		Calendar calendar2 = new GregorianCalendar(2018, 7, 20);

		Comment comment2 = new Comment();
		comment2.setContent("Comment 2");
		comment2.setNickname("Nickname 2");
		comment2.setPostedDate(calendar2);

		NewsWithComments news = new NewsWithComments();
		news.setContent("News");
		news.setComments(Arrays.asList(comment1, comment2));

		Comment1 comment1A = new Comment1();
		comment1A.setContent("Comment 1A");
		comment1A.setNickname("Nickname 1A");
		
		Comment1 comment1B = new Comment1();
		comment1B.setContent("Comment 1B");
		comment1B.setNickname("Nickname 1B");
		
		NewsWithComments1 news1 = new NewsWithComments1();
		news1.setContent("News 1");
		news1.setComments1(Arrays.asList(comment1A, comment1B));
		
		// 2-Obtains an entity manager and a transaction
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter05PU_1");
		EntityManager em = emf.createEntityManager();

		// 3-Persists the objects to the database
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(itemLine1A);
		em.persist(itemLine2A);
		em.persist(itemA);

		em.persist(itemB);

		em.persist(itemC);

		em.persist(news);
		
		em.persist(news1);
		tx.commit();

		// 4-Reads the objects from the database
		em.close();
		em = emf.createEntityManager();

		ItemC item = em.find(ItemC.class, itemC.getId());
		// By default, the fetch type is LAZY, so we will be able
		// to access the item lines only when scanning the list
		System.out.println("ItemLines: " + item.getItemLines());
		for (ItemLine itemLine : item.getItemLines()) {
			System.out.println("ItemLine: " + itemLine);
		}

		NewsWithComments newsWithComments = em.find(NewsWithComments.class, news.getId());
		em.refresh(newsWithComments);
		System.out.println("Comments: " + newsWithComments.getComments());

		// 5-Closes the entity manager and the factory
		em.close();
		emf.close();

		System.exit(0);
	}
}
