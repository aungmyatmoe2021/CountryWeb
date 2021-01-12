package com.countryweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.countryweb.dao.CountryImp;
import com.countryweb.model.Country;

/**
 * Servlet implementation class CountryXMLDataServlet
 */
@WebServlet("/countryxml")
public class CountryXMLDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryXMLDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/xml");
		PrintWriter output = response.getWriter();
		StringBuffer sb = new StringBuffer();
		
		List<Country> records = new CountryImp().getAllRecords();
		sb.append("<country>");
		
		for(int i=0;i<records.size();i++) {
			sb.append("<record>");
			sb.append("<countryID>"+records.get(i).getCountryID()+"</countryID>");
			sb.append("<countryCode>"+records.get(i).getCountryCode()+"</countryCode>");
			sb.append("<countryShortName>"+records.get(i).getCountryShortName()+"</countryShortName>");
			sb.append("<countryFullName>"+records.get(i).getCountryFullName()+"</countryFullName>");
			sb.append("</record>");
		}
		
		sb.append("</country>");
		output.write(sb.toString());
		
		output.flush();
		output.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
