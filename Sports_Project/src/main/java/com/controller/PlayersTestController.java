package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Players;
import com.service.PlayersServiceIMPL;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class PlayersTestController {
	
	@Autowired
	PlayersServiceIMPL playservimpl;
	
	@PostMapping("/playmap1")
	public Players abcPlayers(@RequestBody Players play) {
		return playservimpl.addPlayers(play);
	
	}
	
	@PostMapping("/playmap")
	public ResponseEntity<Players> addPlayers(@RequestBody Players player) {
		Players p = playservimpl.addPlayers(player);
		return ResponseEntity.status(HttpStatus.CREATED).header("Add", "Player created").body(p);
	
	}
	
	@GetMapping("/getbyid/{id}")
	public Players getPlayersById(@PathVariable("id") int id) {
		return playservimpl.getPlayersById(id);
	
	
	}
	
	@GetMapping("/getbyname/{name}")
	public Players getPlayersById(@PathVariable("name") String name) {
		return playservimpl.getPlayersByName(name);
	
	}
	
//	@DeleteMapping("/delbyname/{id}")
//	public  String deletePLayers(@PathVariable("id") int id) {
//		return playservimpl.deletePLayers(id);
//	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletePLayers(@PathVariable int id) {
		playservimpl.deletePlayer1(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

}
	
	
	@PutMapping("/update")
	public Players updatePlayers(@RequestBody Players play) {
		return playservimpl.updatePlayers(play);
	}
	
	@GetMapping("/getAll")
	public List<Players> getAllByPlayers() {
		
		return playservimpl.getAllByPlayers();
	}


}
