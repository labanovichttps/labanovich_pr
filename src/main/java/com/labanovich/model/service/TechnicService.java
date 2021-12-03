package com.labanovich.model.service;

import com.labanovich.model.dao.implementation.TechnicDAOImpl;
import com.labanovich.model.dao.interfaces.TechnicDAO;
import com.labanovich.model.entities.Technic;

import java.sql.Date;
import java.util.List;

public class TechnicService {
    private TechnicDAO technicDAO = new TechnicDAOImpl();

    public List<Technic> getAll() {
        return technicDAO.getAll();
    }

    public boolean edit(String id, String name, String producer, String produceDate, String serviceDate, String cost) {
        int tId = Integer.parseInt(id);
        Date prodDate = Date.valueOf(produceDate);
        Date servDate = Date.valueOf(serviceDate);
        double tCost = Double.parseDouble(cost);
        return technicDAO.editById(tId, name, producer, prodDate, servDate, tCost);
    }

    public boolean add(String name, String producer, String produceDate,
                       String serviceDate, String cost) {
        Date prodDate = Date.valueOf(produceDate);
        Date servDate = Date.valueOf(serviceDate);
        double tCost = Double.parseDouble(cost);
        return technicDAO.add(name, producer, prodDate, servDate, tCost);
    }

    public boolean remove(String id) {
        int tId = Integer.parseInt(id);
        return technicDAO.removeById(tId);
    }


}
