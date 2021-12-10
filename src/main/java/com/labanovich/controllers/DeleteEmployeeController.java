package com.labanovich.controllers;

import com.labanovich.model.entities.Employee;
import com.labanovich.model.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteEmployeeController", value = "/delete_employee")
public class DeleteEmployeeController extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("deleteUser");
        boolean isDeleted = employeeService.deleteById(id);
        if (isDeleted) {
            List<Employee> employees = employeeService.getAll();
            request.setAttribute("employees", employees);
            request.setAttribute("message", "DELETED");
            request.getRequestDispatcher("/users.jsp")
                    .forward(request, response);
        } else {
            request.setAttribute("message", "USER CANNOT BE DELETED");
            request.getRequestDispatcher("/users.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
