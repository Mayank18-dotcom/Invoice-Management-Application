package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addInvoice
 */
@WebServlet("/addInvoice")
public class addInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String url = "jdbc:mysql://localhost:3306/hrc";
	static final String uname = "root";
	static final String pass = "mayanksql";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addInvoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			
			String query = "INSERT INTO mytable (Customer_Number_Customer_,Customer_Name,Due_Date,Invoice_Amount,Invoice_Number_Invoice_,Predicted_Payment_Date,Predicted_Aging_Bucket,Notes) VALUES(?,?,?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(query);
			String CustomerName = request.getParameter("CustomerName");
			String CustomerNumber = request.getParameter("CustomerNumber");
			int InvoiceNumber = Integer.parseInt(request.getParameter("InvoiceNumber")); 
			float InvoiceAmount = Float.parseFloat(request.getParameter("InvoiceAmount")); 
			String Notes = request.getParameter("Notes");
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dates")); 
			java.sql.Date sqlDate=new java.sql.Date(date.getTime());

			st.setString(1, CustomerNumber);
			st.setString(2, CustomerName);
			st.setObject(3, sqlDate);
			st.setFloat(4, InvoiceAmount);
			st.setFloat(5, InvoiceNumber);
			st.setDate(6, null);
			st.setString(7, "-");
			st.setString(8, Notes);
			st.execute();
			System.out.println("Added !");
			response.sendRedirect("/H2HBABBA2606/fetchdata");  
		} catch (Exception e) {
			System.err.println("Got an exception!");
		    System.err.println(e.getMessage());
		}
	}

}
