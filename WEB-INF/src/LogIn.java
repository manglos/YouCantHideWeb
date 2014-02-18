/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import youcanthide.*;

/**
 *
 * @author Christopher Manglos
 */
@WebServlet(name = "LogIn", urlPatterns = {"/LogIn"})
public class LogIn extends HttpServlet {

    String debug="";
    String un="";
    String pw="";
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
        debug="";
        un="";
        pw="";
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp?debug="+debug);
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
        
        RequestDispatcher dispatcher;
        un="";
        pw="";
        
        Player me=null;
       
        if(request.getParameter("username")!=null){
            un=request.getParameter("username");
        }
        if(request.getParameter("password")!=null){
            pw=request.getParameter("password");
        }
        
        
        if(!Database.getList().isEmpty()){
            for(Player p : Database.getList()){
                if(p.getUsername().equals(un) && p.getPassword().equals(pw)){
                    me=p;
                }
            }
        }
        
        if(me==null){
            debug="Username or Password incorrect.";
            dispatcher = request.getRequestDispatcher("login.jsp?debug="+debug);
        }
        else{
            System.out.println(me);
            me.addLogin();
            
            HttpSession session = request.getSession();
            
            session.setAttribute("user", me);
            
            dispatcher = request.getRequestDispatcher("ProfileControl?un="+me.getUsername());
        
            
        }
        dispatcher.forward(request, response);
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
