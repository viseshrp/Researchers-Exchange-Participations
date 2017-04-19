/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rep.controllers;

import com.rep.models.User;
import com.rep.utility.UserDB;
import java.io.IOException;
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
public class UserController extends HttpServlet {

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
        // get current action
        String action = request.getParameter("action");
        User user = (User) session.getAttribute("theUser");
        User admin = (User) session.getAttribute("theAdmin");
        if (action == null) {
            url = "/home.jsp";    // the "main" page
        } else if (action.equalsIgnoreCase("login") || action.equalsIgnoreCase("create") || action.equalsIgnoreCase("how")
                || action.equalsIgnoreCase("about") || action.equalsIgnoreCase("home") || action.equalsIgnoreCase("main") || action.equalsIgnoreCase("logout")) {

            //Cookies
            String requestingMachine = request.getRemoteAddr();
            Cookie c = new Cookie("hostCookie", requestingMachine);
            c.setMaxAge(60 * 60 * 24 * 10);
            c.setPath("/");
            response.addCookie(c);

            if (action.equalsIgnoreCase("login")) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                // VALIDATion
                User loginUser = UserDB.getUser(email);
                if (loginUser != null) {
                    String type = loginUser.getType();
                    if (type.equalsIgnoreCase("Participant")) {
                        User userBean = new User(loginUser.getName(), loginUser.getEmail(), loginUser.getType(), loginUser.getNumCoins(), loginUser.getNumPostedStudies(), loginUser.getNumParticipation());
                        session.setAttribute("theUser", userBean);
                        url = "/main.jsp";
                    } else if (type.equalsIgnoreCase("Admin")) {
                        User userBean = new User(loginUser.getName(), loginUser.getEmail(), loginUser.getType(), loginUser.getNumCoins(), loginUser.getNumPostedStudies(), loginUser.getNumParticipation());
                        session.setAttribute("theAdmin", userBean);
                        url = "/admin.jsp";
                    }
                } else {
                    request.setAttribute("msg", "Not a valid user");
                    url = "/login.jsp";
                }
            } else if (action.equalsIgnoreCase("create")) {
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String type = "Participant";
                String password = request.getParameter("password");
                String confirmPassword = request.getParameter("confirm_password");
                if (name != null && email != null && type != null && password != null && confirmPassword != null && password.equals(confirmPassword)) {
                    User userBean = new User();
                    userBean.setName(name);
                    userBean.setEmail(email);
                    userBean.setType(type);
                    userBean.setNumCoins(String.valueOf(0));
                    userBean.setNumParticipation(String.valueOf(0));
                    userBean.setNumPostedStudies(String.valueOf(0));
                    
                    UserDB.addUser(userBean);
                    session.setAttribute("theUser", userBean);
                    url = "/main.jsp";
                } else {
                    request.setAttribute("msg", "Cannot create the account");
                    url = "/signup.jsp";
                }
            } else if (action.equalsIgnoreCase("how")) {
                if (user != null) {
                    url = "/main.jsp";
                } else {
                    url = "/how.jsp";
                }
            } else if (action.equalsIgnoreCase("about")) {
                if (user != null) {
                    url = "/about.jsp";
                } else {
                    url = "/aboutl.jsp";
                }
            } else if (action.equalsIgnoreCase("home")) {
                if (user != null) {
                    url = "/main.jsp";
                } else {
                    url = "/home.jsp";
                }
            } else if (action.equalsIgnoreCase("main")) {
                if (user != null) {
                    url = "/main.jsp";
                } else {
                    url = "/login.jsp";
                }
            } else if (action.equalsIgnoreCase("logout")) {
                if (user != null || admin != null) {
                    session.invalidate();
                    url = "/home.jsp";
                } else {
                    url = "/home.jsp";
                }
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
