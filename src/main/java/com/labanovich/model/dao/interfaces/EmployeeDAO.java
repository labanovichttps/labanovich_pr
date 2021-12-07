package com.labanovich.model.dao.interfaces;

import com.labanovich.model.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAll();
    boolean deleteById(int id);
    boolean editById(long id, String name, String surname, String position, String number);
    boolean add(String name, String surname, String position, String number);
}
