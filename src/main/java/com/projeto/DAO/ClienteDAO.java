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
 *
 * @author Icaro
 */
public class ClienteDAO {
    
    public static boolean Excluir(Cliente cli){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM Cliente WHERE ID_Cliente = ?");
            
            instrucaoSQL.setInt(1, cli.getID_Cliente());
            
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
    
    public static Cliente getCliente(Cliente cli){

        ResultSet rs;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            
            if (cli.getID_Cliente()>0) {
                instrucaoSQL = conexao.prepareCall("SELECT * FROM Cliente WHERE ID_Cliente = ?");
                instrucaoSQL.setInt(1, cli.getID_Cliente());
            } else {
                instrucaoSQL = conexao.prepareCall("SELECT * FROM Cliente WHERE CPF = ?");
                instrucaoSQL.setString(1, cli.getCPF());
            }
            
            rs = instrucaoSQL.executeQuery();
            
            if (rs.next()) {
                cli.setID_Cliente(rs.getInt("ID_Cliente"));
                cli.setCPF(rs.getString("CPF"));
                cli.setNome(rs.getString("Nome"));
                return cli;
            }else{
                throw new IllegalArgumentException("erro");
            }
            
        }catch (SQLException e){
            throw new IllegalArgumentException(e);
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
    
    public static boolean Atualizar(Cliente cli){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE Cliente SET Nome = ?, CPF = ? WHERE ID_Cliente = ?");
            
            instrucaoSQL.setString(1, cli.getNome());
            instrucaoSQL.setString(2, cli.getCPF());
            instrucaoSQL.setInt(3, cli.getID_Cliente());
            
            int linhaAfetadas = instrucaoSQL.executeUpdate();
            return linhaAfetadas > 0;
            
        } catch (SQLException e){
            throw new IllegalArgumentException(e);
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
    
    public static boolean AddCliente(Cliente cli){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        if (BobuscarCPF(cli)) {
            throw new IllegalArgumentException("CPF já registrado");
        }else{
            try{
                conexao = GerenciadorConexao.abrirConexao();
                instrucaoSQL = conexao.prepareStatement("INSERT INTO Cliente (Nome, CPF) VALUES (?,?)");

                instrucaoSQL.setString(1, cli.getNome());
                instrucaoSQL.setString(2, cli.getCPF());

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
        return clientes;
    }
    
    public static boolean BobuscarCPF(Cliente cli){
        
        ResultSet rs;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareCall("SELECT CPF FROM Cliente WHERE CPF = ?");
            
            instrucaoSQL.setString(1, cli.getCPF());
            rs = instrucaoSQL.executeQuery();
            
            if (rs.next()) {
                return true;
            }else{
                throw new IllegalArgumentException("Cliente não cadastrado");
            }
            
        }catch (SQLException e){
            throw new IllegalArgumentException(e);
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