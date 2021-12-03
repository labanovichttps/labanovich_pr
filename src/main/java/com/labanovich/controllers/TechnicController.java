package com.labanovich.controllers;

import com.labanovich.model.entities.Technic;
import com.labanovich.model.service.TechnicService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TechnicController", value = "/all_technic")
public class TechnicController extends HttpServlet {
    private TechnicService technicService;

    @Override
    public void init() throws ServletException {
        technicService = new TechnicService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Technic> technics = technicService.getAll();
        request.setAttribute("technics", technics);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
