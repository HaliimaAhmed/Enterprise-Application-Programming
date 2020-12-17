/*****************
  * File: EmployeeService.java
 * Date:Febuary 21,2020
 */
package com.algonquincollege.cst8277.employeedirectory.ejb;

import static com.algonquincollege.cst8277.employeedirectory.model.EmployeePojo.ALL_EMPLOYEES_QUERY_NAME;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.algonquincollege.cst8277.employeedirectory.model.EmployeePojo;

/**
 * Stateless Session Bean EJB EmployeeService
 */
@Stateless
public class EmployeeService implements Serializable {
    private static final long serialVersionUID = 1L;

    @PersistenceContext(name = "employeeDirectory-PU")
    protected EntityManager em;

    /**
     * Default constructor.
     */
    public EmployeeService() {
    }

    public List<EmployeePojo> findAllEmployees() {
        TypedQuery<EmployeePojo> allEmpsQuery = em.createNamedQuery(ALL_EMPLOYEES_QUERY_NAME, EmployeePojo.class);
        return allEmpsQuery.getResultList();
    }

    @Transactional
    public EmployeePojo persistEmployee(EmployeePojo employee) {
        em.persist(employee);
        return employee;
    }

    public EmployeePojo findEmployeeByPrimaryKey(int empPK) {
        return em.find(EmployeePojo.class, empPK);
    }

    @Transactional
    public EmployeePojo mergeEmployee(EmployeePojo employeeWithUpdates) {
        EmployeePojo EmployeeToBeUpdated = findEmployeeByPrimaryKey(employeeWithUpdates.getId());
        if(EmployeeToBeUpdated != null) {
        EmployeePojo mergedEmployeePojo = em.merge(employeeWithUpdates);
        return mergedEmployeePojo;
        }
      return EmployeeToBeUpdated;
    }

    @Transactional
    public void removeEmployee(int employeeId) {
        EmployeePojo employee = findEmployeeByPrimaryKey(employeeId);
        if (employee != null) {
            em.refresh(employee);
            em.remove(employee);
        }
    }

}
