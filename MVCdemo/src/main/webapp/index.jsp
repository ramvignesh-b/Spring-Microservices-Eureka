<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="css/main.css"/>
</head>
<body>
<div class="container" id="container">
	<div class="form-container sign-up-container">
		<form action="register" method="POST">
			<h1>Create Account</h1>
			<input type="text" placeholder="Name" name="name" required/>
			<input type="email" placeholder="Email" name="email" required/>
			<input type="text" placeholder="Username" name="username" required/>
			<input type="password" placeholder="Password" name="password" required/>
			<br>
			<button type="submit">Sign Up</button>
		</form>
	</div>
	<div class="form-container sign-in-container">
		<form action="login" method="POST">
			<h1>Sign in</h1>
			<input type="text" placeholder="Username" name="username" required/>
			<input type="password" placeholder="Password" name="password" required/>
			<br>
			<button type="submit">Sign In</button>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>Hello, Friend!</h1>
				<p>Already have an account?</p>
				<button class="ghost" id="signIn">Sign In</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>Welcome Back!</h1>
				<p>Don't have an account?</p>
				<button class="ghost" id="signUp">Sign Up</button>
			</div>
		</div>
	</div>
</div>
 
 <script type="text/javascript" src="js/script.js"></script>
</body>
</html>