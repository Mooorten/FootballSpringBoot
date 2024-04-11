package com.example.footballspringboot.Repository;

import com.example.footballspringboot.Model.FootballPlayers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class Database {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Database(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public FootballPlayers save(FootballPlayers f){
        if(f.getID() == null){
            String SQL = "INSERT INTO fodboldspillere (name, age, club, foot) VALUES (?,?,?,?)";
            jdbcTemplate.update(SQL, f.getName(), f.getAge(), f.getClub(), f.getFoot());
        } else {
            String SQL = "UPDATE fodboldspillere SET name = ?, age = ?, club = ?, foot) VALUES (?,?,?,?,?)";
            jdbcTemplate.update(SQL, f.getName(), f.getAge(), f.getClub(), f.getFoot());
        }
        return f;
    }
    public List<FootballPlayers> readAll(){
        String SQL = "SELECT * FROM fodboldspillere";
        return jdbcTemplate.query(SQL, FootballRowMapper());
    }
    public void delete(Long ID){
        String SQL = "DELETE FROM fodboldspillere WHERE id = ?";
        jdbcTemplate.update(SQL, ID);
    }
    private RowMapper<FootballPlayers> FootballRowMapper(){
        return (rs, rowNum) -> {
            FootballPlayers footballPlayers = new FootballPlayers();
            footballPlayers.setID(rs.getLong("ID"));
            footballPlayers.setName(rs.getString("name"));
            footballPlayers.setAge(rs.getString("age"));
            footballPlayers.setClub(rs.getString("club"));
            footballPlayers.setFoot(rs.getString("foot"));
            return footballPlayers;
        };
    }
    public Optional<FootballPlayers> findByID(Long ID){
        String SQL = "SELECT * FROM fodboldspillere WHERE ID = ?";
        FootballPlayers footballPlayers =jdbcTemplate.queryForObject(SQL, new Object[]{ID}, FootballRowMapper());
        return Optional.ofNullable(footballPlayers);
    }
}