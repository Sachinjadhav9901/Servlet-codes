package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Emp_dao;
import dto.Emp_dto;
@WebServlet("/search")
public class SearchbyId extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
      int id=Integer.parseInt(req.getParameter("Id"));
      Emp_dao dao=new Emp_dao();
     Emp_dto dto=dao.fetch(id);
      
      if(dto==null){
    	  resp.getWriter().print("<h1>invalid id</h1>");
    		  req.getRequestDispatcher("Home.html").include(req, resp);}
	else{
		req.setAttribute("dto", dto);
		resp.setContentType("text/html");
		resp.getWriter().print("<table style='border:5px solid grey;width:2px;'><tr><td>ID</td><td>Name</td><td>phone</td><td>edit</td><td>delete</td></tr>");
		  resp.getWriter().print("<tr><td>"+dto.getId() +"</td><td>"+ dto.getName()+"</td><td>"+dto.getNumber()+"</td><td> <button>edit</button></td><td><button>delete</button></td></tr></table>");
		  
	  }
	}
}

