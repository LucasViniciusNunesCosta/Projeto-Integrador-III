package com.projeto.DAO;

import com.projeto.conexao.GerenciadorConexao;
import com.projeto.entidade.Funcionario;
import com.projeto.entidade.FuncionarioCargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de acesso a dados de Funcionarios.<br> uma série de métodos de manipulação do banco de dados relativo ao funcionário.
 * <br><b>Observação</b> caso tem alguma falha no comando SQL, irá retornar uma mensagem(<b>IllegalArgumentException</b>) com o erro.
 * @author Icaro
 * @author lucas vinicius
 */
public class FuncionarioDAO {
    
    /**
     * método para adicionar os dados do funcionário no banco de dados.
     * @param funcionario Entidade a ser adicionar.
     * @return <b>true</b> se a adicionar foi bem sucedida <b>false</b> se não for.
     */
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
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
    }
   
    /**
     * método para pegar todos os dados <b>exceto a senha</b> da tabela Funcionario no banco de dados.
     * @return Retorna uma <b>List</b> com todas os Funcionario<br> se nenhum Funcionario foram encontrado, retorna uma <b>List</b> vazia.
     */
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
            return Funcionarios;
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
     * método usado para buscar um funcionario em específico.<br><b>Não pega a senha do funcionario.</b> 
     * @param funcionario Entidade identifica o funcionario a ser buscar.
     * @return Retorna uma entidade Funcionario se o funcionario foi encontrado, se não retorna uma mensagem(<b>IllegalArgumentException</b>) que o funcionario não foi encontrado.
     */
    public static Funcionario getFuncionario(Funcionario funcionario){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareCall("SELECT * FROM Funcionario WHERE ID_Funcionario = ?");
            
            instrucaoSQL.setInt(1, funcionario.getID());
            rs = instrucaoSQL.executeQuery();
            
            if (rs.next()) {
                funcionario.setID(rs.getInt("ID_Funcionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSobrenome(rs.getString("Sobrenome"));
                funcionario.setEmail(rs.getString("Email"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setAtuacao(rs.getString("Atuacao"));
                funcionario.setSalario(rs.getDouble("Salario"));
                funcionario.setFilialId(rs.getInt("FK_Flial"));
                return funcionario;
            }else{
                throw new IllegalArgumentException("funcionario não foi encontrado");
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
     * Método para excluir um Funcionario do banco de dados.
     * @param funcionario Entidade identifica o Funcionario a ser excluído.
     * @return <b>true</b> se a exclusão foi bem sucedida <b>false</b> se não for.
     */
    public static boolean Excluir(Funcionario funcionario){
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM Funcionario WHERE ID_Funcionario = ?");
            
            instrucaoSQL.setInt(1, funcionario.getID());
            
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
     * método para atualizar os dados do Funcionario.<br><b>Não atualiza senha.</b>
     * @param funcionario Entidade a ser atualizar e os demais dados.
     * @return <b>true</b> se a Atualizar foi bem sucedida <b>false</b> se não for.
     */
    public static boolean Atualizar(Funcionario funcionario){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE Funcionario SET Nome = ?, Sobrenome = ?, Email = ?, CPF = ?, Atuacao = ?, Salario = ?, FK_Flial = ? WHERE ID_Funcionario = ?");
            
            instrucaoSQL.setString(1, funcionario.getNome());
            instrucaoSQL.setString(2, funcionario.getSobrenome());
            instrucaoSQL.setString(3, funcionario.getEmail());
            instrucaoSQL.setString(4, funcionario.getCpf());
            instrucaoSQL.setString(5, funcionario.getAtuacao());
            instrucaoSQL.setDouble(6, funcionario.getSalario());
            instrucaoSQL.setInt(7, funcionario.getFilialId());
            instrucaoSQL.setInt(8, funcionario.getID());
            
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
     * método que pega os dados necessários para fazer um login.
     * @param funcionario Entidade identifica o funcionario a fazer login.
     * @return Retorna uma entidade FuncionarioCargo se o funcionario foi encontrado, se não retorna uma mensagem(<b>IllegalArgumentException</b>) que o E-mail não foi encontrado.
     */
    public static FuncionarioCargo login(Funcionario funcionario){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareCall("SELECT ID_Funcionario, Senha, nome, Atuacao, FK_Flial FROM Funcionario WHERE Email = ?");
            
            instrucaoSQL.setString(1, funcionario.getEmail());
            rs = instrucaoSQL.executeQuery();
            
            if (rs.next()) {
                funcionario.setID(rs.getInt("ID_Funcionario"));
                funcionario.setSenhaFechada(rs.getString("Senha"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setAtuacao(rs.getString("Atuacao"));
                funcionario.setFilialId(rs.getInt("FK_Flial"));
                FuncionarioCargo funcargo = new FuncionarioCargo(funcionario.getFilialId(), funcionario.getAtuacao(), funcionario.getSalario(), funcionario.getNome(), funcionario.getSobrenome(), funcionario.getCpf(), funcionario.getEmail(), funcionario.getSenhaFechada());
                return funcargo;
            }else{
                throw new IllegalArgumentException("E-mail não encontrado");
            }
        }catch (SQLException | IllegalArgumentException e){
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