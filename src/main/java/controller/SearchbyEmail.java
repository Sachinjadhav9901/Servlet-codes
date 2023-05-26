package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Emp_dao;
import dto.Emp_dto;
@WebServlet("/searchbyemail")
public class SearchbyEmail extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String email=req.getParameter("Email");
        Emp_dao dao=new Emp_dao();
        List<Emp_dto>list= dao.fetch(email);
    	 if(list==null){
    		 resp.getWriter().print("<h1>invalid email</h1>");
    		 req.getRequestDispatcher("Home.html").include(req, resp);
    	 }
    	 else{
     		Emp_dto dto2=list.get(0);
     		 resp.getWriter().print("<table style='border:2px solid grey;width:2px;'><tr><td>ID</td><td>Name</td><td>phone</td><td>email</td></tr>");
    		  resp.getWriter().print("<tr><td>"+ (dto2.getId() +"</td><td>"+ dto2.getName()+"</td><td>"+dto2.getNumber()+"</td><td>"+dto2.getEmail()+"</td><td> <button>edit</button></td><td><button>delete</button></td></tr></table>"));
     	 }
    	}

}
