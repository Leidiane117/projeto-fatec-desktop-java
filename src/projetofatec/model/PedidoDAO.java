/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofatec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projetofatec.dto.Pedido;
import projetofatec.until.Conexao;

/**
 *
 * @author leidi
 */
public class PedidoDAO {
    private final Connection c;
    public PedidoDAO() throws SQLException, ClassNotFoundException{
        this.c = Conexao.getConexao();
    }


    public Pedido excluir(Pedido pedidoE) throws SQLException{
        String sql = "delete from pedido WHERE id = ?";
          // seta os valores
          try ( // prepared statement para inserção
                  PreparedStatement stmt = c.prepareStatement(sql)) {
              // seta os valores
              stmt.setInt(1,pedidoE.getId());
              // executa
              stmt.execute();
              stmt.close();
              c.close();
              return pedidoE;
            }   
       
    }
     public Pedido buscar(Pedido pedidoE) throws SQLException{
        String sql = "select * from pedido WHERE id = ?";
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,pedidoE.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Pedido pedidoS = null;
            while (rs.next()) {
                // criando o objeto 
                pedidoS = new Pedido(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDouble(4));
                          
                      
            }
        stmt.close();
        return pedidoS;
        }
    }  
        
            
   
     
     
     public Pedido inserir(Pedido pedidoE) throws SQLException{
        String sql;
        sql = "insert into pedido " + " (id_cliente,id_produto,valor)" + " values (?,?,?)";
    
        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setInt(1,pedidoE.getId_Cliente());
            stmt.setInt(2,pedidoE.getId_Produto());
            stmt.setDouble(3,pedidoE.getValor());
          
            
            // executa
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                pedidoE.setId(id);
            }
        stmt.close();
        return pedidoE;
    }
}
    public Pedido alterar(Pedido pedidoE) throws SQLException{
        String sql = "UPDATE pedido SET id_cliente = ? , id_produto=?, valor=? WHERE id = ?";
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores      
            stmt.setInt(1,pedidoE.getId_Cliente());
            stmt.setInt(2,pedidoE.getId_Produto());
            stmt.setDouble(3,pedidoE.getValor());
            stmt.setInt(4,pedidoE.getId());
         
            
            // executa
            stmt.execute();
            stmt.close();
        return pedidoE;
    }
 }
    
   public List<Pedido> listar(Pedido pedidoEntrada) throws SQLException{
        // usus: array armazena a lista de registros
        List<Pedido> pedidos=new ArrayList<>();
        String sql = "select * from pedido";
        // seta os valores
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    // criando 
                    Pedido pedido;
                    pedido = new Pedido(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getDouble(4));
                            
                            
                   
                    // adiciona o usu à lista de usus
                    pedidos.add(pedido); 
                }
                
                rs.close();
                stmt.close();
                return pedidos;
            }
       
    
     
  

}
     





