/***************************************************************************f******************u************zz*******y**
 * File: EmployeeDTO.java
 * Course materials (20W) CST 8277
 *
 * @author (original) Mike Norman
 * @author student name: Haliima Ahmed 
 * Student number: 040825884
 * Date:Febuary 21,2020
 */

package com.algonquincollege.cst8277.employeedirectory.model;

import java.time.LocalDateTime;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.PersistenceContext;
import javax.persistence.PostLoad;

public class EmployeePojoListener {

    @PrePersist
    public void setCreatedOnDate(EmployeePojo emp) {
        LocalDateTime now = LocalDateTime.now();
        emp.setCreated_Date(now);
        emp.setUpdated_Date(now);
    }
    @PreRemove
    public void setRemovedOnDate(EmployeePojo emp) {
        emp.setRemovedOnDate(LocalDateTime.now());
    }
    
    @PostPersist
    public void setPostCreatedOnDate(EmployeePojo emp) {
        LocalDateTime now = LocalDateTime.now();
        emp.setPostCreatedOnDate(now);
        emp.setPostUpdatedDate(now);
    }
    @PostRemove
    public void setPostRemovedOnDate(EmployeePojo emp) {
        emp.setPostRemovedOnDate(LocalDateTime.now());
    }
    
    @PreUpdate
    public void setUpdated_Date(EmployeePojo emp) {
        emp.setUpdated_Date(LocalDateTime.now());
    }
    
   @PostUpdate
   public void setPostUpdatedDate(EmployeePojo emp) {
       emp.setPostUpdatedDate(LocalDateTime.now());
   }
   
   @PersistenceContext 
   @PostLoad
   public void setPostLoadDate(EmployeePojo emp) {
       emp.setLoadDate(LocalDateTime.now());
   }

}
