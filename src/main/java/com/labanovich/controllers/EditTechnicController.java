package com.labanovich.controllers;

import com.labanovich.model.entities.Employee;
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
        int id =  Integer.parseInt(request.getParameter("technicEdit"));
        List<Technic> all = technicService.getAll();
        Technic technic = all.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .get();
        request.setAttribute("technic", technic);
        request.getRequestDispatcher("/changingEquipment.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idEdit");
        String name = request.getParameter("nameEdit");
        String producer = request.getParameter("producerEdit");
        String produceDate = request.getParameter("producerDateEdit");
        String serviceDate = request.getParameter("serviceDateEdit");
        String cost = request.getParameter("costEdit");
        boolean isEdited = technicService.edit(id, name , producer, produceDate,serviceDate, cost);
        if (isEdited) {
            List<Technic> technics = technicService.getAll();
            request.setAttribute("message", "TECHNIC EDITED");
            request.setAttribute("technics", technics);
            request.getRequestDispatcher("/equipment.jsp")
                    .forward(request, response);
        } else {
            request.setAttribute("message", "TECHNIC NOT FOUND");
        }
    }
}
