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
import sun.security.util.Password;
import utils.DbUtils;

/**
 *
 * @author BAO
 */
public class UserDAO {

    public ArrayList<UserDTO> list = new ArrayList<>();

    public UserDAO() {

    }

    public UserDTO searchById(String username) {
        Connection conn;
        try {
            conn = DbUtils.getConnection();
            String sql = "SELECT * FROM tblUsers "
                    + " WHERE userID=?";
            System.out.println(sql);
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
        } catch (Exception e) {
            return null;
        } 
    }

    public UserDTO login(String username, String password) {
        UserDTO a = searchById(username);
        if (a != null && a.getPassword().equals(password)) {
            return a;
        }
        return null;
    }
}
