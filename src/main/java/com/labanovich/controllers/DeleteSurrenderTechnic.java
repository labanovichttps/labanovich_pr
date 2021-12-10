package com.labanovich.controllers;

import com.labanovich.model.entities.Employee;
import com.labanovich.model.entities.SurrenderTechnic;
import com.labanovich.model.service.SurrenderTechnicService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteSurrenderTechnic", value = "/delete_surrender_technic")
public class DeleteSurrenderTechnic extends HttpServlet {
    private SurrenderTechnicService surrenderTechnicService;

    @Override
    public void init() throws ServletException {
        surrenderTechnicService = new SurrenderTechnicService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        boolean isDeleted = surrenderTechnicService.deleteById(id);
        if (isDeleted) {
            List<SurrenderTechnic> surrenderTechnics = surrenderTechnicService.getAll();
            request.setAttribute("surrender_technic", surrenderTechnics);
            request.getRequestDispatcher("/")
                    .forward(request, response);
        } else {
            request.setAttribute("message", "TECHNIC CANNOT BE DELETE");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
