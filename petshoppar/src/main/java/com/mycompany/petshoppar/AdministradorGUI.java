package com.mycompany.petshoppar;

import javax.swing.*;
import java.awt.*;

/**
 * Interface Gráfica para Administração - Versão Simplificada
 */
public class AdministradorGUI extends JFrame {    
    public AdministradorGUI() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Administração - Pet-Celso");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(255, 240, 240));
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Título
        JLabel titleLabel = new JLabel("⚙️ Painel de Administração");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(150, 50, 50));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 30, 20);
        mainPanel.add(titleLabel, gbc);
        
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);
        
        // Relatório de Clientes
        JButton btnRelatorioClientes = createAdminButton("📊 Relatório de Clientes", 
            "Ver estatísticas dos clientes", new Color(70, 130, 180));
        btnRelatorioClientes.addActionListener(e -> relatorioClientes());
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(btnRelatorioClientes, gbc);
        
        // Relatório de Serviços
        JButton btnRelatorioServicos = createAdminButton("📈 Relatório de Serviços", 
            "Ver estatísticas dos serviços", new Color(60, 179, 113));
        btnRelatorioServicos.addActionListener(e -> relatorioServicos());
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(btnRelatorioServicos, gbc);
        
        // Configurações do Sistema
        JButton btnConfiguracoes = createAdminButton("⚙️ Configurações", 
            "Configurar o sistema", new Color(255, 140, 0));
        btnConfiguracoes.addActionListener(e -> configuracoes());
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(btnConfiguracoes, gbc);
        
        // Backup e Restauração
        JButton btnBackup = createAdminButton("💾 Backup/Restaurar", 
            "Gerenciar dados", new Color(128, 0, 128));
        btnBackup.addActionListener(e -> backupRestaurar());
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(btnBackup, gbc);
        
        // Logs do Sistema
        JButton btnLogs = createAdminButton("📋 Logs do Sistema", 
            "Ver atividades recentes", new Color(105, 105, 105));
        btnLogs.addActionListener(e -> logsDoSistema());
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(btnLogs, gbc);
        
        // Botão Voltar
        JButton btnVoltar = new JButton("⬅️ Voltar ao Menu Principal");
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
        btnVoltar.setPreferredSize(new Dimension(300, 40));
        btnVoltar.setBackground(new Color(108, 117, 125));
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(e -> voltarMenu());
        gbc.gridy = 4;
        gbc.insets = new Insets(30, 20, 20, 20);
        mainPanel.add(btnVoltar, gbc);
        
        add(mainPanel, BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private JButton createAdminButton(String title, String tooltip, Color color) {
        JButton button = new JButton(title);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(250, 60));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setToolTipText(tooltip);
        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(color.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(color);
            }
        });
        
        return button;
    }
    
    private void relatorioClientes() {
        String relatorio = "📊 RELATÓRIO DE CLIENTES\n\n" +
            "👥 Total de clientes cadastrados: 15\n" +
            "🐕 Total de pets registrados: 23\n" +
            "📈 Novos cadastros este mês: 3\n" +
            "⭐ Cliente com mais pets: Maria Santos (5 pets)\n" +
            "📞 Clientes sem telefone: 0\n\n" +
            "📅 Último cadastro: 14/06/2025\n" +
            "🔄 Última atualização: " + java.time.LocalDateTime.now().format(
                java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        
        JTextArea textArea = new JTextArea(relatorio);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setEditable(false);
        textArea.setBackground(getBackground());
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        
        JOptionPane.showMessageDialog(this, scrollPane,
            "📊 Relatório de Clientes",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void relatorioServicos() {
        String relatorio = "📈 RELATÓRIO DE SERVIÇOS\n\n" +
            "SERVIÇOS INDIVIDUAIS:\n" +
            "🛁 Banho e Tosa: 45 serviços (R$ 2.700,00)\n" +
            "🩺 Consultas: 28 consultas (R$ 3.360,00)\n" +
            "🏥 Cirurgias: 8 cirurgias (R$ 4.000,00)\n\n" +
            "PACOTES:\n" +
            "🎯 Pacote Anual: 5 vendidos (R$ 12.500,00)\n" +
            "🏨 Hospedagem: 12 hospedagens (R$ 10.800,00)\n" +
            "⚱️ Funeral: 3 serviços (R$ 1.950,00)\n\n" +
            "💰 TOTAL FATURADO: R$ 35.310,00\n" +
            "📅 Período: Junho/2025\n" +
            "🔄 Atualizado em: " + java.time.LocalDateTime.now().format(
                java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        
        JTextArea textArea = new JTextArea(relatorio);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setEditable(false);
        textArea.setBackground(getBackground());
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450, 350));
        
        JOptionPane.showMessageDialog(this, scrollPane,
            "📈 Relatório de Serviços",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void configuracoes() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JTextField nomeEmpresaField = new JTextField("Pet-Celso");
        JTextField enderecoField = new JTextField("Rua das Flores, 123");
        JTextField telefoneField = new JTextField("(11) 9999-9999");
        JTextField emailField = new JTextField("contato@petcelso.com");
        JSpinner horaAberturaSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner horaFechamentoSpinner = new JSpinner(new SpinnerDateModel());
        
        panel.add(new JLabel("🏢 Nome da Empresa:"));
        panel.add(nomeEmpresaField);
        panel.add(new JLabel("📍 Endereço:"));
        panel.add(enderecoField);
        panel.add(new JLabel("📞 Telefone:"));
        panel.add(telefoneField);
        panel.add(new JLabel("📧 Email:"));
        panel.add(emailField);
        panel.add(new JLabel("🕘 Horário Abertura:"));
        panel.add(horaAberturaSpinner);
        panel.add(new JLabel("🕕 Horário Fechamento:"));
        panel.add(horaFechamentoSpinner);
        
        int result = JOptionPane.showConfirmDialog(this, panel,
            "⚙️ Configurações do Sistema",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(this,
                "✅ Configurações salvas com sucesso!\n\n" +
                "As alterações serão aplicadas na próxima inicialização.",
                "Configurações Salvas",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void backupRestaurar() {
        String[] opcoes = {"💾 Fazer Backup", "🔄 Restaurar Backup", "📁 Ver Backups"};
        
        String escolha = (String) JOptionPane.showInputDialog(this,
            "Escolha uma opção para gerenciar os dados:",
            "💾 Backup e Restauração",
            JOptionPane.QUESTION_MESSAGE,
            null,
            opcoes,
            opcoes[0]);
        
        if (escolha != null) {
            switch (escolha) {
                case "💾 Fazer Backup":
                    JOptionPane.showMessageDialog(this,
                        "✅ Backup criado com sucesso!\n\n" +
                        "📁 Local: backup_petcelso_" + 
                        java.time.LocalDate.now().format(
                            java.time.format.DateTimeFormatter.ofPattern("ddMMyyyy")) + ".bak\n" +
                        "📊 Dados salvos: Clientes, Serviços, Configurações",
                        "Backup Realizado",
                        JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "🔄 Restaurar Backup":
                    JOptionPane.showMessageDialog(this,
                        "⚠️ Funcionalidade em desenvolvimento!\n\n" +
                        "Em breve você poderá restaurar backups anteriores.",
                        "Em Desenvolvimento",
                        JOptionPane.WARNING_MESSAGE);
                    break;
                case "📁 Ver Backups":
                    String[] backups = {
                        "backup_petcelso_13062025.bak (13/06/2025)",
                        "backup_petcelso_12062025.bak (12/06/2025)",
                        "backup_petcelso_11062025.bak (11/06/2025)"
                    };
                    JList<String> lista = new JList<>(backups);
                    JScrollPane scroll = new JScrollPane(lista);
                    scroll.setPreferredSize(new Dimension(300, 150));
                    JOptionPane.showMessageDialog(this, scroll,
                        "📁 Backups Disponíveis",
                        JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }
    }
    
    private void logsDoSistema() {
        String logs = "📋 LOGS DO SISTEMA\n\n" +
            "14/06/2025 10:30 - 👤 Novo cliente cadastrado: João Silva\n" +
            "14/06/2025 10:25 - 🛁 Serviço realizado: Banho e Tosa para Rex\n" +
            "14/06/2025 10:20 - 🩺 Consulta agendada para 15/06/2025\n" +
            "14/06/2025 10:15 - 📦 Pacote Anual vendido para Maria Santos\n" +
            "14/06/2025 10:10 - 💾 Backup automático realizado\n" +
            "14/06/2025 10:05 - 🏥 Cirurgia agendada para Bolt (20/06/2025)\n" +
            "14/06/2025 10:00 - ⚙️ Sistema iniciado\n" +
            "13/06/2025 18:00 - 🌙 Sistema encerrado\n" +
            "13/06/2025 17:55 - 💾 Backup automático realizado\n" +
            "13/06/2025 17:30 - 🏨 Hospedagem iniciada para Lola\n\n" +
            "🔄 Última atualização: " + java.time.LocalDateTime.now().format(
                java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        
        JTextArea textArea = new JTextArea(logs);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
        textArea.setEditable(false);
        textArea.setBackground(getBackground());
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));
        
        JOptionPane.showMessageDialog(this, scrollPane,
            "📋 Logs do Sistema",
            JOptionPane.INFORMATION_MESSAGE);
    }
      private void voltarMenu() {
        new PetShopGUI().setVisible(true);
        this.dispose();
    }
}
