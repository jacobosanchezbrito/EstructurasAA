// ==============================================
// Clase: ListaSencillaCircular
// Descripción: Implementa una lista enlazada simple circular.
// Autor: Jacobo
// ==============================================

public class ListaSencillaCircular {

    // ==============================================
    // Clase interna Nodo
    // ==============================================
    private static class Nodo {
        int valor;
        Nodo siguiente;

        public Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    // Atributos principales
    private Nodo cabeza;
    private Nodo cola;
    private int cantidad;

    // ==============================================
    // Constructor
    // ==============================================
    // O(1)
    public ListaSencillaCircular() {
        cabeza = null;
        cola = null;
        cantidad = 0;
    }

    // ==============================================
    // Elimina todos los elementos
    // ==============================================
    // O(1)
    public void eliminar() {
        cabeza = null;
        cola = null;
        cantidad = 0;
    }

    // ==============================================
    // Determina si la lista está vacía
    // ==============================================
    // O(1)
    public boolean estaVacia() {
        return cabeza == null;
    }

    // ==============================================
    // Retorna la cantidad de nodos
    // ==============================================
    // O(1)
    public int getCantidadNodos() {
        return cantidad;
    }

    // ==============================================
    // Inserta al final
    // ==============================================
    // O(1)
    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            nuevo.siguiente = cabeza;
            cola = nuevo;
        }
        cantidad++;
    }

    // ==============================================
    // Inserta al inicio
    // ==============================================
    // O(1)
    public void insertarInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            cola.siguiente = cabeza; // Mantiene circularidad
        }
        cantidad++;
    }

    // ==============================================
    // Inserta en posición (0-indexada)
    // ==============================================
    // O(n)
    public void insertarEnPosicion(int posicion, int valor) {
        if (posicion < 0 || posicion > cantidad) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        if (posicion == 0) {
            insertarInicio(valor);
        } else if (posicion == cantidad) {
            insertarFinal(valor);
        } else {
            Nodo nuevo = new Nodo(valor);
            Nodo actual = cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
            cantidad++;
        }
    }

    // ==============================================
    // Obtiene valor por posición
    // ==============================================
    // O(n)
    public Object getValor(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        Nodo actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.valor;
    }

    // ==============================================
    // Busca un valor
    // ==============================================
    // O(n)
    public boolean buscar(Object referencia) {
        if (estaVacia()) return false;

        Nodo actual = cabeza;
        do {
            if (actual.valor == (int) referencia) {
                return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);

        return false;
    }

    // ==============================================
    // Obtiene posición de un valor
    // ==============================================
    // O(n)
    public int getPosicion(Object referencia) {
        if (estaVacia()) return -1;

        Nodo actual = cabeza;
        int index = 0;
        do {
            if (actual.valor == (int) referencia) {
                return index;
            }
            actual = actual.siguiente;
            index++;
        } while (actual != cabeza);

        return -1;
    }

    // ==============================================
    // Elimina nodo por posición
    // ==============================================
    // O(n)
    public void removerPorPosicion(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        if (posicion == 0) {
            if (cabeza == cola) { // Un solo elemento
                cabeza = null;
                cola = null;
            } else {
                cabeza = cabeza.siguiente;
                cola.siguiente = cabeza;
            }
        } else {
            Nodo actual = cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }
            actual.siguiente = actual.siguiente.siguiente;
            if (posicion == cantidad - 1) {
                cola = actual;
            }
        }
        cantidad--;
    }

    // ==============================================
    // Imprime todos los elementos
    // ==============================================
    // O(n)
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("[ ]");
            return;
        }

        Nodo actual = cabeza;
        System.out.print("[ ");
        do {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("]");
    }

    // ==============================================
    // Inserta al final recursivamente
    // ==============================================
    // O(n)
    public void insertarFinalRecursivo(int valor) {
        if (estaVacia()) {
            insertarFinal(valor);
            return;
        }
        insertarFinalRecursivoAux(cabeza, valor);
    }

    private void insertarFinalRecursivoAux(Nodo nodo, int valor) {
        if (nodo.siguiente == cabeza) {
            Nodo nuevo = new Nodo(valor);
            nodo.siguiente = nuevo;
            nuevo.siguiente = cabeza;
            cola = nuevo;
            cantidad++;
        } else {
            insertarFinalRecursivoAux(nodo.siguiente, valor);
        }
    }

    // ==============================================
    // Inserta en posición recursiva
    // ==============================================
    // O(n)
    public void insertarEnPosicionRecursivo(int posicion, int valor) {
        if (posicion < 0 || posicion > cantidad) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        if (posicion == 0) {
            insertarInicio(valor);
        } else if (posicion == cantidad) {
            insertarFinal(valor);
        } else {
            cabeza = insertarEnPosRecursivoAux(cabeza, posicion, valor);
            cantidad++;
        }
    }

    private Nodo insertarEnPosRecursivoAux(Nodo nodo, int posicion, int valor) {
        if (posicion == 1) {
            Nodo nuevo = new Nodo(valor);
            nuevo.siguiente = nodo.siguiente;
            nodo.siguiente = nuevo;
        } else {
            insertarEnPosRecursivoAux(nodo.siguiente, posicion - 1, valor);
        }
        return nodo;
    }

    // ==============================================
    // Búsqueda recursiva
    // ==============================================
    // O(n)
    public boolean buscarRecursivo(Object referencia) {
        if (estaVacia()) return false;
        return buscarRecursivoAux(cabeza, referencia, cabeza);
    }

    private boolean buscarRecursivoAux(Nodo nodo, Object referencia, Nodo inicio) {
        if (nodo == null) return false;
        if (nodo.valor == (int) referencia) return true;
        if (nodo.siguiente == inicio) return false;
        return buscarRecursivoAux(nodo.siguiente, referencia, inicio);
    }
}
