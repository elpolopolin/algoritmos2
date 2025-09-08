package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    //constructor
    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha); //uso constructor por copia para no  referenciar la fecha  q recibo..
        //System.out.println(this.fecha);
        this.horario = horario;
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() { //método
        return new Fecha(fecha.dia(),fecha.mes()); //no aliasing, devuelve una copia q no referencia al objeto fecha de  la clase
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        return this.mensaje + " @ " + this.fecha + " " + this.horario;
    }

    @Override
    public boolean equals(Object otro) {
        if (otro == null){return false;}
        if (otro.getClass() != this.getClass()){
            return false;
        }
        Recordatorio otroRecordatorio = (Recordatorio) otro;  //casteo

        return (otroRecordatorio.mensaje == this.mensaje && 
            otroRecordatorio.horario.equals(this.horario) && 
            otroRecordatorio.fecha.equals(this.fecha));
    }

}
