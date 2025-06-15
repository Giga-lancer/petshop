/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshoppar;

import java.util.List;

/**
 * Classe para representar um cliente do Pet Shop
 * @author Nappada
 */
public class Cliente {
    private final String dono;
    private final List<String> pets;
    private final String telefone;
    
    public Cliente(String dono, List<String> pets, String telefone) {
        this.dono = dono;
        this.pets = pets;
        this.telefone = telefone;
    }
    
    public String getDono() { 
        return dono; 
    }
    
    public List<String> getPets() { 
        return pets; 
    }
    
    public String getTelefone() { 
        return telefone; 
    }
    
    public void adicionarPet(String nome) {
        pets.add(nome);
    }
    
    @Override
    public String toString() {
        return String.format("Cliente{dono='%s', pets=%s, telefone='%s'}", dono, pets, telefone);
    }
}
