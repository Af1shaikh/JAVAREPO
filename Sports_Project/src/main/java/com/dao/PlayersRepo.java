package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Players;

public interface PlayersRepo  extends JpaRepository<Players, Integer>{
	
	Players findByName(String name);

	List<Players> findAllById(int id);

}
