/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofatec.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projetofatec.dto.Cliente;
import projetofatec.dto.Pedido;
import projetofatec.dto.Produto;
import projetofatec.model.PedidoDAO;

/**
 *
 * @author leidi
 */
public class PedidoController {
     ClienteController contUsu;
     ProdutoController contPes;
     PedidoDAO  pedidoDAO;
     
     
      public Pedido inserir (Pedido  pedido) throws SQLException, ClassNotFoundException {
        pedidoDAO = new PedidoDAO  (); 
        pedido=pedidoDAO.inserir(pedido);
        pedidoDAO.inserir(pedido);
        return pedido;
    }
      
    public Pedido alterar (Pedido  pedido) throws SQLException, ClassNotFoundException {
        pedidoDAO = new PedidoDAO  (); 
        pedido=pedidoDAO.alterar(pedido);
        pedidoDAO.alterar(pedido);
        return pedido;
    }
    
    public List<Pedido> listar (Pedido pedido) throws SQLException, ClassNotFoundException {
        pedidoDAO = new PedidoDAO  (); 
        List<Pedido> listaUsuPesAux = pedidoDAO.listar(pedido);
        List<Pedido> listaUsuPedRetorno = new ArrayList<>();
        for(Pedido pedidoS : listaUsuPesAux) {        
            listaUsuPedRetorno .add(buscar(pedidoS));
        }
        return listaUsuPedRetorno;
    }
    
    public Pedido excluir(Pedido pedido) throws SQLException, ClassNotFoundException {
        pedidoDAO = new PedidoDAO  (); 
        pedido=pedidoDAO.excluir(pedido);
        pedidoDAO.excluir(pedido);
        return pedido;
    }
    
    public Pedido buscar(Pedido pedido) throws SQLException, ClassNotFoundException {
        pedidoDAO = new PedidoDAO  (); 
        Pedido usupesSaida = pedidoDAO.buscar(pedido);
        Cliente usuEnt = new Cliente(usupesSaida.getId_Cliente());
        contUsu = new ClienteController();
        usupesSaida.setCliente(contUsu.buscar(usuEnt));
        Produto p = new Produto(usupesSaida.getId_Produto());
        contPes = new ProdutoController();
        usupesSaida.setProduto(contPes.buscar(p));
        return usupesSaida;
        
    }

}
     
     


    
     
     
     
     
     
     
     
     
    
   

    
    


    

