package com.labanovich.controllers;

import com.labanovich.model.entities.SurrenderTechnic;
import com.labanovich.model.service.SurrenderTechnicService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ReceiveSurrenderTechnicController", value = "/receive_surrender_technic")
public class ReceiveSurrenderTechnicController extends HttpServlet {
    private SurrenderTechnicService surrenderTechnicService;

    @Override
    public void init() throws ServletException {
        surrenderTechnicService = new SurrenderTechnicService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("reciveTs");
        boolean isReceived = surrenderTechnicService.receive(id);
        if (isReceived) {
            List<SurrenderTechnic> surrenderTechnics = surrenderTechnicService.getAll();
            request.setAttribute("surrender_technic", surrenderTechnics);
            request.setAttribute("message", "TECHNIC RECEIVED");
            request.getRequestDispatcher("/")
                    .forward(request, response);
        } else {
            request.setAttribute("message", "TECHNIC NOT FOUND");
        }
    }
}
