package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.Worker;

@WebServlet(name = "WorkerRegisterServlet", urlPatterns = {"/registrar.do"})
public class WorkerRegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String rut = request.getParameter("txtRut");
            String nombre = request.getParameter("txtNombre");
            String apeP = request.getParameter("txtApeP");
            String apeM = request.getParameter("txtApeM");
            double sueldo = Double.valueOf(request.getParameter("txtSueldoBase"));
            Worker nuevo = new Worker(rut, nombre, apeP, apeM, sueldo);
            DAO dao = new DAO();
            dao.create(nuevo);
            request.getRequestDispatcher("registrarTrabajador.jsp").forward(request, response);
            } catch (FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(WorkerRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
