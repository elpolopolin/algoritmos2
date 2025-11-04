package aed;
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> {
    private Nodo raiz;
    private int tamaño;

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

    public class HandleABB implements Handle<T> {
        private ABB<T> dueño;   
        private Nodo nodo;    

        private HandleABB(ABB<T> dueño, Nodo nodo) {
        this.dueño = dueño;
        this.nodo = nodo;
        }

        public T valor() {
        //if (this.nodo == null) throw new IllegalStateException("handle inválido");
        return nodo.valor;
        }

        public void eliminar() {
        if (this.nodo == null) return;         
        dueño.eliminar(this.nodo.valor);         
        this.nodo = null;                      
        }
    }

    public ABB() {
        this.raiz = null;
        this.tamaño = 0;
    }

    //constructor x copia
    public ABB(ABB<T> otro) {
        this.raiz = clonar(otro.raiz, null);
        this.tamaño = otro.tamaño; 
    }

    private Nodo clonar(Nodo o, Nodo padreNuevo) {
        if (o == null) return null;
        Nodo n = new Nodo(o.valor);
        n.padre = padreNuevo;
        n.izq = clonar(o.izq, n);
        n.der = clonar(o.der, n);
        return n;
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
    public Nodo NodoMinRecur(Nodo n){
        if(n.izq == null) return n; 
        else return NodoMinRecur(n.izq);
    }

    public Nodo hallarsiguienteMenor(Nodo n){
        if (n == null) return null;
        if (n.der != null){
            return NodoMinRecur(n.der);
        }
        //CASO 2, NO HAY DERECHO, SUBIR
        Nodo padre= n.padre;
        while (padre != null && padre.der == n){ //mientras el minimo sea hijo derecho subimos
            n =padre;
            padre = padre.padre;
        }
        return padre;
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

    public HandleABB insertar(T elem) {
        Nodo actual = null;
        if (this.raiz != null) {
            actual = this.raiz;
        } else {
            actual = new Nodo(elem);
            this.raiz = actual;
            this.tamaño += 1;
            return new HandleABB(this, this.raiz);
        }
        boolean ponido = false;
        while (!ponido) {
            if (actual.valor.compareTo(elem) > 0) {
                if (actual.izq != null) {
                    actual = actual.izq;
                } else {
                    actual.izq = new Nodo(elem);
                    actual.izq.padre = actual;
                    this.tamaño += 1;
                    return new HandleABB(this, actual.izq);
                }
            }
            if (actual.valor.compareTo(elem) < 0) {
                if (actual.der != null) {
                    actual = actual.der;
                } else {
                    actual.der = new Nodo(elem);
                    actual.der.padre = actual;
                    this.tamaño += 1;
                    return new HandleABB(this, actual.der);
                }
            }
            if (actual.valor.compareTo(elem) == 0) {
                return new HandleABB(this, actual);
            }
        }
        return new HandleABB(this, actual);
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
            this.tamaño --;
            return;
            
        } else if (nodoAeliminar.der == null) { 
            transplantar(nodoAeliminar, nodoAeliminar.izq);
            this.tamaño --;
            return;
        }
        if(nodoAeliminar.izq != null && nodoAeliminar.der != null)
            {
                Nodo actual = nodoAeliminar.izq; //predecesor inmediato
                while (actual.der != null) {
                    actual = actual.der;
                }
                nodoAeliminar.valor = actual.valor;
                transplantar(actual, actual.izq);
                this.tamaño --;
            }
    }


}
