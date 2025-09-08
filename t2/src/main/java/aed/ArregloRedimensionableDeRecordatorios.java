package aed;

class ArregloRedimensionableDeRecordatorios {

    private Recordatorio[] recordatorios; //arreglo

    public ArregloRedimensionableDeRecordatorios() {
        this.recordatorios = new Recordatorio[0];
    }

    public int longitud() {
        int cont = 0;
        for (Recordatorio elem : this.recordatorios){ //for each de tipo Recordatorios
            cont++;
        }
        return cont;
    }

    public void agregarAtras(Recordatorio i) {
      
        Recordatorio[] nuevo = new Recordatorio[this.longitud() + 1];
        System.out.println(this.longitud());
        for (int h = 0; h < this.longitud(); h++) {
            nuevo[h] = recordatorios[h];
        }
        nuevo[this.longitud()] = i;
        this.recordatorios = nuevo;
    
    }

    public Recordatorio obtener(int i) {
        
        return this.recordatorios[i];
    }

    public void quitarAtras() {
        if (this.longitud() >0){
            Recordatorio[] nuevo = new Recordatorio[this.longitud() -1];
            for (int i = 0; i<this.longitud() -1; i++){
                nuevo[i] = recordatorios[i];
            }
            this.recordatorios = nuevo;
        }

    }

    public void modificarPosicion(int indice, Recordatorio valor) {
       
        this.recordatorios[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        Recordatorio[] nuevo = new Recordatorio[vector.longitud()];
        int i = 0;
        for (Recordatorio elem : vector.recordatorios) {
            nuevo[i] = new Recordatorio(elem.mensaje(),elem.fecha(),elem.horario());
            i++;
        }
        this.recordatorios = nuevo;
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        
        ArregloRedimensionableDeRecordatorios copia = new ArregloRedimensionableDeRecordatorios();
        for (Recordatorio elem : this.recordatorios){
            copia.agregarAtras(new Recordatorio(elem.mensaje(),elem.fecha(),elem.horario()));
        }
        return copia;
        
       /* return new ArregloRedimensionableDeRecordatorios(this); */
    }
}
