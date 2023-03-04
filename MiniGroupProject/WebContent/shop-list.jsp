<%@ page import="java.util.*, com.userproduct.web.*,com.userproduct.dao.*,com.userproduct.bean.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>OPENWEAVERMART</title>	
	
	<input type="button" value="place more order" 
				  onclick="window.location.href='add-product.jsp'; return false;"
				   class="add-student-button"/>
	
	<link type ="text/css" rel =" stylesheet" href ="css/style.css" >
</head>

<%
	// get the students from the request object (sent by servlet)
	List<ShopCustomer> theStudents = 
					(List<ShopCustomer>) request.getAttribute("listshop");

%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>YOUR products</h2>
		</div>
	</div>

	<div id="container">
	
	
		<div id="content">


		
			<table>
			
				<tr>
					<th> product name</th>
					<th> product id</th>
			
				</tr>
				
				<% for ( ShopCustomer tempStudent : theStudents) { %>
				
					<tr>
						<td> <%= tempStudent.getProductName() %> </td>
						<td> <%= tempStudent.getProductId() %> </td>
						
					</tr>
				
				<% } %>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>