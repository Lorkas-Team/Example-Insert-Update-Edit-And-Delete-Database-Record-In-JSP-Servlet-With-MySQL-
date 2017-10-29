<%-- 
    Document   : DisplayRecord
    Created on : 29 Οκτ 2017, 6:15:25 μμ
    Author     : evimouth
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script type="text/javascript">
            function editRecord(ID)
            {
                url="EditData";
                windows.location.href="http://localhost:8080/Mywebapp/"+url+"?ID="+ID;
                
            }
        </script>
        <table align="center" border="1px" width="80%">
            <%Iterator itr;%>
            <%List data=(List) request.getAttribute("TestData");
            for(itr = data.iterator(); itr.hasNext();)
            {
                %>
                <tr>
                    <% String s = (String) itr.next(); %>
                    <td><%=s%></td>
                    <td><%=itr.next() %></td>
                    <td><%=itr.next() %></td>
                    <td><%=itr.next() %></td>
                    <td><input type ="submit" value="Edit" name="edit" onclick="editRecord(<%=s%>);" /></td>
                    <td><input type ="submit" value="Delete" name="delete" onclick="DeleteRecord(<%=s%>);" /></td>
                   
                    
            
                    <%}%>
                    
                </tr>
        </table>
    
    </body>
</html>
