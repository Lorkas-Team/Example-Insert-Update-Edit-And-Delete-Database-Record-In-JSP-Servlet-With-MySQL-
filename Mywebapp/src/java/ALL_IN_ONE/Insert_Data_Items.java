
package ALL_IN_ONE;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author evimouth
 */
public class Insert_Data_Items extends HttpServlet {

    String ID,SALARY,LAST_NAME,NAME;
    String query;
    Connection conn;
    Statement stmt;
    ResultSet res;
    Database_Connection dbconn;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
       
           dbconn = new Database_Connection ();
           ID = request.getParameter("ID");
           NAME = request.getParameter("NAME");
           LAST_NAME= request.getParameter("LAST_NAME");
           SALARY = request.getParameter("SALARY");
           conn = dbconn.setConnection();
           stmt = conn.createStatement();
           query = "insert into test values('"+ID+"','"+NAME+"','"+LAST_NAME+"','"+SALARY+"') ";
           
           int i=stmt.executeUpdate(query);
        }
        catch(Exception e)
        {
            request.setAttribute("Error", e);
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request,response);
        }
        finally
        {
            RequestDispatcher rd = request.getRequestDispatcher("Main.jsp");
            rd.forward(request,response);
            out.close();
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
