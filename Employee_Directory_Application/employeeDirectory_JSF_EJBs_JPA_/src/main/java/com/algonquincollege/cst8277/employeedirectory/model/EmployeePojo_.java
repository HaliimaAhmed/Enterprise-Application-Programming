package com.algonquincollege.cst8277.employeedirectory.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-02-21T22:07:41.200-0500")
@StaticMetamodel(EmployeePojo.class)
public class EmployeePojo_ {
	public static volatile SingularAttribute<EmployeePojo, Integer> id;
	public static volatile SingularAttribute<EmployeePojo, String> firstName;
	public static volatile SingularAttribute<EmployeePojo, String> lastName;
	public static volatile SingularAttribute<EmployeePojo, String> email;
	public static volatile SingularAttribute<EmployeePojo, String> title;
	public static volatile SingularAttribute<EmployeePojo, Double> salary;
	public static volatile SingularAttribute<EmployeePojo, Integer> version;
	public static volatile SingularAttribute<EmployeePojo, LocalDateTime> postCreatedOnDate;
	public static volatile SingularAttribute<EmployeePojo, LocalDateTime> removedOnDate;
	public static volatile SingularAttribute<EmployeePojo, LocalDateTime> postRemovedOnDate;
	public static volatile SingularAttribute<EmployeePojo, LocalDateTime> loadDate;
	public static volatile SingularAttribute<EmployeePojo, LocalDateTime> postUpdatedDate;
	public static volatile SingularAttribute<EmployeePojo, LocalDateTime> updated_Date;
	public static volatile SingularAttribute<EmployeePojo, LocalDateTime> created_Date;
	public static volatile SingularAttribute<EmployeePojo, Boolean> editable;
}
