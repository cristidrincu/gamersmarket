package com.gamersmarket.entity.types;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "hardware_type")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NamedQueries({
        @NamedQuery(name = HardwareType.GET_HARDWARE_TYPES, query = "select hwType from HardwareType hwType"),
        @NamedQuery(name = HardwareType.GET_HARDWARE_TYPE, query = "select hwType from HardwareType hwType where hwType.id = :id")
})
public class HardwareType implements Serializable {

    private static final long serialVersionUID = -1484902680516970327L;
    public static final String PARAM_ID = "id";
    public static final String GET_HARDWARE_TYPES = "HardwareType.getHardwareTypes";
    public static final String GET_HARDWARE_TYPE = "HardwareType.getHardwareType";

    @Id
    @NotNull
    @GeneratedValue(generator = "sq_hardware_type")
    @SequenceGenerator(name = "sq_hardware_type", sequenceName = "sq_hardware_type", initialValue = 30, allocationSize = 1)
    private int id;

    @Column(unique = true)
    @Size(min = 5, max = 50, message = "The name of the hardware type must be between 5 and 50 characters.")
    private String name;

    @Column(unique = true, name = "hw_type_alias")
    @Size(min = 2, max = 10, message = "The alias must be between 2 and 10 characters long.")
    private String hwTypeAlias;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updatedOn;

    public HardwareType() {}

    public HardwareType(HardwareType hardwareType) {
        this.name = hardwareType.getName();
        this.hwTypeAlias = hardwareType.getHwTypeAlias();
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

    public String getHwTypeAlias() {
        return hwTypeAlias;
    }

    public void setHwTypeAlias(String hwTypeAlias) {
        this.hwTypeAlias = hwTypeAlias;
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
        if (!(o instanceof HardwareType)) {
            return false;
        }

        HardwareType other = (HardwareType) o;
        return id == other.id && createdOn.equals(other.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdOn);
    }
}
