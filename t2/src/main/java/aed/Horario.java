package aed;

public class Horario {
    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        return this.hora;
    }

    public int minutos() {
        return this.minutos;
    }

    @Override
    public String toString() {
        
        return hora + ":" + minutos; // al concatenar con el + y un strring, los ints se conviertene en string
    }

    @Override
    public boolean equals(Object otro) {
        if (otro == null || otro.getClass() != this.getClass()){return false;}
        Horario otroHorario = (Horario) otro;
        return this.hora == otroHorario.hora & this.minutos == otroHorario.minutos;
    }

}
