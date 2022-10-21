/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofatec.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import projetofatec.controller.PedidoController;
import projetofatec.dto.Pedido;

/**
 *
 * @author leidi
 */
public class ManterPedido {
        public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
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
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("IDCLIENTE"));
        int idProduto = Integer.parseInt(JOptionPane.showInputDialog("IDPRODUTO"));
        double valor_total=Double.parseDouble(JOptionPane.showInputDialog("VALOR TOTAL"));
        Pedido  pedidoE= new Pedido(idCliente,idProduto,valor_total);
        PedidoController pedidoCliente=new PedidoController();  
        Pedido  pedidoS = pedidoCliente.inserir(pedidoE);
        JOptionPane.showMessageDialog(null, "cadastro realizado com sucesso"+" \n" +pedidoS.toString());
        
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int id_cliente = Integer.parseInt(JOptionPane.showInputDialog("IDCLIENTE"));
        int id_produto = Integer.parseInt(JOptionPane.showInputDialog("IDPRODUTO"));
        double valor_total=Double.parseDouble(JOptionPane.showInputDialog("VALOR TOTAL"));
        Pedido  pedidoE= new Pedido(id,id_cliente,id_produto,valor_total);
        PedidoController pedidoCliente=new PedidoController();  
        Pedido  pedidoS = pedidoCliente.alterar(pedidoE);
        JOptionPane.showMessageDialog(null, "alterado com sucesso" + " \n"+pedidoS.toString());
       
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pedido  pedidoE= new Pedido(id);
        PedidoController pedidoCliente=new PedidoController();  
        Pedido  pedidoS = pedidoCliente.buscar(pedidoE);
        JOptionPane.showMessageDialog(null, pedidoS.toString());
      
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pedido  pedidoE= new Pedido(id);
        PedidoController pedidoCliente=new PedidoController();  
        Pedido  pedidoS = pedidoCliente.excluir(pedidoE);
        JOptionPane.showMessageDialog(null, "excluído com sucesso" +" \n" +pedidoS.toString());
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        Pedido  pedidoE= new Pedido();
        PedidoController pedidoCliente=new PedidoController(); 
        List <Pedido> listaPedido = pedidoCliente.listar(pedidoE);
        listaPedido.forEach(pedidoS -> {
            JOptionPane.showMessageDialog(null, pedidoS.toString());
            JOptionPane.showMessageDialog(null, pedidoS.getCliente().toString());
            JOptionPane.showMessageDialog(null, pedidoS.getProduto().toString());         
          
            });
    }
    
}

