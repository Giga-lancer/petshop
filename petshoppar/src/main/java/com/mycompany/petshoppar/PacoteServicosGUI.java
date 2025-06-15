package com.mycompany.petshoppar;

import javax.swing.*;
import java.awt.*;

/**
 * Interface Gráfica para Pacote de Serviços - Versão Simplificada
 */
public class PacoteServicosGUI extends JFrame {    
    public PacoteServicosGUI() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Pacote de Serviços - Pet-Celso");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel();        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Título
        JLabel titleLabel = new JLabel("Pacotes de Serviços");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 30, 20);
        mainPanel.add(titleLabel, gbc);
        
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);
        
        // Pacote Anual
        JButton btnAnual = createPackageButton("Pacote Anual", 
            "<html><center>Inclui todos os serviços<br>por um ano inteiro<br><b>R$ 2.500,00</b></center></html>");
        btnAnual.addActionListener(e -> processarPacoteAnual());
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(btnAnual, gbc);
        
        // Hospedagem
        JButton btnHospedagem = createPackageButton("Hospedagem", 
            "<html><center>Cuidados completos<br>por 3 meses<br><b>R$ 900,00</b></center></html>");
        btnHospedagem.addActionListener(e -> processarHospedagem());
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(btnHospedagem, gbc);
        
        // Funeral
        JButton btnFuneral = createPackageButton("Funeral", 
            "<html><center>Serviços funerários<br>completos<br><b>R$ 650,00</b></center></html>");
        btnFuneral.addActionListener(e -> processarFuneral());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        mainPanel.add(btnFuneral, gbc);
          // Botão Voltar
        JButton btnVoltar = new JButton("Voltar ao Menu Principal");
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
        btnVoltar.setPreferredSize(new Dimension(300, 40));
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(e -> voltarMenu());
        gbc.gridy = 3;
        gbc.insets = new Insets(30, 20, 20, 20);
        mainPanel.add(btnVoltar, gbc);
        
        add(mainPanel, BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }
      private JButton createPackageButton(String title, String description) {
        JButton button = new JButton("<html><center><h3>" + title + "</h3>" + description + "</center></html>");
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setPreferredSize(new Dimension(280, 120));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        return button;
    }
    
    private void processarPacoteAnual() {
        String[] opcoesPagamento = {"💳 Cartão de Crédito", "💰 Dinheiro", "🏦 PIX", "📄 Boleto"};
        
        int opcao = JOptionPane.showConfirmDialog(this,
            "🎯 Pacote Anual - R$ 2.500,00\n\n" +
            "✅ Banhos e tosas ilimitados\n" +
            "✅ Consultas veterinárias\n" +
            "✅ Vacinas incluídas\n" +
            "✅ Desconto em cirurgias\n\n" +
            "Deseja adquirir este pacote?",
            "Pacote Anual",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (opcao == JOptionPane.YES_OPTION) {
            String formaPagamento = (String) JOptionPane.showInputDialog(this,
                "Escolha a forma de pagamento:",
                "Forma de Pagamento",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoesPagamento,
                opcoesPagamento[0]);
            
            if (formaPagamento != null) {
                JOptionPane.showMessageDialog(this,
                    "✅ Pacote Anual Adquirido!\n\n" +
                    "💰 Valor: R$ 2.500,00\n" +
                    "💳 Pagamento: " + formaPagamento + "\n\n" +
                    "🎫 Seu cartão de fidelidade chegará em 3 dias úteis!",
                    "Compra Confirmada",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    private void processarHospedagem() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField nomePetField = new JTextField();
        JTextField nomeDonoField = new JTextField();
        JTextField dataInicioField = new JTextField();
        
        panel.add(new JLabel("Nome do pet:"));
        panel.add(nomePetField);
        panel.add(new JLabel("Nome do dono:"));
        panel.add(nomeDonoField);
        panel.add(new JLabel("Data de início:"));
        panel.add(dataInicioField);
        
        int result = JOptionPane.showConfirmDialog(this, panel,
            "🏨 Hospedagem (3 meses) - R$ 900,00",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            String pet = nomePetField.getText().trim();
            String dono = nomeDonoField.getText().trim();
            String data = dataInicioField.getText().trim();
            
            if (!pet.isEmpty() && !dono.isEmpty() && !data.isEmpty()) {
                String[] opcoesPagamento = {"💳 Cartão de Crédito", "💰 Dinheiro", "🏦 PIX", "📄 Boleto"};
                String formaPagamento = (String) JOptionPane.showInputDialog(this,
                    "Escolha a forma de pagamento:",
                    "Forma de Pagamento",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoesPagamento,
                    opcoesPagamento[0]);
                
                if (formaPagamento != null) {
                    JOptionPane.showMessageDialog(this,
                        String.format("✅ Hospedagem Confirmada!\n\n" +
                            "🐕 Pet: %s\n" +
                            "👤 Dono: %s\n" +
                            "📅 Início: %s\n" +
                            "💰 Valor: R$ 900,00\n" +
                            "💳 Pagamento: %s\n\n" +
                            "🏨 Traga seu pet no dia combinado!",
                            pet, dono, data, formaPagamento),
                        "Hospedagem Confirmada",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "❌ Por favor, preencha todos os campos!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void processarFuneral() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField nomePetField = new JTextField();
        JTextField nomeDonoField = new JTextField();
        JTextField dataField = new JTextField();
        
        panel.add(new JLabel("Nome do pet:"));
        panel.add(nomePetField);
        panel.add(new JLabel("Nome do dono:"));
        panel.add(nomeDonoField);
        panel.add(new JLabel("Data do serviço:"));
        panel.add(dataField);
        
        int result = JOptionPane.showConfirmDialog(this, panel,
            "⚱️ Serviços Funerários - R$ 650,00",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            String pet = nomePetField.getText().trim();
            String dono = nomeDonoField.getText().trim();
            String data = dataField.getText().trim();
            
            if (!pet.isEmpty() && !dono.isEmpty() && !data.isEmpty()) {
                String[] opcoesPagamento = {"💳 Cartão de Crédito", "💰 Dinheiro", "🏦 PIX", "📄 Boleto"};
                String formaPagamento = (String) JOptionPane.showInputDialog(this,
                    "Escolha a forma de pagamento:",
                    "Forma de Pagamento",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoesPagamento,
                    opcoesPagamento[0]);
                
                if (formaPagamento != null) {
                    JOptionPane.showMessageDialog(this,
                        String.format("✅ Serviço Funerário Agendado\n\n" +
                            "🐕 Pet: %s\n" +
                            "👤 Dono: %s\n" +
                            "📅 Data: %s\n" +
                            "💰 Valor: R$ 650,00\n" +
                            "💳 Pagamento: %s\n\n" +
                            "🙏 Nossos pêsames. Estaremos à disposição.",
                            pet, dono, data, formaPagamento),
                        "Serviço Confirmado",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "❌ Por favor, preencha todos os campos!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
      private void voltarMenu() {
        new PetShopGUI().setVisible(true);
        this.dispose();
    }
}
