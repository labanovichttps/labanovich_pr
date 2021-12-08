package com.labanovich.controllers;

import com.labanovich.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_employee")
public class AddEmployeeController  extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("eAddName");
        String surname = req.getParameter("eAddSurname");
        String position = req.getParameter("eAddPosition");
        String phoneNumber = req.getParameter("eAddPn");

        boolean isAdded = employeeService.add(name, surname, position, phoneNumber);

        if(isAdded){
            req.setAttribute("message", "ADDED SUCCESS");
            req.setAttribute("employees", employeeService.getAll());
            req.getRequestDispatcher("/users.jsp")
                    .forward(req, resp);
        }

    }
}
