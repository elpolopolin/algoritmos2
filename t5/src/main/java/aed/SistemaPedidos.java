package aed;

public class SistemaPedidos {
    private ABB<Pedido> pedidosPorId;    
    private ListaEnlazada<ABB<Pedido>.HandleABB> colallegada; 

    public SistemaPedidos(){
        this.pedidosPorId = new ABB<>();
        this.colallegada = new ListaEnlazada<>();
    }

    public void agregarPedido(Pedido pedido){
          ABB<Pedido>.HandleABB handle = pedidosPorId.insertar(pedido);
          colallegada.agregarAtras(handle);
    }

    public Pedido proximoPedido(){
         if (colallegada.longitud() == 0){
            return null;
         } else{
            ABB<Pedido>.HandleABB handle = colallegada.obtener(0);
            Pedido p = handle.valor();
            handle.eliminar();           
            colallegada.eliminar(0);          
            return p;
         }
        
    }

    public Pedido pedidoMenorId(){
         if (pedidosPorId.cardinal() == 0) return null;
        return pedidosPorId.minimo();
    }

    public String obtenerPedidosEnOrdenDeLlegada(){
        String texto = "[";
       for (int i = 0; i < colallegada.longitud(); i++) {
            Pedido p = colallegada.obtener(i).valor();
            texto = texto + p.toString();
            if (i +1 < colallegada.longitud()){
                texto = texto + ", ";
            }
        }
        return texto + "]";
    }

    public String obtenerPedidosOrdenadosPorId(){
        String texto = "{";
        ABB<Pedido>.ABB_Iterador it = pedidosPorId.new ABB_Iterador();
        while (it.haySiguiente()) {
            Pedido p = it.siguiente();
            texto = texto + p.toString();
            if (it.haySiguiente()){
                texto = texto += ", ";
            }
        }
        return texto + "}";
    }

    
}