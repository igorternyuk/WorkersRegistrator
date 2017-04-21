package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.Worker;

@WebServlet(name = "WorkerEditInfoServlet", urlPatterns = {"/editar.do"})
public class WorkerEditInfoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("txtID");        
        try {
            DAO dao = new DAO();
            Worker worker = dao.buscarPorID(id);
            if(worker != null){
               String nombre = request.getParameter("txtNombre");
               String apellidoPaterno = request.getParameter("txtApeP");
               String apellidoMaterno = request.getParameter("txtApeM");
               double sb = Double.valueOf(request.getParameter("txtSueldoBase"));
               dao.editarPorID(id, nombre, apellidoPaterno, apellidoMaterno, sb);
            }
            request.getRequestDispatcher("editarInfoTrabajador.jsp").forward(request, response);
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(WorkerEditInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    }// </editor-fold>

}
