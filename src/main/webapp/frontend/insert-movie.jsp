<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Form</title>
</head>
<body>
	<h1 align="center"> This is for Insertion</h1>
		<div align="center"> 
			<form action="insert-movie" method="post" enctype="multipart/form-data">	
					Movie Name : <br>
					<input type="text" name="name" required><br><br>
					Movie Language : <br>
					<select name="language" required="required">
						<option disabled selected value=> Select a Language </option>
	            		<option> Kannada</option>
	            		<option> English</option>
	            		<option> Hindi</option>
       		 		</select>	
       		 		<br> <br>
       		 		Rating : <br>
					<input type="text" name="rating" required><br><br>
					Image : <br>
					<input type="file" name="picture" required><br><br>
					Genre : <br>
					<select name="genre" required="required">
						<option disabled selected value=> Select a Genre</option>
	            		<option> Horror</option>
	            		<option> Comedy</option>
	            		<option> Action</option>
	            		<option> Thriller</option>            		
       		 		</select>	
       		 		<br> <br>				
       		 		 <button>Add</button>		
			</form>		
		</div>
</body>
</html>

