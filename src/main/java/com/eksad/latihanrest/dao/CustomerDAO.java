package com.eksad.latihanrest.dao;

import org.springframework.data.repository.CrudRepository;

import com.eksad.latihanrest.model.Customer;

public interface CustomerDAO extends CrudRepository<Customer, Long> {

}
