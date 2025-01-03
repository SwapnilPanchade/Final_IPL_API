package com.tka.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.PlayerDao;
import com.tka.entity.Player;

@Service
public class PlayerService {

    @Autowired
    private PlayerDao playerDao;

    public Player createPlayer(Player player) {
        return playerDao.save(player);
    }

    public Player getPlayerById(Long id) {
        return playerDao.findById(id);
               
    }

    public List<Player> getAllPlayers() {
        return playerDao.findAll();
    }
}
