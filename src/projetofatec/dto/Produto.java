/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofatec.dto;

/**
 *
 * @author leidi
 */
public class Produto {
    private int id;
    private String nome;
    private double preco;
    private String descricao;
    
    // inserir
    public Produto(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }
    //alterar
    public Produto(int id, String nome, double preco, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }
    //listar
    public Produto(String nome)
    {
        this.nome= nome;
        
    }
    public Produto(int id)
    {
        this.id= id;
        
    }
    //listar tudo
    public Produto()
    {
        
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
 

    @Override
    public String toString() {
        return "Produto{" + "\nid=" + id + ", \nnome=" + nome + ", \npreco=" + preco + '}';
    }
    
    
    
    
}
