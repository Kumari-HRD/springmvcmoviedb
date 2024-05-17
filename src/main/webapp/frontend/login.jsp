<%@page isELIgnored="false" %>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div align="center">
		<h1>Login Page</h1>
	 	<h3 align="center" style="color:red">${failure} </h3>		
		<form action="login" method="post">
				UserName : <input type="text" name="un"> <br><br>
				Password : <input type="text" name="pwd"> <br><br>
				<button>Login</button>	
		</form>	
	</div>
</body>
</html>