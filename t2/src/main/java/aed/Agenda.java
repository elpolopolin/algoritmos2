package aed;

public class Agenda {
    private Fecha fecha;
    private ArregloRedimensionableDeRecordatorios recordatorios;

    public Agenda(Fecha fechaActual) {
       this.fecha = fechaActual;
       this.recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
            this.recordatorios.agregarAtras(recordatorio);
        
    }

    @Override
    public String toString() {
         String mensaje = this.fecha.toString() + "\n" + "=====" + "\n";
        for (int i =0; i< recordatorios.longitud();i++){
            if (recordatorios.obtener(i).fecha().equals(fechaActual())){
                mensaje += recordatorios.obtener(i).toString();
                mensaje += "\n";
            }
        }
        return mensaje;
    }

    public void incrementarDia() {
        this.fecha.incrementarDia();
       
    }

    public Fecha fechaActual() {
        Fecha fechaActual = new Fecha(this.fecha); // no aliasing
        return fechaActual;
    }

}
