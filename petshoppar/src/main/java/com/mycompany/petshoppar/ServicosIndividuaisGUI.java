package com.mycompany.petshoppar;

import javax.swing.*;
import java.awt.*;

/**
 * Interface Gráfica para Serviços Individuais - Versão Simplificada
 */
public class ServicosIndividuaisGUI extends JFrame {
    
    public ServicosIndividuaisGUI() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Serviços Individuais - Pet-Celso");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());
          // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Título
        JLabel titleLabel = new JLabel("Serviços Individuais");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 30, 20);
        mainPanel.add(titleLabel, gbc);
        
        // Botões de serviços
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);
        
        // Banho e Tosa
        JButton btnBanho = createServiceButton("Banho e Tosa", "R$ 60,00");
        btnBanho.addActionListener(e -> processarBanhoTosa());
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(btnBanho, gbc);
        
        // Consulta
        JButton btnConsulta = createServiceButton("Consulta Veterinária", "R$ 120,00");
        btnConsulta.addActionListener(e -> processarConsulta());
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(btnConsulta, gbc);
        
        // Cirurgia
        JButton btnCirurgia = createServiceButton("Cirurgia", "R$ 500,00");
        btnCirurgia.addActionListener(e -> processarCirurgia());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        mainPanel.add(btnCirurgia, gbc);
        
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
      private JButton createServiceButton(String service, String price) {
        JButton button = new JButton("<html><center>" + service + "<br><small>" + price + "</small></center></html>");
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(250, 80));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        return button;
    }    private void processarBanhoTosa() {
        int opcao = JOptionPane.showConfirmDialog(this,
            "Serviço: Banho e Tosa\nValor: R$ 60,00\n\nDeseja confirmar o serviço?",
            "Confirmação - Banho e Tosa",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (opcao == JOptionPane.YES_OPTION) {
            String resultado = "Serviço confirmado!\n\nLeve seu pet à recepção\nApresente esta confirmação";
            JOptionPane.showMessageDialog(this,
                resultado,
                "Banho e Tosa - Confirmado",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void processarConsulta() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField nomeDonoField = new JTextField();
        JTextField nomePetField = new JTextField();
        JTextField dataField = new JTextField();
        
        panel.add(new JLabel("Nome do dono:"));
        panel.add(nomeDonoField);
        panel.add(new JLabel("Nome do pet:"));
        panel.add(nomePetField);
        panel.add(new JLabel("Data (DD/MM/AAAA):"));
        panel.add(dataField);
        
        int result = JOptionPane.showConfirmDialog(this, panel, 
            "🩺 Agendar Consulta Veterinária - R$ 120,00", 
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            String dono = nomeDonoField.getText().trim();
            String pet = nomePetField.getText().trim();
            String data = dataField.getText().trim();            if (!dono.isEmpty() && !pet.isEmpty() && !data.isEmpty()) {
                String resultado = String.format("✅ Consulta Agendada!\n\n👤 Dono: %s\n🐕 Pet: %s\n📅 Data: %s\n💰 Valor: R$ 120,00",
                    dono, pet, data);
                JOptionPane.showMessageDialog(this,
                    resultado,
                    "Consulta Confirmada",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "❌ Por favor, preencha todos os campos!", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void processarCirurgia() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        JTextField nomeDonoField = new JTextField();
        JTextField nomePetField = new JTextField();
        JTextField dataField = new JTextField();
        JTextField tipoField = new JTextField();
        
        panel.add(new JLabel("Nome do dono:"));
        panel.add(nomeDonoField);
        panel.add(new JLabel("Nome do pet:"));
        panel.add(nomePetField);
        panel.add(new JLabel("Tipo de cirurgia:"));
        panel.add(tipoField);
        panel.add(new JLabel("Data (DD/MM/AAAA):"));
        panel.add(dataField);
        
        int result = JOptionPane.showConfirmDialog(this, panel, 
            "🏥 Agendar Cirurgia - R$ 500,00", 
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            String dono = nomeDonoField.getText().trim();
            String pet = nomePetField.getText().trim();
            String tipo = tipoField.getText().trim();
            String data = dataField.getText().trim();            if (!dono.isEmpty() && !pet.isEmpty() && !tipo.isEmpty() && !data.isEmpty()) {
                String resultado = String.format("✅ Cirurgia Agendada!\n\n👤 Dono: %s\n🐕 Pet: %s\n🏥 Tipo: %s\n📅 Data: %s\n💰 Valor: R$ 500,00",
                    dono, pet, tipo, data);
                JOptionPane.showMessageDialog(this,
                    resultado,
                    "Cirurgia Confirmada",
                    JOptionPane.INFORMATION_MESSAGE);
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
