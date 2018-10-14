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


<form:form method="POST" action="addemployee" modelAttribute="employee">

<div class="form-horizontal">
	<h2>Add a New Employee</h2>
	<hr/>
	<br/>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="firstName">First Name:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="firstName"></form:input>
    			<form:errors path="firstName" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="lastName">Last Name:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="lastName"></form:input>
    			<form:errors path="lastName" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="email">Email:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="email"></form:input>
    			<form:errors path="email" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="phone">Phone:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="phone"></form:input>
    			<form:errors path="phone" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="employeeid">Employee ID:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="employeeid"></form:input>
    			<form:errors path="employeeid" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="col-md-2 control-label" path="admin" for="adminoptions">Admin (1=true, 0=false):</form:label>
    		<div class="col-md-10">
    			<form:select class="form-control text-body" path="admin" id="adminoptions">
				    <option>0</option>
				    <option>1</option>
				</form:select>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="col-md-2 control-label" path="active" for="activeoptions">Active (1=true, 0=false):</form:label>
    		<div class="col-md-10">
    			<form:select class="form-control text-body" path="active" id="activeoptions">
				    <option>1</option>
				    <option>0</option>
				</form:select>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="col-md-2 control-label" path="terminated" for="terminatedoptions">Terminated (1=true, 0=false):</form:label>
    		<div class="col-md-10">
    			<form:select class="form-control text-body" path="terminated" id="terminatedoptions">
				    <option>0</option>
				    <option>1</option>
				</form:select>
			</div>
	</div>
	
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<input type="submit" value="Add Employee" class="btn btn-default" />
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<p style="color:#ff0000;">${message}</p>
		</div>
	</div>

</div>

</form:form>
