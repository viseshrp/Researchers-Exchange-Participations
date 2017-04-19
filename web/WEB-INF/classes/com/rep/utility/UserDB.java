/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rep.utility;

import com.rep.models.Answer;
import com.rep.models.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author viseshprasad
 */
public class UserDB {

        public static int addUser(User user) throws IOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

       // INSERT INTO user VALUES ('admin','admin@rep.com', 'Admin', 40, 10, 30);
        String query
                = "INSERT INTO user (name, email, type, numCoins, numPostedStudies, numParticipation) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getType());
            ps.setString(4, user.getNumCoins());
            ps.setString(5, user.getNumPostedStudies());
            ps.setString(6, user.getNumParticipation());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static User getUser(String email) throws IOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM user "
                + "WHERE email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setType(rs.getString("type"));
                //user.setPassword(rs.getString("password"));
                user.setNumCoins(rs.getString("numCoins"));
                user.setNumParticipation(rs.getString("numPostedStudies"));
                user.setNumPostedStudies(rs.getString("numParticipation"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    // List/Collection<User> getUsers() {}
    public static ArrayList<User> getUsers() throws IOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM user";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<User> users = new ArrayList<User>();
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setType(rs.getString("type"));
                //user.setPassword(rs.getString("password"));
                user.setNumCoins(rs.getString("numCoins"));
                user.setNumParticipation(rs.getString("numPostedStudies"));
                user.setNumPostedStudies(rs.getString("numParticipation"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }
}
