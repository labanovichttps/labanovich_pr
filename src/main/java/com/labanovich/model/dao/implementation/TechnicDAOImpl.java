package com.labanovich.model.dao.implementation;

import com.labanovich.model.constants.SQLRequests;
import com.labanovich.model.dao.interfaces.TechnicDAO;
import com.labanovich.model.db.ConnectionManager;
import com.labanovich.model.entities.Technic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TechnicDAOImpl implements TechnicDAO {

    @Override
    public List<Technic> getAll() {
        List<Technic> technics = new ArrayList<>();
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SQLRequests.GET_ALL_TECHNIC)) {
            var rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String producer = rs.getString("producer");
                Date produce_date = rs.getDate("produce_date");
                Date service_date = rs.getDate("service_date");
                double cost = rs.getDouble("cost");
                Technic technic = new Technic(id, name, producer, produce_date, service_date, cost);
                technics.add(technic);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return technics;
    }

    @Override
    public boolean editById(int id, String name, String producer, Date produceDate, Date serviceDate, double cost) {
        boolean isEdited = false;
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SQLRequests.EDIT_TECHNIC_BY_ID)) {
            ps.setString(1, name);
            ps.setString(2, producer);
            ps.setDate(3, produceDate);
            ps.setDate(4, serviceDate);
            ps.setDouble(5, cost);
            ps.setInt(6, id);
            int i = ps.executeUpdate();
            isEdited = i == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return isEdited;
    }

    @Override
    public boolean add(String name, String producer, Date produceDate, Date serviceDate, double cost) {
        boolean isAdded = false;
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SQLRequests.ADD_TECHNIC)) {
            ps.setString(1, name);
            ps.setString(2, producer);
            ps.setDate(3, produceDate);
            ps.setDate(4, serviceDate);
            ps.setDouble(5, cost);
            int i = ps.executeUpdate();
            isAdded = i == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    @Override
    public boolean removeById(int id) {
        boolean isRemoved = false;
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SQLRequests.DELETE_TECHNIC_BY_ID)) {
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            isRemoved = i == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRemoved;
    }
}
