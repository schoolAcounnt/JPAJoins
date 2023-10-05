package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.PetClass;
import model.PetOwners;

public class OwnerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPAJoins");
	public void addOwner(PetOwners po) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(po);
		em.getTransaction().commit();
		em.close();
		
	}
	public PetClass searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		PetClass found = em.find(PetClass.class, idToEdit);
		em.close();
		return found;
	}
	public List<PetOwners> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<PetOwners> allOwners = em.createQuery("SELECT A FROM PetOwners A").getResultList();
		return allOwners;
	}
}
