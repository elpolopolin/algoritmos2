package aed;

public class SistemaPedidos {
    private ABB<Pedido> pedidosPorId;    
    private ListaEnlazada<ABB<Pedido>.HandleABB> colallegada; 

    public SistemaPedidos(){
        this.pedidosPorId = new ABB<>();
        this.colallegada = new ListaEnlazada<>();
    }

    public void agregarPedido(Pedido pedido){
        throw new UnsupportedOperationException("No implementado aún");
    }

    public Pedido proximoPedido(){
        throw new UnsupportedOperationException("No implementado aún");
    }

    public Pedido pedidoMenorId(){
        throw new UnsupportedOperationException("No implementado aún");
    }

    public String obtenerPedidosEnOrdenDeLlegada(){
        String texto = "[";
       for (int i = 0; i < colallegada.longitud(); i++) {
            Pedido p = colallegada.obtener(i).valor();
            texto = texto + p.toString();
        }
        return texto + "]";
    }

    public String obtenerPedidosOrdenadosPorId(){
        throw new UnsupportedOperationException("No implementado aún");
    }
}