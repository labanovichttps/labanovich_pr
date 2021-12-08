package com.labanovich.controllers;

import com.labanovich.model.entities.SurrenderTechnic;
import com.labanovich.model.service.SurrenderTechnicService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditSurrenderTechnicController", value = "/EditSurrenderTechnicController")
public class EditSurrenderTechnicController extends HttpServlet {
    private SurrenderTechnicService surrenderTechnicService;

    @Override
    public void init() throws ServletException {
        surrenderTechnicService = new SurrenderTechnicService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String editTsq = request.getParameter("editTs");
        request.setAttribute("tempDate", request.getParameter("tempDate"));
        session.setAttribute("editTsq11", editTsq);
        request.getRequestDispatcher("/changingRecords.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getSession().getAttribute("editTsq11");
        String date = request.getParameter("dateForEdit");
        boolean isEdited = surrenderTechnicService.editById(id, date);
        if (isEdited) {
            List<SurrenderTechnic> surrenderTechnics = surrenderTechnicService.getAll();
            request.setAttribute("surrender_technic", surrenderTechnics);
            request.getRequestDispatcher("/deliveredEquipment.jsp")
                    .forward(request, response);
        } else {
            request.setAttribute("message", "TECHNIC NOT FOUND");
        }
    }
}
