package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {

		try {
			
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernatewithxml");
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			Category category=new Category();
			SubCategory subCategory=new SubCategory();
			
			
			//save category
			category.setName("Category Entity");
			em.persist(category);
			
			//save subcategory
			subCategory.setName("SubCategory Entity");
			subCategory.setCategory(category);
			
			em.persist(subCategory);
			
			em.getTransaction().commit();
	em.close();		
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
	}

	
}
