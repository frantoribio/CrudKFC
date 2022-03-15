import controllers.UsuariosController;
import controllers.VentasController;
import models.Persona;
import utils.Console;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        secuenciaCRUD();
        secuenciaVentas();

        System.out.println("KFC");
        System.out.println("=================");
        // Bucle infinito a la espera de una opción o salir
        do {
            System.out.println();
            System.out.println("1. Crear pedido");
            System.out.println("2. Eliminar pedido");
            System.out.println("3. Actualizar pedido");
            System.out.println("4. Mostrar pedidos");
            System.out.println("5. Salir");
            System.out.println();
            String opcion = Console.getString("Elige una opción [1-5]: ");
            // Expresion regular para validar la opción
            var regex = "[1-5]";
            if (opcion.matches(regex)) {
                switch (opcion) {
                    case "1":
                        //metodo();
                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    case "4":

                        break;
                    case "5":
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

    private static void secuenciaVentas() {
        var userController = UsuariosController.getInstance();
        var ventasController = VentasController.getInstance();

        System.out.println();
        System.out.println("Secuencia de Ventas");
        System.out.println("==================");
        System.out.println("");

        // Creamos o buscamos el cliente
        var cliente = userController.crearUsuario("joseluis", 20);

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

    private static void secuenciaCRUD() {
        var userController = UsuariosController.getInstance();

        System.out.println();
        System.out.println("Secuencia de CRUD");
        System.out.println("================");
        System.out.println("");
        System.out.println("1. Create: Crear usuario");

        var sal = userController.crearUsuario("joseluis", 20);
        if (sal!=null) {
            System.out.println("Usuario creado: " + sal);
        } else {
            System.out.println("Usuario no creado");
        }

        System.out.println("");
        System.out.println("2. Read: Buscar usuario");
        var sal2 = userController.buscarPorNombre("joseluis");
        if (sal2 != null) {
            System.out.println("Usuario encontrado: " + sal2);
        } else {
            System.out.println("Usuario no encontrado");
        }

        System.out.println("");
        System.out.println("3. Update: Actualizar usuario");
        var nuevosDatos = new Persona("pepe",22);
        var sal3 = userController.actualizarUsuarioPorNombre("joseluis", nuevosDatos);
        if (sal3 != null) {
            System.out.println("Usuario actualizado: " + sal3);
        } else {
            System.out.println("Usuario no actualizado");
        }

        sal2 = userController.buscarPorNombre("pepe");
        if (sal2 != null) {
            System.out.println("Usuario encontrado: " + sal2);
        } else {
            System.out.println("Usuario no encontrado");
        }

        System.out.println("");
        System.out.println("4. Delete: Eliminar usuario");
        var sal4 = userController.eliminarPorPorNombre("pepe");
        if (sal4!=null) {
            System.out.println("Usuario eliminado: " + sal4);
        } else {

            System.out.println("Usuario no eliminado");
        }

        System.out.println("");
        System.out.println("5. ReadAll: Obtener todos");
        userController.crearUsuario("persona 1", 20);
        userController.crearUsuario("persona 2", 30);
        userController.crearUsuario("persona 3", 50);
        userController.crearUsuario("persona 4", 25);
        var res = userController.obtenerTodos();
        if (res != null) {
            System.out.println("Usuarios encontrados: " + res);
        }


    }

}

