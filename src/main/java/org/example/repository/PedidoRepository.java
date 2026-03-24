package org.example.repository;

import org.example.model.Pedido;
import org.example.model.StatusPedido;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PedidoRepository {
    private List<Pedido> pedidos = new ArrayList<>();
    private AtomicInteger contadorPedidos = new AtomicInteger(1);

    public List<Pedido> listar() {
        return pedidos;
    }

    public Pedido criar(String nomeCliente, List<String> itensPedido) {
        Pedido pedido = new Pedido(contadorPedidos.getAndIncrement(), nomeCliente, itensPedido);
        pedidos.add(pedido);
        return pedido;
    }

    public Pedido buscar(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public Pedido atualizarStatus(int id, StatusPedido novoStatus) {
        Pedido pedido = buscar(id);

        if (pedido != null) {
            pedido.setStatusPedido(novoStatus);
            return pedido;
        }

        return null;
    }

    public Pedido finalizar(int id) {
        Pedido pedido = buscar(id);

        if (pedido != null) {
            pedido.finalizarPedido();
            return pedido;
        }

        return null;
    }
}
