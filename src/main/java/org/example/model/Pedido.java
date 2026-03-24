package org.example.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Pedido {
    private int id;
    private String nomeCliente;
    @XmlElementWrapper(name = "itensPedido") @XmlElement(name = "item")
    private List<String> itensPedido = new ArrayList<>();
    private StatusPedido statusPedido;

    public Pedido() {}
    public Pedido(int id, String nomeCliente, List<String> itensPedido) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.itensPedido = (itensPedido != null) ? itensPedido : new ArrayList<>();
        this.statusPedido = StatusPedido.ABERTO;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<String> getItensPedido() {
        return itensPedido;
    }
    public void setItensPedido(List<String> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }
    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public void adicionarItem(String item) {
        if (item != null && !item.trim().isEmpty()) {
            this.itensPedido.add(item);
        }
    }
    public void finalizarPedido() {
        this.statusPedido = StatusPedido.FINALIZADO;
    }
}
