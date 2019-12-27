<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<table class="table table-striped table-dark">
	<thead>
		<tr>
			<th>Description</th>
			<th>Target Date</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<!-- for(Items item: val) -->
		<c:forEach items="${todos}" var="todo">
			<tr>
				<td>${todo.description}</td>
				<td><fmt:formatDate value="${todo.targetDate}"
				 pattern="MM/dd/yyyy"/></td>
				<td>${todo.status}</td>
				<td><a role="button"  class="btn btn-danger" href="/deletetodo?todoId=${todo.id}">Delete</a></td>
			    <td><a role="button"  class="btn btn-danger" href="/edittodo?todoId=${todo.id}">Edit</a></td>
			
			</tr>
		</c:forEach>
		
	</tbody>
	</table>
	
Click here to <a href="/todo">Add To do</a>

<%@ include file="common/footer.jspf" %>
