
package crudeLojaRoupa.Dao;
import crudLojaRoupa.Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
/**
 * @author robsonPaiva
 */
public class ClienteDao {
    Connection conexao;
    PreparedStatement stm;
    ResultSet rs;
    ArrayList<Cliente> lista = new ArrayList<>();
    
    public ClienteDao(){
        conexao = new ConnectionFactory().getConnection();
    }
    
    /**
     *
     * @param cliente
     */
    public void criarCliente(Cliente cliente){
        String sql = "insert into cliente(nome,cpf,telefone,email) values(?,?,?,?)";
        
        try {
            stm = conexao.prepareStatement(sql);
            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getCpf());
            stm.setString(3, cliente.getTelefone());
            stm.setString(4, cliente.getEmail());
            stm.execute();
            stm.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cadastrar aluno"+e);
        }
    }
    public ArrayList<Cliente> readyCliente(){
       String sql = "select * from cliente";
       
        try {
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                
                lista.add(cliente);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro em listar cliente" + e);
        }
        return lista;
        
      }
    
    public ArrayList<Cliente> pesquisarCliente(String desc){
       String sql = "select * from cliente where nome like '%"+desc+"%'" ;
       
        try {
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                
                lista.add(cliente);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro em listar cliente" + e);
        }
        return lista;
        
      }
    
    public void excluirCliente(Cliente cliente){
        String sql = "delete from cliente where id = ?";
        try {
            stm = conexao.prepareStatement(sql);
            stm.setInt(1, cliente.getId());
            stm.execute();
            stm.close();
        } catch (Exception e) {
        }
    }
    
    public void atualizarCliente(Cliente cliente){
        String sql = "update cliente set nome = ?,telefone = ?, cpf = ?, email = ? where id=?";
        
        try {
            stm = conexao.prepareStatement(sql);
            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getTelefone());
            stm.setString(3, cliente.getCpf());
            stm.setString(4, cliente.getEmail());
            stm.setInt(5, cliente.getId());
            stm.execute();
            stm.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cadastrar aluno"+e);
        }
    }
    
    
    
}
