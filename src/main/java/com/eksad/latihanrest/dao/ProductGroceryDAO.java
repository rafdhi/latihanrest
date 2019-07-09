package com.eksad.latihanrest.dao;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eksad.latihanrest.model.ProductGrocery;

@RepositoryRestResource(path = "groceries")
public interface ProductGroceryDAO extends CrudRepository<ProductGrocery, Long> {

	List<ProductGrocery> findByName(@Param("name") String name);
	List<ProductGrocery> findByBrandName(@Param("brandName") String name);
}
