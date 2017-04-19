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
    
    private String choice1;
    private String choice2;
    private String choice3;

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
        choice1 = "";
        choice2 = "";
        choice3 = "";
    }

    public Study(String StudyName, String StudyCode, String DateCreated, String Email, String Question, String requestedParticipants, String Numofparticipants, String Description, String Status, String AnswerType, String choice1, String choice2, String choice3) {
        this.studyName = StudyName;
        this.studyCode = StudyCode;
        this.dateCreated = DateCreated;
        this.email = Email;
        this.question = Question;
        this.requestedParticipants = requestedParticipants;
        this.numOfParticipants = Numofparticipants;
        this.description = Description;
        this.status = Status;
        this.answerType = AnswerType;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
    }

//URL that can be used in your pages that points to an image file 
//within the project for your question. Generated from study code.
    public String getImageURL(String studyCode) {
        String imageURL = "";
        if (studyCode.equalsIgnoreCase("1")) {
            imageURL = "images/small_tree.jpg";
        }
        if (studyCode.equalsIgnoreCase("2")) {
            imageURL = "images/computer.jpg";
        }
        if (studyCode.equalsIgnoreCase("3")) {
            imageURL = "images/small_tree.jpg";
        }
        if (studyCode.equalsIgnoreCase("4")) {
            imageURL = "images/computer.jpg";
        }
        else {
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

    public String getRequestedParticipants() {
        return requestedParticipants;
    }

    public void setRequestedParticipants(String requestedParticipants) {
        this.requestedParticipants = requestedParticipants;
    }

    public String getNumOfParticipants() {
        return numOfParticipants;
    }

    public void setNumOfParticipants(String numOfParticipants) {
        this.numOfParticipants = numOfParticipants;
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

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }


}
