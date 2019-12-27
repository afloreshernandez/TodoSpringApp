<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<table class="table table-striped table-dark">
	<thead>
	
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Fullname</th>
			<th>Roles</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<!-- for(Items item: val) -->
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.userName}</td>
				<td>${user.password}</td>
				<td>${user.fullName}</td>
				<td>${user.roles}</td>
				<td><a role="button"  class="btn btn-danger" href="/deleteuser?userId=${user.id}">Delete</a></td>
			    <td><a role="button"  class="btn btn-danger" href="/edituser?userId=${user.id}">Edit</a></td>
			
			</tr>
		</c:forEach>
		
	</tbody>
	</table>
	
Click here to <a href="/user">Add user</a>

<%@ include file="common/footer.jspf" %>
