package bank.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.controller.*;
import bank.dao.*;
import bank.db.*;
import bank.login.*;
import java.util.*;

/**
 * Servlet implementation class MOV
 */
@WebServlet("/register")
public class MOV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MOV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		int regNo=Integer.parseInt(request.getParameter("regNo"));
		String uName=request.getParameter("uName");
		String password=request.getParameter("password");
	
		float accBal=Float.parseFloat(request.getParameter("accBal"));
		
	     register robj= new register(regNo,uName,password, accBal);
		List <register> lst=new ArrayList<register>();
		lst.add(robj);
		
		PrintWriter pw=response.getWriter();
		bankDao bdao=new bankDaoImpl();
		int i=bdao.create(lst);
		if(i>0)
		{
			pw.println("<h1><b>Record Inserted....</b></h1>");
	}
		else {
			pw.println("<h1>not inserted</h1>");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
