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
        String name = request.getParameter("name");
        String producer = request.getParameter("producer");
        String produceDate = request.getParameter("produceDate");
        String serviceDate = request.getParameter("serviceDate");
        String cost = request.getParameter("cost");

        boolean isAdded = technicService.add(name, producer, produceDate, serviceDate, cost);
        if (isAdded) {
            List<Technic> technics = technicService.getAll();
            request.setAttribute("technics", technics);
            request.getRequestDispatcher("/")
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
