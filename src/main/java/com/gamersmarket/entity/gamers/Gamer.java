package com.gamersmarket.entity.gamers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gamersmarket.common.deserializers.GamerDeserializer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "gamers")
@NamedQueries({
    @NamedQuery(name = Gamer.GET_GAMER_DETAILS, query = Gamer.GET_GAMER_DETAILS_QUERY),
    @NamedQuery(name = Gamer.FIND_GAMER_BY_EMAIL, query = Gamer.FIND_GAMER_BY_EMAIL_QUERY)
})
@JsonDeserialize(using = GamerDeserializer.class)
public class Gamer implements Serializable {

    private static final long serialVersionUID = 5201550250565494409L;
    public static final String PARAM_GAMER_ID = "id";
    public static final String PARAM_GAMER_EMAIL = "email";
    public static final String GET_GAMER_DETAILS = "get_gamer_details";
    public static final String GET_GAMER_DETAILS_QUERY = "select gamer from Gamer gamer where gamer.id = :" + PARAM_GAMER_ID;
    public static final String FIND_GAMER_BY_EMAIL = "findGamerByEmail";
    public static final String FIND_GAMER_BY_EMAIL_QUERY = "select gamer from Gamer gamer where gamer.email = :" + PARAM_GAMER_EMAIL;

    @Id
    @NotNull
    @GeneratedValue(generator = "sq_hardware_item")
    @SequenceGenerator(name = "sq_gamer_generator", sequenceName = "sq_hardware_item")
    private int id;

    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private int age;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRole role;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updatedOn;

    public Gamer() {}

    public Gamer(Gamer gamer) {
        this.password = gamer.getPassword();
        this.firstName = gamer.getFirstName();
        this.lastName = gamer.getLastName();
        this.email = gamer.getEmail();
        this.age = gamer.getAge();
    }

    public Gamer(JsonNode gamerNode) {
        this.firstName = gamerNode.get("firstName").asText();
        this.lastName = gamerNode.get("lastName").asText();
        this.email = gamerNode.get("email").asText();
        this.age = gamerNode.get("age").asInt();
        this.password = gamerNode.get("password").asText();
        this.updatedOn = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gamer gamer = (Gamer) o;
        return id == gamer.id &&
                email.equals(gamer.email) &&
                createdOn.equals(gamer.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, createdOn);
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
