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
import projetofatec.dto.Produto;
import projetofatec.until.Conexao;

/**
 *
 * @author leidi
 */
public class ProdutoDAO {
    private final Connection c;
    public ProdutoDAO() throws SQLException, ClassNotFoundException{
        this.c = Conexao.getConexao();
    }


    public Produto excluir(Produto produtoE) throws SQLException{
        String sql = "delete from produto WHERE id = ?";
          // seta os valores
          try ( // prepared statement para inserção
                  PreparedStatement stmt = c.prepareStatement(sql)) {
              // seta os valores
              stmt.setInt(1,produtoE.getId());
              // executa
              stmt.execute();
              stmt.close();
              c.close();
              return produtoE;
            }   
       
    }
     public Produto buscar(Produto produtoE) throws SQLException{
        String sql;
        sql = "select * from produto WHERE id = ?";
        Produto produtoS;
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,produtoE.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            produtoS = null;
            while (rs.next()) {
                // criando o objeto 
                produtoS = new Produto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4));
            }
        stmt.close();
        return produtoS;
        }
    }  
    
     public Produto inserir(Produto produtoE) throws SQLException{
        String sql = "insert into produto " + " (nome, preco, descricao)" + " values (?,?,?)";
    
        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1,produtoE.getNome());
            stmt.setDouble(2,produtoE.getPreco());
            stmt.setString(3,produtoE.getDescricao());
            
            // executa
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                produtoE.setId(id);
            }
        stmt.close();
        return produtoE;
    }
}
    public Produto alterar(Produto produtoE) throws SQLException{
        String sql = "UPDATE produto SET nome = ?, preco = ?, descricao = ? WHERE id = ?";
        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,produtoE.getNome());
            stmt.setDouble(2,produtoE.getPreco());
            stmt.setString(3,produtoE.getDescricao());
                      
            stmt.setInt(4,produtoE.getId());
            
            // executa
            stmt.execute();
            stmt.close();
        return produtoE;
    }
 }
    
   public List<Produto> listar(Produto produtoEntrada) throws SQLException{
        // usus: array armazena a lista de registros
        List<Produto> produtoL = new ArrayList<>();
        String sql = "select * from produto";
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
                     
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // criando o objeto
                    Produto produto;
                    produto = new Produto(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDouble(3),
                            rs.getString(4)
                            
                    );
                    // adicion
                    produtoL.add(produto);
                }
                
                rs.close();
                stmt.close();
                return produtoL;
            }
        catch(SQLException ex){
              throw new RuntimeException(ex + "Algo aconteceu de errado com a conexão com a query, veja: ");
          
        
        }
        
      }
    
   }  
  

}
     




