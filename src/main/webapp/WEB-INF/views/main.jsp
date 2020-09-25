<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Welcome</title>
	</head>
	<body>
		<h3>Welcome</h3>
		<hr/>
			${user}, hello!
		<hr/>
		<a href="controller?command=logout">Logout</a>
	</body>
</html>