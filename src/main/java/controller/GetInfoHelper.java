package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.PetClass;





public class GetInfoHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPAJoins");
	
	public void insertItem(PetClass pc) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(pc);
		em.getTransaction().commit();
		em.close();
		
	}
	public List<PetClass> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<PetClass> allItems = em.createQuery("SELECT A FROM PetClass A").getResultList();
		return allItems;
	}
	public void deleteItem(PetClass toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetClass> typedQuery = em.createQuery("select li from PetClass li where li.name = :selectedName and li.animal = :selectedAnimal",PetClass.class);
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedAnimal", toDelete.getAnimal());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		PetClass result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
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

	public void updateItem(PetClass toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<PetClass> searchForItemByStore(String storeName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetClass> typedQuery = em.createQuery("select li from PetClass li where li.animal = :selectedName", PetClass.class);
		typedQuery.setParameter("selectedStore", storeName);

		List<PetClass> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<PetClass> searchForItemByItem(String itemName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetClass> typedQuery = em.createQuery("select li from PetClass li where li.name = :selectedAnimal", PetClass.class);
		typedQuery.setParameter("selectedItem", itemName);

		List<PetClass> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp(){
		emfactory.close();
	}
	
}
