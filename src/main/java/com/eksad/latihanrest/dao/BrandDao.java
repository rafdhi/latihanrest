package com.eksad.latihanrest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eksad.latihanrest.model.Brand;



public interface BrandDao extends CrudRepository<Brand, Long> {
	
	// ini kalo mau nyari kek pake where
	public Optional<Brand> findById(Long id);
	//public Brand findOneByName(String name);
	//public List<Brand> findAllByOrderByName();
	//public List<Brand> findByName(String name);
	public List<Brand> findByProductType(String product_type);
	
//	@Query("select b from Brand b where name = ?1") // ?1 menunjukkan indeksnya 1
//	public List<Brand> findBySearch(String search);
	
	@Query("select b from Brand b where name = :search")
	public List<Brand> findBySearch(@Param("search") String search);


}
