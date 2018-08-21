package main;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.onetoone.AddressItem;
import model.onetoone.CustomerItemA;
import model.onetoone.CustomerItemB;

public class MainOneToOne {
	public static void main(String[] args) {
		// Generate schema
		Persistence.generateSchema("chapter05PU_1", new HashMap<Object, Object>());

		// 1-Creates instances of objects to persist
		AddressItem addressItem1 = new AddressItem();
		addressItem1.setStreet1("Linschotensingel, 1BK");
		addressItem1.setState("Netherland");
		addressItem1.setCity("Utrecht");
		
		CustomerItemA customerItemA = new CustomerItemA();
		customerItemA.setFirstName("Francesco");
		customerItemA.setLastName("Neri");
		customerItemA.setEmail("francesco.neri@gmail.com");
		customerItemA.setAddress(addressItem1);
		
		AddressItem addressItem2 = new AddressItem();
		addressItem2.setStreet1("Beneluxlaan, 1FG");
		addressItem2.setState("Netherland");
		addressItem2.setCity("Utrecht");
		
		CustomerItemB customerItemB = new CustomerItemB();
		customerItemB.setFirstName("Antonio");
		customerItemB.setLastName("Rossi");
		customerItemB.setEmail("antonio.rossi@gmail.com");
		customerItemB.setAddress(addressItem2);
		
		// 2-Obtains an entity manager and a transaction
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter05PU_1");
		EntityManager em = emf.createEntityManager();

		// 3-Persists the objects to the database
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// Not using @OneToOne annotation with cascade on CustomerItemA implies that we have to save not only
		// the owner, but also the owned object
		em.persist(addressItem1);
		em.persist(customerItemA);
		
		em.persist(customerItemB);
		tx.commit();

		// 5-Closes the entity manager and the factory
		em.close();
		emf.close();

		System.exit(0);
	}
}
