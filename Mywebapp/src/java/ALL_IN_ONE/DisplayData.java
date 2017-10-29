
package ALL_IN_ONE;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author evimouth
 */
public class DisplayData extends HttpServlet {
   
    String query;
    Connection conn;
    Statement stmt;
    ResultSet res;
    Database_Connection dbconn;
    List lst=new ArrayList();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            dbconn= new Database_Connection();
            conn= dbconn.setConnection();
            stmt=conn.createStatement();
            query="select * from test";
            res=dbconn.getResult(query, conn);
            while(res.next())
            {
                lst.add(res.getString("ID"));
                lst.add(res.getString("NAME"));
                lst.add(res.getString("LAST_NAME"));
                lst.add(res.getString("SALARY"));
            }
            res.close();
        }
        catch(Exception e)
        {
            RequestDispatcher rd=request.getRequestDispatcher("/error.jsp");
            rd.forward(request,response);
        }
        finally
        {
            request.setAttribute("TestData", lst);
            RequestDispatcher rd=request.getRequestDispatcher("/DisplayRecord.jsp");
            rd.forward(request,response);
            lst.clear();
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
