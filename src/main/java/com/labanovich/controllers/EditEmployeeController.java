package com.labanovich.controllers;

import com.labanovich.model.entities.Employee;
import com.labanovich.model.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditEmployeeController", value = "/edit_employee")
public class EditEmployeeController extends HttpServlet {

    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int editUser = Integer.parseInt(request.getParameter("editUser"));
        List<Employee> all = employeeService.getAll();
        Employee employee = all.stream()
                .filter(e -> e.getId() == editUser)
                .findFirst()
                .get();
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("/changingUsers.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String position = request.getParameter("position");
        String phoneNumber = request.getParameter("phone_number");
        boolean isEdited = employeeService.edit(id, name, surname, position, phoneNumber);
        if (isEdited) {
            List<Employee> employees = employeeService.getAll();
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("/")
                    .forward(request, response);
        } else {
            request.setAttribute("message", "USER NOT FOUND");
        }
    }
}
