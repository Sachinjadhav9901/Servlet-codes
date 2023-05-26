package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Emp_dao;
import dto.Emp_dto;

public class Fetch extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Emp_dao dao=new Emp_dao();
		List<Emp_dto> list=dao.fetch();
		
		req.setAttribute("list", dao.fetch());
	}

}
