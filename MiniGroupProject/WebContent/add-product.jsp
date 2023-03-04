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
		<h3>OrderMore</h3>
		
		<form action="CustomerServlet" method="GET">
		
			<input type="hidden" name="command" value="additems" />
			
			<table>
				<tbody>
					<tr>
						<td><label>productID :</label></td>
						<td><input type="text" name="productIDtoaddproduct" /></td>
					</tr>

					<tr>
						<td><label>productName:</label></td>
						<td><input type="text" name="productNametoaddproduct" /></td>
					</tr>					
					<tr>
						<td><label>plz enter again city:</label></td>
						<td><input type="text" name="citytoaddproduct" /></td>
					</tr>
					<tr>
						<td><label>plz enter the storename:</label></td>
						<td><input type="text" name="usernametoaddproduct" /></td>
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
			<a href="after-shop-login.jsp">Back to List</a>
		</p>
	</div>
</body>

</html>











