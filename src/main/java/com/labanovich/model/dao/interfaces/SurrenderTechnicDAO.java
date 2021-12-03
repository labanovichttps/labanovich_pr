package com.labanovich.model.dao.interfaces;

import com.labanovich.model.entities.SurrenderTechnic;

import java.sql.Date;
import java.util.List;

public interface SurrenderTechnicDAO {
    List<SurrenderTechnic> getAll();
    boolean receiveById(int id);
    boolean deleteById(int id);
    boolean edit(int id, Date receiveDate);

}
