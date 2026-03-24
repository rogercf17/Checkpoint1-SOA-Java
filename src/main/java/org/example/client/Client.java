package org.example.client;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static java.util.stream.Collectors.toList;

public class Client {
    private static final PedidoServiceService service = new PedidoServiceService();
    private static final PedidoService port = service.getPedidoServicePort();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String menu = "1 - Criar pedido\n"+
                "2 - Listar pedidos\n"+
                "3 - Buscar pedido\n"+
                "4 - Atualizar status\n"+
                "5 - Finalizar pedido\n"+
                "0 - Sair ";
        int opcao;

        do {
            System.out.println(menu);
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarPedido(scanner);
                    break;
                case 2:
                    listarPedidos();
                    break;
                case 3:
                    buscarPedidoPorId(scanner);
                    break;
                case 4:
                    atualizarStatusPedido(scanner);
                    break;
                case 5:
                    finalizarPedido(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema do restaurante...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }while (opcao != 0);

        scanner.close();
    }

    private static void listarPedidos() {
        List<Pedido> pedidos = port.listarPedidos();

        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido encontrado.");
        } else {
            System.out.println("Pedidos:");
            for (Pedido p : pedidos) {
                System.out.println("ID: "+p.getId());
                System.out.println("Cliente: "+p.getNomeCliente());
                System.out.println("Itens: "+p.getItensPedido().item);
                System.out.println("Status: "+p.getStatusPedido()+"\n");
            }
        }
    }
    private static void criarPedido(Scanner scanner) {
        System.out.println("Nome do cliente: ");
        String nomeCliente = scanner.nextLine().trim();

        System.out.println("Digite os itens do pedido (separados por vírgula): ");
        String itensInput = scanner.nextLine();
        List<String> itensPedido = Arrays.stream(itensInput.split(","))
                .map(String::trim)
                .collect(toList());

        Pedido pedido = port.criarPedido(nomeCliente, itensPedido);
        System.out.println("Pedido criado! ID: "+pedido.getId()+"\n");
    }

    private static void buscarPedidoPorId(Scanner scanner) {
        System.out.println("Digite o ID do pedido: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Pedido pedido = port.buscarPedidoPorId(id);
        if (pedido != null) {
            System.out.println("ID: "+pedido.getId());
            System.out.println("Cliente: "+pedido.getNomeCliente());
            System.out.println("Itens: "+pedido.getItensPedido().item);
            System.out.println("Status: "+pedido.getStatusPedido()+"\n");
        } else {
            System.out.println("Pedido não encontrado.\n");
        }
    }

    private static void atualizarStatusPedido(Scanner scanner) {
        System.out.println("Digite o ID do pedido: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o novo status do pedido: ");
        String novoStatus = scanner.nextLine().trim();

        Pedido pedido = port.atualizarStatusPedido(id, novoStatus);

        if (pedido != null) {
            System.out.println("Status atualizado: " + pedido.getStatusPedido()+"\n");
        } else {
            System.out.println("Erro ao atualizar, Pedido não encontrado.\n");
        }
    }

    private static void finalizarPedido(Scanner scanner) {
        System.out.println("Digite o ID do pedido: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Pedido pedido = port.finalizarPedido(id);

        if (pedido != null) {
            System.out.println("Pedido finalizado! Status: " + pedido.getStatusPedido()+"\n");
        } else {
            System.out.println("Erro ao finalizar, Pedido não encontrado.\n");
        }
    }
}
