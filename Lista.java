/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RadixSortListas;

/**
 *
 * @author DELL
 */
public class Lista {

    Nodo inicio = null;

    public void insertar(int dato) {
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        nuevo.sig = null;

        if (inicio != null) {
            nuevo.sig = inicio;
        }
        inicio = nuevo;

    }

    public void insertarFinal(int dato) {
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        nuevo.sig = null;
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            while (aux.sig != null) {
                aux = aux.sig;
            }
            aux.sig = nuevo;
        }
    }

    public void recorrer() {
       
        Nodo aux = inicio;

        while (aux != null) {
            System.out.print(aux.dato + " ");
            aux = aux.sig;
        }
        System.out.println();
    }

    public void radixSort() {
        Lista array[] = new Lista[10];
        for (int i = 0; i < 10; i++) {
            array[i] = new Lista();
        }
        Nodo aux;
        int repeticiones = maximoDigito();
        int veces = 1;
        while (veces <= repeticiones) {
            while ((aux = eliminarInicio()) != null) {
                int numero = numeroArreglo(aux.dato, veces); //Nos da el numero de el array que usara
                array[numero].insertarFinal(aux.dato);

            }
            for (Lista array1 : array) {
                unirLista(array1);
            }
            veces++;
        }
    }

    void unirLista(Lista uni) { //Une las listas
        if (inicio != null) {
            Nodo aux = inicio;
            Nodo ant = null;
            while (aux != null) {
                ant = aux;
                aux = aux.sig;
            }
            if (ant != null) {
                ant.sig = uni.inicio;
            }
        } else {
            inicio = uni.inicio;
        }
        uni.inicio = null; //borreamos la lista
    }

    int numeroArreglo(int dato, int posicion) {//regrese un solo digito en la posicion indicada
        int regreso = 0;
        for (int i = 0; i < posicion; i++) {
            regreso = dato % 10;
            dato = dato / 10;
        }
        return regreso;
    }

    Nodo eliminarInicio() { //elimina el principio
        Nodo aux = inicio;
        if (aux != null) {
            inicio = inicio.sig;
            aux.sig = null;
        }
        return aux;
    }

    int maximoDigito() {
        Nodo aux = inicio;
        int max = 0;
        while (aux != null) {
            int temp = aux.dato;
            if (temp > max) {
                max = temp;
            }
            aux = aux.sig;
        }
        return String.valueOf(max).length(); //El largo del numero maximo
    }

}
