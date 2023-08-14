package dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import controller.AddTask;

import java.util.*;

import dto.MyUser;
import dto.Task;

public class UserDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void save(MyUser user) {
		transaction.begin();
		manager.persist(user);
		transaction.commit();
	}

	public MyUser findByEmail(String email) {
		List<MyUser> list = manager.createQuery("select x from MyUser x where email=?1")
//	sql query->	.createNativeQuery(select * from MyUser where email=",MyUser.class)
				.setParameter(1, email).getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public void save(Task task) {
		transaction.begin();
		manager.persist(task);
		transaction.commit();
	}

	public List<Task> fetchAllTask() {
		return manager.createQuery("select x from Task x").getResultList();

	}
    public void update(MyUser myUser) {
		transaction.begin();
		manager.merge(myUser);
		transaction.commit();
	}
	public Task fetchTask(int id) {
		return manager.find(Task.class,id);
	}
	
	public void update(Task task) {
		transaction.begin();
		manager.merge(task);
		transaction.commit();
	}
	public void remove(Task task) {
		transaction.begin();
		manager.merge(task);
		transaction.commit();
	}




}
