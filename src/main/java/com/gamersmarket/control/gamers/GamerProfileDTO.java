package com.gamersmarket.control.gamers;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gamersmarket.entity.gamers.Gamer;

@JsonPropertyOrder({"authenticationToken", "firstName", "lastName", "email", "age"})
public class GamerProfileDTO {

    private String authenticationToken;
    private String email;
    private String firstName;
    private String lastName;
    private int age;

    public GamerProfileDTO(String authenticationToken, Gamer gamer) {
        this.authenticationToken = authenticationToken;
        this.email = gamer.getEmail();
        this.firstName = gamer.getFirstName();
        this.lastName = gamer.getLastName();
        this.age = gamer.getAge();
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
