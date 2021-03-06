package com.labanovich.model.dao.implementation;

import com.labanovich.model.constants.SQLRequests;
import com.labanovich.model.dao.interfaces.EmployeeDAO;
import com.labanovich.model.db.ConnectionManager;
import com.labanovich.model.entities.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SQLRequests.GET_ALL_EMPLOYEE)) {
            var rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String position = rs.getString("position");
                String phoneNumber = rs.getString("phone_number");
                Employee employee = new Employee(id, name, surname, position, phoneNumber);
                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employees;
    }

    @Override
    public boolean deleteById(int id) {
        boolean isDeleted = false;
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SQLRequests.DELETE_EMPLOYEE_BY_ID)) {
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            isDeleted = i == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return isDeleted;
    }

    @Override
    public boolean editById(long id, String name, String surname, String position, String number) {
        boolean isEdited = false;
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SQLRequests.EDIT_EMPLOYEE_BY_ID)) {
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, position);
            ps.setString(4, number);
            ps.setLong(5, id);
            int i = ps.executeUpdate();
            isEdited = i == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return isEdited;
    }

    @Override
    public boolean add(String name, String surname, String position, String number) {
        boolean isAdded = false;
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SQLRequests.ADD_EMPLOYEE)) {
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, position);
            ps.setString(4, number);

            isAdded = ps.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return isAdded;
    }
}
