/***************************************************************************f******************u************zz*******y**
 * File: EmployeeController.java
 * Course materials (20W) CST 8277
 * @author (original) Mike Norman
 * @author student name: Haliima Ahmed 
 * Student number: 040825884
 * Date:Febuary 21,2020
 */
package com.algonquincollege.cst8277.employeedirectory.jsf;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

import com.algonquincollege.cst8277.employeedirectory.dao.EmployeeDao;
import com.algonquincollege.cst8277.employeedirectory.model.EmployeePojo;

/**
 * Description: Responsible for collection of Employee DTO's in XHTML (list) <h:dataTable> </br>
 * Delegates all C-R-U-D behaviour to DAO
 */
@Named("employeeController")
@SessionScoped
public class EmployeeController implements Serializable {
    private static final long serialVersionUID = 1L;

    protected FacesContext facesContext;
    protected ServletContext sc;
    protected EmployeeDao employeeDao;
    protected List<EmployeePojo> employees;
    protected boolean adding; 

    @Inject
    public EmployeeController(FacesContext facesContext, ServletContext sc, EmployeeDao employeeDao) {
        this.facesContext = facesContext;
        this.sc = sc;
        this.employeeDao = employeeDao;
    }

    public void loadEmployees() {
        sc.log("refreshing employees");
        employees = employeeDao.readAllEmployees();
    }

    public List<EmployeePojo> getEmployees() {
        return this.employees;
    }
    public void setEmployees(List<EmployeePojo> employees) {
        this.employees = employees;
    }

    public boolean isAdding() {
        return adding;
    }

    public void setAdding(boolean adding) {
        this.adding = adding;
    }

    public void toggleAdding() {
        //take the oposite of adding 
        setAdding(false);
    }

    public String editEmployee(EmployeePojo employee) {
        return null;
    }

    public String updateEmployee(EmployeePojo employee) {
        EmployeePojo employeeToUpdateEmployeed = employeeDao.readEmployeeById(employee.getId());
        if (employeeToUpdateEmployeed == null) {
            // someone else deleted it
            facesContext.addMessage(null, new FacesMessage(SEVERITY_ERROR, "Employee record missing, please refresh", null));
        }
        else {
            employeeToUpdateEmployeed = employeeDao.updateEmployee(employee);
            if (employeeToUpdateEmployeed == null) {
                // OptimisticLockException - someone else altered it 'faster' than we could hit the 'save' button
                facesContext.addMessage(null, new FacesMessage(SEVERITY_ERROR, "Employee record out-of-date, please refresh", null));
            }
            else {
                //setEditable
                employeeToUpdateEmployeed.setEditable(false);
                int idx = employees.indexOf(employee);
                employees.remove(idx);
                employees.add(idx, employeeToUpdateEmployeed);
            }
        }
        return null; 
    }

    public String cancelUpdate(EmployeePojo employee) {
        return null; 
    }

    public void deleteEmployee(int empId) {
        EmployeePojo employeePojoToBeRemoted = employeeDao.readEmployeeById(empId);
        if (employeePojoToBeRemoted != null) {
            employeeDao.deleteEmployeeById(empId);
            employees.remove(employeePojoToBeRemoted);
        }
    }
// add new employee 
    public void addNewEmployee(EmployeePojo theNewEmployee) {
        EmployeePojo addNewEmployees = employeeDao.createEmployee(theNewEmployee);
        if (addNewEmployees != null) {
            employeeDao.createEmployee(theNewEmployee);
            employees.add(addNewEmployees);
        }    }
}