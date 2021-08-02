package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fetchdata
 */
@WebServlet("/fetchdata")
public class fetchdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String url = "jdbc:mysql://localhost:3306/hrc";
	static final String uname = "root";
	static final String pass = "mayanksql";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fetchdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			Statement st = con.createStatement();
			String query = "select * from mytable";
			ResultSet rs = st.executeQuery(query);
			
			ArrayList<Response> mainList = new ArrayList<Response>();
			while(rs.next()) {
				Response record = new Response();
				record.setCustomerName(rs.getString("Customer_Name"));
				record.setCustomerNumber(rs.getString("Customer_Number_Customer_"));
				record.setDueDate(rs.getDate("Due_Date"));
				record.setInvoiceAmount(rs.getFloat("Invoice_Amount"));
				record.setInvoiceNumber(rs.getInt("Invoice_Number_Invoice_"));
				record.setPredicted_Payment_Date(rs.getDate("Predicted_Payment_Date"));
				record.setPredicted_Aging_Bucket(rs.getString("Predicted_Aging_Bucket"));
				record.setNotes(rs.getString("Notes"));
				mainList.add(record);
			}
			request.setAttribute("allData", mainList);
			System.out.println("Running !");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
		} catch (Exception e) {
			System.err.println("Got an exception!");
		    System.err.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
	}

}
