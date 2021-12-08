package com.labanovich.controllers;

import com.labanovich.model.service.TechnicService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_in_st")
public class AddInSurrenderTechnicController extends HttpServlet {
    private TechnicService technicService;

    @Override
    public void init() throws ServletException {
        technicService = new TechnicService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rcID = req.getParameter("rcID");
        req.getSession().setAttribute("rcID", rcID);
        req.getRequestDispatcher("recieveTechnic.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rcID = (String) req.getSession().getAttribute("rcID");
        String surrenderTecOwnerId = req.getParameter("surrenderTecOwnerId");
        boolean isS = technicService.addInSurrenderTechnic(surrenderTecOwnerId, rcID);
        if (isS){
            req.setAttribute("technics", technicService.getAll());
            req.getRequestDispatcher("/")
                    .forward(req, resp);
        }
    }
}
