<%@page isELIgnored="false" %>
<html>
<head>

</head>
<body>
	<h3 align="center" style="color:green">${success} </h3>
	<h3 align="center" style="color:red">${failure} </h3>
 	<div align="center">
		<h2> Movie Collection</h2>
		<a href="insert-movie"><button> Add Movie</button></a> <br> <br>
		<a href="fetch-movies"><button> View All Movies</button></a> <br> <br>
		<a href="fetch-movies-id"><button>View Movies by ID</button></a> <br> <br>
		<a href="fetch-movies-name"><button>View Movies by Name</button></a> <br> <br>
		<a href="fetch-movies-rating"><button>View Movies by Rating</button></a> <br> <br>
		<a href="fetch-movies-language"> <button>View Movies by Language</button></a> <br> <br>
		<a href="fetch-movies-genre"><button>View Movies by Genre</button></a> <br> <br>
		<a href="logout"><button>Logout</button></a><br><br>	
	 </div>
</body>	
</html>
