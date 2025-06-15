/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshoppar;

import java.util.Scanner;

/**
 * Classe para gerenciar pacotes de serviços do Pet Shop
 * @author Nappada
 */
public class PacoteServicos {
    private final Scanner sc;

    public PacoteServicos(Scanner sc) {
        this.sc = sc;
    }

    public void executar() {
        System.out.println("\n--- Pacote de Serviços ---");
        System.out.println("1) Pacote Anual (R$2500)");
        System.out.println("2) Hospedagem (R$900/3meses)");
        System.out.println("3) Funeral (R$650)");
        System.out.println("4) Voltar");

        switch (sc.nextInt()) {
            case 1 -> pacoteAnual();
            case 2 -> pacoteHospedagem();
            case 3 -> pacoteFuneral();
            case 4 -> {}
            default -> System.out.println("Opção inválida!");
        }
    }

    private void pacoteAnual() {
        System.out.println("\nPacote Anual - R$2500");
        System.out.println("1) Comprar\n2) Cancelar");
        if (sc.nextInt() == 1) processarPagamento();
    }

    private void pacoteHospedagem() {
        System.out.println("\nHospedagem - R$900/3meses");
        System.out.println("1) Comprar\n2) Cancelar");
        if (sc.nextInt() == 1) processarPagamento();
    }

    private void pacoteFuneral() {
        System.out.println("\nFuneral - R$650");
        System.out.println("1) Comprar\n2) Cancelar");
        if (sc.nextInt() == 1) processarPagamento();
    }

    private void processarPagamento() {
        System.out.println("\nForma de pagamento:");
        System.out.println("1) Crédito\n2) Débito\n3) Pix");
        System.out.println("Pagamento processado com sucesso!");
    }
    
    // Métodos para interface gráfica
    public String processarPacoteAnual() {
        return "Pacote Anual contratado com sucesso!\n\n" +
               "Valor: R$ 2.500,00\n" +
               "Inclui: Banho e tosa mensal, consultas ilimitadas, desconto em cirurgias\n" +
               "Vigência: 12 meses";
    }
    
    public String processarHospedagem() {
        return "Hospedagem contratada com sucesso!\n\n" +
               "Valor: R$ 900,00 (3 meses)\n" +
               "Inclui: Alimentação, cuidados básicos, passeios diários\n" +
               "Período: 3 meses";
    }
    
    public String processarFuneral() {
        return "Serviço funerário contratado com sucesso!\n\n" +
               "Valor: R$ 650,00\n" +
               "Inclui: Cremação, urna básica, certificado\n" +
               "Nossos sentimentos pela perda do seu pet.";
    }
}
