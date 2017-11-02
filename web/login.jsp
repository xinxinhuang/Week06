<%-- 
    Document   : login
    Created on : Oct 2, 2017, 1:23:40 PM
    Author     : 721292
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>

<!DOCTYPE html>
<c:import url="/includes/header.html" />


    <sait:debug>
	Remote Host: ${pageContext.request.remoteHost} <br />
	Session ID: ${pageContext.session.id}
    </sait:debug>
        
        <h1>-REMEMBER ME LOGIN PAGE-</h1>
        <h3 style="color:red;">${message}</h3>
        
        <ct:login usern="${usern}" checked="${checked}"/>

<c:import url="/includes/footer.html" />