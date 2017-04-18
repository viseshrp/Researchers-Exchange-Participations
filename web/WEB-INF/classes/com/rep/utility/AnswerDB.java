/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rep.utility;

import com.rep.models.Answer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author viseshprasad
 */
public class AnswerDB {

    public static int addAnswer(Answer answer) throws IOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO answer (studyCode, email, choice, submissionDate) "
                + "VALUES (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, answer.getStudyCode());
            ps.setString(2, answer.getEmail());
            ps.setString(3, answer.getChoice());
            ps.setDate(4, new Date(Calendar.getInstance().getTime().getTime()));
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
        }
    }

}
