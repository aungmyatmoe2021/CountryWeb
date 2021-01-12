package com.countryweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[EmployeeServlet]doGet method is starting here.");
		doProcess(request, response);
		System.out.println("[EmployeeServlet]doGet method is starting here.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[EmployeeServlet]doPost method is starting here.");
		doProcess(request, response);
		System.out.println("[EmployeeServlet]doPost method is starting here.");
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[EmployeeServlet]doProcess method is starting here.");
		String keyFilter = "";
		String keyValue="";
		String hidIndex = "";
		if(request.getParameter("keyFilter") != null) {
			keyFilter = request.getParameter("keyFilter");
		}
		if(request.getParameter("txtKeyValue") != null) {
			keyValue = request.getParameter("txtKeyValue");
		}
		if(request.getParameter("hidIndex") != null) {
			hidIndex = request.getParameter("hidIndex");
		}
		
		
		
		System.out.println("[EmployeeServlet]doProcess method is starting here.");
	}

}
