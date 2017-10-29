<%-- 
    Document   : InsertRecord_Items
    Created on : 28 Οκτ 2017, 7:08:12 μμ
    Author     : evimouth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script>
    function trim(s) 
    {
        return s.replace( /^s*/, "" ).replace( /s*$/, "" );
    }

    function validate()
    {
        if(trim(document.frm_inputs.ID.value)==="")
        {
          alert("ID empty");
          document.frm_inputs.ID.focus();
          return false;
        }
        else if(trim(document.frm_inputs.NAME.value)==="")
        {
          alert("NAME empty");
          document.frm_inputs.NAME.focus();
          return false;
        }
        else if(trim(document.frm_inputs.LAST_NAME.value)==="")
        {
          alert("LAST_NAME empty");
          document.frm_inputs.LAST_NAME.focus();
          return false;
        }
        else if(trim(document.frm_inputs.SALARY.value)==="")
        {
          alert("SALARY empty");
          document.frm_inputs.SALARY.focus();
          return false;
        }
    }
</script>
    </head>
    <body>
        <form name="frm_inputs" onSubmit="return validate();" action="Insert_Data_Items" method="post">
       <center>
           <h1>Put values in Boxes</h1>
        <table>
            <tr>
                
                <td>ID</td>
                <td><input type="text" name="ID" /></td>
            </tr>
            <tr>
                <td>NAME</td>
                <td><input type="text" name="NAME" /></td>
            </tr>
            <tr>
                <td>LAST_NAME</td>
                <td><input type="text" name="LAST_NAME" /></td>
            </tr>
            <tr>
                <td>SALARY</td>
                <td><input type="text" name="SALARY" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="submit" /></td>
            </tr>
        </table>
       </center>
      </form>
    </body>
</html>
