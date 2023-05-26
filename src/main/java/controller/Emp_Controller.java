package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Emp_dao;
import dto.Emp_dto;
@WebServlet("/save")
public class Emp_Controller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String name=req.getParameter("EmpName");
		 int  id=Integer.parseInt(req.getParameter("EmpId"));
		 String number=req.getParameter("Number");
		 String email=req.getParameter("Email");
		 String password=req.getParameter("Password");
	
		 Emp_dto dto=new Emp_dto();
		 dto.setId(id);
		 dto.setName(name);
         dto.setNumber(number);
         dto.setPassword(password);
         dto.setEmail(email);

         Emp_dao dao=new Emp_dao();
         dao.save(dto);
         
         resp.getWriter().print("<h1>saved successfully<h1>");
	}}
