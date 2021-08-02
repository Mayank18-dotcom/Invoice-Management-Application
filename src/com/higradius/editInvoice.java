package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editInvoice
 */
@WebServlet("/editInvoice")
public class editInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String url = "jdbc:mysql://localhost:3306/hrc";
	static final String uname = "root";
	static final String pass = "mayanksql";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editInvoice() {
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
			String output = request.getParameter("toEdit");
			int size = output.length();
	
			ArrayList<String> arr = new ArrayList<String>();
			String temp = "";
			for(int i = 0 ; i < size-1 ; i++) {
				temp = temp + output.charAt(i);
				if(output.charAt(i+1) == '$') {
					arr.add(temp);
					i++;
					temp = "";
				}
			}
			String invID = arr.get(0);
			String amount = arr.get(1);
			String note = arr.get(2);
			
			int ID = Integer.parseInt(invID);
			float Amount = Float.parseFloat(amount);	
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			String query = "update mytable set Invoice_Amount=?,Notes=? where Invoice_Number_Invoice_= ?";
			PreparedStatement st=con.prepareStatement(query);  
			st.setFloat(1, Amount);
			st.setString(2, note);
			st.setInt(3, ID);
			st.execute();
			System.out.println("Updated !");
			response.sendRedirect("/H2HBABBA2606/fetchdata");
		} catch (Exception e) {
			System.err.println("Got an exception!");
		    System.err.println(e.getMessage());
		}
	}

}
