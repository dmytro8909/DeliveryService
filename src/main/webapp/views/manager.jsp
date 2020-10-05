<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<%@ include file="/views/jspf/head.jspf" %>
	<body class="text-center">
		<%@ include file="/views/jspf/header_after_login.jspf"%>
		<div class="container-fluid">
			<div class="row">
				<div class="col"></div>
				<div class="col">
					<h3>${user}, hello!</h3>
				</div>
				<div class="col"></div>
			</div>
		</div>
		<%@ include file="/views/jspf/footer.jspf"%>
	</body>
</html>