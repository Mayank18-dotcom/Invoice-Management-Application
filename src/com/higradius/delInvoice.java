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
 * Servlet implementation class delInvoice
 */
@WebServlet("/delInvoice")
public class delInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String url = "jdbc:mysql://localhost:3306/hrc";
	static final String uname = "root";
	static final String pass = "mayanksql";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delInvoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = request.getParameter("toDelete");
		int size = output.length();
		ArrayList<String> arr = new ArrayList<String>();
		String temp = "";
		for(int i = 0 ; i < size ; i++) {
			if(output.charAt(i) >= '0' && output.charAt(i) <= '9') {
				temp = temp + output.charAt(i);
			}
			else {
				if(temp.length() > 0) {
					arr.add(temp);
					temp = "";
				}
			}
		}
		
		ArrayList<Integer> finalID = new ArrayList<Integer>(arr.size());
		for(String x : arr) {
			finalID.add(Integer.parseInt(x));
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			for(Integer x : finalID) {
				String query = "DELETE FROM mytable WHERE Invoice_Number_Invoice_ = ?";
				PreparedStatement st = con.prepareStatement(query);
				st.setInt(1,x);
				st.executeUpdate();
			}
			System.out.println("Deleted !");
			response.sendRedirect("/H2HBABBA2606/fetchdata");
		} catch (Exception e) {
			System.err.println("Got an exception!");
		    System.err.println(e.getMessage());
		}
	}

}
