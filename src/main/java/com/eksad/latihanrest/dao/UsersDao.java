package com.eksad.latihanrest.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.eksad.latihanrest.model.Users;

public interface UsersDao extends JpaRepository<Users, Long>{

	public Users findByUsername(String username);
}
