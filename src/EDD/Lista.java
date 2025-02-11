/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
/**
 *
 * @author pedro
 */
import java.util.Iterator;

public class Lista<T> implements Iterable<T> {
    private Nodo<T> pFirst;
    private String name;
    private int id;

    public Lista(String name, int id) {
        this.name = name;
        this.id = id;
        this.pFirst = null;
    }

    // Método para agregar un elemento al final de la lista
    public void agregar(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        if (pFirst == null) {
            pFirst = nuevo;
        } else {
            Nodo<T> actual = pFirst;
            while (actual.getpNext() != null) {
                actual = actual.getpNext();
            }
            actual.setpNext(nuevo);
        }
    }

    // Método para eliminar el primer elemento de la lista
    public T eliminar() {
        if (pFirst == null) {
            return null; // Lista vacía
        }
        T info = pFirst.gettInfo();
        pFirst = pFirst.getpNext();
        return info;
    }

    // Método para recorrer la lista y retornar una representación en String
    public String recorrer() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = pFirst;
        while (actual != null) {
            sb.append(actual.gettInfo()).append(" --> ");
            actual = actual.getpNext();
        }
        return sb.toString();
    }

    // Método para verificar si la lista está vacía
    public boolean isEmpty() {
        return pFirst == null;
    }

    // Método para obtener el tamaño de la lista
    public int getSize() {
        int size = 0;
        Nodo<T> actual = pFirst;
        while (actual != null) {
            size++;
            actual = actual.getpNext();
        }
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> current = pFirst;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.gettInfo();
                current = current.getpNext();
                return data;
            }
        };
    }
}
