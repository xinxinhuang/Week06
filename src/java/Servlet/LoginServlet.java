/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import businesslogic.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 721292
 */
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String formaction = request.getParameter("action");
        
        Cookie[] cookies = request.getCookies();
        
        if(cookies!=null)
        {
            for(Cookie cookie : cookies)
            {
                if(cookie.getName().equals("userIdCookie"))
                {
                    request.setAttribute("usern", cookie.getValue());
                    request.setAttribute("checked", "checked");
                }
            }
        }
        if((formaction!=null)&& formaction.equals("logout")){
            session.removeAttribute("usern");
            request.setAttribute("message", "User have logout successfully.");
            getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
           
        }
        else if(session.getAttribute("usern")!=null)
        {
            response.sendRedirect("Home");
            return;
        }
        
        getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("usern");
        String pass = request.getParameter("passw");
        
        UserService us = new UserService(user,pass);
        request.setAttribute("us", us);
        
        if(user == null || pass == null || user.trim().isEmpty() || pass.trim().isEmpty())
        {
            request.setAttribute("message", "Username or password is empty.");
            getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
            return;
            
        }
        if(!us.login(user, pass))
        {
            request.setAttribute("message", "Wrong user name or password.");
            request.setAttribute("usern", user);
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }  

        /*Setting up cookie*/
        if(request.getParameter("reme") == null)
        {
            Cookie[] cookies = request.getCookies();
            for(Cookie cookie : cookies)
            {
                if(cookie.getName().equals("userIdCookie"))
                {
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
        }
        else {
            Cookie newcookie = new Cookie("userIdCookie", request.getParameter("usern"));
            newcookie.setMaxAge(60*60*24*30);
            newcookie.setPath("/");
            response.addCookie(newcookie);     
        }
        
        /**session generated**/        
        HttpSession session = request.getSession();
        session.setAttribute("usern", user);
        response.sendRedirect("/home.jsp");
    }

}
