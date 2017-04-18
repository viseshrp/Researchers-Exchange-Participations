/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rep.models;

import java.io.Serializable;

/**
 *
 * @author viseshprasad
 */
public class Answer implements Serializable {

    private String studyCode; //todo
    
    private String email; // : of the participant
    private String choice;
    private String submissionDate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String Choice) {
        this.choice = Choice;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String SubmissionDate) {
        this.submissionDate = SubmissionDate;
    }

    public String getStudyCode() {
        return studyCode;
    }

    public void setStudyCode(String studyCode) {
        this.studyCode = studyCode;
    }

    
}
