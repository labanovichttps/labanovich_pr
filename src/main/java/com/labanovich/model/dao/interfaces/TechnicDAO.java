package com.labanovich.model.dao.interfaces;

import com.labanovich.model.entities.Technic;

import java.sql.Date;
import java.util.List;

public interface TechnicDAO {
    List<Technic> getAll();
    boolean editById(int id,String name, String producer, Date produceDate, Date serviceDate, double cost);
    boolean add(String name, String producer, Date produceDate,
                Date serviceDate, double cost);
    boolean removeById(int id);
    boolean addInSurrenderTechnic(int userId, int technicId);

}
