package com.userproduct.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.userproduct.bean.Customer;
import com.userproduct.bean.Shop;
import com.userproduct.bean.ShopCustomer;
import com.userproduct.dao.UserCustomerService;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private UserCustomerService usercustomerservice;
	
	@Resource(name="jdbc/miniproject")
	private DataSource dataSource;
	
	

 

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		
		usercustomerservice = new UserCustomerService(dataSource);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//product(request,response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// read the "command" parameter
//			System.out.println("i am inside the try methord ");
			String fristname = request.getParameter("fristnametotake");
			String dateofbirth = request.getParameter("dateofbirth");

			//String city = request.getParameter("citytotake");
			//String city ="chennai" ;
			
			String storename = request.getParameter("storenametotake");
			String storecity = request.getParameter("citytotakeforshop");
		//	System.out.println("i have got alldetail"+ city);
		
			String theCommand = request.getParameter("command");	
				switch(theCommand){
				
			
				case"product":
					System.out. println("i am in command product ");
					String city = request.getParameter("citytotake");
					System.out.println("i have got alldetail"+ city);

					product(request,response,"chennai");					
					break;
				case "addorder":
					System.out.println("i am in command addorder  ");
					addOrder(request,response);					 
					break;
				case "userdetails":
					adduser(request,response);
					break;
				case "shopdetails":
					addshop(request,response);
					break;
				case "userlogin":
				    userlogin(request,response);
				    break;
				case "shoplogin" :   
					shoplogin(request,response);

				case"additems":
					additems(request,response);
					break;
			default	:				
					break;
				}
		}
		
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	
		

			
	}
		
	
	

	private void additems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("productNametoaddproduct");
		
		String productId = request.getParameter("productIDtoaddproduct");
		String storename = request.getParameter("usernametoaddproduct");
		String city = request.getParameter("citytoaddproduct");
		String userName = storename +city;
		
		
		
		

		 
		ShopCustomer newUser = new ShopCustomer(productName,productId,city,userName);
		usercustomerservice.additems(newUser);
		shopproducts(request,response,storename,city);	
		
	
		
	}
	private void shopproducts(HttpServletRequest request, HttpServletResponse response, String storename, String city) throws ServletException, IOException {
				
		
		String username = storename + city;
		List<ShopCustomer> listUser = usercustomerservice.getshopproducts(username);
		request.setAttribute("listshop", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("shop-list.jsp");		
		dispatcher.forward(request, response);
		
		
	}
	private void shoplogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String storename = request.getParameter("storenametotake");
		String city = request.getParameter("citytotakeforshop");
		Shop a = new Shop();
		a.setStorename(storename);
		a.setCity(city);
		
		if (usercustomerservice.validShopid(a))
		{ 
			shopproducts(request,response,storename,city);	
			
		}
		else 
		{
			response.sendRedirect("shop-register.jsp");

			//HttpSession session = request.getSession();
			
			
		}
		
		
		
		
	}
	private void userlogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String fristname = request.getParameter("fristnametotake");
		String dateofbirth = request.getParameter("dateofbirth");
		String city = request.getParameter("citytotake");
		String userName = fristname+city;
		Customer a = new Customer();
		a.setFristname(fristname);
		a.setDateofbirth(dateofbirth);
		
		if (usercustomerservice.validUserid(a))
		{ 
			previousOrder(request,response,userName);
			
			
		}
		else 
		{
			response.sendRedirect("user-register.jsp");

			//HttpSession session = request.getSession();
			
			
		}
		
		
		
		
	
		
		
		
		
	}
	private void addshop(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String storename = request.getParameter("storename");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String userName= storename+city;
		Shop user = new Shop(storename,address,city,userName);
		usercustomerservice.addShop(user);
		response.sendRedirect("shop-register.jsp");
		
		
	}
	private void adduser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fristname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String dateofbirth = request.getParameter("dateofbirth");
		String city = request.getParameter("city");
		DateTimeFormatter birthDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        LocalDate birthDate = LocalDate.parse(dateofbirth, birthDateFormat); 
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();
        if(age>=18) {
        	String userName= fristname+city;
    		Customer newUser = new Customer(fristname,lastname,dateofbirth,city,age,userName);
    		usercustomerservice.addUser(newUser);
    		response.sendRedirect("user-register.jsp");
        	
        }else {
        	response.sendRedirect("under-age.jsp");
        	
        }
        
        
		


		
		
	}
	private void  product(HttpServletRequest request, HttpServletResponse response,String city ) throws ServletException, IOException {
		
//		System.out.println("im in the jdbc ");
//		String city = request.getParameter("citytotake");


		List<ShopCustomer> listUser = usercustomerservice.getItems(city);
		request.setAttribute("listuser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("item-form.jsp");		
		dispatcher.forward(request, response);
		
		
		
		
	}
	private void previousOrder(HttpServletRequest request, HttpServletResponse response,String username) throws ServletException, IOException {
	//    String userName = request.getParameter("userName");
		

		List<ShopCustomer> listUser = usercustomerservice.getPreviousOrder(username);
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");		
		dispatcher.forward(request, response);
		
		
		
	}
	private void addOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//System.out.println("ur data have reached to the jdbc connaction");
		String productName = request.getParameter("productName");
		//System.out.println("i have got productname");
		
		String productId = request.getParameter("productID");
	//	System.out.println("i have got product id");
		
		
		
		String userName =request.getParameter("userName");
		
		
		if (usercustomerservice.validorder(productId))
		{ 
			ShopCustomer newUser = new ShopCustomer(productName,productId,userName);
			usercustomerservice.addorder(newUser);		
			previousOrder(request,response,userName);
			System.out.println("again previous called");	
		}
		else 
		{
			response.sendRedirect("user-form.jsp");
		}
	}
}
