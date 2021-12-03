package com.labanovich.controllers;

import com.labanovich.model.entities.SurrenderTechnic;
import com.labanovich.model.entities.Technic;
import com.labanovich.model.service.TechnicService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditTechnicController", value = "/edit_technic")
public class EditTechnicController extends HttpServlet {
    private TechnicService technicService;

    @Override
    public void init() throws ServletException {
        technicService = new TechnicService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String producer = request.getParameter("producer");
        String produceDate = request.getParameter("produceDate");
        String serviceDate = request.getParameter("serviceDate");
        String cost = request.getParameter("cost");
        boolean isEdited = technicService.edit(id, name , producer, produceDate,serviceDate, cost);
        if (isEdited) {
            List<Technic> technics = technicService.getAll();
            request.setAttribute("technics", technics);
            request.getRequestDispatcher("/")
                    .forward(request, response);
        } else {
            request.setAttribute("message", "TECHNIC NOT FOUND");
        }
    }
}
