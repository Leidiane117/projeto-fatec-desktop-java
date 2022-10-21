/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofatec.controller;

import java.sql.SQLException;
import java.util.List;
import projetofatec.dto.Produto;
import projetofatec.model.ProdutoDAO;


/**
 *
 * @author leidi
 */
public class ProdutoController {
     static ProdutoDAO produtoDAO;
    
    public Produto inserir (Produto produto) throws SQLException, ClassNotFoundException {
        produtoDAO = new ProdutoDAO (); 
        return produtoDAO.inserir(produto);
    }
    public Produto alterar (Produto produto) throws SQLException, ClassNotFoundException {
        produtoDAO = new ProdutoDAO (); 
        return produtoDAO.alterar(produto);
    }
    public List<Produto> listar (Produto produto) throws SQLException, ClassNotFoundException {
        produtoDAO = new ProdutoDAO (); 
        return produtoDAO.listar(produto);
    }
    public Produto excluir(Produto produto) throws SQLException, ClassNotFoundException {
        produtoDAO = new ProdutoDAO (); 
        return produtoDAO.excluir(produto);
    }
    public Produto  buscar(Produto produto) throws SQLException, ClassNotFoundException {
        produtoDAO = new ProdutoDAO (); 
        return produtoDAO.buscar(produto);
    }

}

    
    



