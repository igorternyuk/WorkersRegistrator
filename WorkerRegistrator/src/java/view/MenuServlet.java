package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO;
import model.User;
import model.Error;

@WebServlet(name = "MenuServlet", urlPatterns = {"/menu.view"})
public class MenuServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        User u = (User)session.getAttribute("user");
        
        if(u == null){
            try {
                //Si el objeto de usuario es vacio creamos el objeto de la clase
                //error con descripcíon correspondiente.
                List<Error> errors = new ArrayList();
                DAO dao = new DAO();
                errors.add(new Error(dao.getERRORS_DESCRIPTION()[3][0], dao.getERRORS_DESCRIPTION()[3][1]));
                session.setAttribute("errors", errors);
                request.getRequestDispatcher("error.view").forward(request, response);
            } catch (FileNotFoundException | ClassNotFoundException ex) {
                Logger.getLogger(MenuServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MenuServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MenuServlet at " + request.getContextPath() + "</h1>");
            out.println("<br /><a href='registrarTrabajador.jsp'>Registrar Trabajador</a>");
            out.println("<br /><a href='eliminarTrabajador.jsp'>Eliminar Trabajador</a>");
            out.println("<br /><a href='listarTrabajador.view'>Listar trabajadores</a>");
            out.println("<br /><a href='editarInfoTrabajador.jsp'>Editar info de trabajadores</a>");
            out.println("<br /><a href='LogOut.do'>Cerrar sesíon</a>");
            out.println("</body>");
            out.println("</html>");
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
