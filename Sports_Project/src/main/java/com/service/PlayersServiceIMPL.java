package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PlayersRepo;
//import com.exception.NoSuchPlayerExist;
import com.model.Players;

@Service
public class PlayersServiceIMPL implements PlayersService {
	
	@Autowired
	PlayersRepo playersrepo;

	@Override
	public Players addPlayers(Players play) {
		return playersrepo.save(play);
	}

	@Override
	public Players getPlayersById(int id) {

		return playersrepo.findById(id).orElse(null);
	}
	
//	@Override
//	public Players getPlayersById(int id) {
//
//		return playersrepo.findById(id).orElseThrow(
//				()->
//				new NoSuchPlayerExist("No player"+id)
//				);
//	}


	@Override
	public Players getPlayersByName(String name) {

		return playersrepo.findByName(name);
	}

//	@Override
//	public  String deletePLayers(int id) {
//		
//		playersrepo.deleteById(id);
//		
//		return "delete data";
//				
//	}

	@Override
	public Players updatePlayers(Players play) {
		Players exsistingplayers = playersrepo.findById(play.getId()).orElse(null);
		exsistingplayers.setName(play.getName());
		return playersrepo.save(exsistingplayers);
	}

	@Override
	public List<Players> getAllByPlayers() {
		
		return playersrepo.findAll();
	}


	public Map<String, Boolean> deletePlayer1(int id){
		
		playersrepo.deleteById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return response;
	}


}
