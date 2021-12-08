package com.labanovich.controllers;

import com.labanovich.model.entities.Technic;
import com.labanovich.model.service.TechnicService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteTechnicController", value = "/delete_technic")
public class DeleteTechnicController extends HttpServlet {
    private TechnicService technicService;

    @Override
    public void init() throws ServletException {
        technicService = new TechnicService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("technicDelete");
        boolean isRemoved = technicService.remove(id);
        if (isRemoved) {
            List<Technic> technics = technicService.getAll();
            request.setAttribute("message", "TECHNIC DELETED");
            request.setAttribute("technics", technics);
            request.getRequestDispatcher("/equipment.jsp")
                    .forward(request, response);
        } else {
            request.setAttribute("message", "TECHNIC NOT FOUND");
            request.getRequestDispatcher("/equipment.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
