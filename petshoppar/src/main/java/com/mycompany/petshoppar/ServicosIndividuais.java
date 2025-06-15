/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshoppar;

import java.util.Scanner;

/**
 * Classe para gerenciar serviços individuais do Pet Shop
 * @author Nappada
 */
public class ServicosIndividuais {
    private final Scanner sc;
    
    public ServicosIndividuais(Scanner sc) {
        this.sc = sc;
    }
    
    public void executar() {
        System.out.println("\n--- Serviços Individuais ---");
        System.out.println("1) Banho e Tosa");
        System.out.println("2) Consulta");
        System.out.println("3) Cirurgia");
        System.out.println("4) Voltar");

        switch (sc.nextInt()) {
            case 1 -> banhoETosa();
            case 2 -> consulta();
            case 3 -> cirurgia();
            case 4 -> {}
            default -> System.out.println("Opção inválida!");
        }
    }

    private void banhoETosa() {
        System.out.println("\nBanho e Tosa - R$60,00");
        System.out.println("1) Confirmar\n2) Cancelar");
        if (sc.nextInt() == 1) {
            System.out.println("Leve seu pet à recepção com a nota!");
        }
    }

    private void consulta() {
        sc.nextLine();
        System.out.println("\n--- Agendar Consulta ---");
        System.out.println("Nome do dono:");
        String dono = sc.nextLine();
        
        System.out.println("Nome do pet:");
        String pet = sc.nextLine();
        
        System.out.println("Data da consulta (DD/MM/AAAA):");
        String data = sc.nextLine();
        
        String servico = String.format("Consulta para %s (Dono: %s) - %s", pet, dono, data);
        System.out.println("Agendado: " + servico);
    }

    private void cirurgia() {
        sc.nextLine();
        System.out.println("\n--- Agendar Cirurgia ---");
        System.out.println("Nome do dono:");
        String dono = sc.nextLine();
        
        System.out.println("Nome do pet:");
        String pet = sc.nextLine();
        
        System.out.println("Data da cirurgia (DD/MM/AAAA):");
        String data = sc.nextLine();
        
        String servico = String.format("Cirurgia para %s (Dono: %s) - %s", pet, dono, data);
        System.out.println("Agendado: " + servico);
    }
    
    // Métodos públicos para interface gráfica
    public String processarBanhoETosa() {
        return "Banho e Tosa realizado com sucesso!\nValor: R$ 60,00\nLeve seu pet à recepção.";
    }
    
    public String processarConsulta(String dono, String pet, String data) {
        return String.format("Consulta agendada com sucesso!\n\nPet: %s\nDono: %s\nData: %s\nValor: R$ 80,00", pet, dono, data);
    }
    
    public String processarCirurgia(String dono, String pet, String data, String tipo) {
        return String.format("Cirurgia agendada com sucesso!\n\nPet: %s\nDono: %s\nTipo: %s\nData: %s\nValor: R$ 300,00", pet, dono, tipo, data);
    }
}
