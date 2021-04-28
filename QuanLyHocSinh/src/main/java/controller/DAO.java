/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author lequo
 */
public class DAO {
    private Connection conn;
    
    public DAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                    + "databasename=QLHS;username=sa;password=123456");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> ls_students = new ArrayList<>();
        String sql = "SELECT * FROM HOCSINH";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("MAHS");
                String TenHS = rs.getString("TenHS");
                String HinhAnh = rs.getString("HinhAnh");
                String DiaChi = rs.getString("DiaChi");
                String GhiChu = rs.getString("GhiChu");
                double Diem = rs.getDouble("Diem");
                Student s = new Student(ID, TenHS, Diem, HinhAnh, DiaChi, GhiChu);
                ls_students.add(s);
            }
            rs.close();
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return ls_students;
    }
    
    public boolean addStudent(Student s) {
        String sql = "INSERT INTO HOCSINH(MAHS, TenHS, HinhAnh, DiaChi, GhiChu,"
                + " Diem) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMHS());
            ps.setString(2, s.getTenHS());
            ps.setString(3, s.getHinhAnh());
            ps.setString(4, s.getDiaChi());
            ps.setString(5, s.getGhiChu());
            ps.setDouble(6, s.getDiem());
            int result = ps.executeUpdate();
            conn.close();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateStudent(Student s) {
        String sql = "UPDATE HOCSINH SET TENHS = ?, HINHANH = ?, DIACHI = ?,"
                + " GHICHU = ?, DIEM = ? WHERE MAHS = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getTenHS());
            ps.setString(2, s.getHinhAnh());
            ps.setString(3, s.getDiaChi());
            ps.setString(4, s.getGhiChu());
            ps.setDouble(5, s.getDiem());
            ps.setString(6, s.getMHS());
            int isUpdated = ps.executeUpdate();
            conn.close();
            return isUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteStudent(Student s)  {
        String sql = "DELETE HOCSINH WHERE MAHS = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMHS());
            int isDeleted = ps.executeUpdate();
            conn.close();
            return isDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean InsertManyStudent(ArrayList<Student> students) {
        String sql = "INSERT INTO HOCSINH(MAHS, TenHS, HinhAnh, DiaChi, GhiChu,"
                + " Diem) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            for(Student s: students) {
                ps.setString(1, s.getMHS());
                ps.setString(2, s.getTenHS());
                ps.setString(3, s.getHinhAnh());
                ps.setString(4, s.getDiaChi());
                ps.setString(5, s.getGhiChu());
                ps.setDouble(6, s.getDiem());
                ps.executeUpdate();
            }
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
