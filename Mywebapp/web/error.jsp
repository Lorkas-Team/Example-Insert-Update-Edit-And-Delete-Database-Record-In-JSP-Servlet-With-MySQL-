<%-- 
    Document   : error
    Created on : 29 Οκτ 2017, 5:31:55 μμ
    Author     : evimouth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Error: <%=(String)request.getAttribute("Error")%></h1>
    </body>
</html>
