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
		
			<input type="hidden" name="command" value="shopdetails" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Storename  :</label></td>
						<td><input type="text" name="storename" /></td>
					</tr>
					<tr>
						<td><label>address:</label></td>
						<td><input type="text" name="address" /></td>
					</tr>
				
						<td><label>city:</label></td>
						<td><input type="text" name="city" /></td>
					</tr>
								
			 
			 			
					
					
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" onclick ="main-page.jsp"/></td>
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











