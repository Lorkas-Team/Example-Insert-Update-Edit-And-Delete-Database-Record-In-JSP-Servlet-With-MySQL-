
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
public class EditRecord extends HttpServlet {
    Connection conn;
    ResultSet res;
    Statement stmt;
    String ID,query;
    Database_Connection dbconn;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  
        {
           ID=request.getParameter("ID");
           dbconn= new Database_Connection();
           conn= dbconn.setConnection();
           stmt=conn.createStatement();
           query="select * from test where ID="+ID;
           res= dbconn.getResult(query,conn);
           
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            request.setAttribute("EditData",res);
            RequestDispatcher rd = request.getRequestDispatcher("/EditData.jsp");
            
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
