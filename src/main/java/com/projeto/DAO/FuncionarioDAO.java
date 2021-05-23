package com.projeto.DAO;

import com.projeto.conexao.GerenciadorConexao;
import com.projeto.entidade.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas vinicius
 */
public class FuncionarioDAO {
    
    public static boolean cadastrar (Funcionario funcionario){
       
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        String query = "insert into FUNCIONARIO (Nome, Sobrenome, Email, Senha, CPF, Atuacao, Salario, FK_Flial) VALUES (?,?,?,?,?,?,?,?)";
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(query);
            instrucaoSQL.setString(1, funcionario.getNome());
            instrucaoSQL.setString(2, funcionario.getSobrenome());
            instrucaoSQL.setString(3, funcionario.getEmail());
            instrucaoSQL.setString(4, funcionario.getSenha());
            instrucaoSQL.setString(5, funcionario.getCpf());
            instrucaoSQL.setString(6, funcionario.getAtuacao());
            instrucaoSQL.setDouble(7, funcionario.getSalario());
            instrucaoSQL.setInt(8, funcionario.getFilialId());

            int linhaAfetadas = instrucaoSQL.executeUpdate();
            return linhaAfetadas > 0;
        } catch (SQLException e){
                throw new IllegalArgumentException(e.getMessage());
            }finally{
                try {
                    if (instrucaoSQL!=null) {
                        instrucaoSQL.close();
                    }
                    conexao.close();
                    GerenciadorConexao.fecharConexao();
                } catch (SQLException e) {
                }
            }
    }
   
    public static List<Funcionario> getFuncionarios(){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Funcionario> Funcionarios = new ArrayList<>();
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Funcionario");
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                int ID = rs.getInt("ID_Funcionario");
                int IDFlial = rs.getInt("FK_Flial");
                String Nome = rs.getString("Nome");
                String Sobrenome = rs.getString("Sobrenome");
                String Email = rs.getString("Email");
                String CPF = rs.getString("CPF");
                String Atuacao = rs.getString("Atuacao");
                double Salario = rs.getDouble("Salario");
                
                Funcionario fun = new Funcionario(IDFlial, Atuacao, Salario, Nome, Sobrenome, CPF, ID, Email);
                
                Funcionarios.add(fun);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }finally{
            try {
                if (rs!=null) {
                    rs.close();
                }
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                conexao.close();
                GerenciadorConexao.fecharConexao();
            } catch (SQLException e) {
            }
        }
        return Funcionarios;
    }
    
    public static Funcionario getFuncionario(Funcionario fun){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareCall("SELECT * FROM Funcionario WHERE ID_Funcionario = ?");
            
            instrucaoSQL.setInt(1, fun.getID());
            rs = instrucaoSQL.executeQuery();
            
            if (rs.next()) {
                fun.setID(rs.getInt("ID_Funcionario"));
                fun.setNome(rs.getString("nome"));
                fun.setSobrenome(rs.getString("Sobrenome"));
                fun.setEmail(rs.getString("Email"));
                fun.setCpf(rs.getString("CPF"));
                fun.setAtuacao(rs.getString("Atuacao"));
                fun.setSalario(rs.getDouble("Salario"));
                fun.setFilialId(rs.getInt("FK_Flial"));
                return fun;
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
                conexao.close();
                GerenciadorConexao.fecharConexao();
            } catch (SQLException e) {
            }
        }
    }
    
    public static boolean deletar(Integer Id){
        boolean ok = true;
        String query = "delete from Funcionario where id=?";
        Connection con;
        try{
            con = GerenciadorConexao.abrirConexao();
            GerenciadorConexao.abrirConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Id);
            ps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        
        return ok;
    }
    
    public static boolean Atualizar(Funcionario fun){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE Funcionario SET Nome = ?, Sobrenome = ?, Email = ?, CPF = ?, Atuacao = ?, Salario = ?, FK_Flial = ? WHERE ID_Funcionario = ?");
            
            instrucaoSQL.setString(1, fun.getNome());
            instrucaoSQL.setString(2, fun.getSobrenome());
            instrucaoSQL.setString(3, fun.getEmail());
            instrucaoSQL.setString(4, fun.getCpf());
            instrucaoSQL.setString(5, fun.getAtuacao());
            instrucaoSQL.setDouble(6, fun.getSalario());
            instrucaoSQL.setInt(7, fun.getFilialId());
            instrucaoSQL.setInt(8, fun.getID());
            
            int linhaAfetadas = instrucaoSQL.executeUpdate();
            return linhaAfetadas > 0;
            
        } catch (SQLException e){
            throw new IllegalArgumentException(e);
        }finally{
            try {
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                conexao.close();
                GerenciadorConexao.fecharConexao();
            } catch (SQLException e) {
            }
        }
    }

    public static Funcionario login(Funcionario fun){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareCall("SELECT * FROM Funcionario WHERE Email = ?");
            
            instrucaoSQL.setString(1, fun.getEmail());
            rs = instrucaoSQL.executeQuery();
            
            if (rs.next()) {
                fun.setID(rs.getInt("ID_Funcionario"));
                fun.setSenhaFechada(rs.getString("Senha"));
                fun.setNome(rs.getString("nome"));
                fun.setSobrenome(rs.getString("Sobrenome"));
                fun.setCpf(rs.getString("CPF"));
                fun.setAtuacao(rs.getString("Atuacao"));
                fun.setFilialId(rs.getInt("FK_Flial"));
                return fun;
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
                conexao.close();
                GerenciadorConexao.fecharConexao();
            } catch (SQLException e) {
            }
        }
    }
}