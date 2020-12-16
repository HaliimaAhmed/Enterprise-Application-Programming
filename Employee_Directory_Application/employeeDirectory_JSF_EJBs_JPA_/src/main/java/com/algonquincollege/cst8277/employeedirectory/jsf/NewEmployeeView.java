/***************************************************************************f******************u************zz*******y**
 * File: EmployeeController.java
 * Course materials (20W) CST 8277
 * @author (original) Mike Norman
 * @author student name: Haliima Ahmed 
 * Student number: 040825884
 * Date:Febuary 21,2020
 */
package com.algonquincollege.cst8277.employeedirectory.jsf;

import java.io.Serializable;

import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Version;

import com.algonquincollege.cst8277.employeedirectory.model.EmployeePojo;
import com.algonquincollege.cst8277.employeedirectory.jsf.EmployeeController;

@Named("newEmployee")
@ViewScoped
public class NewEmployeeView implements Serializable {
    /** explicit set serialVersionUID */
    private static final long serialVersionUID = 1L;

    protected String firstName;
    protected String lastName;
    protected String email;
    protected String title;
    protected Double salary;
    protected int version;
    
    @Inject
    @ManagedProperty("#{employeeController}")
    protected EmployeeController employeeController;

    public NewEmployeeView() {
    }

    /**
     * @return  firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName  firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return  lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param LastName  LastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * @return  Email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email  email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return  title
     */
    public String getTitle() {
        return title;
    }
    /**
     * @param title  title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @return  salary
     */
    public Double getSalary() {
        return salary;
    }

    /**
     * @param salary  salary to set
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    /**
     * @return the value for Version
     */
    @Version
    public int getVersion() {
        return version;
    }
    /**
     * @param salary new value for version
     */
    public void setVersion(int version) {
        this.version = version;
    }
    public void addEmployee() {
        
        if (allNotNullOrEmpty(firstName, lastName, email,title,salary )) {
            
            EmployeePojo theNewEmployee = new EmployeePojo();
            
            theNewEmployee.setFirstName(getFirstName());
            theNewEmployee.setLastName(getLastName());
            theNewEmployee.setEmail(getEmail());
            theNewEmployee.setTitle(getTitle());
            theNewEmployee.setSalary(getSalary());
            theNewEmployee.setVersion(getVersion());
            
            employeeController.addNewEmployee(theNewEmployee);

            //employeeController.toggleAdding();
            setFirstName(firstName);
            setLastName(lastName);
            setEmail(email);
            setTitle(title);
            setSalary(salary);
            setVersion(version);
        }
    }

    static boolean allNotNullOrEmpty(final Object... values) {
        if (values == null) {
            return false;
        }
        for (final Object val : values) {
            if (val == null) {
                return false;
            }
            if (val instanceof String) {
                String str = (String)val;
                if (str.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}