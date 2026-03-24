package org.example.service;

import org.example.model.Pedido;
import org.example.model.StatusPedido;
import org.example.repository.PedidoRepository;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://service.example.org/")
public class PedidoService {
    private static final PedidoRepository repository = new PedidoRepository();

    @WebMethod
    public List<Pedido> listarPedidos() {
        return repository.listar();
    }

    @WebMethod
    public Pedido criarPedido(String nomeCliente, List<String> itensPedido) {
        return repository.criar(nomeCliente, itensPedido);
    }

    @WebMethod
    public Pedido buscarPedidoPorId(int id) {
       return repository.buscar(id);
    }

    @WebMethod
    public Pedido atualizarStatusPedido(int id, String novoStatus) {
        try {
            StatusPedido statusPedido = StatusPedido.valueOf(novoStatus);
            return repository.atualizarStatus(id, statusPedido);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @WebMethod
    public Pedido finalizarPedido(int id) {
        return repository.finalizar(id);
    }
}
