package models;

import org.apache.commons.lang3.RandomStringUtils;

public class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public static User generateCorrectUser() {
        String name =  "User" + RandomStringUtils.randomAlphabetic(3,12);
        String email = RandomStringUtils.randomAlphabetic(3,12) + "@gmail.com";
        String password = RandomStringUtils.randomAlphabetic(6,11);

        return new User(name, email, password);
    }

    public static User generateIncorrectUser() {
        String name =  "User" + RandomStringUtils.randomAlphabetic(4,11);
        String email = RandomStringUtils.randomAlphabetic(4,11) + "@gmail.com";
        String password = RandomStringUtils.randomAlphabetic(1, 5);

        return new User(name, email, password);
    }
}
