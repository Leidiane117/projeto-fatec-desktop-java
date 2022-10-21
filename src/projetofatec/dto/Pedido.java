/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofatec.dto;

import java.util.List;

/**
 *
 * @author leidi
 */
public class Pedido {
    private int id_pedido;
    private int id_cliente;
    private int id_produto;
    private double valor_total;
    private Cliente  cliente;
    private Produto  produto;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    /**
     *
     * @param id
     */
    public Pedido(int id) {
        this.id_pedido= id;
    }
    
    public Pedido() {
           
    }
    
    // para inserir
    public Pedido(int id_cliente,int id_produto, double valor_total) {
        this.id_cliente= id_cliente;
        this.id_produto= id_produto;
        this.valor_total = valor_total;
    }
    
    // para alterar
    public Pedido(int id_pedido,int id_cliente,int id_produto, double valor_total) {
        this.id_pedido = id_pedido;
        this.id_cliente= id_cliente;
        this.id_produto= id_produto;
        this.valor_total = valor_total;
    }

    public int getId() {
        return id_pedido;
    }

    public void setId(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public double getValor() {
        return valor_total;
    }

    public void setValor(double valor) {
        this.valor_total = valor;
    }
   
    public int getId_Cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente=id_cliente;
    }

     public int getId_Produto() {
        return id_produto;
    }

    public void setId_Produto(int id_produto) {
        this.id_produto=id_produto;
    }

    // para impressao

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Pedido{" + "\nid=" + id_pedido + ",  \nid_cliente=" + id_cliente + "\nid_produto="+ id_produto + "\nvalor=" + valor_total + '}';
    }
    
    
    
    
}

    

