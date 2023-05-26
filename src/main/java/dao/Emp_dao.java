package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Emp_dto;

public class Emp_dao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=manager.getTransaction();
	
	public void save(Emp_dto dto)
	{
		System.out.println("Invoked save");
		entityTransaction.begin();
		manager.persist(dto);
		entityTransaction.commit();
	}
	
	public Emp_dto fetch(int id)
	{
		return manager.find(Emp_dto.class,id);
	}
	
	public List<Emp_dto>fetch(String email)
	{
		List<Emp_dto>list=manager.createQuery("select x from Emp_dto x where email=?1").setParameter(1, email).getResultList();
		if(list.isEmpty())
		{
			return null;
		}
		else{
			return list;
		}
	}
	public List<Emp_dto>fetch()
	
	{
		List<Emp_dto>list=manager.createQuery("select x from Emp_dto x").getResultList();
		return list;
	}
	{
		
	}
	}


