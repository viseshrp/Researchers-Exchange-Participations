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
public class User implements Serializable {

    private String name;
    private String email;
    private String type;

    private String numCoins;

    private String numPostedStudies;   // : how many studies have he/she created
    private String numParticipation;   // : how many studies have he/she participated in
// 1 participation = 1 coin
// 1 participant = 1 coin

    public User() {
        name = "";
        email = "";
        type = "";
        numCoins = "";
        numPostedStudies = "";
        numParticipation = "";

    }

    public User(String name, String email, String type, String numCoins, String numPostedStudies, String numParticipation) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.numCoins = numCoins;
        this.numPostedStudies = numPostedStudies;
        this.numParticipation = numParticipation;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getType() {
        return type;
    }

    public void setType(String Type) {
        this.type = Type;
    }

    public String getNumCoins() {
        return numCoins;
    }

    public void setNumCoins(String NumCoins) {
        this.numCoins = NumCoins;
    }

    public String getNumPostedStudies() {
        return numPostedStudies;
    }

    public void setNumPostedStudies(String NumPostedStudies) {
        this.numPostedStudies = NumPostedStudies;
    }

    public String getNumParticipation() {
        return numParticipation;
    }

    public void setNumParticipation(String NumParticipation) {
        this.numParticipation = NumParticipation;
    }

}
