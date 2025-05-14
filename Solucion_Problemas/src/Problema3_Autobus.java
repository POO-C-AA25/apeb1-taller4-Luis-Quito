/**
 * Un conductor de autobús escolar necesita un sistema sencillo que le permita verificar si los estudiantes tienen permitido subir al autobús, 
 * según su ruta y si están autorizados para ese día. El programa debe permitir registrar temporalmente una lista de estudiantes con su nombre, 
 * grado, y si tienen permiso vigente. Luego, debe simular el ingreso de estudiantes, indicando si pueden subir o no, y mostrando al final un 
 * resumen del total de estudiantes aceptados y rechazados.
 * Los requerimientos generales en resumen son los siguientes:
 * Registrar estudiantes con los datos requeridos.
 * Simular el ingreso y verificar condiciones dadas.
 * Mostrar un resumen con totales de aceptados y rechazados.
 * @author Luis
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Problema3_Autobus {
    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        String nombre = "", ruta = "", grado = "";
        boolean permisoVigente;
        int numeroEstudiantes;
        ArrayList<Estudiantes> estudiantes1 = new ArrayList<>();
        Estudiantes estudiante1 = new Estudiantes();
        Autobus autobus1 = new Autobus("Ruta 1", true);
        System.out.print("Ingrese el número de estudiantes: ");
        numeroEstudiantes = Integer.parseInt(tcl.nextLine());
        for (int i = 0; i < numeroEstudiantes; i++) {
            System.out.println("\nEstudiante #" + (i + 1));
            System.out.print("Nombre: ");
            nombre = tcl.nextLine();
            System.out.print("Grado: ");
            grado = tcl.nextLine();
            System.out.print("Ruta: ");
            ruta = tcl.nextLine();
            System.out.print("¿Tiene permiso vigente? (true/false): ");
            permisoVigente = Boolean.parseBoolean(tcl.nextLine());
            estudiante1.registroEstudiantes(estudiantes1, nombre, grado, ruta, permisoVigente);
        }
        autobus1.simularIngresoEstudiantes(estudiantes1);
        autobus1.mostrarResumen();
        System.out.print(autobus1.toString());
    }
}
class Autobus {
    public String ruta;
    public boolean autorizacion;
    public int estudiantesAdmitidos;
    public int estudiantesRechazados;
    public Autobus() {
    }
    public Autobus(String ruta, boolean autorizacion) {
        this.ruta = ruta;
        this.autorizacion = autorizacion;
    }
    public void simularIngresoEstudiantes(ArrayList<Estudiantes> estudiantes) {
        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.permisoVigente == true && (estudiante.ruta.equalsIgnoreCase(this.ruta))) {
                this.estudiantesAdmitidos++;
            } else {
                this.estudiantesRechazados++;
            }
        }
    }
    public void mostrarResumen() {
        System.out.println("--------------RESUMEN--------------");
        System.out.println("Estudiantes aceptados: " + this.estudiantesAdmitidos);
        System.out.println("Estudiantes rechazados: " + this.estudiantesRechazados);
    }
    @Override
    public String toString() {
        return "\nAutobus{"
                + "\nRuta: " + ruta
                + "\nAutorizacion: " + autorizacion
                + "\nEstudiantes admitidos:" + estudiantesAdmitidos
                + "\nEstudiantes rechazados:" + estudiantesRechazados
                + "\n}\n";
    }
}
class Estudiantes {
    public String nombre;
    public String grado;
    public String ruta;
    public boolean permisoVigente;
    public Estudiantes() {
    }
    public Estudiantes(String nombre, String grado, String ruta, boolean permisoVigente) {
        this.nombre = nombre;
        this.grado = grado;
        this.ruta = ruta;
        this.permisoVigente = permisoVigente;
    }
    public void registroEstudiantes(ArrayList<Estudiantes> estudiantes, String nombre, String grado, String ruta, boolean permisoVigente) {
        estudiantes.add(new Estudiantes(nombre, grado, ruta, permisoVigente));
    }
}