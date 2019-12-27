<%@ include file ="common/header.jspf" %>
<%@ include file ="common/navigation.jspf" %>
	Add user 
		<form:form method="post" modelAttribute = "user">
			<form:hidden path="id"/>
			
			<fieldset class="form-group">
				<form:label path= "userName">UserName:</form:label> 
				<form:input type="text" path="userName" class="form-control" required = "required"/>
				<form:errors path="userName" class="text-warning"/>
			</fieldset>
			<fieldset class="form-group">
				<form:label path= "password">Password:</form:label> 
				<form:input type="text" path="password" class="form-control" required = "required"/>
				<form:errors path="password" class="text-warning"/>
			</fieldset>
				<fieldset class="form-group">
				<form:label path= "fullName">Full Name:</form:label> 
				<form:input type="text" path="fullName" class="form-control" required = "required"/>
				<form:errors path="fullName" class="text-warning"/>
			</fieldset>
			<fieldset class="form-group">
				<form:label path= "roles">Roles:</form:label> 
				<form:input type="text" path="roles" class="form-control" required = "required"/>
				<form:errors path="roles" class="text-warning"/>
			</fieldset>
			
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>



<%@ include file ="common/footer.jspf" %>

