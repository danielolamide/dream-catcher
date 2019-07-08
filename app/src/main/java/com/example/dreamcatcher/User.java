package com.example.dreamcatcher;

public class User {
    public User(int id, String username, String name, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    }
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    private String name;
    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }
}
