package com.example.footballspringboot.Repository;

import com.example.footballspringboot.Model.FootballPlayers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Database {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Database(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public FootballPlayers save(FootballPlayers f){
        if(f.getID() == null){

        }
    }
}