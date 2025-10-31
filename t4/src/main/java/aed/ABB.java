package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> {
    public Nodo raiz;
    public int tamaño;

    private class Nodo {
        public Nodo padre;
        public Nodo izq;
        public Nodo der;
        public T valor;

         public Nodo (T data) {
            this.valor = data;
            this.izq = null;
            this.der = null;
            this.padre = null;
        }
       
    }

    public ABB() {
        this.raiz = null;
        this.tamaño = 0;
    }

    public int cardinal() {
        return this.tamaño;
    }

    public T minimo(){
        if (this.raiz == null){
            return null;
        }
        return MinRecur(this.raiz);
    }
    public T MinRecur(Nodo nodoactual){
        if(nodoactual.izq != null){
            return MinRecur(nodoactual.izq);
        }else{
            return nodoactual.valor;
        }
    }
     public T maxRecur(Nodo nodoactual){
        if(nodoactual.der != null){
            return maxRecur(nodoactual.der);
        }else{
            return nodoactual.valor;
        }
    }

    public T maximo(){
         if (this.raiz == null){
            return null;
        }
        return maxRecur(this.raiz);
    }

    public void insertar(T elem){
        Nodo actual = null;
        if (this.raiz != null){
            actual = this.raiz;
        }else{
            actual = new Nodo(elem);
            this.raiz = actual;
            tamaño += 1;
        }
        boolean ponido = false;
        while (!ponido) {
            if(actual.valor.compareTo(elem) > 0){
                    if(actual.izq != null){
                        actual = actual.izq;
                    }else{
                        actual.izq = new Nodo(elem);
                        actual.izq.padre=actual;
                        tamaño +=1;
                        ponido = true;
                    }
                } 
            if (actual.valor.compareTo(elem) < 0){
                    if(actual.der != null){
                        actual = actual.der;
                    }else{
                        actual.der = new Nodo(elem);
                        actual.der.padre = actual;
                        tamaño +=1;
                        ponido = true;
                    }
                }
            if(actual.valor.compareTo(elem) == 0){
                ponido = true;
            }
            }
    }

    public boolean pertenece(T elem){
        Nodo nodoactual = this.raiz;
        while (nodoactual != null) {
            if(elem.compareTo(nodoactual.valor) == 0){
                return true;
            } else{
                 if(elem.compareTo(nodoactual.valor) < 0){
                    nodoactual = nodoactual.izq;
                 }
                else if (elem.compareTo(nodoactual.valor) > 0){
                    nodoactual = nodoactual.der;
                }
                
            }
        }
        return false;
    }

    public Nodo nodoElemento(T elem){
        Nodo actual = this.raiz; 
        if (this.raiz == null){
            return null;
        } else {
            while (actual != null) {
                if (actual.valor.compareTo(elem) == 0) {
                    return actual;
                } else if (actual.valor.compareTo(elem) > 0) {
                        actual = actual.izq;
                } else if (actual.valor.compareTo(elem) < 0) {
                        actual = actual.der;
                }
            }
            return null;
        }
    }


    private void transplantar(Nodo u, Nodo v) {
        if (u.padre == null) {
            this.raiz = v;
        } else if (u == u.padre.izq) {
            u.padre.izq = v;
        } else {
            u.padre.der = v;
        }
        if (v != null) v.padre = u.padre;
    }

    public void eliminar(T elem){
        Nodo nodoAeliminar = nodoElemento(elem);
        if (nodoAeliminar == null) return;
        
        if (nodoAeliminar.izq == null) {
            transplantar(nodoAeliminar, nodoAeliminar.der);
        } else if (nodoAeliminar.der == null) { 
            transplantar(nodoAeliminar, nodoAeliminar.izq);
        }

        if(nodoAeliminar.izq == null && nodoAeliminar.der == null){ //caso hoja.
            if (nodoAeliminar.padre.valor.compareTo(nodoAeliminar.valor) > 0){
                nodoAeliminar.padre.izq = null;
            } else {
                nodoAeliminar.padre.der = null;
            }
            this.tamaño --;
        }

        
        
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public class ABB_Iterador {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public ABB_Iterador iterador() {
        return new ABB_Iterador();
    }

}
