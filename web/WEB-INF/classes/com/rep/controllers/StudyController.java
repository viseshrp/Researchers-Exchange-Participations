/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rep.controllers;

import com.rep.models.Answer;
import com.rep.models.Study;
import com.rep.models.User;
import com.rep.utility.AnswerDB;
import com.rep.utility.StudyDB;
import com.rep.utility.UserDB;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author viseshprasad
 */
public class StudyController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("theUser");
        User admin = (User) session.getAttribute("theAdmin");
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            if (user != null) {
                url = "/main.jsp";
            } else {
                if (admin != null) {
                    url = "/admin.jsp";
                } else {
                    url = "/main.jsp";
                }
            }
        } else if (action.equalsIgnoreCase("participate")) {
            if (user != null) {
                String studyCode = request.getParameter("StudyCode");
                if (studyCode != null) {
                    Study study = StudyDB.getStudy(studyCode);
                    request.setAttribute("study", study);
                    url = "/question.jsp";
                } else {
                    ArrayList<Study> studies = StudyDB.getStudiesByStatus("start");
                    request.setAttribute("study", studies);
                    url = "/participate.jsp";
                }
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("edit")) {
            if (user != null) {
                String studyCode = request.getParameter("StudyCode");
                if (studyCode != null) {
                    Study study = StudyDB.getStudy(studyCode);
                    request.setAttribute("study", study);
                    url = "/editstudy.jsp";
                }
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("report")) {
            if (user != null) {
                String reporterEmail = request.getParameter("ReporterEmail");
                if (reporterEmail == null) {
                    String studyCode = request.getParameter("StudyCode");
                    //String question = request.getParameter("question");
                    if (studyCode != null) {
                        Date currDate = new Date();
                        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                        String reportedDate = df.format(currDate);
                        Study report = StudyDB.getStudy(studyCode); //get the reported study

                        //create a new record
                        Study reportRecord = new Study();
                        reportRecord.setStudyCode(studyCode + "Reported");//todo
                        reportRecord.setQuestion(report.getQuestion());
                        reportRecord.setEmail(report.getEmail());
                        reportRecord.setStatus("Reported");
                        reportRecord.setDateCreated(reportedDate);
                        StudyDB.addStudy(reportRecord);

                        request.setAttribute("study", reportRecord);
                        url = "/confirmrep.jsp";
                    } else {
                        /*
                    If it does not exist
                    • Retrieve all requests that were submitted by the current user from the DB
                         */
                        ArrayList<Study> studies = StudyDB.getStudies(user.getEmail(), "Reported");
                        request.setAttribute("study", studies);
                        url = "/reporth.jsp";
                    }
                } else {
                    ArrayList<Study> studies = StudyDB.getStudies(reporterEmail, "Reported");
                    request.setAttribute("study", studies);
                    url = "/reporth.jsp";
                }
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("reportedQuestions")) {
            if (admin != null) {
                ArrayList<Study> studies = StudyDB.getStudiesByStatus("Reported");
                request.setAttribute("study", studies);
                url = "/reportques.jsp";
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("approve")) {
            if (admin != null) {
                //get, change status and update db
                String studyCode = request.getParameter("StudyCode");
                Study study = StudyDB.getStudy(studyCode);
                study.setStatus("approve");
                StudyDB.updateStudy(studyCode, study);

                ArrayList<Study> studies = StudyDB.getStudiesByStatus("Reported");
                request.setAttribute("study", studies);
                url = "/reportques.jsp";
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("disapprove")) {
            if (admin != null) {
                String studyCode = request.getParameter("StudyCode");
                Study study = StudyDB.getStudy(studyCode);
                study.setStatus("disapprove");
                StudyDB.updateStudy(studyCode, study);

                ArrayList<Study> studies = StudyDB.getStudiesByStatus("Reported");
                request.setAttribute("study", studies);
                url = "/reportques.jsp";
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("update")) {
            if (user != null) {

                String studyCode = request.getParameter("StudyCode");
                String studyName = request.getParameter("study_name");
                String question = request.getParameter("question_text");
                String noOfParticipants = request.getParameter("participants");
                String desc = request.getParameter("description");
                Study study = StudyDB.getStudy(studyCode);
                study.setStudyCode(studyCode);
                study.setStudyName(studyName);
                study.setQuestion(question);
                study.setNumOfParticipants(noOfParticipants);
                study.setDescription(desc);
                StudyDB.updateStudy(studyCode, study);
                ArrayList<Study> studies = StudyDB.getStudies(user.getEmail());
                request.setAttribute("study", studies);
                url = "/studies.jsp";
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("add")) {
            if (user != null) {
                String studyCode = request.getParameter("StudyCode");
                String studyName = request.getParameter("study_name");
                String question = request.getParameter("question_text");

                String answer1 = request.getParameter("Answer1");
                String answer2 = request.getParameter("Answer2");
                String answer3 = request.getParameter("Answer3");

                Date currDate = new Date();
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                String createdDate = df.format(currDate);

                //int noOfParticipants = Integer.parseInt(request.getParameter("participants"));
                String desc = request.getParameter("description");
                Study study = new Study();
                study.setStudyCode(studyCode);
                study.setStudyName(studyName);
                study.setQuestion(question);
                study.setNumOfParticipants(request.getParameter("participants"));
                study.setDescription(desc);
                study.setEmail(user.getEmail());
                study.setRequestedParticipants(String.valueOf(1));
                study.setStatus("start");
                study.setAnswerType("text");
                study.setChoice1(desc);

                if (answer1 != null) {
                    study.setChoice1(answer1);
                } else {
                    study.setChoice1("");
                }

                if (answer2 != null) {
                    study.setChoice2(answer2);
                } else {
                    study.setChoice2("");
                }

                if (answer3 != null) {
                    study.setChoice3(answer3);
                } else {
                    study.setChoice3("");
                }

                study.setDateCreated(createdDate);
                StudyDB.addStudy(study);
                ArrayList<Study> studies = StudyDB.getStudies(user.getEmail());
                request.setAttribute("study", studies);
                url = "/studies.jsp";
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("start")) {
            if (user != null) {
                String studyCode = request.getParameter("StudyCode");
                Study study = StudyDB.getStudy(studyCode);
                study.setStatus("start");
                StudyDB.updateStudy(studyCode, study);
                ArrayList<Study> studies = StudyDB.getStudies(user.getEmail());
                request.setAttribute("study", studies);
                url = "/studies.jsp";
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("stop")) {
            if (user != null) {
                String studyCode = request.getParameter("StudyCode");
                Study study = StudyDB.getStudy(studyCode);
                study.setStatus("stop");
                ArrayList<Study> studies = StudyDB.getStudies(user.getEmail());
                request.setAttribute("study", studies);
                url = "/studies.jsp";
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("answer")) {
            if (user != null) {
                String studyCode = request.getParameter("StudyCode");
                String choice = request.getParameter("ans");
                Study study = StudyDB.getStudy(studyCode);
                Study ansStudy = new Study();
                ansStudy = study;
                ansStudy.setStudyCode(studyCode + "answered");
                ansStudy.setStatus("answered");
                StudyDB.addStudy(ansStudy);

                Answer answer = new Answer();
                answer.setChoice(choice);
                answer.setEmail(user.getEmail());
                answer.setStudyCode(studyCode);

                user.setNumCoins(user.getNumCoins() + 1);
                user.setNumParticipation(user.getNumParticipation() + 1);
                session.setAttribute("theUser", user);
                ArrayList<Study> studies = StudyDB.getStudiesByStatus("start");
                request.setAttribute("study", studies);
                url = "/participate.jsp";
            } else {
                url = "/login.jsp";
            }
        } else if (action.equalsIgnoreCase("studies")) {
            if (user != null) {
                ArrayList<Study> studies = StudyDB.getStudies(user.getEmail());
                request.setAttribute("study", studies);
                url = "/studies.jsp";
            } else {
                url = "/login.jsp";
            }
        }
        // forward request and response objects to specified URL
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
