<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>

<div class="form-horizontal">
<form:form method="POST" action="updateemployee" modelAttribute="wrapper">
<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Phone #</th>
				<th>Email</th>
				<th>Employee ID</th>
				<th>Admin</th>
				<th>Active</th>
				<th>Terminated</th>
				<th>Action</th>
			</tr>
		</thead>


<c:forEach items="${wrapper.employees}" var="employee" varStatus="status">

		<tbody>
		<c:choose>
				<c:when test="${employee.employeeid == id}">
				
				</c:when>
				<c:otherwise>
				<tr>
				<td>${employee.firstName} ${employee.lastName}</td>
				<td>${employee.phone}</td>
				<td>${employee.email}</td>
				<td>${employee.employeeid}</td>
				<td>

					<form:select cssClass="form-control text-body" path="employees[${status.index}].admin" value="employees[${status.index}].admin" id="adminoptions">
						<form:option value="0" label="No" />
						<form:option value="1" label="Yes" />
					</form:select>
					</td>
					<td>

					<form:select cssClass="form-control text-body" path="employees[${status.index}].active" value="employees[${status.index}].active" id="activeoptions">
						<form:option value="0" label="No" />
						<form:option value="1" label="Yes" />
					</form:select>
					</td>
					<td>
					
					<form:select cssClass="form-control text-body" path="employees[${status.index}].terminated" value="employees[${status.index}].terminated" id="terminatedoptions">
						<form:option value="0" label="No" />
						<form:option value="1" label="Yes" />
					</form:select>
					
					</td>
					<td>
					<a href="<c:url value="/employee/remove?id=${employee.employeeid}" />" class="btn btn-default">Delete</a>
					</td>
					<form:hidden path="employees[${status.index}].employeeid" value="${employee.employeeid}" />

				</tr>
				</c:otherwise>
		</c:choose> 
			
		</tbody>
</c:forEach>
</table>
	<div class="form-group">
		<div class="col-md-10">
			<input type="submit" value="Update Employees" class="btn btn-default" />
		</div>
	</div>
</form:form>
</div>



