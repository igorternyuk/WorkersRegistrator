package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.Worker;
//listarTrabajador.view
@WebServlet(name = "WorkerListServlet", urlPatterns = {"/listarTrabajador.view"})
public class WorkerListServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            DAO dao = new DAO();
            List<Worker> trabajadores = dao.getAll();
            String rutBuscar = request.getParameter("idBuscar");
            
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Listado de trabajadores</title>");
                out.println("</head>");
                out.println("<h1>Listado de trabajadores</h1>");
                
                out.println("<form action='listarTrabajador.view' method='post' style= \"font-size: 20px\"/>");
                out.println("<input type='text' name='idBuscar' placeholder='ID' style= \"font-size: 20px\"/>");
                out.println("<input type='submit' value='Buscar aguinaldo' style= \"font-size: 20px\"/>");
                                    
                if(rutBuscar != null){
                    double aguinaldo = dao.getAguinaldo(rutBuscar);
                    out.println("Aguinaldo: $"+aguinaldo);
                }                    
                out.println("</form><br />");
                
                out.println("<body>");
                out.println("<table border='1'>");
                    out.println("<tr>");
                    out.println("<td>ID</td>");
                    out.println("<td>Nombre completo</td>");
                    out.println("<td>Sueldo base</td>");
                    out.println("<td>Dcto AFP (13%)</td>");
                    out.println("<td>Dcto Salud (7%)</td>");
                    out.println("<td>Bono producíon</td>");
                    out.println("<td>Aguinaldo</td>");
                    out.println("<td>Sueldo liquido</td>");
                    out.println("</tr>");
                   
                    for(Worker t: trabajadores){
                        out.println("<tr>");
                        out.println("<td>" + t.getId() + "</td>");
                        out.println("<td>" + t.getNombre() + " " + t.getApellidoPaterno() + " " + t.getApellidoMaterno() + "</td>");
                        out.format("<td>$%10.3f</td>", t.getSueldoBase());
                        out.format("<td>$%10.3f</td>", t.getAfp());
                        out.format("<td>$%10.3f</td>", t.getSalud());
                        out.format("<td>$%d</td>", t.BONO_PRODUCCION);
                        out.format("<td>$%10.1f</td>", t.getAguinaldo());
                        out.format("<td>$%10.1f</td>", t.getSueldoLiquido());
                        out.println("</tr>");
                    }
                out.println("</table>");
                out.format("<br />Cantidad de trabajadores - %d personas.", trabajadores.size());
                out.print("<br /><a href = \"menu.view\">Menú</a>");
                out.println("</body>");
                out.println("</html>");
            }
        }   catch (FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(WorkerListServlet.class.getName()).log(Level.SEVERE, null, ex);
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
