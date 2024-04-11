package com.example.footballspringboot.Service;

import com.example.footballspringboot.Model.FootballPlayers;
import com.example.footballspringboot.Repository.Database;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PlayerService {
    Database db = new Database(new JdbcTemplate());

    public void addFootballer(FootballPlayers f){
        db.save(f);
    }
    public void deleteFootballer(Long ID){
        db.delete(ID);
    }
    public Optional findPlayer(Long ID){
        db.findByID(ID);
        return null;
    }
    public FootballPlayers readAll(){
        db.readAll();
        return null;
    }
}