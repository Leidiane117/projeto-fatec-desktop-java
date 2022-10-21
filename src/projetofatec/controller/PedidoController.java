/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofatec.controller;

import java.sql.SQLException;
import java.util.List;
import projetofatec.dto.Pedido;
import projetofatec.model.PedidoDAO;

/**
 *
 * @author leidi
 */
public class PedidoController {
     static PedidoDAO  pedidoDAO;
    
    public Pedido inserir (Pedido  pedido) throws SQLException, ClassNotFoundException {
        pedidoDAO = new PedidoDAO  (); 
        return pedidoDAO.inserir(pedido);
    }
    public Pedido alterar (Pedido  pedido) throws SQLException, ClassNotFoundException {
        pedidoDAO = new PedidoDAO  (); 
        return pedidoDAO.alterar(pedido);
    }
    public List<Pedido> listar (Pedido pedido) throws SQLException, ClassNotFoundException {
        pedidoDAO = new PedidoDAO  (); 
        return pedidoDAO.listar(pedido);
    }
    public Pedido excluir(Pedido pedido) throws SQLException, ClassNotFoundException {
       pedidoDAO = new PedidoDAO  (); 
        return pedidoDAO.excluir(pedido);
    }
    public Pedido buscar(Pedido pedido) throws SQLException, ClassNotFoundException {
        pedidoDAO = new PedidoDAO  (); 
        return pedidoDAO.buscar(pedido);
    }

}

    
    


    

