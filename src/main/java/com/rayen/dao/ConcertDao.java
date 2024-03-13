package com.rayen.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.rayen.entities.Concert;
import com.rayen.util.JPAutil;

public class ConcertDao {
	private EntityManager entityManager = JPAutil.getEntityManager("ConcertJPA");

	public void ajouter(Concert c)
	{
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.persist(c);
	tx.commit();
	}
	
		public void modifier(Concert c) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.merge(c);
			tx.commit();
		}
	
		public void supprimer(Concert c) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			c = entityManager.merge(c); // important
			entityManager.remove(c);
			tx.commit();
		}
	
		public Concert consulter(Concert c, Object id) {
			return entityManager.find(c.getClass(), id);
		}
	
		public List<Concert> listerTous() {
			List<Concert> concerts = entityManager.createQuery("select c from Concert c").getResultList();
			return concerts;
		}
	
		public List<Concert> listerParNom(String nom) {
			List<Concert> concerts = entityManager.createQuery("select c from Concert c where c.nom like :pnom").setParameter("pnom", "%" + nom + "%").getResultList();
	
			return concerts;
		}
}