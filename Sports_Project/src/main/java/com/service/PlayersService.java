package com.service;

import java.util.List;
import java.util.Map;

import com.model.Players;

public interface PlayersService {
	
	Players addPlayers(Players play);
	
	Players getPlayersById(int id);
	
	Players getPlayersByName(String name);
	
//	String deletePLayers(int id);
	
	Players updatePlayers(Players play);

	List<Players> getAllByPlayers();
	
	Map<String, Boolean> deletePlayer1(int id);


}
