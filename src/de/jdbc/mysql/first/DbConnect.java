package de.jdbc.mysql.first;

import java.awt.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;

import de.jdbc.mysql.first.MySqlConnect;
import de.jdbc.mysql.first.*;

import org.json.simple.*;
import org.json.simple.parser.*;
import com.google.gson.*;

/**
 * Servlet implementation class DbConnect
 */
@WebServlet("/DbConnect")
public class DbConnect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DbConnect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String location = request.getParameter("location");*/
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		MySqlConnect mysqlclass = new MySqlConnect();
		try {
			String resultoajax = mysqlclass.getDataBase();
	        out.write(resultoajax);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}        	
	}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
