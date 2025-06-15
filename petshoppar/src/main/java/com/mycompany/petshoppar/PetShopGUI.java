package com.mycompany.petshoppar;

import javax.swing.*;
import java.awt.*;

/**
 * Interface Gráfica Principal do Pet Shop - Versão Simplificada
 */
public class PetShopGUI extends JFrame {
    
    public PetShopGUI() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Pet-Celso - Sistema de Gestão");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Criar painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(230, 240, 255));
        GridBagConstraints gbc = new GridBagConstraints();
          // Título
        JLabel titleLabel = new JLabel("Pet-Celso");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 30, 20);
        mainPanel.add(titleLabel, gbc);
        
        // Subtítulo
        JLabel subtitleLabel = new JLabel("Sistema de Gestão de Pet Shop");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 20, 40, 20);
        mainPanel.add(subtitleLabel, gbc);
        
        // Botões do menu
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);
          // Botão Serviços Individuais
        JButton btnServicos = createStyledButton("Serviços Individuais");
        btnServicos.addActionListener(e -> abrirServicosIndividuais());
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(btnServicos, gbc);
        
        // Botão Pacote de Serviços
        JButton btnPacotes = createStyledButton("Pacote de Serviços");
        btnPacotes.addActionListener(e -> abrirPacoteServicos());
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(btnPacotes, gbc);
        
        // Botão Cadastro de Cliente
        JButton btnCadastro = createStyledButton("Cadastro de Cliente");
        btnCadastro.addActionListener(e -> abrirCadastroCliente());
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(btnCadastro, gbc);
        
        // Botão Administração
        JButton btnAdmin = createStyledButton("Administração");
        btnAdmin.addActionListener(e -> abrirAdministracao());
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(btnAdmin, gbc);
        
        // Botão Sair
        JButton btnSair = createStyledButton("Sair");
        btnSair.addActionListener(e -> System.exit(0));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(30, 20, 20, 20);
        mainPanel.add(btnSair, gbc);
        
        add(mainPanel, BorderLayout.CENTER);
        
        // Configurar janela
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }
      private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(200, 50));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        return button;
    }
      private void abrirServicosIndividuais() {
        new ServicosIndividuaisGUI().setVisible(true);
        this.setVisible(false);
    }
    
    private void abrirPacoteServicos() {
        new PacoteServicosGUI().setVisible(true);
        this.setVisible(false);
    }
    
    private void abrirCadastroCliente() {
        new CadastroClienteGUI().setVisible(true);
        this.setVisible(false);
    }
      private void abrirAdministracao() {
        new AdministradorGUI().setVisible(true);
        this.setVisible(false);
    }public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                // Use look and feel padrão se houver erro
            }
            new PetShopGUI().setVisible(true);
        });
    }
}
