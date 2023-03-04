<%@ page import="java.util.*, com.userproduct.web.*,com.userproduct.dao.*,com.userproduct.bean.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>OPENWEAVERMART</title>	
	
	<link type ="text/css" rel =" stylesheet" href ="css/style.css" >
</head>
         
           
		<%List<ShopCustomer> zamm = (List<ShopCustomer>) request.getAttribute("listuser");%>	
	

<body>

	<div id="wrapper">
		<div id="header">
			<h2>placeOrder</h2>
		</div>
	</div>

		<div id="container">
		
	
	
		<div id="content">
		
				<!-- put new button: Add Student -->
			
			<table  >
			
				<tr>
					<th> product name</th>
					<th> product id</th>
					<th> shop name</th>
					
					
				</tr>
				
				<% for ( ShopCustomer tempStudent : zamm) { %>
				
					<tr>
						<td> <%= tempStudent.getProductName() %> </td>
						<td> <%= tempStudent.getProductId() %> </td>					
						<td> <%= tempStudent.getUserName() %> </td>
						
					</tr>
				
				<% } %>
				
			</table>
		
		</div>
	
	</div>
	
</body>


</html>