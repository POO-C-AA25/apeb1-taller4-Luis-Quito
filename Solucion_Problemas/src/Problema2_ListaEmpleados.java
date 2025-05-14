/**
 * Desarrolla un programa que permita gestionar una lista de empleados de una empresa y su nómina de pagos. El programa debe permitir 
 * al usuario realizar las siguientes acciones:
 * 1. Agregar un empleado: El usuario debe ingresar el nombre, el salario y la edad del empleado. El programa debe crear un objeto de la clase "Empleado" 
 * con esta información y agregarlo a la lista de empleados.
 * 2. Mostrar información de los empleados: El programa debe mostrar en pantalla la información de todos los empleados registrados, incluyendo su nombre, 
 * salario y edad.
 * 3. Calcular aumento de salario: El programa debe solicitar al usuario ingresar un porcentaje de aumento salarial. Luego, para cada empleado 
 * cuyo salario sea menor al salario promedio de todos los empleados, se debe aplicar el aumento correspondiente y mostrar en pantalla el nuevo salario.
 * La clase "Empleado" debe tener los siguientes atributos:
 * Nombre: nombre del empleado (cadena de caracteres).
 * Salario: salario del empleado (número decimal).
 * Edad: edad del empleado (entero).
 * @author Luis
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Problema2_ListaEmpleados {
    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        int opcion = 0, edad = 0, salir = 0;
        double salario = 0.0, aumento = 0;
        String nombre;
        ArrayList<Empleados> dinamicaEmpleados = new ArrayList<>();
        Empleados empleadoObj = new Empleados();
        do {
            System.out.print("""
                                                        
                                                Menú 

                            [1] Agregar un empleado          
                         
                            [2] visualizar la informacion de los empleados

                            [3] Solicitar un aumento de salario
                            
                            [4] Salir
                        
                             """);
            
            System.out.println("");
            opcion = tcl.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese los datos del nuevo empleado");
                    tcl.nextLine();
                    System.out.print("\nNombre del empleado: ");
                    nombre = tcl.nextLine();
                    System.out.print("\nEdad del empleado: ");
                    edad = tcl.nextInt();
                    System.out.print("\nSalario del empleado: ");
                    salario = tcl.nextDouble();
                    tcl.nextLine();
                    empleadoObj.agregarEmpleado(dinamicaEmpleados, nombre, edad, salario);
                    break;
                case 2:
                    System.out.println("");
                    empleadoObj.mostrarInformacion(dinamicaEmpleados);
                    break;
                case 3:
                    System.out.print("Ingrese el porcentaje de aumento: ");
                    aumento = tcl.nextInt();
                    
                    empleadoObj.calcularAumento(dinamicaEmpleados, aumento);
                    break;
                default:
                    System.out.print("Cerrando el sistema");
            }

        } while (opcion != 4);
    }
    static class Empleados {
        public String nombres;
        public int edad;
        public double salario;
        public double aumentoSalario;
        public Empleados() {
        }
        public Empleados(String nombres, int edad, double salario) {
            this.nombres = nombres;
            this.edad = edad;
            this.salario = salario;
        }
        public void agregarEmpleado(ArrayList<Empleados> empleados, String nombre, int edad, double salario){
            empleados.add(new Empleados(nombre, edad, salario));
        }
        public void mostrarInformacion(ArrayList<Empleados> empleados){
            int i = 0;
            
            for (Empleados empleado : empleados) {
                i++;
                System.out.print("Empleado N" +i+ ": "
                        + "\t\nNombres:" + empleado.nombres 
                        + "\t\nEdad:" + empleado.edad
                        + "\t\nSalario:" + empleado.salario
                        + "\n_____________________________\n");
            }
        }
        public void calcularAumento(ArrayList<Empleados> empleados, double aumento){
            this.aumentoSalario = ((aumento + 100.0)/100.0);
            for (Empleados empleado : empleados) {
                empleado.salario = empleado.salario * this.aumentoSalario;
            }
        }
    }
}