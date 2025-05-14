/**
 * Un parque de diversiones necesita controlar la entrada de visitantes según su edad y altura. Solo pueden ingresar a ciertos juegos los visitantes 
 * que cumplen con las restricciones mínimas. El programa debe registrar a los visitantes e indicar a cuáles juegos pueden acceder. Al final, debe 
 * mostrar cuántos visitantes cumplieron con todos los requisitos. Por tanto, los requerimientos generales son los siguientes:
 * Registrar al visitante con los datos de entreda necesarios.
 * Determinar si el visitante puede acceder al juegos de su elección.
 * Al final del día, se debe mostrar el resumen de cuántos cumplen con todas las condiciones.
 * @author Luis
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Problema4_Parque {
    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        int edad = 0, numeroVisitantes = 0;
        double altura = 0.0;
        String juegoPreferencial = "";
        ArrayList<Visitante> grupoVisitantes = new ArrayList<>();
        Visitante visitanteTemp = new Visitante();
        Parque juego1 = new Parque("Juego 1", 15, 1.60);
        System.out.print("Ingrese cuantos visitantes van a ingresar: ");
        numeroVisitantes = tcl.nextInt();
        tcl.nextLine();
        for (int i = 0; i < numeroVisitantes; i++) {
            System.out.println("----------------Visitante" +(i+1)+"----------------");
            System.out.print("Ingrese el juego al que quiere ingresar el visitante: ");
            juegoPreferencial = tcl.nextLine();
            System.out.print("Ingrese la estatura del visitante: ");
            altura = tcl.nextDouble();
            System.out.print("Ingrese la edad del visitante: ");
            edad = tcl.nextInt();
            tcl.nextLine();

            visitanteTemp.registrarVisitantes(grupoVisitantes, juegoPreferencial, edad, altura);
        }
        juego1.determinarAcceso(grupoVisitantes);
        System.out.print("\nResumen del dia:\n" + juego1.toString());

    }

}
class Visitante {

    public int edad;
    public double altura;
    public String juegoPreferencial;
    
    public Visitante() {
    }
    public Visitante(String juegoPreferencial, int edad, double altura) {
        this.edad = edad;
        this.altura = altura;
        this.juegoPreferencial = juegoPreferencial;
    }
    public void registrarVisitantes(ArrayList<Visitante> grupovisitantes, String juegoPreferencial, int edad, double altura) {
        grupovisitantes.add(new Visitante(juegoPreferencial, edad, altura));
    }

}
class Parque {
    public int cumplieronRequisitos;
    public String nombre;
    public int edadRequerida;
    public double alturaRequerida;

    public Parque() {
    }
    public Parque(String nombre, int edadRequerida, double alturaRequerida) {
        this.nombre = nombre;
        this.edadRequerida = edadRequerida;
        this.alturaRequerida = alturaRequerida;
    }
    public void determinarAcceso(ArrayList<Visitante> grupoVisitantes) {
        for (Visitante grupoVisitante : grupoVisitantes) {
            if (grupoVisitante.edad >= this.edadRequerida && grupoVisitante.altura >= this.alturaRequerida) {
                this.cumplieronRequisitos++;
                System.out.print("El visitante puede acceder a todos los juegos");
            } else if (grupoVisitante.edad >= this.edadRequerida || grupoVisitante.altura >= this.alturaRequerida) {
                if (grupoVisitante.juegoPreferencial.equalsIgnoreCase(this.nombre)) {
                    System.out.println("El visitante puede subir a su juego de preferencia ");
                }
                System.out.print("El visitante puede acceder a los siguientes juegos: ");
                System.out.println("\t" + this.nombre);
            }
        }
    }
    @Override
    public String toString() {
        return "\nJuego mecanico{"
                + "\nCumplieron con todos los requisitos: " + cumplieronRequisitos
                + "\nNombre: " + nombre
                + "\nEdad requerida: " + edadRequerida
                + "\nAltura requerida: " + alturaRequerida 
                + "\n}\n";
    }
}