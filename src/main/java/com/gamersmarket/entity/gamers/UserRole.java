package com.gamersmarket.entity.gamers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = -665267612439990899L;

    @Id
    @NotNull
    private int id;

    private String role;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updatedOn;

    public UserRole() {}

    public UserRole(UserRole role) {
        this.id = role.getId();
        this.role = role.getRole();
        this.updatedOn = new Date();
    }

    public UserRole(JsonNode userRoleNode) {
        this.role = userRoleNode.get("role").asText();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return id == userRole.id &&
                createdOn.equals(userRole.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdOn);
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
