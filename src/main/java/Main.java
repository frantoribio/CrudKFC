import controllers.ProductosController;
import controllers.ClientesController;
import controllers.VentasController;
import models.Cliente;
import utils.Console;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final ClientesController userController = ClientesController.getInstance();
    private static final VentasController ventasController = VentasController.getInstance();
    private static final ProductosController productosController = ProductosController.getInstance();

    public static void main(String[] args) {

        System.out.println("KFC");
        System.out.println("=================");
        // Bucle infinito a la espera de una opción o salir
        do {
            System.out.println();
            System.out.println("1. Gestionar clientes");
            System.out.println("2. Gestionar ventas");
            System.out.println("3. Salir");
            String opcion = Console.getString("Elige una opción [1-5]: ");
            // Expresion regular para validar la opción
            var regex = "[1-3]";
            if (opcion.matches(regex)) {
                switch (opcion) {
                    case "1":
                        gestionClientes();
                        break;
                    case "2":
                        //gestionPedidos();
                        break;
                    case "3":
                        salir();
                        break;
                }
            }
        } while (true);
    }

    public static void gestionClientes() {
        do {
            System.out.println();
            System.out.println("1. Crear cliente nuevo");
            System.out.println("2. Buscar cliente");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Mostrar clientes");
            System.out.println("6. Salir");
            System.out.println();
            String opcion = Console.getString("Elige una opción [1-5]: ");
            // Expresion regular para validar la opción
            var regex = "[1-5]";
            if (opcion.matches(regex)) {
                switch (opcion) {
                    case "1":
                        nuevoCliente();
                        break;
                    case "2":
                        buscarCliente();
                        break;
                    case "3":
                        actualizarCliente();
                        break;
                    case "4":
                        eliminarCliente();
                        break;
                    case "5":
                        mostrarClientes();
                        break;
                    case "6":
                        salir();
                        break;
                }
            }
        } while (true);
    }

    /**
     * Salir del programa
     */
    private static void salir() {
        System.out.println("¡Hasta pronto!");
        System.exit(0);
    }

    private static void nuevoCliente() {
        var sal = userController.crearUsuario(Console.
                getString("Introduce tu nombre"),Console.getInt("Introduce tu edad"));
        if (sal!=null) {
            System.out.println("Usuario creado: " + sal);
        } else {
            System.out.println("Usuario no creado");
        }
    }

    private static void buscarCliente() {
        var sal2 = userController.buscarPorNombre(Console.getString("Introduce el nombre"));
        if (sal2 != null) {
            System.out.println("Usuario encontrado: " + sal2);
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    private static void actualizarCliente() {
        var nuevosDatos = new Cliente(Console.getString("Introduce el nombre"),Console
                .getInt("Introduce tu edad"));
        var sal3 = userController.actualizarUsuarioPorNombre(Console
                .getString("Introduce el nombre"), nuevosDatos);
        if (sal3 != null) {
            System.out.println("Usuario actualizado: " + sal3);
        } else {
            System.out.println("Usuario no actualizado");
        }
    }

    private static void eliminarCliente() {
        System.out.println("4. Delete: Eliminar usuario");
        var sal4 = userController.eliminarPorPorNombre(Console.
                getString("Introduce el nombre"));
        if (sal4!=null) {
            System.out.println("Usuario eliminado: " + sal4);
        } else {

            System.out.println("Usuario no eliminado");
        }
    }

    private static void mostrarClientes() {
        var res = userController.obtenerTodos();
        if (res != null) {
            System.out.println("Usuarios encontrados: " + res);
        }
    }

    private static void secuenciaVentas() {
        var userController = ClientesController.getInstance();
        var ventasController = VentasController.getInstance();

        System.out.println();
        System.out.println("Secuencia de Ventas");
        System.out.println("==================");
        System.out.println("");

        // Creamos o buscamos el cliente
        var cliente = userController.crearUsuario(Console.
                getString("Introduce tu nombre"),Console.getInt("Introduce tu edad"));

        Map<Integer,Integer> datosLinea = new HashMap<>();
        datosLinea.put(1,1);
        datosLinea.put(2,1);
        datosLinea.put(3,2);
        datosLinea.put(4,1);

        try {
            var res = ventasController.realizarVenta(cliente, datosLinea);
            System.out.println("Venta realizada: " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

