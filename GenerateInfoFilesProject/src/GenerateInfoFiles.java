import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GenerateInfoFiles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtener la cantidad de vendedores
        System.out.println("Ingrese la cantidad de vendedores:");
        int cantidadVendedores = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()

        // Bucle para capturar la información de cada vendedor
        for (int i = 1; i <= cantidadVendedores; i++) {
            System.out.println("Vendedor " + i + ":");

            // Obtener información del vendedor
            System.out.println("Ingresar tipo de documento del vendedor:");
            String tipoDocumentoVendedor = scanner.nextLine();

            System.out.println("Ingresar número de documento del vendedor - 10 dígitos:");
            long numeroDocumentoVendedor = scanner.nextLong();
            scanner.nextLine(); // Consumir el salto de línea después de nextLong()

            // Obtener información de ventas del vendedor
            System.out.println("Ingresar información de ventas del vendedor (IDProducto;CantidadProductoVendido).");
            System.out.println("Escriba 'fin' para terminar.");

            StringBuilder ventasBuilder = new StringBuilder(); // Para construir la cadena de ventas

            while (true) {
                System.out.print("Venta (IDProducto;Cantidad): ");
                String venta = scanner.nextLine();

                if (venta.equalsIgnoreCase("fin")) {
                    break;
                }

                // Agregar la venta a la cadena de ventas
                ventasBuilder.append(venta).append("\n");
            }

            // Imprimir información obtenida del vendedor
            System.out.println("Información del vendedor " + i + ":");
            System.out.println("Tipo de documento del vendedor: " + tipoDocumentoVendedor);
            System.out.println("Número de documento del vendedor: " + numeroDocumentoVendedor);
            System.out.println("Ventas del vendedor:");
            System.out.println(ventasBuilder.toString());

            // Generar archivo de texto plano para el vendedor
            String nombreArchivo = tipoDocumentoVendedor.toLowerCase() + "_" + numeroDocumentoVendedor + ".txt";
            try (FileWriter writer = new FileWriter(nombreArchivo)) {
                writer.write("TipoDocumentoVendedor;" + tipoDocumentoVendedor + "\n");
                writer.write("NúmeroDocumentoVendedor;" + numeroDocumentoVendedor + "\n");
                writer.write(ventasBuilder.toString());
                System.out.println("Archivo generado para el vendedor " + i + ": " + nombreArchivo);
            } catch (IOException e) {
                System.err.println("Error al escribir archivo para el vendedor " + i + ": " + e.getMessage());
            }
        }

        // Cerrar el scanner
        scanner.close();
    }
}

