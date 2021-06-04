package com.projeto.DAO;

import com.projeto.conexao.GerenciadorConexao;
import com.projeto.entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de acesso a dados de Clientes.<br> uma série de métodos de manipulação do banco de dados relativo ao Cliente.
 * <br><b>Observação</b> caso tem alguma falha no comando SQL, irá retornar uma mensagem(<b>IllegalArgumentException</b>) com o erro.
 * @author Icaro
 */
public class ClienteDAO {
    
    /**
     * Método para excluir um Client do banco de dados.
     * @param cliente Entidade identifica o cliente a ser excluído.
     * @return <b>true</b> se a exclusão foi bem sucedida <b>false</b> se não for.
     */
    public static boolean Excluir(Cliente cliente){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM Cliente WHERE ID_Cliente = ?");
            
            instrucaoSQL.setInt(1, cliente.getID_Cliente());
            
            int linhaAfetadas = instrucaoSQL.executeUpdate();
            return linhaAfetadas > 0;
            
        } catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }finally{
            try {
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
    }
    
    /**
     * método usado para buscar um Cliente em específico.
     * @param cliente Entidade identifica o cliente a ser buscar.
     * @return Retorna uma entidade clientes se o clientes foi encontrado, se não retorna uma mensagem(<b>IllegalArgumentException</b>) que o cliente não foi encontrado.
     */
    public static Cliente getCliente(Cliente cliente){

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            
            if (cliente.getID_Cliente()>0) {
                instrucaoSQL = conexao.prepareCall("SELECT * FROM Cliente WHERE ID_Cliente = ?");
                instrucaoSQL.setInt(1, cliente.getID_Cliente());
            } else {
                instrucaoSQL = conexao.prepareCall("SELECT * FROM Cliente WHERE CPF = ?");
                instrucaoSQL.setString(1, cliente.getCPF());
            }
            
            rs = instrucaoSQL.executeQuery();
            
            if (rs.next()) {
                cliente.setID_Cliente(rs.getInt("ID_Cliente"));
                cliente.setCPF(rs.getString("CPF"));
                cliente.setNome(rs.getString("Nome"));
                return cliente;
            }else{
                throw new IllegalArgumentException("Cliente não encontrado");
            }
            
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }finally{
            try {
                if (rs!=null) {
                    rs.close();
                }
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
    }
    
    /**
     * método usado para buscar um Cliente de acordo com o nome.
     * @param cliente Entidade que referencia o cliente a ser buscado.
     * @return Retorna uma <b>List</b> com todas os Clientes<br> se nenhum cliente for encontrado, retorna uma <b>List</b> vazia.
     */
    public static List<Cliente> BuscarClientes(Cliente cliente){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareCall("SELECT * FROM Cliente WHERE Nome LIKE ? ");
            instrucaoSQL.setString(1, "%" + cliente.getNome() + "%");
            
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                int ID = rs.getInt("ID_Cliente");
                String Nome = rs.getString("Nome");
                String CPF = rs.getString("CPF");
                
                Cliente cli = new Cliente(ID, Nome, CPF);
                
                clientes.add(cli);
            }
            return clientes;
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }finally{
            try {
                if (rs!=null) {
                    rs.close();
                }
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
    }
    
    /**
     * método para atualizar os dados do cliente.
     * @param cliente Entidade a ser atualizar e os demais dados.
     * @return <b>true</b> se a Atualizar foi bem sucedida <b>false</b> se não for.
     */
    public static boolean Atualizar(Cliente cliente){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE Cliente SET Nome = ?, CPF = ? WHERE ID_Cliente = ?");
            
            instrucaoSQL.setString(1, cliente.getNome());
            instrucaoSQL.setString(2, cliente.getCPF());
            instrucaoSQL.setInt(3, cliente.getID_Cliente());
            
            int linhaAfetadas = instrucaoSQL.executeUpdate();
            return linhaAfetadas > 0;
            
        } catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }finally{
            try {
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
    }
    
    /**
     * método para adicionar os dados do cliente no banco de dados.
     * @param cliente Entidade a ser adicionar.
     * @return <b>true</b> se a adicionar foi bem sucedida <b>false</b> se não for.
     */
    public static boolean AddCliente(Cliente cliente){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        if (BobuscarCPF(cliente)) {
            throw new IllegalArgumentException("CPF já registrado");
        }else{
            try{
                conexao = GerenciadorConexao.abrirConexao();
                instrucaoSQL = conexao.prepareStatement("INSERT INTO Cliente (Nome, CPF) VALUES (?,?)");

                instrucaoSQL.setString(1, cliente.getNome());
                instrucaoSQL.setString(2, cliente.getCPF());

                int linhaAfetadas = instrucaoSQL.executeUpdate();
                return linhaAfetadas > 0;

            } catch (SQLException e){
                throw new IllegalArgumentException(e.getMessage());
            }finally{
                try {
                    if (instrucaoSQL!=null) {
                        instrucaoSQL.close();
                    }
                    if (conexao!=null) {
                        conexao.close();
                        GerenciadorConexao.fecharConexao();  
                    }
                } catch (SQLException e) {
                }
            }
        }
    }
    
    /**
     * método para pegar todos os dados da tabela cliente no banco de dados.
     * @return Retorna uma <b>List</b> com todas os Clientes<br> se nenhum cliente foram encontrado, retorna uma <b>List</b> vazia.
     */
    public static List<Cliente> getClientes(){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Cliente");
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                int ID = rs.getInt("ID_Cliente");
                String Nome = rs.getString("Nome");
                String CPF = rs.getString("CPF");
                
                Cliente cliente = new Cliente(ID, Nome, CPF);
                
                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }finally{
            try {
                if (rs!=null) {
                    rs.close();
                }
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
    }
    
    /**
     * método que verifica se existe um cliente com um CPF específico.
     * @param cliente Entidade com o CPF a ser verifica.
     * @return <b>true</b> se o CPF existe <b>false</b> se não for.
     */
    public static boolean BobuscarCPF(Cliente cliente){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareCall("SELECT CPF FROM Cliente WHERE CPF = ?");
            
            instrucaoSQL.setString(1, cliente.getCPF());
            rs = instrucaoSQL.executeQuery();

            return rs.next();
            
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }finally{
            try {
                if (rs!=null) {
                    rs.close();
                }
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
    }
}