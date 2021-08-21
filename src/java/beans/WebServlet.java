/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pablo ajin
 */
public class WebServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
private HttpSession sesion;
    private String mensaje = null;
    ClienteBean cliente = new ClienteBean(); 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("action");     
        
        
        if (accion!=null){
                                    
            if(accion.equals("nuevo")){
                nuevo(request,response);
                return;
            }
            if(accion.equals("editar")){
                editar(request,response);
                return;
            }
        }
        if (accion.equals(""));
        request.getRequestDispatcher("error_campos.jsp").forward(request, response);
    }

    protected void nuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");   
              
        
        int cod_cliente = request.getParameter("cod_cliente")==null ? 0:
                Integer.parseInt(request.getParameter("cod_cliente"));
        String nombre = request.getParameter("nombre")==null ? "":
                request.getParameter("nombre");       
        String apellido = request.getParameter("apellido")==null ? "":
                request.getParameter("apellido");
        String direccion = request.getParameter("direccion")==null ? "":
                request.getParameter("direccion");

        try{
            ClienteBean cliente = new ClienteBean();
            cliente.setCod_cliente(cod_cliente);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDireccion(direccion);        
            
            mensaje = "Cliente insertado correctamente";
            
            sesion = request.getSession();       
            
            sesion.setAttribute("cod_cliente", cliente.getCod_cliente()); 
            sesion.setAttribute("nombre", cliente.getNombre()); 
            sesion.setAttribute("apellido", cliente.getApellido()); 
            sesion.setAttribute("direccion", cliente.getDireccion()); 
            
            sesion.setAttribute("cod_cliente2", ""); 
            sesion.setAttribute("nombre2", ""); 
            sesion.setAttribute("apellido2", ""); 
            sesion.setAttribute("direccion2", "");
        
            response.sendRedirect("Cliente.jsp");

            
        }catch(Exception e){
            Logger.getLogger(WebServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); 
        
        sesion = request.getSession();       
            
        sesion.setAttribute("cod_cliente2", sesion.getAttribute("cod_cliente")); 
        sesion.setAttribute("nombre2", sesion.getAttribute("nombre")); 
        sesion.setAttribute("apellido2", sesion.getAttribute("apellido")); 
        sesion.setAttribute("direccion2", sesion.getAttribute("direccion")); 

        
        response.sendRedirect("Cliente.jsp");
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
