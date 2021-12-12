package com.labanovich.controllers;

import com.labanovich.model.entities.Employee;
import com.labanovich.model.entities.SurrenderTechnic;
import com.labanovich.model.entities.Technic;
import com.labanovich.model.service.EmployeeService;
import com.labanovich.model.service.SurrenderTechnicService;
import com.labanovich.model.service.TechnicService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "PrintTechnicController", value = "/print_technic")
public class PrintTechnicController extends HttpServlet {
    private SurrenderTechnicService surrenderTechnicService;
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        surrenderTechnicService = new SurrenderTechnicService();
        employeeService = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idForPrint = Integer.parseInt(request.getParameter("idForPrint"));
        List<SurrenderTechnic> all = surrenderTechnicService.getAll();
        SurrenderTechnic technic = all.stream()
                .filter(t -> t.getId() == idForPrint)
                .findFirst()
                .orElseThrow();
        Employee employee1 = employeeService.getAll().stream()
                .filter(employee -> technic.getUserId() == employee.getId())
                .findFirst()
                .orElseThrow();

        Path newFilePath = Paths.get("/Users/tsimafeilabanovich/Documents/Projects/Practic/labanovich_pr/src/main/resources/word/" + LocalTime.now() + ".txt");
        Files.createFile(newFilePath);
        Files.writeString(newFilePath, "ТЕХНИКА С ID = " + technic + "  БЫЛА ВЫДАНА ПОЛЬЗОВАТЕЛЮ "
                                       + employee1 + " " + technic.getSurrenderDate() + " И БЫЛА ВОЗВРАЗЕНА " + technic.getReceiveDate() + " ЧИСЛА");
        request.getRequestDispatcher("/")
                .forward(request, response);
    }
}
