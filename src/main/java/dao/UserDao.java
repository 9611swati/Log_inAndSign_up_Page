package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import dto.User_info;

public class UserDao
{
EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
EntityManager manager=factory.createEntityManager();
EntityTransaction transaction=manager.getTransaction();


public void save(User_info info)
{
	transaction.begin();
	manager.persist(info);
	transaction.commit();
}


public User_info fetch(long mobile)
{
	Query query=manager.createQuery("select email from User_info email where mobile=?1").setParameter(1, mobile);
	List<User_info> lst=query.getResultList();
	if(lst.isEmpty())
	{
		return null;
	}
	else
	{
	return lst.get(0);
}
}


public User_info fetch(String email)
{
	Query query=manager.createQuery("select x from User_info x where email=?1").setParameter(1, email);
	List<User_info> lst1=query.getResultList();
	if(lst1.isEmpty())
	{
		return null;
	}
	else
	{
	return lst1.get(0);
	}
}
public List<User_info> fetchAll()
{
	return manager.createQuery("select x from User_info x ").getResultList();
}
public void delete(User_info info) 
{
	transaction.begin();
	manager.remove(info);
	transaction.commit();
}
public User_info fetch(int id)
{
	return manager.find(User_info.class, id);
}
public void Update(User_info info) 
{
	transaction.begin();
	manager.merge(info);
	transaction.commit();
}

}