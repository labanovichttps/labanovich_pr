package com.labanovich.model.service;

import com.labanovich.model.dao.implementation.EmployeeDAOImpl;
import com.labanovich.model.dao.interfaces.EmployeeDAO;
import com.labanovich.model.entities.Employee;

import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    public List<Employee> getAll(){
        return employeeDAO.getAll();
    }

    public boolean deleteById(String id){
        int eId = Integer.parseInt(id);
        return employeeDAO.deleteById(eId);
    }

    public boolean edit(String id, String name, String surname, String position, String number){
        int eId = Integer.parseInt(id);
        return employeeDAO.editById(eId, name, surname, position, number);
    }

}
