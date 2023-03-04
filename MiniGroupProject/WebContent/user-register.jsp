<%@ page import="java.util.*, com.userproduct.web.*,com.userproduct.dao.*,com.userproduct.bean.*" %>

<!DOCTYPE html>
<html>

<head>
	<title>order more</title>

	<link type="text/css" rel="stylesheet" href="css/servlet!.css">
	
</head>


<body>

    
	<div id="wrapper">
		<div id="header">
			<h2>open weaver mart</h2>
		</div>
	</div>
	
	
	
	<div id="container">
		<h3>User register</h3>
		
		<form action="CustomerServlet" method="GET">
		
			<input type="hidden" name="command" value="userdetails" />
			
			<table>
				<tbody>
					<tr>
						<td><label>firstname :</label></td>
						<td><input type="text" name="firstname" /></td>
					</tr>

					<tr>
						<td><label>lastname:</label></td>
						<td><input type="text" name="lastname" /></td>
					</tr>
					<tr>
						<td><label>dateofbirth:</label></td>
						<td><input type="text" name="dateofbirth" /></td>
					</tr>
					<tr>
						<td><label>city:</label></td>
						<td><input type="text" name="city" /></td>
					</tr>
					
			
			 
			 			
					
					
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					 
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="main-page.jsp">Back to List</a>
		</p>
	</div>
</body>

</html>











