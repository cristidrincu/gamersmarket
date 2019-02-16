package com.gamersmarket.entity.manufacturer;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "hardware_manufacturer")
@NamedQueries({
        @NamedQuery(name = Manufacturer.GET_MANUFACTURERS, query = "select m from Manufacturer m"),
        @NamedQuery(name = Manufacturer.GET_MANUFACTURER_DETAILS, query = "select m from Manufacturer m where m.id = :id")
})
public class Manufacturer implements Serializable {

    private static final long serialVersionUID = -9158739309039344296L;
    public static final String GET_MANUFACTURERS = "Manufacturer.getAll";
    public static final String GET_MANUFACTURER_DETAILS = "Manufacturer.getDetails";

    @Id
    @NotNull
    @GeneratedValue(generator = "sq_hardware_manufacturer")
    @SequenceGenerator(name = "hardware_manufacturer_sequence", sequenceName = "sq_hardware_manufacturer", initialValue = 40, allocationSize = 1)
    private int id;

    @NotNull
    @Column(unique = true)
    @Size(min = 3, max = 20, message = "Manufacturer name must be between 3 and 20 characters max")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updatedOn;

    public Manufacturer() {}

    public Manufacturer(Manufacturer manufacturer) {
        this.name = manufacturer.getName();
        this.updatedOn = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Manufacturer that = (Manufacturer) o;
        return id == that.id &&
                name.equals(that.name) &&
                createdOn.equals(that.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdOn);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
