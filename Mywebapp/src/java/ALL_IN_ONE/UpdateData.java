
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
public class UpdateData extends HttpServlet {
    
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
        try
        {
            dbconn = new Database_Connection ();
           ID = request.getParameter("ID");
           NAME = request.getParameter("NAME");
           LAST_NAME= request.getParameter("LAST_NAME");
           SALARY = request.getParameter("SALARY");
           conn = dbconn.setConnection();
           stmt = conn.createStatement();
           query = "update test set NAME= '"+NAME+"',LAST_NAME='"+LAST_NAME+"',SALARY='"+SALARY+"' where ID= '"+ID+"' ";
           
           int i=stmt.executeUpdate(query);
            
            
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            RequestDispatcher rd = request.getRequestDispatcher("Main.jsp");
            rd.forward(request,response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
