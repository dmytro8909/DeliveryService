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
					<form name="loginForm" method="POST" action="controller">
						<input type="hidden" name="command" value="login" />
						<div class="form-group">
    						<input type="text" name="login" 
    							   class="form-control" placeholder="Login">
						</div>
						<div class="form-group">
						    <input type="password" name="password" 
						           class="form-control" placeholder="Password">
						</div>
						<br/>
							${errorLoginPassMessage}
							${wrongAction}
							${nullPage}
						<br/>
						    <button type="submit" 
						            class="btn btn-lg btn-success btn-block">
						            Log in</button>
					</form>
				</div>
				<div class="col"></div>
				<div class="col"></div>
			</div>
		</div>
		<%@ include file="/views/jspf/footer.jspf"%>
	</body>
</html>