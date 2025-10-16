// ==============================================
// Clase: ListaDoblementeEnlazada
// Descripción: Implementa una lista doblemente enlazada.
// Autor: Jacobo
// ==============================================

public class ListaDoblementeEnlazada {

    // ==============================================
    // Clase interna Nodo
    // ==============================================
    private static class Nodo {
        int valor;
        Nodo anterior;
        Nodo siguiente;

        public Nodo(int valor) {
            this.valor = valor;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    // ==============================================
    // Atributos principales
    // ==============================================
    private Nodo cabeza;
    private Nodo cola;
    private int cantidad;

    // ==============================================
    // Constructor
    // ==============================================
    // O(1)
    public ListaDoblementeEnlazada() {
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
    // Determina si está vacía
    // ==============================================
    // O(1)
    public boolean estaVacia() {
        return cabeza == null;
    }

    // ==============================================
    // Retorna cantidad de nodos
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
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
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
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
        cantidad++;
    }

    // ==============================================
    // Inserta en una posición específica
    // ==============================================
    // O(n)
    public void insertarEnPosicion(int posicion, int valor) {
        if (posicion < 0 || posicion > cantidad) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        if (posicion == 0) {
            insertarInicio(valor);
            return;
        }

        if (posicion == cantidad) {
            insertarFinal(valor);
            return;
        }

        Nodo actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }

        Nodo nuevo = new Nodo(valor);
        nuevo.anterior = actual.anterior;
        nuevo.siguiente = actual;
        actual.anterior.siguiente = nuevo;
        actual.anterior = nuevo;

        cantidad++;
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
    // Obtiene posición de un valor
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
            if (cabeza == cola) {
                cabeza = null;
                cola = null;
            } else {
                cabeza = cabeza.siguiente;
                cabeza.anterior = null;
            }
        } else if (posicion == cantidad - 1) {
            cola = cola.anterior;
            cola.siguiente = null;
        } else {
            Nodo actual = cabeza;
            for (int i = 0; i < posicion; i++) {
                actual = actual.siguiente;
            }
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
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
    // Inserta al final recursivamente
    // ==============================================
    // O(n)
    public void insertarFinalRecursivo(int valor) {
        if (estaVacia()) {
            insertarFinal(valor);
        } else {
            insertarFinalRecursivoAux(cabeza, valor);
        }
    }

    private void insertarFinalRecursivoAux(Nodo nodo, int valor) {
        if (nodo.siguiente == null) {
            Nodo nuevo = new Nodo(valor);
            nodo.siguiente = nuevo;
            nuevo.anterior = nodo;
            cola = nuevo;
            cantidad++;
        } else {
            insertarFinalRecursivoAux(nodo.siguiente, valor);
        }
    }

    // ==============================================
    // Inserta al inicio recursivamente
    // ==============================================
    // O(1)
    public void insertarInicioRecursivo(int valor) {
        insertarInicio(valor); // misma eficiencia, pero conserva interfaz
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
            return;
        }

        if (posicion == cantidad) {
            insertarFinal(valor);
            return;
        }

        cabeza = insertarEnPosRecursivoAux(cabeza, posicion, valor);
        cantidad++;
    }

    private Nodo insertarEnPosRecursivoAux(Nodo nodo, int posicion, int valor) {
        if (posicion == 1) {
            Nodo nuevo = new Nodo(valor);
            nuevo.siguiente = nodo.siguiente;
            nuevo.anterior = nodo;
            if (nodo.siguiente != null) {
                nodo.siguiente.anterior = nuevo;
            }
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
        return buscarRecursivoAux(cabeza, referencia);
    }

    private boolean buscarRecursivoAux(Nodo nodo, Object referencia) {
        if (nodo == null) return false;
        if (nodo.valor == (int) referencia) return true;
        return buscarRecursivoAux(nodo.siguiente, referencia);
    }
}
