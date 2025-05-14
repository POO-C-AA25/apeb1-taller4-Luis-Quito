/**
 * Un gimnasio desea implementar un sistema sencillo para registrar las rutinas de ejercicio de sus clientes. Cada cliente puede seleccionar entre
 * diferentes tipos de ejercicios (cardio, fuerza, estiramiento), la duración de cada uno y si completó o no la rutina diaria. Al finalizar, el 
 * sistema debe mostrar cuántos clientes completaron su rutina y el tiempo promedio invertido.
 * Por tanto, los requerimientos generales son los siguientes:
 * Registrar nombre del cliente, tipo de ejercicio, duración y cumplimiento.
 * Calcular estadísticas básicas.
 * Mostrar resumen al finalizar: cuántos completaron su rutina y promedio de tiempo.
 * @author Luis
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Problema5_GYM {
    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        ArrayList<Cliente> grupoClientes = new ArrayList<>();
        String nombre = " ", tipoEjercicio = " ";
        double tiempoRutina = 0.0;
        boolean cumplimiento;
        int cantidadClientes = 0;
        Cliente clienteTemp = new Cliente();
        Gimnasio gimnasio1 = new Gimnasio("Inca");
        System.out.println("Ingrese la cantidad de clientes: ");
        cantidadClientes = tcl.nextInt();
        tcl.nextLine();
        for (int i = 0; i < cantidadClientes; i++) {
            System.out.print("---------------------Cliente" +(i+1)+"---------------------");
            System.out.print("\nNombre del cliente: ");
            nombre = tcl.nextLine();
            System.out.print("Ingrese el tipo de ejercicio: ");
            tipoEjercicio = tcl.nextLine();
            System.out.print("Ingrese el tiempo de rutina del cliente: ");
            tiempoRutina = tcl.nextDouble();
            System.out.print("Ingrese si el cliente completo su rutina(true/false): ");
            cumplimiento = tcl.nextBoolean();
            tcl.nextLine();
            
            clienteTemp.registroCliente(grupoClientes, nombre, tipoEjercicio, tiempoRutina, cumplimiento);      
        }
        gimnasio1.estadisticaBasica(grupoClientes);
        System.out.println(gimnasio1.toString());
    }
}
class Cliente{
    public String nombre;
    public String tipoEjercicio;
    public double tiempoRutina;
    public boolean cumplimiento;
    
    public Cliente() {
    }
    public Cliente(String nombre, String tipoEjercicio, double tiempoRutina, boolean cumplimiento) {
        this.nombre = nombre;
        this.tipoEjercicio = tipoEjercicio;
        this.tiempoRutina = tiempoRutina;
        this.cumplimiento = cumplimiento;
    }
    public void registroCliente(ArrayList<Cliente> cliente, String nombre, String tipoEjercicio, double tiempoRutina, boolean cumplimiento){
        cliente.add(new Cliente(nombre, tipoEjercicio, tiempoRutina, cumplimiento));
    }  
}
class Gimnasio{
    public String nombreGym;
    public int rutinaCompleta;
    public int rutinaIncompleta;
    public int totalMin;

    public Gimnasio() {
    }
    public Gimnasio(String nombreGym) {
        this.nombreGym = nombreGym;
    }
    public void estadisticaBasica(ArrayList<Cliente> cliente){
        for (Cliente cliente1 : cliente) {
            if(cliente1.cumplimiento == true){
                this.rutinaCompleta++;
            }else{
                this.rutinaIncompleta++;
            }
            this.totalMin += cliente1.tiempoRutina;
        }
    }
    @Override
    public String toString() {
        return "\nGimnasio{" 
                + "\nNombre gimnasio: " + nombreGym 
                + "\nPersonas que completaron la rutina: " + rutinaCompleta 
                + "\nPersonas que no completaron la rutina: " + rutinaIncompleta 
                + "\nTotal de los minutos de rutina: " + totalMin 
                + "\n}\n";
    }
}