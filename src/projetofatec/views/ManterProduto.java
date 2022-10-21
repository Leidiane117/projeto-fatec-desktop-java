/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofatec.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import projetofatec.controller.ProdutoController;
import projetofatec.dto.Produto;

/**
 *
 * @author leidi
 */
public class ManterProduto {
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
        String nome = JOptionPane.showInputDialog("NOME");
        double preco=Double.parseDouble(JOptionPane.showInputDialog("PREÇO"));
        String descricao= JOptionPane.showInputDialog("DESCRIÇÃO");
        ProdutoController produtoC=new ProdutoController();
        var novo = new Produto(nome,preco,descricao);
        produtoC.inserir(novo);
        JOptionPane.showMessageDialog(null,"cadastrado realizado com sucesso"+ " \n"+novo.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        double preco=Double.parseDouble(JOptionPane.showInputDialog("PREÇO"));
        String descricao= JOptionPane.showInputDialog("DESCRIÇÃO");
        ProdutoController produtoC=new ProdutoController();
        var novo = new Produto(id,nome,preco,descricao);
        produtoC.alterar(novo);
        JOptionPane.showMessageDialog(null,"alterado com sucesso" + "\n "  +novo.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ProdutoController produtoC=new ProdutoController();
        var novo = new Produto(id);
        novo = produtoC.buscar(novo);
        JOptionPane.showMessageDialog(null,novo.toString());
      
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Produto  produtoE=new Produto();
        ProdutoController produtoC=new ProdutoController();
        Produto produtoS= produtoC.excluir(produtoE);
        JOptionPane.showMessageDialog(null,produtoS.toString());
        
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        Produto produto = new Produto();
        ProdutoController produtoC=new ProdutoController();
        List<Produto> listaProduto = produtoC.listar(produto);
        for (Produto produtoSaida : listaProduto) {
            JOptionPane.showMessageDialog(null,produtoSaida.toString());
        }
    }
    
}
    

