/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DbUtils;

/**
 *
 * @author BAO
 */
public class UserDAO {

    Connection conn;

    public UserDAO() {

        try {
            conn = DbUtils.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private UserDTO SearchById(String username) {
        try {
            String sql = "SELECT * FROM tblUsers" + " WHERE userID =?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            UserDTO user = null;

            while (rs.next()) {
                String userID = rs.getString("userID");
                String fullname = rs.getString("fullname");
                String password = rs.getString("password");
                String roleID = rs.getString("roleID");
                boolean status = rs.getBoolean("status");
                user = new UserDTO(userID, fullname, password, roleID, status);
            }
            return user;
        } catch (Exception ex) {
            return null;
        }
    }

    public UserDTO login(String username, String Password) {
        UserDTO user = SearchById(username);
        
        if (user != null && user.getPassword().equalsIgnoreCase(Password)) {
            return user;
        }
        return null;

    }


    }
