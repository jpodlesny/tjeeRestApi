package com.podlesny.repository;

import java.util.List;

public interface CrudRepository <T>{

	void add(T object);
	void update(T object);
	void delete(int id);
	List<T> getAll();
	T getById(int id);
	
}
