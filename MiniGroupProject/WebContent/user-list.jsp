<%@ page import="java.util.*, com.userproduct.web.*,com.userproduct.dao.*,com.userproduct.bean.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>OPENWEAVERMART</title>	
	
	<link type ="text/css" rel =" stylesheet" href ="css/style.css" >
</head>

<%
	// get the students from the request object (sent by servlet)
	List<ShopCustomer> theStudents = 
					(List<ShopCustomer>) request.getAttribute("listUser");

%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Previous Order</h2>
		</div>
	</div>

	<div id="container">
	
	
		<div id="content">
		
				<!-- put new button: Add Student -->
			<input type="button" value="place more order" 
				  onclick="window.location.href='user-form.jsp'; return false;"
				   class="add-student-button"/>
				   
			<form action="CustomerServlet" method="GET">
				<input type="hidden" name="command" value="product" />
				    <input type = "submit" value=" itemslist"  />
			</form>
				   
			
			
<!-- 			<input type="button" value=" itemslist "  -->
<!-- 				   onclick="window.location.href='item-form.jsp'; return false;" -->
<!-- 				   class="add-student-button" -->
<!-- 			/> -->
			
<!-- 			<form action="CustomerServlet" method="GET"> -->
		
<!-- 			<input type="hidden" name="command" value="addorder" /> -->
			
			
		
		
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