/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofatec.controller;
import java.sql.SQLException;
import java.util.List;
import  projetofatec.model.ClienteDAO;
import  projetofatec.dto.Cliente;


/**
 *
 * @author leidi
 */
public class ClienteController {
     static ClienteDAO clienteDAO;
    
    public Cliente inserir (Cliente pes) throws SQLException, ClassNotFoundException {
        clienteDAO = new ClienteDAO (); 
        return clienteDAO.inserir(pes);
    }
    public Cliente alterar (Cliente pes) throws SQLException, ClassNotFoundException {
        clienteDAO = new ClienteDAO (); 
        return clienteDAO.alterar(pes);
    }
    public List<Cliente> listar (Cliente pes) throws SQLException, ClassNotFoundException {
        clienteDAO = new ClienteDAO (); 
        return clienteDAO.listar(pes);
    }
    public Cliente excluir(Cliente pes) throws SQLException, ClassNotFoundException {
        clienteDAO = new ClienteDAO (); 
        return clienteDAO.excluir(pes);
    }
    public Cliente buscar(Cliente pes) throws SQLException, ClassNotFoundException {
        clienteDAO = new ClienteDAO (); 
        return clienteDAO.buscar(pes);
    }

}

    
    

