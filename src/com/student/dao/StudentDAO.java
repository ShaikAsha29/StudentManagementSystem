package com.student.dao;

import com.student.util.DBConnection;
import java.sql.*;

public class StudentDAO {

    public void addStudent(String name, String email, String course) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO students(name,email,course) VALUES(?,?,?)")) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                //System.out.println("Student added successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM students");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " | " +
                            rs.getString("name") + " | " +
                            rs.getString("email") + " | " +
                            rs.getString("course")
            );
        }
    }

    public void updateStudent(int id, String course) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE students SET course=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, course);
        ps.setInt(2, id);
        ps.executeUpdate();
    }
    public void updateStudent(int id, String name, String email, String course)
            throws Exception {

        Connection con = DBConnection.getConnection();
        String sql =
                "UPDATE students SET name=?, email=?, course=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, course);
        ps.setInt(4, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Student updated successfully");
        } else {
            System.out.println("Student not found");
        }
    }


    public void deleteStudent(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM students WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}

