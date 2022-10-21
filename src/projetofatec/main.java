
package projetofatec;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import projetofatec.views.ManterCliente;
import projetofatec.views.ManterPedido;
import projetofatec.views.ManterProduto;

/**
 *
 * @author leidi
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        String usuario = JOptionPane.showInputDialog("USUARIO");
        String senha = JOptionPane.showInputDialog("SENHA");
       if (!"admin".equals(usuario)  ||  !"123".equals(senha))
     {         
       JOptionPane.showMessageDialog(null, "Senha ou usuário inválidos!","Atenção:", JOptionPane.ERROR_MESSAGE);
        
     
     }
       else{
            try {
                menu();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
       
       }
       
    }
  
    
     public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 0 - Sair \n 1 - Cliente \n 2 - Produto \n 3 - Pedido \n";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair?","Sair...",JOptionPane.YES_NO_OPTION);
                if (sair > 0) menu();
           
                break;
            case 1:
                ManterCliente.menu();
                break;
            case 2:
                ManterProduto.menu();
                break;
            case 3:
                ManterPedido.menu();
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
    
}

  