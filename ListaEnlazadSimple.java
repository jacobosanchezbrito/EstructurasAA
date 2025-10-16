// ==============================================
// Clase: ListaEnlazadaSimple
// Descripción: Implementa una lista enlazada simple
// Autor: Jacobo
// ==============================================

public class ListaEnlazadaSimple {

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

    // Atributo principal de la lista
    private Nodo cabeza;
    private int cantidad; // Para llevar conteo rápido de nodos

    // ==============================================
    // Constructor
    // ==============================================
    // O(1)
    public ListaEnlazadaSimple() {
        this.cabeza = null;
        this.cantidad = 0;
    }

    // ==============================================
    // Elimina todos los elementos de la lista
    // ==============================================
    // O(1)
    public void eliminarLista() {
        cabeza = null;
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
    // O(n)
    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        cantidad++;
    }

    // ==============================================
    // Inserta al inicio
    // ==============================================
    // O(1)
    public void insertarInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        cantidad++;
    }

    // ==============================================
    // Inserta en posición específica (0-indexada)
    // ==============================================
    // O(n)
    public void insertarEnPosicion(int posicion, int valor) {
        if (posicion < 0 || posicion > cantidad) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        if (posicion == 0) {
            insertarInicio(valor);
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
    // Obtiene el valor en una posición dada
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
    // Busca un valor en la lista
    // ==============================================
    // O(n)
    public boolean buscar(Object referencia) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.valor == (int) referencia) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // ==============================================
    // Retorna la posición de un valor dado
    // ==============================================
    // O(n)
    public int getPosicion(Object referencia) {
        Nodo actual = cabeza;
        int index = 0;
        while (actual != null) {
            if (actual.valor == (int) referencia) {
                return index;
            }
            actual = actual.siguiente;
            index++;
        }
        return -1; // No encontrado
    }

    // ==============================================
    // Elimina un nodo por posición
    // ==============================================
    // O(n)
    public void removerPorPosicion(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        if (posicion == 0) {
            cabeza = cabeza.siguiente;
        } else {
            Nodo actual = cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }
            actual.siguiente = actual.siguiente.siguiente;
        }
        cantidad--;
    }

    // ==============================================
    // Imprime todos los elementos
    // ==============================================
    // O(n)
    public void imprimir() {
        Nodo actual = cabeza;
        System.out.print("[ ");
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println("]");
    }

    // ==============================================
    // Busca un valor recursivamente
    // ==============================================
    // O(n)
    public boolean buscarRecursivo(Object referencia) {
        return buscarRecursivoAux(cabeza, referencia);
    }

    private boolean buscarRecursivoAux(Nodo nodo, Object referencia) {
        if (nodo == null) return false;
        if (nodo.valor == (int) referencia) return true;
        return buscarRecursivoAux(nodo.siguiente, referencia);
    }

    // ==============================================
    // Inserta al final recursivamente
    // ==============================================
    // O(n)
    public void insertarFinalRecusivo(int valor) {
        cabeza = insertarFinalRecursivoAux(cabeza, valor);
        cantidad++;
    }

    private Nodo insertarFinalRecursivoAux(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        } else {
            nodo.siguiente = insertarFinalRecursivoAux(nodo.siguiente, valor);
            return nodo;
        }
    }

    // ==============================================
    // Remueve por posición recursivamente
    // ==============================================
    // O(n)
    public void removerEnPosicionRecursivo(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        cabeza = removerRecursivoAux(cabeza, posicion);
        cantidad--;
    }

    private Nodo removerRecursivoAux(Nodo nodo, int posicion) {
        if (posicion == 0) {
            return nodo.siguiente;
        }
        nodo.siguiente = removerRecursivoAux(nodo.siguiente, posicion - 1);
        return nodo;
    }

    // ==============================================
    // Inserta en posición específica recursivamente
    // ==============================================
    // O(n)
    public void insertarEnPosicionRecursivo(int posicion, int valor) {
        if (posicion < 0 || posicion > cantidad) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        cabeza = insertarPosRecursivoAux(cabeza, posicion, valor);
        cantidad++;
    }

    private Nodo insertarPosRecursivoAux(Nodo nodo, int posicion, int valor) {
        if (posicion == 0) {
            Nodo nuevo = new Nodo(valor);
            nuevo.siguiente = nodo;
            return nuevo;
        }
        nodo.siguiente = insertarPosRecursivoAux(nodo.siguiente, posicion - 1, valor);
        return nodo;
    }
}
