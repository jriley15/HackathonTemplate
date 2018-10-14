<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>

<form:form method="POST" action="updateemployee" modelAttribute="employees">
<table class="table table-hover">
		<thead>
			<tr>
				<th>Employee Name</th>
				<th>Phone #</th>
				<th>Email</th>
				<th>Employee ID</th>
				<th>Admin</th>
				<th>Active</th>
				<th>Terminated</th>
			</tr>
		</thead>


<c:forEach items="${employees}" var="employee" varStatus="status">

		<tbody>
			<tr>
				<td>${employee.firstName} ${employee.lastName}</td>
				<td>${employee.phone}</td>
				<td>${employee.email}</td>
				<td>${employee.employeeid}</td>
				<td>
				<div class="form-group">
			    		<div class="col-sm-3">
			    			<form:select class="form-control text-body" path="employee[${status.index}].admin" value="${employee.admin}" id="adminoptions">
							    <option>0</option>
							    <option>1</option>
							</form:select>
						</div>
				</div>
				</td>
				<td>
				<div class="form-group">
		    		<div class="col-sm-3">
		    			<form:select class="form-control text-body" path="employee[${status.index}].active" value="${employee.active}" id="activeoptions">
						    <option>1</option>
						    <option>0</option>
						</form:select>
					</div>
				</div>
				</td>
				<td>
				<div class="form-group">
		    		<div class="col-md-3">
		    			<form:select class="form-control text-body" path="employee[${status.index}].terminated" value="${employee.terminated}" id="terminatedoptions">
						    <option>0</option>
						    <option>1</option>
						</form:select>
					</div>
				</div>
				</td>
			</tr>
		</tbody>
</c:forEach>
</table>
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<input type="submit" value="Update Employees" class="btn btn-default" />
		</div>
	</div>
</form:form>

