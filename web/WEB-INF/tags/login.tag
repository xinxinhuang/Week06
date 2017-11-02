<%-- 
    Document   : login
    Created on : Nov 1, 2017, 8:35:26 PM
    Author     : 721292
--%>

<%@tag description="login tag" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="usern"%>
<%@attribute name="checked"%>

<%-- any content can be specified here e.g.: --%>
            <form action="Login" method="post">
                Username :   <input type="text" name="usern" value="${usern}"><br>
                Password :   <input type="password" name="passw"><br>
                Remember Me <input type="checkbox" name="reme" ${checked}><br>
                <input type="submit" value="Login">
            </form>