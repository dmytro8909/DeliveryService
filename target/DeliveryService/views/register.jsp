<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<%@ include file="/views/jspf/head.jspf" %>
	<body class="text-center">
		<%@ include file="/views/jspf/header.jspf"%>
		<div class="container-fluid">
			<div class="row">
				<div class="col"></div>
				<div class="col"></div>
				<div class="col">
					<form name="registerForm" method="POST" action="controller">
						<input type="hidden" name="command" value="register" />
						<div class="form-group">
							<input type="text" class="form-control" 
								   name="name" placeholder="First name">
						</div>			
						<div class="form-group">
							<input type="text" class="form-control" 
								   name="lastName" placeholder="Last name">
						</div>		
						<div class="form-group">	
							<input type="text" class="form-control" 
								   name="login"	placeholder="Login">
						</div>		
						<div class="form-group">	
							<input type="password" class="form-control" 
								   name="password" placeholder="Password">
						</div>	
						<br/>
							${errorLoginPassMessage}
							${wrongAction}
							${nullPage}
						<br/>
						<button type="submit" 
							    class="btn btn-lg btn-success btn-block">
							    Registration</button>		
					</form>
				</div>
				<div class="col"></div>
				<div class="col"></div>
			</div>
		</div>
		<%@ include file="/views/jspf/footer.jspf"%>
	</body>
</html>