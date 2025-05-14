/**
 * Desarrolla un programa que automatice la venta de X producto. El programa debe permitir al usuario ingresar el precio de un producto 
 * y determinar el descuento aplicable según las siguientes reglas:
 * Si el precio del producto es mayor o igual a $1000, y el número de productos al menos 10, se aplica un descuento del 10%.
 * Si el precio del producto es menor a $1000, se aplica un descuento del 5%, independientemente del número de productos.
 * Una vez determinado el descuento, el programa debe calcular y mostrar el precio final la la compra después de aplicar el descuento.
 * El programa debe implementar una clase respectiva base que contenga al menos los métodos:
 * -Un método llamado "calcularDescuento" que tome como parámetro el precio y número de productos y devuelva el descuento correspondiente.
 * -Un método llamado "calcularPrecioFinal" que devuelva el precio final después de aplicar el descuento.
 * Además, el programa debe solicitar al usuario ingresar el precio y número de productos y utilizar los métodos de la clase para calcular 
 * y mostrar el descuento aplicado y el precio final. No olvide que la clase de prueba (que contiene el método main), es quien realiza la gestión 
 * de ingreso de datos y/o visualización de resultados.
 * @author Luis
 */
import java.util.Scanner;
public class Problema1_VentaProducto {
    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        int cantidad;
        double precio;

        System.out.print("Ingrese la cantidad de producto que deseas: ");
        cantidad = tcl.nextInt();
        System.out.print("Intrese el precio por producto: ");
        precio = tcl.nextInt();

        Producto  producto1 = new Producto(cantidad, precio);
            producto1.calcularDescuento(precio, cantidad);
            producto1.calcularPrecioFinal();
            System.out.print(producto1.toString());
        
        Producto producto2 = new Producto(10, 10.0);
            producto2.calcularDescuento(precio, cantidad);
            producto2.calcularPrecioFinal();
            System.out.print(producto2.toString());
    }
}
class Producto {
    public int cantidadProducto;
    public double precioProducto;
    public double descuento;
    public double montoDescuento;
    public double precioFinal;

    public Producto() {
    }

    public Producto(int cantidadProducto, double precioProducto) {
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
    }

    public double calcularDescuento(double precioProducto, int cantidadProducto) {
        if (this.precioProducto >= 1000 && this.cantidadProducto >= 10) {
            this.descuento = 10;
        } else if (this.precioProducto < 1000) {
            this.descuento = 5;
        }
        this.montoDescuento = (this.cantidadProducto * this.precioProducto) * (this.descuento / 100);
        return this.descuento;
    }

    public double calcularPrecioFinal() {
        this.precioFinal = (this.cantidadProducto * this.precioProducto) - this.montoDescuento;
        return this.precioFinal;
    }
    
    @Override
    public String toString() {
        return "\nProducto{" 
                + "\nCantidad del producto: " + cantidadProducto 
                + "\nPrecio del producto: " + precioProducto 
                + "\nDescuento aplicado: " + descuento +" %" 
                + "\nDescuento:" + montoDescuento 
                + "\nPrecio final: " + precioFinal + "}\n";
    }
}
