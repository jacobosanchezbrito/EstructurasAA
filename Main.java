// ============================================================
// Clase: MainEstructuras
// Descripción: Prueba exhaustiva de todas las estructuras de datos
// implementadas: listas, pila y cola basadas en nodos enlazados.
// Autor: Jacobo
// https://chatgpt.com/share/68f1148f-6aa4-800b-86b1-caa055e5e6f1
// ============================================================

public class MainEstructuras {

    public static void main(String[] args) {

        System.out.println("\n\n============================================================");
        System.out.println("     🧩 PRUEBAS DE ESTRUCTURAS DE DATOS ENLAZADAS");
        System.out.println("============================================================\n");

        // ============================================================
        // 1. LISTA ENLAZADA SIMPLE
        // ============================================================
        System.out.println("\n\n🔷 PRUEBAS: LISTA ENLAZADA SIMPLE");
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        System.out.println("\n--- Método: insertarInicio(valor) --- O(1)");
        System.out.println("Insertando 3, 2, 1 al inicio (la lista quedará 1→2→3)...");
        lista.insertarInicio(3);
        lista.insertarInicio(2);
        lista.insertarInicio(1);
        lista.imprimir();

        System.out.println("\n--- Método: insertarFinal(valor) --- O(n)");
        System.out.println("Insertando 4 y 5 al final...");
        lista.insertarFinal(4);
        lista.insertarFinal(5);
        lista.imprimir();

        System.out.println("\n--- Método: insertarEnPosicion(pos, valor) --- O(n)");
        System.out.println("Insertando 99 en la posición 3...");
        lista.insertarEnPosicion(3, 99);
        lista.imprimir();

        System.out.println("\n--- Método: getValor(posicion) --- O(n)");
        System.out.println("Obteniendo valor en la posición 3: " + lista.getValor(3));

        System.out.println("\n--- Método: buscar(valor) --- O(n)");
        System.out.println("¿Existe el valor 99?: " + lista.buscar(99));

        System.out.println("\n--- Método: getPosicion(valor) --- O(n)");
        System.out.println("Posición del valor 4: " + lista.getPosicion(4));

        System.out.println("\n--- Método: removerPorPosicion(posicion) --- O(n)");
        System.out.println("Eliminando elemento en posición 3...");
        lista.removerPorPosicion(3);
        lista.imprimir();

        System.out.println("\n--- Método: getCantidadNodos() --- O(1)");
        System.out.println("Cantidad actual de nodos: " + lista.getCantidadNodos());

        System.out.println("\n--- Método: eliminar() --- O(1)");
        System.out.println("Eliminando toda la lista...");
        lista.eliminar();
        lista.imprimir();

        // ============================================================
        // 2. LISTA DOBLEMENTE ENLAZADA
        // ============================================================
        System.out.println("\n\n🔷 PRUEBAS: LISTA DOBLEMENTE ENLAZADA");
        ListaDoblementeEnlazada listaDoble = new ListaDoblementeEnlazada();

        System.out.println("\n--- insertarInicio(valor) --- O(1)");
        listaDoble.insertarInicio(10);
        listaDoble.insertarInicio(20);
        listaDoble.insertarInicio(30);
        listaDoble.imprimir();

        System.out.println("\n--- insertarFinal(valor) --- O(1)");
        listaDoble.insertarFinal(40);
        listaDoble.insertarFinal(50);
        listaDoble.imprimir();

        System.out.println("\n--- insertarEnPosicion(pos, valor) --- O(n)");
        System.out.println("Insertando 99 en la posición 2...");
        listaDoble.insertarEnPosicion(2, 99);
        listaDoble.imprimir();

        System.out.println("\n--- buscar(valor) --- O(n)");
        System.out.println("¿Existe el valor 99?: " + listaDoble.buscar(99));

        System.out.println("\n--- getPosicion(valor) --- O(n)");
        System.out.println("Posición del valor 50: " + listaDoble.getPosicion(50));

        System.out.println("\n--- removerPorPosicion(pos) --- O(n)");
        System.out.println("Removiendo elemento en posición 2...");
        listaDoble.removerPorPosicion(2);
        listaDoble.imprimir();

        System.out.println("\n--- getCantidadNodos() --- O(1)");
        System.out.println("Cantidad actual de nodos: " + listaDoble.getCantidadNodos());

        System.out.println("\n--- eliminar() --- O(1)");
        System.out.println("Eliminando todos los nodos...");
        listaDoble.eliminar();
        listaDoble.imprimir();

        // ============================================================
        // 3. LISTA CIRCULAR DOBLEMENTE ENLAZADA
        // ============================================================
        System.out.println("\n\n🔷 PRUEBAS: LISTA CIRCULAR DOBLEMENTE ENLAZADA");
        ListaCircularDoblementeEnlazada listaCircular = new ListaCircularDoblementeEnlazada();

        System.out.println("\n--- insertarInicio(valor) --- O(1)");
        listaCircular.insertarInicio(5);
        listaCircular.insertarInicio(15);
        listaCircular.insertarInicio(25);
        listaCircular.imprimir();

        System.out.println("\n--- insertarFinal(valor) --- O(1)");
        listaCircular.insertarFinal(35);
        listaCircular.insertarFinal(45);
        listaCircular.imprimir();

        System.out.println("\n--- insertarEnPosicion(pos, valor) --- O(n)");
        System.out.println("Insertando 99 en la posición 3...");
        listaCircular.insertarEnPosicion(3, 99);
        listaCircular.imprimir();

        System.out.println("\n--- buscar(valor) --- O(n)");
        System.out.println("¿Existe el valor 99?: " + listaCircular.buscar(99));

        System.out.println("\n--- getPosicion(valor) --- O(n)");
        System.out.println("Posición del valor 35: " + listaCircular.getPosicion(35));

        System.out.println("\n--- removerPorPosicion(pos) --- O(n)");
        System.out.println("Removiendo elemento en posición 3...");
        listaCircular.removerPorPosicion(3);
        listaCircular.imprimir();

        System.out.println("\n--- getCantidadNodos() --- O(n) (en listas circulares puede requerir recorrer una vuelta)");
        System.out.println("Cantidad actual de nodos: " + listaCircular.getCantidadNodos());

        System.out.println("\n--- eliminar() --- O(1)");
        listaCircular.eliminar();
        listaCircular.imprimir();

        // ============================================================
        // 4. PILA BASADA EN NODOS
        // ============================================================
        System.out.println("\n\n🔷 PRUEBAS: PILA BASADA EN NODOS");
        PilaBasadaNodos pila = new PilaBasadaNodos();

        System.out.println("\n--- push(valor) --- O(1)");
        System.out.println("Apilando elementos 10, 20, 30...");
        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.imprimir();

        System.out.println("\n--- top() --- O(1)");
        System.out.println("Elemento en el tope: " + pila.top());

        System.out.println("\n--- pop() --- O(1)");
        System.out.println("Desapilando elemento...");
        pila.pop();
        pila.imprimir();

        System.out.println("\n--- estaVacia() --- O(1)");
        System.out.println("¿Está vacía?: " + pila.estaVacia());

        // ============================================================
        // 5. COLA BASADA EN NODOS
        // ============================================================
        System.out.println("\n\n🔷 PRUEBAS: COLA BASADA EN NODOS");
        ColaBasadaNodos cola = new ColaBasadaNodos();

        System.out.println("\n--- enqueue(valor) --- O(1)");
        System.out.println("Encolando elementos 1, 2, 3...");
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.imprimir();

        System.out.println("\n--- front() --- O(1)");
        System.out.println("Elemento frente: " + cola.front());

        System.out.println("\n--- dequeue() --- O(1)");
        System.out.println("Desencolando elemento...");
        cola.dequeue();
        cola.imprimir();

        System.out.println("\n--- size() --- O(1)");
        System.out.println("Tamaño actual de la cola: " + cola.size());

        System.out.println("\n--- estaVacia() --- O(1)");
        System.out.println("¿Está vacía?: " + cola.estaVacia());

        System.out.println("\n============================================================");
        System.out.println("        ✅ FIN DE TODAS LAS PRUEBAS DE ESTRUCTURAS");
        System.out.println("============================================================");
    }
}
