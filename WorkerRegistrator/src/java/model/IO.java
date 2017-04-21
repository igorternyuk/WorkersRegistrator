package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IO {
    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static ObjectInputStream ois;
    private static ObjectOutputStream oos;
    
    public static void escribirObjetoEn (Object objeto, String ruta) throws IOException{
       //si la ruta no existe, la creo
       if(!new File(ruta).exists()){
          String[] carpetas = ruta.split("/");
          String archivo = carpetas[carpetas.length - 1];
          //Si carpetas.length != 1 el usuario quiere crear las carpetas tambien
          if(carpetas.length != 1){
              String rutaCarpetas = "";
              for(String carpeta : carpetas){
                  //Si carpeta es distinta al archivo lo argrego a la ruta
                  if(!carpeta.equalsIgnoreCase(archivo)){
                    rutaCarpetas += carpeta + "/";
                  }
              }
              //Aquí creo los directiorios necesarios
              new File(rutaCarpetas).mkdirs();
              //Creo el archivo en la ruta especificada
              new File(ruta).createNewFile();
          }
       }
       fos = new FileOutputStream(ruta);
       oos = new ObjectOutputStream(fos);
       oos.writeObject(objeto);
       
       oos.close();
       fos.close();
    }
    
    public static Object leerObjetoDesde(String ruta) throws FileNotFoundException, IOException, ClassNotFoundException{
        fis = new FileInputStream(ruta);
        ois = new ObjectInputStream(fis);
        return ois.readObject();
    }
}
