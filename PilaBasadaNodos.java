// ============================================================
// Clase: PilaBasadaNodos
// Descripción: Implementa una pila (LIFO) utilizando nodos enlazados.
// Autor: Jacobo
// ============================================================

public class PilaBasadaNodos {

    // ============================================================
    // Clase interna Nodo
    // ============================================================
    private static class Nodo {
        Object valor;
        Nodo siguiente;

        public Nodo(Object valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    // ============================================================
    // Atributos principales
    // ============================================================
    private Nodo tope;
    private int cantidad;

    // ============================================================
    // Constructor
    // ============================================================
    // O(1)
    public PilaBasadaNodos() {
        tope = null;
        cantidad = 0;
    }

    // ============================================================
    // Verificar si la pila está vacía
    // ============================================================
    // O(1)
    public boolean estaVacia() {
        return tope == null;
    }

    // ============================================================
    // Push: Agregar un elemento a la pila
    // ============================================================
    // O(1)
    public void push(Object valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = tope;  // el nuevo nodo apunta al anterior tope
        tope = nuevo;            // ahora el nuevo nodo es el tope
        cantidad++;
    }

    // ============================================================
    // Top: Retorna el elemento en el tope sin eliminarlo
    // ============================================================
    // O(1)
    public Object top() {
        if (estaVacia()) {
            throw new RuntimeException("La pila está vacía.");
        }
        return tope.valor;
    }

    // ============================================================
    // Pop: Elimina y retorna el elemento del tope
    // ============================================================
    // O(1)
    public Object pop() {
        if (estaVacia()) {
            throw new RuntimeException("La pila está vacía.");
        }
        Object valor = tope.valor;
        tope = tope.siguiente;  // el siguiente nodo pasa a ser el tope
        cantidad--;
        return valor;
    }

    // ============================================================
    // Método auxiliar: imprime el contenido de la pila
    // ============================================================
    // O(n)
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("[ Pila vacía ]");
            return;
        }

        System.out.print("Tope -> ");
        Nodo actual = tope;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println("<- Base");
    }

    // ============================================================
    // Obtener cantidad de elementos (opcional)
    // ============================================================
    // O(1)
    public int getCantidad() {
        return cantidad;
    }
}
