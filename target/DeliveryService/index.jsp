<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Delivery Service</title>
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" 
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
			integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" 
			crossorigin="anonymous">
	</head>
	<body>
		<div class="container-fluid">
			<div class="row">
				<div class="col">
					<nav class="nav">
  						<a class="nav-link active" href="#">Home</a>
  						<a class="nav-link" href="#">Link</a>
  						<a class="nav-link" href="#">About Us</a>
					</nav>
				</div>
				<div class="col"></div>
				<div class="col"></div>
				<div class="col"></div>
				<div class="col">
					<div class="btn-group btn-group-sm" role="group" aria-label="Basic example">
						<form action="controller" method="POST">
							<input type="hidden" name="command" value="toLoginForm" />
							<input type="submit" class="btn btn-success" value="Login">					
						</form>
						<form action="controller" method="POST">
							<input type="hidden" name="command" value="toRegisterForm" />
							<input type="submit" class="btn btn-success" value="Register">					
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<!-- Optional JavaScript -->
    	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" 
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" 
			crossorigin="anonymous">
		</script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" 
			integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" 
			crossorigin="anonymous">
		</script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" 
			integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" 
			crossorigin="anonymous">
		</script>
	</body>
</html>
