package edu.romantictrust.webdriver.model;

import java.util.Objects;

public class User {
    private String username;
    private String email;
    private String age;
    private String password;

    public User(String username, String email, String age, String password) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public User(String username, String email, String age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getAge(), user.getAge()) &&
                Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getEmail(), getAge(), getPassword());
    }
}
