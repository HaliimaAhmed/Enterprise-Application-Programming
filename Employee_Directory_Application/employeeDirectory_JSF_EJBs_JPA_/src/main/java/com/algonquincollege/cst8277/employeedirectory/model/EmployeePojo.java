/***************************************************************************f******************u************zz*******y**
 * File: EmployeePojo.java
 * Course materials (20W) CST 8277
 *
 * @author (original) Mike Norman
 * @author student name: Haliima Ahmed 
 * Student number: 040825884
 * Date:Febuary 21,2020
 */
package com.algonquincollege.cst8277.employeedirectory.model;

import static
com.algonquincollege.cst8277.employeedirectory.model.EmployeePojo.ALL_EMPLOYEES_QUERY_NAME;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
*
* Description: model for the employee object
*/
@Entity(name = "Employee")
@Table(name = "Employee")
@Access(AccessType.PROPERTY)
@EntityListeners({EmployeePojoListener.class})
@NamedQueries(
    @NamedQuery(name=ALL_EMPLOYEES_QUERY_NAME, query = "select e from Employee e")
)
public class EmployeePojo implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String ALL_EMPLOYEES_QUERY_NAME =
        "allEmployees";

    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String title;
    protected Double salary;
    protected int version;
    protected boolean Editable;
    
    
    protected LocalDateTime Created_Date;
    protected LocalDateTime Updated_Date;
    protected LocalDateTime PostUpdatedDate;
    protected LocalDateTime PostCreatedOnDate;
    protected LocalDateTime RemovedOnDate;
    protected LocalDateTime PostRemovedOnDate;
    protected LocalDateTime LoadDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    /**
     * @param id new value for id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the value for firstName
     */
    @Column(name = "FNAME")
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName new value for firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the value for lastName
     */
    @Column(name = "LNAME")
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lastName new value for lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the value for email
     */
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }
    /**
     * @param email new value for email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the value for title
     */
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }
    /**
     * @param title new value for title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the value for salary
     */
   @Column(name = "SALARY")
    public Double getSalary() {
        return salary;
    }
    /**
     * @param salary new value for salary
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    /**
     * @return the value for Version
     */
    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }
    /**
     * @param salary new value for version
     */
    public void setVersion(int version) {
        this.version = version;
    }
    /**
     * @return the value for Editable
     */
    public boolean isEditable() {
        return Editable;
    }
    /**
     * @param Editable new value for editable
     */
    public void setEditable(boolean editable) {
        Editable = editable;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmployeePojo)) {
            return false;
        }
        EmployeePojo other = (EmployeePojo) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder
            .append("Employee [id=")
            .append(id)
            .append(", ");
        if (firstName != null) {
            builder
                .append("firstName=")
                .append(firstName)
                .append(", ");
        }
        if (lastName != null) {
            builder
                .append("lastName=")
                .append(lastName)
                .append(", ");
        }
        if (email != null) {
            builder
                .append("email=")
                .append(email)
                .append(", ");
        }
        if (salary != null) {
            builder
                .append("salary=")
                .append(salary)
                .append(", ");
        }
        if (title != null) {
            builder
                .append("title=")
                .append(title);
        }
        builder.append("]");
        return builder.toString();
    }
    /**
     * @param salary new value for CreatedDate
     */
    public void setCreated_Date(LocalDateTime now) {
        this.Created_Date = now;
    }
    /**
     * @param salary new value for UpdatedDate
     */
    public void setUpdated_Date(LocalDateTime now) {
        this.Updated_Date = now;
    }
    /**
     * @param salary new value for PostUpdatedDate
     */
    public void setPostUpdatedDate(LocalDateTime now) {
        this.PostUpdatedDate = now;
        
    }
    /**
     * @param salary new value for PostCreatedOnDate
     */
    public void setPostCreatedOnDate(LocalDateTime now) {
        this.PostCreatedOnDate = now;
        
    }
    /**
     * @param salary new value for RemovedOnDate
     */
    public void setRemovedOnDate(LocalDateTime now) {
        this.RemovedOnDate = now;
        
    }
    /**
     * @param salary new value for PostRemovedOnDate
     */
    public void setPostRemovedOnDate(LocalDateTime now) {
        this.PostRemovedOnDate = now;
        
    }
    /**
     * @param salary new value for LoadDate
     */
    public void setLoadDate(LocalDateTime now) {
        this.LoadDate = now;
        
    }
    /**
     * @return the value for Created_Date
     */
    @Column(name = "CREATED_DATE")
    public LocalDateTime getCreated_Date() {
        return Created_Date;
    }
    /**
     * @return the value for UpdatedDate
     */
    @Column(name = "UPDATED_DATE")
    public LocalDateTime getUpdated_Date() {
        return Updated_Date;
    }
    /**
     * @return the value for PostUpdatedDate
     */
    public LocalDateTime getPostUpdatedDate() {
        return PostUpdatedDate;
    }
    /**
     * @return the value for PostCreatedOnDate
     */
    public LocalDateTime getPostCreatedOnDate() {
        return PostCreatedOnDate;
    }
    /**
     * @return the value for RemovedOnDate
     */
    public LocalDateTime getRemovedOnDate() {
        return RemovedOnDate;
    }
    /**
     * @return the value for PostRemovedOnDate
     */
    public LocalDateTime getPostRemovedOnDate() {
        return PostRemovedOnDate;
    }
    /**
     * @return the value for LoadDate
     */
    public LocalDateTime getLoadDate() {
        return LoadDate;
    }


}