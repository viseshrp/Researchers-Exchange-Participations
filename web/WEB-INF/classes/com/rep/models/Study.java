/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rep.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author viseshprasad
 */
public class Study implements Serializable {

    private String studyName;
    private String studyCode;
    private String dateCreated;
    private String email;  // (Creator)
    private String question;
    private String requestedParticipants; //How many participants does the creator want
    private String numOfParticipants; // : How participants have finished this study thus far.
    private String description;
    private String status;
    private String answerType; // [Text or Numeric]
    private ArrayList<String> answerList; //List / Collection (your choice) of answer.

    public Study() {
        studyName = "";
        studyCode = "";
        dateCreated = "";
        email = "";
        question = "";
        requestedParticipants = "";
        numOfParticipants = "";
        description = "";
        status = "";
        answerType = "";
    }

    public Study(String StudyName, String StudyCode, String DateCreated, String Email, String Question, String Requestedparticipants, String Numofparticipants, String Description, String Status, String AnswerType, ArrayList<String> answerList) {
        this.studyName = StudyName;
        this.studyCode = StudyCode;
        this.dateCreated = DateCreated;
        this.email = Email;
        this.question = Question;
        this.requestedParticipants = Requestedparticipants;
        this.numOfParticipants = Numofparticipants;
        this.description = Description;
        this.status = Status;
        this.answerType = AnswerType;
        this.answerList = answerList;
    }

//URL that can be used in your pages that points to an image file 
//within the project for your question. Generated from study code.
    public String getImageURL(String studyCode) {
        String imageURL = "";
        if (studyCode.equalsIgnoreCase("GUI")) {
            imageURL = "images/small_tree.jpg";
        } else if (studyCode.equalsIgnoreCase("Sec")) {
            imageURL = "images/computer.jpg";
        }
        return imageURL;
    }

    public float getAverage() {
        return 0;

    }

    public int getMinimum() {
        return 0;

    }

    public int getMaximum() {
        return 0;

    }

    public float getSD() {
        return 0;
    }   //– standard deviation

    
    
    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String StudyName) {
        this.studyName = StudyName;
    }

    public String getStudyCode() {
        return studyCode;
    }

    public void setStudyCode(String StudyCode) {
        this.studyCode = StudyCode;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String DateCreated) {
        this.dateCreated = DateCreated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String Question) {
        this.question = Question;
    }

    public String getRequestedparticipants() {
        return requestedParticipants;
    }

    public void setRequestedparticipants(String Requestedparticipants) {
        this.requestedParticipants = Requestedparticipants;
    }

    public String getNumofparticipants() {
        return numOfParticipants;
    }

    public void setNumofparticipants(String Numofparticipants) {
        this.numOfParticipants = Numofparticipants;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = Status;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String AnswerType) {
        this.answerType = AnswerType;
    }

    public ArrayList<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<String> answerList) {
        this.answerList = answerList;
    }

}
