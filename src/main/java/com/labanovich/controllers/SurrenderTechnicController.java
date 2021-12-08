package com.labanovich.controllers;

import com.labanovich.model.entities.SurrenderTechnic;
import com.labanovich.model.service.SurrenderTechnicService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SurrenderTechnicController", value = "/surrender_technic")
public class SurrenderTechnicController extends HttpServlet {
    private SurrenderTechnicService surrenderTechnicService;

    @Override
    public void init() throws ServletException {
        surrenderTechnicService = new SurrenderTechnicService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SurrenderTechnic> surrender_technic = surrenderTechnicService.getAll();
        System.out.println(surrender_technic);
        request.setAttribute("surrender_technicQ", surrender_technic);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
