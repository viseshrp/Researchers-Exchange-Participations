/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rep.utility;

import com.rep.models.Study;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author viseshprasad
 */
public class StudyDB {

    public static Study getStudy(String studyCode) throws IOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM study "
                + "WHERE studyCode = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, studyCode);
            rs = ps.executeQuery();
            Study study = null;
            if (rs.next()) {
                study = new Study();
                study.setStudyName(rs.getString("studyName"));
                study.setStudyCode(rs.getString("studyCode"));
                study.setDateCreated(rs.getString("dateCreated"));
                study.setEmail(rs.getString("email"));
                study.setQuestion(rs.getString("question"));
                study.setRequestedParticipants(rs.getString("requestedParticipants"));
                study.setNumOfParticipants(rs.getString("numOfParticipants"));
                study.setDescription(rs.getString("description"));
                study.setStatus(rs.getString("status"));
                study.setAnswerType(rs.getString("answerType"));
            }
            return study;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Study> getStudies(String email, String status) throws IOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM study "
                + "WHERE email = ? and status = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, status);
            rs = ps.executeQuery();
            Study study = null;
            ArrayList<Study> studies = new ArrayList<>();
            if (rs != null) {
                while (rs.next()) {
                    study = new Study();
                    study.setStudyName(rs.getString("studyName"));
                    study.setStudyCode(rs.getString("studyCode"));
                    study.setDateCreated(rs.getString("dateCreated"));
                    study.setEmail(rs.getString("email"));
                    study.setQuestion(rs.getString("question"));
                    study.setRequestedParticipants(rs.getString("requestedParticipants"));
                    study.setNumOfParticipants(rs.getString("numOfParticipants"));
                    study.setDescription(rs.getString("description"));
                    study.setStatus(rs.getString("status"));
                    study.setAnswerType(rs.getString("answerType"));
                    studies.add(study);
                }
            }
            connection.close();
            return studies;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static ArrayList<Study> getStudiesByStatus(String status) throws IOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM study "
                + "WHERE status = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, status);
            rs = ps.executeQuery();
            ArrayList<Study> studies = new ArrayList<>();
            while (rs.next()) {
                Study study = new Study();
                study.setStudyName(rs.getString("studyName"));
                study.setStudyCode(rs.getString("studyCode"));
                study.setDateCreated(rs.getString("dateCreated"));
                study.setEmail(rs.getString("email"));
                study.setQuestion(rs.getString("question"));
                study.setRequestedParticipants(rs.getString("requestedParticipants"));
                study.setNumOfParticipants(rs.getString("numOfParticipants"));
                study.setDescription(rs.getString("description"));
                study.setStatus(rs.getString("status"));
                study.setAnswerType(rs.getString("answerType"));
                studies.add(study);
            }
            return studies;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Study> getStudies() throws IOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM study ";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Study> studies = new ArrayList<>();
            while (rs.next()) {
                Study study = new Study();
                study.setStudyName(rs.getString("studyName"));
                study.setStudyCode(rs.getString("studyCode"));
                study.setDateCreated(rs.getString("dateCreated"));
                study.setEmail(rs.getString("email"));
                study.setQuestion(rs.getString("question"));
                study.setRequestedParticipants(rs.getString("requestedParticipants"));
                study.setNumOfParticipants(rs.getString("numOfParticipants"));
                study.setDescription(rs.getString("description"));
                study.setStatus(rs.getString("status"));
                study.setAnswerType(rs.getString("answerType"));
                studies.add(study);
            }
            return studies;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }

    public static ArrayList<Study> getStudies(String email) throws IOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM study "
                + "WHERE email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            ArrayList<Study> studies = new ArrayList<>();
            while (rs.next()) {
                Study study = new Study();
                study.setStudyName(rs.getString("studyName"));
                study.setStudyCode(rs.getString("studyCode"));
                study.setDateCreated(rs.getString("dateCreated"));
                study.setEmail(rs.getString("email"));
                study.setQuestion(rs.getString("question"));
                study.setRequestedParticipants(rs.getString("requestedParticipants"));
                study.setNumOfParticipants(rs.getString("numOfParticipants"));
                study.setDescription(rs.getString("description"));
                study.setStatus(rs.getString("status"));
                study.setAnswerType(rs.getString("answerType"));
                studies.add(study);
            }
            return studies;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }

    public static int addStudy(Study study) throws IOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO study (studyName, studyCode, dateCreated, "
                + "email, question, requestedParticipants, numOfParticipants,"
                + " description, status, answerType, choice1, choice2, choice3) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, study.getStudyName());
            ps.setString(2, study.getStudyCode());
            ps.setString(3, study.getDateCreated());
            ps.setString(4, study.getEmail());
            ps.setString(5, study.getQuestion());
            ps.setString(6, study.getRequestedParticipants());
            ps.setString(7, study.getNumOfParticipants());
            ps.setString(8, study.getDescription());
            ps.setString(9, study.getStatus());
            ps.setString(10, study.getAnswerType());
            ps.setString(11, study.getChoice1());
            ps.setString(12, study.getChoice2());
            ps.setString(13, study.getChoice3());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int updateStudy(String SCode, Study study) throws IOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE study SET "
                + "studyName = ?, "
                + "studyCode = ?, "
                + "dateCreated = ?, "
                + "email = ?, "
                + "question = ?, "
                + "requestedParticipants = ?, "
                + "numOfParticipants = ?, "
                + "description = ?, "
                + "status = ?, "
                + "answerType = ? "
                + "WHERE studyCode = ?";

        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, study.getStudyName());
            ps.setString(2, study.getStudyCode());
            ps.setString(3, study.getDateCreated());
            ps.setString(4, study.getEmail());
            ps.setString(5, study.getQuestion());
            ps.setString(6, study.getRequestedParticipants());
            ps.setString(7, study.getNumOfParticipants());
            ps.setString(8, study.getDescription());
            ps.setString(9, study.getStatus());
            ps.setString(10, study.getAnswerType());
            ps.setString(11, SCode);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }
}
