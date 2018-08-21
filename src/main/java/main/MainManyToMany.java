package main;

import java.util.Arrays;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.manytomany.Artist;
import model.manytomany.CompactDisk;

public class MainManyToMany {
	public static void main(String[] args) {
		// Generate schema
		Persistence.generateSchema("chapter05PU_1", new HashMap<Object, Object>());

		// 1-Creates instances of objects to persist
		CompactDisk cd1 = new CompactDisk();
		cd1.setTitle("CD1");
		cd1.setDescription("This is CD1");
        cd1.setPrice(30f);
       
        CompactDisk cd2 = new CompactDisk();
        cd2.setTitle("CD2");
        cd2.setDescription("This is CD2");
        cd2.setPrice(50f);
       
        Artist artist1 = new Artist();
		artist1.setFirstName("Artist1");
		artist1.setLastName("Artist1");
		artist1.setAppearsOnCDs(Arrays.asList(cd1, cd2));
		
		Artist artist2 = new Artist();
		artist2.setFirstName("Artist2");
		artist2.setLastName("Artist2");
		artist2.setAppearsOnCDs(Arrays.asList(cd1));
		
		Artist artist3 = new Artist();
		artist3.setFirstName("Artist3");
		artist3.setLastName("Artist3");
		artist3.setAppearsOnCDs(Arrays.asList(cd2));
		
		// 2-Obtains an entity manager and a transaction
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter05PU_1");
		EntityManager em = emf.createEntityManager();

		// 3-Persists the objects to the database
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// Persist the owning objects
		em.persist(artist1);
		em.persist(artist2);
		em.persist(artist3);
		tx.commit();

		// 4-Reads the objects from the database
		em.close();
		em = emf.createEntityManager();
		
		Artist artist = em.find(Artist.class, artist3.getId());
		if (artist != null) {
			// By default, the fetch type is LAZY, so we will be able
			// to access the artists only when scanning the list.
			// Change fetch type on the owning side, if appropriate
			System.out.println("CDs for artist " + artist.getLastName() + ": " + artist.getAppearsOnCDs());
			for (CompactDisk cd :  artist.getAppearsOnCDs()) {
				System.out.println("CD for artist " +  artist.getLastName() + ": " + cd);
			}
		}
		
		// 5-Closes the entity manager and the factory
		em.close();
		emf.close();

		System.exit(0);
	}
}
