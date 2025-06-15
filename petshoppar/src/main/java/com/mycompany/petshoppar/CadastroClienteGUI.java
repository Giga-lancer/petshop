package com.mycompany.petshoppar;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Interface Gráfica para Cadastro de Cliente - Versão Simplificada
 */
public class CadastroClienteGUI extends JFrame {
    
    public CadastroClienteGUI() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Cadastro de Cliente - Pet-Celso");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(255, 248, 240));
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Título
        JLabel titleLabel = new JLabel("👤 Cadastro de Cliente");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(180, 100, 60));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 30, 20);
        mainPanel.add(titleLabel, gbc);
        
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);
        
        // Novo Cadastro
        JButton btnNovoCadastro = createButton("📝 Novo Cadastro", 
            "Cadastrar novo cliente", new Color(60, 179, 113));
        btnNovoCadastro.addActionListener(e -> novoCadastro());
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(btnNovoCadastro, gbc);
        
        // Listar Clientes
        JButton btnListar = createButton("📋 Listar Clientes", 
            "Ver todos os clientes", new Color(70, 130, 180));
        btnListar.addActionListener(e -> listarClientes());
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(btnListar, gbc);
        
        // Buscar Cliente
        JButton btnBuscar = createButton("🔍 Buscar Cliente", 
            "Buscar por nome", new Color(255, 140, 0));
        btnBuscar.addActionListener(e -> buscarCliente());
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(btnBuscar, gbc);
        
        // Excluir Cliente
        JButton btnExcluir = createButton("🗑️ Excluir Cliente", 
            "Remover cadastro", new Color(220, 20, 60));
        btnExcluir.addActionListener(e -> excluirCliente());
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(btnExcluir, gbc);
        
        // Botão Voltar
        JButton btnVoltar = new JButton("⬅️ Voltar ao Menu Principal");
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
        btnVoltar.setPreferredSize(new Dimension(300, 40));
        btnVoltar.setBackground(new Color(108, 117, 125));
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(e -> voltarMenu());
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(30, 20, 20, 20);
        mainPanel.add(btnVoltar, gbc);
        
        add(mainPanel, BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private JButton createButton(String title, String tooltip, Color color) {
        JButton button = new JButton(title);
        button.setFont(new Font("Arial", Font.BOLD, 16));
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
    
    private void novoCadastro() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JTextField nomeDonoField = new JTextField();
        JTextField telefoneField = new JTextField();
        JSpinner qtdPetsSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        JTextArea observacoesArea = new JTextArea(3, 20);
        observacoesArea.setBorder(BorderFactory.createLoweredBevelBorder());
        
        panel.add(new JLabel("👤 Nome do dono:"));
        panel.add(nomeDonoField);
        panel.add(new JLabel("📞 Telefone:"));
        panel.add(telefoneField);
        panel.add(new JLabel("🐕 Quantidade de pets:"));
        panel.add(qtdPetsSpinner);
        panel.add(new JLabel("📝 Observações:"));
        panel.add(new JScrollPane(observacoesArea));
        
        int result = JOptionPane.showConfirmDialog(this, panel,
            "📝 Novo Cadastro de Cliente",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            String nomeDono = nomeDonoField.getText().trim();
            String telefone = telefoneField.getText().trim();
            int qtdPets = (Integer) qtdPetsSpinner.getValue();
            
            if (!nomeDono.isEmpty() && !telefone.isEmpty()) {
                List<String> pets = new ArrayList<>();
                
                // Coletar nomes dos pets
                for (int i = 0; i < qtdPets; i++) {
                    String nomePet = JOptionPane.showInputDialog(this,
                        String.format("Nome do pet %d/%d:", i + 1, qtdPets),
                        "Nome do Pet",
                        JOptionPane.QUESTION_MESSAGE);
                    
                    if (nomePet != null && !nomePet.trim().isEmpty()) {
                        pets.add(nomePet.trim());
                    } else {
                        JOptionPane.showMessageDialog(this, "❌ Cadastro cancelado!",
                            "Cancelado", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                
                // Simular cadastro (na implementação real, usaria cadastroCliente)
                JOptionPane.showMessageDialog(this,
                    String.format("✅ Cliente cadastrado com sucesso!\n\n" +
                        "👤 Nome: %s\n" +
                        "📞 Telefone: %s\n" +
                        "🐕 Pets: %s\n" +
                        "📝 Observações: %s",
                        nomeDono, telefone, String.join(", ", pets), 
                        observacoesArea.getText().trim()),
                    "Cadastro Realizado",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "❌ Por favor, preencha nome e telefone!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void listarClientes() {
        // Simulação de clientes (na implementação real, usaria cadastroCliente.listarClientes())
        String[] clientes = {
            "João Silva - Tel: (11) 99999-9999 - Pets: Rex, Mimi",
            "Maria Santos - Tel: (11) 88888-8888 - Pets: Bolt",
            "Pedro Costa - Tel: (11) 77777-7777 - Pets: Lola, Max, Nina"
        };
        
        if (clientes.length > 0) {
            JList<String> lista = new JList<>(clientes);
            lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            lista.setFont(new Font("Arial", Font.PLAIN, 14));
            
            JScrollPane scrollPane = new JScrollPane(lista);
            scrollPane.setPreferredSize(new Dimension(400, 200));
            
            JOptionPane.showMessageDialog(this, scrollPane,
                "📋 Lista de Clientes Cadastrados",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "📭 Nenhum cliente cadastrado ainda!",
                "Lista Vazia", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void buscarCliente() {
        String nome = JOptionPane.showInputDialog(this,
            "Digite o nome do cliente para buscar:",
            "🔍 Buscar Cliente",
            JOptionPane.QUESTION_MESSAGE);
        
        if (nome != null && !nome.trim().isEmpty()) {
            // Simulação de busca (na implementação real, usaria cadastroCliente.buscarCliente())
            JOptionPane.showMessageDialog(this,
                String.format("👤 Cliente encontrado!\n\n" +
                    "Nome: %s\n" +
                    "Telefone: (11) 99999-9999\n" +
                    "Pets: Rex, Mimi\n" +
                    "Cadastrado em: 15/06/2025",
                    nome),
                "Cliente Encontrado",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void excluirCliente() {
        String nome = JOptionPane.showInputDialog(this,
            "Digite o nome do cliente para excluir:",
            "🗑️ Excluir Cliente",
            JOptionPane.WARNING_MESSAGE);
        
        if (nome != null && !nome.trim().isEmpty()) {
            int opcao = JOptionPane.showConfirmDialog(this,
                String.format("⚠️ Tem certeza que deseja excluir o cliente:\n\n%s\n\n" +
                    "Esta ação não pode ser desfeita!", nome),
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
            
            if (opcao == JOptionPane.YES_OPTION) {
                // Simulação de exclusão (na implementação real, usaria cadastroCliente.excluirCliente())
                JOptionPane.showMessageDialog(this,
                    String.format("✅ Cliente '%s' foi excluído do sistema!", nome),
                    "Cliente Excluído",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
      private void voltarMenu() {
        new PetShopGUI().setVisible(true);
        this.dispose();
    }
}
