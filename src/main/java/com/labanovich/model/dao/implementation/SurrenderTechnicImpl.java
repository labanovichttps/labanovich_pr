package com.labanovich.model.dao.implementation;

import com.labanovich.model.constants.SQLRequests;
import com.labanovich.model.dao.interfaces.SurrenderTechnicDAO;
import com.labanovich.model.db.ConnectionManager;
import com.labanovich.model.entities.SurrenderTechnic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SurrenderTechnicImpl implements SurrenderTechnicDAO {

    @Override
    public List<SurrenderTechnic> getAll() {
        List<SurrenderTechnic> surrenderTechnics = new ArrayList<>();
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SQLRequests.GET_ALL_SURRENDER_TECHNIC)) {
            var rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                int technicId = rs.getInt("technic_id");
                Date surrenderDate = rs.getDate("surrender_date");
                Date receiveDate = rs.getDate("receive_date");
                SurrenderTechnic technic = new SurrenderTechnic(id, userId, technicId, surrenderDate, receiveDate);
                surrenderTechnics.add(technic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return surrenderTechnics;
    }

    @Override
    public boolean receiveById(int id) {
        boolean isReceived = false;
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SQLRequests.RECEIVE_SURRENDER_TECHNIC);
             var ps1 = connection.prepareStatement(SQLRequests.CUM);
             var ps420 = connection.prepareStatement(SQLRequests.RETURN_BACK)) {
            ps.setInt(1, id);
            ps1.setInt(1, id);
            int i = ps.executeUpdate();
            var rs = ps1.executeQuery();
            if (rs.next()) {
                int technic_id = rs.getInt("technic_id");
                ps420.setInt(1, technic_id);
            }
            ps420.executeUpdate();
            isReceived = i == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isReceived;
    }

    @Override
    public boolean deleteById(int id) {
        boolean isDeleted = false;
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SQLRequests.DELETE_SURRENDER_TECHNIC)) {
            int i = ps.executeUpdate();
            isDeleted = i == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isDeleted;
    }

    @Override
    public boolean edit(int id, Date receiveDate) {
        boolean isEdited = false;
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SQLRequests.EDIT_SURRENDER_TECHNIC_DATE)) {
            ps.setDate(1, receiveDate);
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            isEdited = i == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isEdited;
    }
}
