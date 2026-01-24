/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.xml.transform.Result;
import utils.DbUtils;

/**
 *
 * @author BAO
 */
public class UniversityDAO {

    public UniversityDAO() {
    }
    
    public ArrayList<UniversityDTO> SearchByColum(String colum, String value){
        ArrayList<UniversityDTO> result = new ArrayList<>();
        try {
            Connection conn = DbUtils.getConnection();
            String sql = "SELECT * FROM tblUniversity WHERE " + colum + "=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, value);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                  String id = rs.getString("id");
                String name = rs.getString("name");
                String shortName = rs.getString("shortName");
                String description = rs.getString("description");
                int foundedYear = rs.getInt("foundedYear");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String region = rs.getString("region");
                String type = rs.getString("type");
                int totalStudents = rs.getInt("totalStudents");
                int totalFaculties = rs.getInt("totalFaculties");
                boolean isDraft = rs.getBoolean("isDraft");

                UniversityDTO u = new UniversityDTO(id, name, shortName, description, foundedYear, address, city, region, type, totalStudents, totalFaculties, isDraft);
                result.add(u);
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }
    
     public ArrayList<UniversityDTO> FilterByColum(String colum, String value){
        ArrayList<UniversityDTO> result = new ArrayList<>();
        try {
            Connection conn = DbUtils.getConnection();
            String sql = "SELECT * FROM tblUniversity WHERE " + colum + " LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + value +"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                  String id = rs.getString("id");
                String name = rs.getString("name");
                String shortName = rs.getString("shortName");
                String description = rs.getString("description");
                int foundedYear = rs.getInt("foundedYear");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String region = rs.getString("region");
                String type = rs.getString("type");
                int totalStudents = rs.getInt("totalStudents");
                int totalFaculties = rs.getInt("totalFaculties");
                boolean isDraft = rs.getBoolean("isDraft");

                UniversityDTO u = new UniversityDTO(id, name, shortName, description, foundedYear, address, city, region, type, totalStudents, totalFaculties, isDraft);
                result.add(u);
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }
      public ArrayList<UniversityDTO> searchByID(String ID) {
        return SearchByColum("id", ID);
    }

    public ArrayList<UniversityDTO> searchByName(String name) {
        return SearchByColum("name", name);
    }

    public ArrayList<UniversityDTO> filterByName(String name) {
        return FilterByColum("name", name);
    }
}
