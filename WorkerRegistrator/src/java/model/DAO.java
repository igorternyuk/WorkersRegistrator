package model;

import controller.InitListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {    
    private static final String CORRECT_MAIL = "xmonad100@gmail.com";
    private static final String CORRECT_PASS = "123";
    private static final String CORRECT_USER_NAME = "Igor Ternyuk";
    private static final String[][] ERRORS_DESCRIPTION = {
        {"100", "La contraseña es incorrecta"},
        {"200", "E-mail es erróneo"},
        {"300", "E-mail y contraseña son incorrectos!"},
        {"400", "Debe iniciar sesión para acceder al menú"}
        };
    private static List<Worker> trabajadores;
    
    public DAO() throws IOException, FileNotFoundException, ClassNotFoundException{
        File archivoTrabajadores 
                = new File(InitListener.RUTA_ARCHIVO_TRABAJADORES);
        if(archivoTrabajadores.exists()){// si existe el archivo
            /*Lo cargo a la lista*/
            trabajadores = (List)IO.leerObjetoDesde(InitListener.RUTA_ARCHIVO_TRABAJADORES);
            //trabajadores = (List)IO.leerObjetoDesde("/home/igor/prj/java/clase_5/clase_5/build/web/WEB-INF/data/trabajadores.dat");
        }else{
            /*Si no, lo creo vacío*/
            trabajadores = new ArrayList<Worker>();
        }
    }
    
    public void create(Worker t) throws IOException{
        trabajadores.add(t);
        IO.escribirObjetoEn(trabajadores, InitListener.RUTA_ARCHIVO_TRABAJADORES);
        //IO.escribirObjetoEn(trabajadores, "/home/igor/prj/java/clase_5/clase_5/build/web/WEB-INF/data/trabajadores.dat");
    }
    
    public List<Worker> getAll(){
        return trabajadores;
    }
    
    public Worker buscarPorID(String id){
        for(Worker w: trabajadores){
            if(w.getId().equals(id)){
                return w;
            }
        }
        return null;
    }
    
    public void editarPorID(String id, String nombre, String apellidoPaterno, String apellidoMaterno, double sb){
        try {
            for(Worker w: trabajadores){
                if(w.getId().equals(id)){
                    
                    if(!nombre.equals(" ")){
                        w.setNombre(nombre);
                    }
                    if(!apellidoPaterno.equals(" ")){
                        w.setApellidoPaterno(apellidoPaterno);
                    }
                    if(!apellidoMaterno.equals(" ")){
                        w.setApellidoMaterno(apellidoMaterno);
                    }
                    w.setSueldoBase(sb);
                }
            }
            IO.escribirObjetoEn(trabajadores, InitListener.RUTA_ARCHIVO_TRABAJADORES);
        } catch (IOException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarPorID(String id) throws IOException{
        System.out.println("Eliminacion del trabajador");
        for(Worker w: trabajadores){
            if(w.getId().equalsIgnoreCase(id)){
                trabajadores.remove(w);
                break;
            }
        }
        IO.escribirObjetoEn(trabajadores, InitListener.RUTA_ARCHIVO_TRABAJADORES);
    }
    public double getAguinaldo(String id){
        for(Worker w: trabajadores){
            if(w.getId().equalsIgnoreCase(id)){
                return w.getAguinaldo();
            }
        }        
        return -1.0;
    }
    
    public User exist(User u){
        if(!u.getMail().equalsIgnoreCase(CORRECT_MAIL) &&
                !u.getPass().equalsIgnoreCase(CORRECT_PASS)){
            /*Malo*/
            u.addError(new Error(ERRORS_DESCRIPTION[2][0], ERRORS_DESCRIPTION[2][1]));
            return u;
        }else if(u.getMail().equalsIgnoreCase(CORRECT_MAIL)){
            /*OK*/
            if(u.getPass().equalsIgnoreCase(CORRECT_PASS)){
                /*OK*/
                return new User(u.getMail(), u.getPass(), CORRECT_USER_NAME);
            }else{
                /*Pass Incorrecta*/
                User newUser = new User(u.getMail(), u.getPass(), CORRECT_USER_NAME);
                newUser.addError(new Error(ERRORS_DESCRIPTION[0][0], ERRORS_DESCRIPTION[0][1]));
                return newUser;
            }
        }else{
            /*Email erróneo*/
            User newUser = new User(u.getMail(), u.getPass(), CORRECT_USER_NAME);
            newUser.addError(new Error(ERRORS_DESCRIPTION[1][0], ERRORS_DESCRIPTION[1][1]));
            return newUser;
        }
    }

    public String[][] getERRORS_DESCRIPTION() {
        return ERRORS_DESCRIPTION;
    }
    
   /* public static void main(String[] args){
        try {
            DAO dao = new DAO();
            Worker w1 = new Worker("1", "Ivan", "K", "S", 25000);
            dao.create(w1);
            Worker w2 = new Worker("1", "Ivan2", "P", "A", 245000);
            dao.create(w2);
            Worker w3 = new Worker("1", "Ivan3", "P4", "S", 35000);
            dao.create(w3);
            System.out.println("Number of workers = " + dao.getAll().size());
            System.out.println("le eliminamos el trabajador");
            dao.eliminarPorID("1");
            System.out.println("Number of workers = " + dao.getAll().size());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    
}
