package com.labanovich.model.service;

import com.labanovich.model.dao.implementation.SurrenderTechnicImpl;
import com.labanovich.model.dao.interfaces.SurrenderTechnicDAO;
import com.labanovich.model.entities.SurrenderTechnic;

import java.sql.Date;
import java.util.List;

public class SurrenderTechnicService {
    private SurrenderTechnicDAO surrenderTechnic = new SurrenderTechnicImpl();

    public List<SurrenderTechnic> getAll() {
        return surrenderTechnic.getAll();
    }

    public boolean editById(String id, String date) {
        Date receiveDate = Date.valueOf(date);
        int tId = Integer.parseInt(id);
        return surrenderTechnic.edit(tId, receiveDate);
    }

    public boolean deleteById(String id) {
        int tId = Integer.parseInt(id);
        return surrenderTechnic.deleteById(tId);
    }

    public boolean receive(String id) {
        int tId = Integer.parseInt(id);
        return surrenderTechnic.receiveById(tId);
    }


}
