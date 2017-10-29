<%-- 
    Document   : EditData
    Created on : 29 Οκτ 2017, 7:18:55 μμ
    Author     : evimouth
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="UpdateData" method="post">
        <table align="center" border="1px" width="80%">
            <tr>
                <%ResultSet res=(ResultSet) request.getAttribute("EditData");%>
                <%if(res.next())
                {   %>
                <td>
                    ID
                </td>
                <td>
                    <input type="text" name="ID" value="<%=res.getString("ID")%>" /> 
                </td>
                </tr>
                <tr>
                <td> 
                    NAME
                </td>
                <td>
                    <input type="text" name="NAME" value="<%=res.getString("NAME")%>" />
                </td>
                </tr>
                <tr>
                <td>
                    LAST_NAME
                </td>
                <td>
                    <input type="text" name="LAST_NAME" value="<%=res.getString("LAST_NAME")%>" />
                </td>
                </tr>
                <tr>
                <td>
                    SALARY
                </td>
                <td>
                    <input type="text" name="SALARY" value="<%=res.getString("SALARY")%>" />
                </td>
                </tr>
                <tr>
                    <td>
                        
                    </td>
                    <td>
                        <input type="submit" name="Update" value="Update" />
                    </td>
                </tr>
                <%}%>
                
            
        </table>
        </form>
    </body>
</html>
