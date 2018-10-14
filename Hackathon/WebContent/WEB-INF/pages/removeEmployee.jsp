<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>

<!-- 
Trevor Moore
CST-341
10/10/2018
This assignment was completed in collaboration with Trevor Moore and Aaron Ross

We used source code from the following websites to complete this assignment:
https://www.w3schools.com/bootstrap/bootstrap_forms.asp
https://www.w3schools.com/bootstrap/bootstrap_forms_inputs.asp
https://www.guru99.com/jsp-date-handling.html

For bootstrapping the form, and also getting the current date/time
-->


<form:form method="POST" action="deleteemployee" modelAttribute="employee">


<div class="form-horizontal">
	<h2>Are you sure you want to delete this employee?</h2>
	<hr/>
	<br/>
		<dl class="dl-horizontal">
				
			<dt>
				First Name:
			</dt>
	
			<dd>
				${employee.firstName}
			</dd>
			
			<dt>
				Last Name:
			</dt>
	
			<dd>
				${employee.lastName}
			</dd>
		
			<dt>
				Phone Number:
			</dt>
	
			<dd>
				${employee.phone}
			</dd>
			
			<dt>
				Email:
			</dt>
	
			<dd>
				${employee.email}
			</dd>
			
			<dt>
				Employee ID:
			</dt>
	
			<dd>
				${employee.employeeid}
			</dd>	
				 
		
		</dl>
		
		<table class="table">
		<tbody>
		<tr>
			<form:hidden path="employeeid" value="${employee.employeeid}"/>
		</tr>
		</tbody>
		</table>
		
		<div class="form-group">
			<div class="col-md-10">
				<input type="submit" value="Delete Employee" class="btn btn-default" />
			</div>
		</div>

</div>

</form:form>