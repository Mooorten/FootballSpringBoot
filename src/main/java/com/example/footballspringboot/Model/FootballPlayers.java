package com.example.footballspringboot.Model;

public class FootballPlayers {
    Long ID;
    String name, age, club, foot;

    public FootballPlayers() {
    }

    public FootballPlayers(Long ID, String name, String age, String club, String foot) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.club = club;
        this.foot = foot;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    @Override
    public String toString() {
        return "FootballPlayers{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", club='" + club + '\'' +
                ", foot='" + foot + '\'' +
                '}';
    }
}
