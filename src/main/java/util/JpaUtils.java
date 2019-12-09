package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaUtils {
	private static EntityManagerFactory EntityManagerFactory;
	private static EntityTransaction transaction;
	static{
		String persistenceUnitName = "ma";
		EntityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
	}
	
	public static  EntityManager getEntityManager()
	{
		EntityManager em = EntityManagerFactory.createEntityManager();
		 transaction = em.getTransaction();
		transaction.begin();
		return em;
		
	}
	
	public static void colseAll(EntityManager em)
	{
		transaction.commit();
		em.close();
	}
}
