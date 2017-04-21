package model;

import java.io.Serializable;

public class Worker implements Serializable {
    private String id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private double sueldoBase;
    private double afp;
    private double salud;
    private double sueldoLiquido;
    private double aguinaldo;
    public final int BONO_PRODUCCION = 30000;

    public Worker(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, double sueldoBase) {
        this.id = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sueldoBase = sueldoBase;
        calculate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
        //Recalcular todos los parametros qué dependen de sueldoBase
        calculate();
    }

    public double getAfp() {
        return afp;
    }

    public void setAfp(double afp) {
        this.afp = afp;
    }

    public double getSalud() {
        return salud;
    }

    public void setSalud(double salud) {
        this.salud = salud;
    }

    public double getSueldoLiquido() {
        return sueldoLiquido;
    }

    public void setSueldoLiquido(double sueldoLiquido) {
        this.sueldoLiquido = sueldoLiquido;
    }

    public double getAguinaldo() {
        return aguinaldo;
    }

    public void setAguinaldo(double aguinaldo) {
        this.aguinaldo = aguinaldo;
    }
    
    @Override
    public String toString() {
        return "Trabajador{" + "sueldoBase=" + sueldoBase + ", afp=" + afp + ", salud=" + salud + ", sueldoLiquido=" + sueldoLiquido + ", aguinaldo=" + aguinaldo + ", BONO_PRODUCCION=" + BONO_PRODUCCION + '}';
    }
    
    public final void calculate() {
        afp = sueldoBase * 0.13;
        salud = sueldoBase * 0.07;
        sueldoLiquido = (sueldoBase + BONO_PRODUCCION - afp - salud);
        if(sueldoBase <= 200000){
            aguinaldo = 80000;
        }else if(sueldoBase > 200000 && sueldoBase <= 500000){
            aguinaldo = 40000;
        }else{
            aguinaldo = 5000;
        }
    }
    public static void main(String[] args) {
        Worker t1 = new Worker(null, null, null, null, 100000);
        Worker t2 = new Worker(null, null, null, null, 600000);
        System.out.println(t1.toString());
        System.out.println(t2.toString());
    }
}
