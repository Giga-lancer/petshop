/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshoppar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe para funcionalidades de administração do Pet Shop
 * @author Nappada
 */
public class Administrador {
    private final Scanner sc;
    private final CadastroCliente cadastroCliente;
    private final ServicosIndividuais servicosIndividuais;
    private List<String> servicosAgendados;
    
    public Administrador(Scanner sc, CadastroCliente cadastroCliente, ServicosIndividuais servicosIndividuais) {
        this.sc = sc;
        this.cadastroCliente = cadastroCliente;
        this.servicosIndividuais = servicosIndividuais;
        this.servicosAgendados = new ArrayList<>();
    }

    public void executar() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Menu Administrador ---");
            System.out.println("1) Listar clientes");
            System.out.println("2) Buscar cliente");
            System.out.println("3) Excluir cliente");
            System.out.println("4) Listar serviços agendados");
            System.out.println("5) Cancelar serviço");
            System.out.println("0) Voltar");
            
            int opcao = sc.nextInt();
            sc.nextLine();
            
            switch (opcao) {
                case 1 -> cadastroCliente.listarClientes();
                case 2 -> {
                    System.out.println("Digite o nome do cliente:");
                    cadastroCliente.buscarCliente(sc.nextLine());
                }
                case 3 -> {
                    System.out.println("Digite o nome do cliente a excluir:");
                    cadastroCliente.excluirCliente(sc.nextLine());
                }
                case 4 -> listarServicosAgendados();
                case 5 -> {
                    System.out.println("Digite o nome do pet para cancelar serviço:");
                    cancelarServicoAgendado(sc.nextLine());
                }
                case 0 -> continuar = false;
                default -> System.out.println("Opção inválida!");
            }
        }
    }
    
    private void listarServicosAgendados() {
        if (servicosAgendados.isEmpty()) {
            System.out.println("Nenhum serviço agendado.");
        } else {
            System.out.println("\n--- Serviços Agendados ---");
            servicosAgendados.forEach(System.out::println);
        }
    }
    
    private void cancelarServicoAgendado(String nomePet) {
        if (servicosAgendados.removeIf(s -> s.contains(nomePet))) {
            System.out.println("Serviço cancelado com sucesso!");
        } else {
            System.out.println("Nenhum serviço encontrado para " + nomePet);
        }
    }
    
    public void agendarServico(String servico) {
        servicosAgendados.add(servico);
    }
    
    // Métodos para interface gráfica
    public List<Cliente> listarTodosClientes() {
        return cadastroCliente.getClientes();
    }
    
    public Cliente buscarClientePorNome(String nome) {
        return cadastroCliente.buscarClientePorNome(nome);
    }
    
    public String excluirClientePorNome(String nome) {
        Cliente cliente = cadastroCliente.buscarClientePorNome(nome);
        if (cliente != null) {
            cadastroCliente.excluirCliente(nome);
            return "Cliente '" + nome + "' excluído com sucesso!";
        }
        return "Cliente '" + nome + "' não encontrado!";
    }
    
    public List<String> getServicosAgendados() {
        return new ArrayList<>(servicosAgendados);
    }
    
    public String cancelarServicoAgendadoGUI(String identificador) {
        if (servicosAgendados.removeIf(s -> s.contains(identificador))) {
            return "Serviço cancelado com sucesso!";
        }
        return "Nenhum serviço encontrado para: " + identificador;
    }
}
