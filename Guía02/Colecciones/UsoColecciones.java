package Colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UsoColecciones {

    public static void main(String[] args) {
        /* ejemploarraylist(); */   // Llamamos al método para que se ejecute
        /* ejemplolist(); */
        usodemap();
    }

    static void ejemploarraylist() {
        // Declaración de un ArrayList con tipo parametrizado
        Collection<String> listaMarcasCoches = new ArrayList<>();

        // Agregando elementos al objeto
        listaMarcasCoches.add("Audi");
        listaMarcasCoches.add("Porsche");
        listaMarcasCoches.add("Aston Martin");
        listaMarcasCoches.add("Ferrari");
        listaMarcasCoches.add("Mercedes");
        listaMarcasCoches.add("Seat");

        System.out.printf("Total de %d elementos almacenados%n", listaMarcasCoches.size());

        // Devuelve lista de elementos almacenados
        System.out.println("Elementos existentes en la Colección:\n" + listaMarcasCoches);

        System.out.println("\nSe borrarán elementos Seat y Mercedes de la colección\n");
        listaMarcasCoches.remove("Seat");
        listaMarcasCoches.remove("Mercedes");

        System.out.println("Nuevo número de elementos almacenados: " + listaMarcasCoches.size());
        System.out.println("Elementos:\n" + listaMarcasCoches);
    }

    static void ejemplolist() {
        ArrayList<String> listaPersona = new ArrayList<>();

        // ---- Agregando elementos ----
        listaPersona.add("Marie Curie");
        listaPersona.add("Benjamin Franklin");
        listaPersona.add("Marco Antonio");
        listaPersona.add(1, "Juan Murillo");   // Inserta en la posición 1

        // ---- Mostrar contenido ----
        System.out.println("USO DE ARRAYLIST");
        System.out.println("Contenido de listaPersona: " + listaPersona + "\n");

        // ---- Búsqueda y consultas ----
        int pos = listaPersona.indexOf("Benjamin Franklin");
        System.out.println("El indice de Benjamin Franklin es: " + pos);

        System.out.println("Verificando si ArrayList está vacío: " + listaPersona.isEmpty());
        System.out.println("El tamaño de listaPersona es: " + listaPersona.size());
        System.out.println("¿Contiene 'Marco Antonio'? " + listaPersona.contains("Marco Antonio"));
        System.out.println("El elemento con indice 0 es: " + listaPersona.get(0));

        // ---- Recuperar elementos (FOR) ----
        System.out.println("\nRecuperando elementos del ArrayList con FOR");
        for (int i = 0; i < listaPersona.size(); i++) {
            System.out.println("Indice: " + i + " - Elemento: " + listaPersona.get(i));
        }

        // ---- Recuperar elementos (FOREACH) ----
        System.out.println("\nRecuperando elementos del ArrayList con FOREACH");
        for (String persona : listaPersona) {
            System.out.println("Elemento: " + persona);
        }

        // ---- Recuperar elementos (Iterator) ----
        System.out.println("\nRecuperando elementos del ArrayList con ITERATOR");
        for (Iterator<String> it = listaPersona.iterator(); it.hasNext(); ) {
            System.out.println("Elemento: " + it.next());
        }

        // ---- Reemplazar un elemento ----
        listaPersona.set(1, "Nikola Tesla");
        System.out.println("\nArrayList después de reemplazo:\n" + listaPersona);

        // ---- Eliminar el primer elemento ----
        listaPersona.remove(0);
        System.out.println("\nArrayList después de eliminar elemento 0:\n" + listaPersona);

        // ---- Convertir a array ----
        String[] simpleArray = listaPersona.toArray(new String[listaPersona.size()]);
        System.out.println("\nObjeto Array creado es:\n" + Arrays.toString(simpleArray));
    }

    static void usodemap() {
        // Declarando HashMap
        HashMap<Integer, String> hmap = new HashMap<>();

        // Agregando elementos
        hmap.put(12, "Crayolas");
        hmap.put(2, "Lápices");
        hmap.put(7, "Borradores");
        hmap.put(49, "Colores");
        hmap.put(3, "Bolígrafos");

        // Mostrando contenido usando Iterator
        System.out.println("Contenido de HashMap:");
        Set<Map.Entry<Integer, String>> set = hmap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterador = set.iterator();

        while (iterador.hasNext()) {
            Map.Entry<Integer, String> mentry = iterador.next();
            System.out.println("Clave: " + mentry.getKey() + " - Valor: " + mentry.getValue());
        }

        // Obtener valor en base a clave
        String var = hmap.get(2);
        System.out.println("\nValor asociado a clave 2: " + var);

        // Remover elemento en base a clave
        hmap.remove(3);
        System.out.println("\nHashMap después de eliminar elemento con clave 3:");
        Set<Map.Entry<Integer, String>> set2 = hmap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterador2 = set2.iterator();

        while (iterador2.hasNext()) {
            Map.Entry<Integer, String> mentry2 = iterador2.next();
            System.out.println("Clave: " + mentry2.getKey() + " - Valor: " + mentry2.getValue());
        }
    } // fin de método usodemap

}