package io.cucumber.skeleton.model;

import org.apache.commons.lang3.RandomStringUtils;

public class User {
    private String email;
    private String password;

    public User() {
        this.email = RandomStringUtils.randomAlphabetic(8) + "A*" + ("@gmail.com");//(randomize email)
        this.password = "qwerty123";
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String repeatPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void repeatPassword(String password) { this.password = password;
    }
}
