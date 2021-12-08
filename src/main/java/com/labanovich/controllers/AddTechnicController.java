package com.labanovich.controllers;

import com.labanovich.model.entities.Technic;
import com.labanovich.model.service.TechnicService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddTechnicController", value = "/add_technic")
public class AddTechnicController extends HttpServlet {
    private TechnicService technicService;

    @Override
    public void init() throws ServletException {
        technicService = new TechnicService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("tname");
        String producer = request.getParameter("tproducer");
        String produceDate = request.getParameter("tproduceDate");
        String serviceDate = request.getParameter("tserviceDate");
        String cost = request.getParameter("tcost");

        boolean isAdded = technicService.add(name, producer, produceDate, serviceDate, cost);
        if (isAdded) {
            List<Technic> technics = technicService.getAll();
            request.setAttribute("technics", technics);
            request.setAttribute("message", "TECHNIC ADDED");
            request.getRequestDispatcher("/equipment.jsp")
                    .forward(request, response);
        } else {
            request.setAttribute("message", "TECHNIC NOT FOUND");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
