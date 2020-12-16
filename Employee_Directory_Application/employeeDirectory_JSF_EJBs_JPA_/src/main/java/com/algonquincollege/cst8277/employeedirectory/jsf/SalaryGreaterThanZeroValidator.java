/***************************************************************************f******************u************zz*******y**
 * File: EmployeeController.java
 * Course materials (20W) CST 8277
 * @author (original) Mike Norman
 * @author student name: Haliima Ahmed 
 * Student number: 040825884
 * Date:Febuary 21,2020
 */
package com.algonquincollege.cst8277.employeedirectory.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

public class SalaryGreaterThanZeroValidator {
    
   
    public void validate(FacesContext context, UIComponent component, Double value) throws ValidatorException {
       
        if (value == null || value < 0) {
            return;
        } else if (context.isValidationFailed()) {
            throw new ValidatorException(new FacesMessage( FacesMessage.SEVERITY_ERROR,"true", null ));
       }else if(component.isCompositeComponent(component)) {
            throw new ValidatorException(new FacesMessage( FacesMessage.SEVERITY_ERROR,"true", null ));
       }

    }

}