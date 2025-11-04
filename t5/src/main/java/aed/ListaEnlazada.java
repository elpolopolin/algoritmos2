package aed;

public class ListaEnlazada<T> { //lista doblemente enlazada
    private Nodo primero;
    private Nodo ultimo;
    private int longitud;

    private class Nodo {
        Nodo anterior, siguiente;
        T valor;
        public Nodo(T valor){ //constructor de la sub clase
            this.valor = valor;
        }
    }

    public ListaEnlazada() { //constructor inicial clase
        this.primero = null;
        this.ultimo = null;
        this.longitud = 0;
    }
    public ListaEnlazada(ListaEnlazada<T> lista) { //constructor por copia
       for (int n=0;n<lista.longitud();n++){
            this.agregarAtras(lista.obtener(n));
       }
    }
    
  
    public int longitud() {
        return this.longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (longitud() == 0){
            this.primero = this.ultimo = nuevo;
        } else{
            this.primero.anterior = nuevo; //el primero actual ahora sera el segundo de modo que su anterior es el nuevo (nuevo primero)
            nuevo.siguiente = this.primero; // el siguiente del nuevo (el nuevo primero) es el q pasamos ahora a segundo
            this.primero = nuevo; //listo
        }
        this.longitud = this.longitud +1;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (longitud() == 0){
            this.primero = this.ultimo = nuevo;
        } else{ 
            this.ultimo.siguiente = nuevo;
            nuevo.anterior = this.ultimo;
            this.ultimo = nuevo;
        }
        this.longitud = this.longitud +1;
    }

    public T obtener(int i) {
        Nodo actual = this.primero;
        for (int n = 0; n<i;n++) {
            actual = actual.siguiente; // n veces
        }
        return actual.valor;
    }

    public void eliminar(int i) {
            //Chequeo de rango
            if (i < 0 || i >= this.longitud) {
                return;
            }
            //Lista de un solo elemento
            if (this.longitud == 1) {
                this.primero = null;
                this.ultimo = null;
                this.longitud = 0;
                return;
            }
            // Eliminar primero
            if (i == 0) {
                Nodo aEliminar = this.primero;
                Nodo sig = aEliminar.siguiente;      
                this.primero = sig;
                sig.anterior = null;                
                this.longitud--;
                return;
            }
            if (i == this.longitud - 1) {
                Nodo aEliminar = this.ultimo;
                Nodo ant = aEliminar.anterior;     
                this.ultimo = ant;
                ant.siguiente = null;
                this.longitud--;
                return;
            }
            // Eliminar en el medio
            Nodo aEliminar = this.primero;
            for (int n = 0; n < i; n++) {
                aEliminar = aEliminar.siguiente;
            }
            aEliminar.anterior.siguiente = aEliminar.siguiente;
            aEliminar.siguiente.anterior = aEliminar.anterior;

            this.longitud--;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo Areemplazar = this.primero;
        for (int n = 0; n<indice;n++) {
            Areemplazar = Areemplazar.siguiente;
        }
        Areemplazar.valor = elem;
    }

 
    @Override
    public String toString() {
       String lista = "[";
        for (int n = 0; n < this.longitud - 1; n++){
            lista = lista + this.obtener(n) + ", ";
        };
        return lista + this.ultimo.valor + "]";
    }

    public class ListaIterador {
    	// Completar atributos privados
        private int indice;
        private ListaEnlazada<T> nuevo;
        public ListaIterador(ListaEnlazada<T> lista){
            indice = 0;
            nuevo = lista;
        }

        public boolean haySiguiente() {
            Nodo nodo = this.nuevo.primero; //osea... en los test q hacen ustedes no contemplan q un nodo este mal definido y no tenga siguiente o anterior, etc
            if (nodo != null){ 
                for (int i =0; i<indice-1;i++){
                    nodo = nodo.siguiente;
                }
                return (nodo.siguiente != null);
            } else{
                return false;
            }
        }
        
        public boolean hayAnterior() {
	        Nodo nodo = this.nuevo.primero; //imaginate q dijiera: indice != 0, en un caso de nodo correctamente definido no deberia tener un anterior.. pero en un caso choto? 
            if (nodo != null){
            if (this.nuevo.longitud() == indice){ //el unico outOfRange permitido
                return (this.nuevo.ultimo != null);
            }
            for (int i =0; i<indice ;i++){
                nodo = nodo.siguiente;
            }
            return (nodo.anterior != null);} else{
                return false;
            }
        }

        public T siguiente() {
	        indice ++;
            return nuevo.obtener(indice -1);
        }
        

        public T anterior() {
	        indice --;
            return nuevo.obtener(indice);
        }
    }

    public ListaIterador iterador() {
	    return new ListaIterador(this);
    }

}
