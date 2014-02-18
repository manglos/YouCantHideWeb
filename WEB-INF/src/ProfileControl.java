/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import youcanthide.*;

/**
 *
 * @author Christopher Manglos
 */
@WebServlet(name = "ProfileControl", urlPatterns = {"/ProfileControl"})
public class ProfileControl extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
        
        Player p = null;
        boolean full=false;
        
        if(p!=null && p==(Player)request.getSession().getAttribute("user")){
            full=true;
        }
        else{   
            p = (Player)request.getSession().getAttribute("user");
        }
        
        if(request.getParameter("mode")!=null){
            if(request.getParameter("mode").equalsIgnoreCase("full"))
                full=true;
        }
              
        //if user is logged in, boolean is true, and local user is set to master
        if(p!=null && p.getUsername().equals(request.getParameter("un"))){
            p.setOnline(true);
            request.setAttribute("isuser", new Boolean(true));
            request.setAttribute("user", p);
        }
        else if(p!=null && request.getParameter("un")!=null && request.getParameter("un").equalsIgnoreCase("default")){
            request.setAttribute("isuser", new Boolean(true));
            request.setAttribute("user", p);
        }
        //otherwise, boolean is false, and local user is set to requested one
        else if(!full && Database.getPlayerByUsername(request.getParameter("un"))!=null){
            request.setAttribute("user", Database.getPlayerByUsername(request.getParameter("un")));
            request.setAttribute("isuser", new Boolean(false));
        }
        else if(request.getParameter("un").equals("default")){
            dispatcher = request.getRequestDispatcher("needlogin.jsp");
        }
        else if(Database.getPlayerByUsername(request.getParameter("un"))==null){
            dispatcher = request.getRequestDispatcher("nouser.jsp?un="+request.getParameter("un"));
        }
        
        
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
