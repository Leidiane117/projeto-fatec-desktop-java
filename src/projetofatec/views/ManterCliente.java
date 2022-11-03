/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofatec.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import projetofatec.controller.ClienteController;
import projetofatec.dto.Cliente;

/**
 *
 * @author leidi
 */
public class ManterCliente {
     public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - Buscar \n 4 - Excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opcao inválida");
        }
    }

    public static void inserir() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        String celular = JOptionPane.showInputDialog("CELULAR");
        String email = JOptionPane.showInputDialog("EMAIL");
        ClienteController clienteC=new ClienteController();
        var novo = new Cliente(nome,celular,email);
        clienteC.inserir(novo);
        JOptionPane.showMessageDialog(null,"cadastro realizado com sucesso! "+ "\n "+novo.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String celular = JOptionPane.showInputDialog("CELULAR");
        String email = JOptionPane.showInputDialog("EMAIL");
        ClienteController clienteC=new ClienteController();
        var novo = new Cliente(id,nome,celular,email);
        clienteC.alterar(novo);
        JOptionPane.showMessageDialog(null,"alterado com sucesso! "+" \n"+novo.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ClienteController clienteC=new ClienteController();
        var novo = new Cliente(id);
        novo = clienteC.buscar(novo);
        JOptionPane.showMessageDialog(null,novo.toString());
      
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Cliente cliente = new Cliente(id);
        ClienteController clienteC =new ClienteController();
        cliente = clienteC.excluir(cliente);
        JOptionPane.showMessageDialog(null,"excluído com sucesso! "+"\n "+cliente.toString());
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Cliente pes = new Cliente(nome);
        ClienteController contpes = new ClienteController();
        List<Cliente> listaPes = contpes.listar(pes);
        for (Cliente pesSaida : listaPes) {
            JOptionPane.showMessageDialog(null,pesSaida.toString());
        }
    }
    
}

    

