package org.example.publisher;

import org.example.service.PedidoService;
import javax.xml.ws.Endpoint;

public class Publisher {
    public static void main(String[] args) {
        String url = "http://localhost:8080/sistema-restaurante";
        PedidoService service = new PedidoService();

        Endpoint.publish(url, service);

        System.out.println("WebService de pedidos publicado em "+url+"?wsdl");
    }
}
