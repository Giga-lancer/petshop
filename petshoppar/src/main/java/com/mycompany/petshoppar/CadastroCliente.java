/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshoppar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe para gerenciar cadastro de clientes
 * @author Nappada
 */
public class CadastroCliente {
    private final Scanner sc;
    private final List<Cliente> clientes;
    
    public CadastroCliente(Scanner sc) {
        this.sc = sc;
        this.clientes = new ArrayList<>();
    }

    public void executar() {
        sc.nextLine();  
        System.out.println("\n--- Cadastro de Cliente ---");
        
        System.out.println("Nome do dono:");
        String dono = sc.nextLine();

        System.out.println("Quantidade de pets:");
        int qtdPets = sc.nextInt();
        sc.nextLine();
        
        List<String> pets = new ArrayList<>();
        for (int i = 0; i < qtdPets; i++) {
            System.out.println("Nome do pet #" + (i+1) + ":");
            pets.add(sc.nextLine());
        }

        System.out.println("Telefone:");
        String telefone = sc.nextLine();

        clientes.add(new Cliente(dono, pets, telefone));
        System.out.println("\n✅ Cadastro realizado!");

        System.out.println("Adicionar mais pets? (1-Sim/2-Não)");
        if (sc.nextInt() == 1) {
            sc.nextLine();
            adicionarMaisPets(dono);
        }
    }
    
    private void adicionarMaisPets(String nomeDono) {
        System.out.println("\nQuantos pets deseja adicionar?");
        int qtd = sc.nextInt();
        sc.nextLine();
        
        for (Cliente c : clientes) {
            if (c.getDono().equalsIgnoreCase(nomeDono)) {
                for (int i = 0; i < qtd; i++) {
                    System.out.println("Nome do pet #" + (i+1) + ":");
                    c.adicionarPet(sc.nextLine());
                }
                System.out.println("🐾 Pets adicionados! Lista atual:");
                System.out.println(c.getPets());
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }
    
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
        } else {
            System.out.println("\n--- Clientes Cadastrados ---");
            clientes.forEach(c -> {
                System.out.println("Dono: " + c.getDono());
                System.out.println("Pets: " + c.getPets());
                System.out.println("Tel: " + c.getTelefone() + "\n");
            });
        }
    }
    
    public void buscarCliente(String nome) {
        boolean encontrado = false;
        for (Cliente c : clientes) {
            if (c.getDono().equalsIgnoreCase(nome)) {
                System.out.println("\n--- Dados do Cliente ---");
                System.out.println("Dono: " + c.getDono());
                System.out.println("Pets: " + c.getPets());
                System.out.println("Tel: " + c.getTelefone());
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("Cliente não encontrado!");
    }
    
    public void excluirCliente(String nome) {
        if (clientes.removeIf(c -> c.getDono().equalsIgnoreCase(nome))) {
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }
    
    // Métodos para interface gráfica
    public String cadastrarCliente(String dono, List<String> pets, String telefone) {
        Cliente novoCliente = new Cliente(dono, pets, telefone);
        clientes.add(novoCliente);
        return "Cliente cadastrado com sucesso!\n\n" +
               "Dono: " + dono + "\n" +
               "Pets: " + pets + "\n" +
               "Telefone: " + telefone;
    }
    
    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }
    
    public Cliente buscarClientePorNome(String nome) {
        for (Cliente c : clientes) {
            if (c.getDono().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }
}
