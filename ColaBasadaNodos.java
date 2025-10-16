// ============================================================
// Clase: ColaBasadaNodos
// Descripción: Implementa una cola (FIFO) utilizando nodos enlazados.
// Autor: Jacobo
// ============================================================

public class ColaBasadaNodos {

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
    private Nodo frente;   // primer elemento (el que se atiende)
    private Nodo fin;      // último elemento (donde se encola)
    private int cantidad;

    // ============================================================
    // Constructor
    // ============================================================
    // O(1)
    public ColaBasadaNodos() {
        frente = null;
        fin = null;
        cantidad = 0;
    }

    // ============================================================
    // Verifica si la cola está vacía
    // ============================================================
    // O(1)
    public boolean estaVacia() {
        return frente == null;
    }

    // ============================================================
    // Enqueue: agregar un elemento al final
    // ============================================================
    // O(1)
    public void enqueue(Object nuevo) {
        Nodo nodo = new Nodo(nuevo);
        if (estaVacia()) {
            frente = nodo;
            fin = nodo;
        } else {
            fin.siguiente = nodo;
            fin = nodo;
        }
        cantidad++;
    }

    // ============================================================
    // Front: retorna el elemento del frente sin eliminarlo
    // ============================================================
    // O(1)
    public Object front() {
        if (estaVacia()) {
            throw new RuntimeException("La cola está vacía.");
        }
        return frente.valor;
    }

    // ============================================================
    // Dequeue: elimina y retorna el elemento del frente
    // ============================================================
    // O(1)
    public Object dequeue() {
        if (estaVacia()) {
            throw new RuntimeException("La cola está vacía.");
        }
        Object valor = frente.valor;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null; // si se vacía, el fin también se elimina
        }
        cantidad--;
        return valor;
    }

    // ============================================================
    // Size: retorna cantidad de elementos
    // ============================================================
    // O(1)
    public int size() {
        return cantidad;
    }

    // ============================================================
    // Método auxiliar: imprimir la cola
    // ============================================================
    // O(n)
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("[ Cola vacía ]");
            return;
        }

        System.out.print("Frente -> ");
        Nodo actual = frente;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println("<- Final");
    }
}
