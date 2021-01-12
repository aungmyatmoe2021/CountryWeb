package com.countryweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.countryweb.dao.CountryImp;
import com.countryweb.model.Country;

/**
 * Servlet implementation class CountryServlet
 */
@WebServlet("/country")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[CountryServlet]doGet is starting here.");
		doProcess(request, response);
		System.out.println("[CountryServlet]doGet is ending here.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[CountryServlet]doPost is starting here.");
		doProcess(request, response);
		System.out.println("[CountryServlet]doPost is ending here.");
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[CountryServlet]doProcess is starting here.");
		String strCCode = "0";
		String strCSName = "";
		String strCFName = "";
		String strHidID = "0";
		String strHidStatus = "N";
		boolean flag = false;
		
		if(request.getParameter("txtCCode") != null)
			strCCode = request.getParameter("txtCCode");
		if(request.getParameter("txtCSName") != null)
			strCSName = request.getParameter("txtCSName");
		if(request.getParameter("txtCFName") != null)
			strCFName = request.getParameter("txtCFName");
		if(request.getParameter("hidID") != null)
			strHidID = request.getParameter("hidID");
		if(request.getParameter("hidStatus") != null)
			strHidStatus = ""+request.getParameter("hidStatus").charAt(0);
		
		System.out.println("Hidden Status : "+strHidStatus);
		
		Country country = new Country(Integer.parseInt(strHidID), Integer.parseInt(strCCode), strCSName, strCFName);
		if(strHidStatus.equals("N"))
			flag = new CountryImp().insertRecord(country);
		if(strHidStatus.equals("U"))
			flag = new CountryImp().updateRecord(country);
		if(strHidStatus.equals("D"))
			flag = new CountryImp().deleteRecord(country);
		
		if(flag)
			response.sendRedirect(request.getContextPath()+"/countrylist.jsp");
		else
			response.sendRedirect(request.getContentType()+"/error.jsp");
		
		System.out.println("[CountryServlet]doProcess is ending here.");
	}
}
