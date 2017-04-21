package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
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

@WebServlet(name = "ValidateServlet", urlPatterns = {"/validate.do"})
public class ValidateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try {
            response.setContentType("text/html;charset=UTF-8");
            DAO dao = new DAO();
            String mail = request.getParameter("txtMail");
            String pass = request.getParameter("txtPass");            
            User u = new User(mail, pass);
            User u2 = dao.exist(u);
            HttpSession session = request.getSession();
            if(u2.errorsExist()){
                //Enviarme a error.view (Lista de errores)
                List<Error> errors = u2.getErrors();
                session.setAttribute("errors", errors);
                request.getRequestDispatcher("error.view").forward(request, response);
            }else {
                //Dirigimos al menu
                session.setAttribute("user", u2);
                request.getRequestDispatcher("menu.view").forward(request, response);
            }
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(ValidateServlet.class.getName()).log(Level.SEVERE, null, ex);
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
