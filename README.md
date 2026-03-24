# Checkpoint1-SOA-Java
**Sala:** 3ESPW

**Integrantes:**
* Fernanda Rocha - 554673
* Luan Ramos - 558537
* Luiza Macena - 556237
* Matheus Ricciotti - 556930
* Matheus Bortolotto - 555189
* Roger Cardoso - 557230

## Descrição do Projeto
Este projeto consiste no desenvolvimento de um WebService SOAP em Java para gerenciamento de pedidos em um restaurante, juntamente com um cliente responsável por consumir os serviços disponibilizados. A aplicação permite criar, consultar, atualizar e finalizar pedidos, simulando o fluxo básico de atendimento em um restaurante físico.

---

## Objetivo
Atender ao requisito de:
> "Desenvolvimento de um código que publique serviços de uma API SOAP e um código que os consuma."

O sistema foi desenvolvido com foco em demonstrar:
* Comunicação via SOAP
* Serialização de objetos em XML
* Integração cliente-servidor

---

## Contexto de Implantação
O sistema pode ser utilizado em restaurantes físicos para controle de pedidos realizados no local, auxiliando no fluxo entre atendimento e cozinha.

Problemas que o sistema resolve:
* Organização de pedidos realizados no restaurante
* Controle do status dos pedidos
* Centralização das informações dos pedidos
* Simulação de comunicação entre sistemas distribuídos

---

## Funcionalidades
* [x] Criar pedido
* [x] Listar pedidos
* [x] Buscar pedido por ID
* [x] Atualizar status do pedido
* [x] Finalizar pedido

---

## Arquitetura do Projeto
O projeto foi dividido em camadas para melhor organização:
* Model → Representação da entidade Pedido
* Repository → Simulação de banco de dados em memória
* Service → Exposição dos métodos via SOAP (@WebService)
* Publisher → Publicação do WebService
* Client → Consumo do WebService

---

## Regras de Negócio
* Todo pedido é criado com status ABERTO
* O status pode ser alterado para:
  * EM_PREPARO
  * FINALIZADO
* Um pedido finalizado não pode ser alterado novamente
* Cada pedido possui:
  * ID único
  * Nome do cliente
  * Lista de itens

---

## Tecnologias
* Java
* JAX-WS (SOAP)
* Maven
* JAXB (Serialização XML)

---

## Como Executar
**1. Rodar o servidor**
* Executar a classe `Publisher.java`
* Acessar o WSDL [URL que aparece no console](http://localhost:8080/sistema-restaurante?wsdl)

**2. Gerar o client (caso necessário)**
* Via Maven: `mvn clean compile`

**3. Rodar o Client**
* Executar a classe `Client.java`
* O sistema apresentará um menu interativo no console para uso das funcionalidades, utilize ele!
