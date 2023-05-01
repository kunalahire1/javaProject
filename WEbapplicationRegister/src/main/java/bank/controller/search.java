package bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.dao.*;
import bank.login.register;

/**
 * Servlet implementation class searched
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	String strregno=request.getParameter("regNo");
	int regNo=Integer.parseInt("strregno");
	bankDao rdao=new bankDaoImpl();
	List<register>  lst=rdao.retrive(regNo);
	//int regNo=Integer.parseInt(stregno);
	//System.out.println(stregno);
	register r= lst.get(0);
//	PrintWriter pw=response.getClass();
	HttpSession session=request.getSession();
	session.setAttribute("data",r);
	response.sendRedirect("search.jsp");
	//System.out.println(r.getuName()+" "+r.getRegNo()+""+r.getAccBal()+" "+r.getPassword());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
