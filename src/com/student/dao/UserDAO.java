package com.student.dao;

import com.student.util.DBConnection;
import com.student.util.PasswordUtil;
import java.sql.*;

public class UserDAO {

    public boolean register(String username, String password) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO users(username, password) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, PasswordUtil.hashPassword(password));

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean login(String username, String password) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, PasswordUtil.hashPassword(password));

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}


