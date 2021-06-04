package com.projeto.DAO;

import com.projeto.conexao.GerenciadorConexao;
import com.projeto.entidade.Funcionario;
import com.projeto.entidade.Suporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de acesso a dados do Suporte.<br> uma série de métodos de manipulação do banco de dados relativo ao Suporte.
 * <br><b>Observação</b> caso tem alguma falha no comando SQL, irá retornar uma mensagem(<b>IllegalArgumentException</b>) com o erro.
 * @author Icaro
 */
public class SuporteDAO {
    
    /**
     * método que gera uma lista com as requisições ao suporte filtrada pela filial que não fora finalizadas.
     * @param fun Entidade que referencia a filial.
     * @return Retorna uma <b>List</b> com o requisições.
     */
    public static List<Suporte> RequisicaoFilial(Funcionario fun){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Suporte> MSuporte = new ArrayList<>();
        
        String QUERY ="SELECT ID_suporte, topico, assunto, resposta FROM suporte " +
            "INNER JOIN Funcionario ON Funcionario.ID_Funcionario = suporte.FK_Funcionario " +
            "WHERE FK_Flial = ? AND resposta = 0";

        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(QUERY);
            
            instrucaoSQL.setInt(1, fun.getFilialId());
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {                
                int ID_suporte = rs.getInt("ID_suporte");
                String topico = rs.getString("topico");
                String assunto = rs.getString("assunto");
                boolean resposta = rs.getBoolean("resposta");
                
                Suporte sup = new Suporte(ID_suporte, topico, assunto, resposta);
                sup.setID_Requisicao(ID_suporte);
                
                MSuporte.add(sup);
            }
            return MSuporte;
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
     * método que pega os dados de uma requisição em específico.
     * @param sup Entidade que referencia a requisição.
     * @return retorna uma entidade com os dados.
     */
    public static Suporte RequisicaoID(Suporte sup){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        String QUERY ="SELECT topico, assunto, descricao, Email, resposta FROM suporte " +
            "INNER JOIN Funcionario ON Funcionario.ID_Funcionario = suporte.FK_Funcionario " +
            "WHERE ID_suporte = ?";
        
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(QUERY);
            
            instrucaoSQL.setInt(1, sup.getID_Requisicao());
            rs = instrucaoSQL.executeQuery();
            
            if (rs.next()) {
                sup.setTopico(rs.getString("topico"));
                sup.setAssunto(rs.getString("assunto"));
                sup.setDescricao(rs.getString("descricao"));
                sup.setResposta(rs.getBoolean("resposta"));
                sup.setEmail(rs.getString("Email"));
                return sup;
            }else{
                throw new IllegalArgumentException("Requisição não encontrada");
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
    }
    
    /**
     * método que gera uma lista com todos os dados de uma requisição.
     * @param sup entidade tem parecia a "linha" de comunicação
     * @return Retorna uma <b>List</b> com a comunicação do funcionário com suporte.
     */
    public static List<Suporte> RequisicaoCorrente(Suporte sup){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Suporte> MSuporte = new ArrayList<>();
        
        String QUERY ="SELECT topico, assunto, Descricao, Email FROM suporte " +
            "INNER JOIN Funcionario ON Funcionario.ID_Funcionario = suporte.FK_Funcionario " +
            "WHERE ID_suporte = ? OR referencia = ?";
        
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(QUERY);
            
            instrucaoSQL.setInt(1, sup.getID_Requisicao());
            instrucaoSQL.setInt(2, sup.getID_Requisicao());
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                String Topico = rs.getString("topico");
                String Assunto = rs.getString("assunto");
                String Descricao = rs.getString("Descricao");
                String Email = rs.getString("Email");
                Suporte suporte = new Suporte(Topico, Assunto, Descricao, Email);
                MSuporte.add(suporte);
            }
            return MSuporte;
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
     * método que gera uma lista com todas as requisições de um funcionário em específico.
     * @param fucionario Entidade que referencia o funcionário.
     * @return Retorna uma <b>List</b> com todas as requisições de um funcionário.
     */
    public static List<Suporte> MinhaRequisicao(Funcionario fucionario){
       
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Suporte> MSuporte = new ArrayList<>();
        
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT ID_suporte, topico, assunto, resposta FROM suporte WHERE FK_Funcionario = ? ORDER BY ID_suporte DESC");
            
            instrucaoSQL.setInt(1, fucionario.getID());
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {                
                int ID_suporte = rs.getInt("ID_suporte");
                String topico = rs.getString("topico");
                String assunto = rs.getString("assunto");
                boolean resposta = rs.getBoolean("resposta");
                
                Suporte sup = new Suporte(ID_suporte, topico, assunto, resposta);
                sup.setID_Requisicao(ID_suporte);
                
                MSuporte.add(sup);
            }
            return MSuporte;
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
     * método que gera uma nova requisição de um funcionário.
     * @param sup Entidade com a requisição.
     * @return <b>true</b> se a nova requisição foi gerada com sucesso <b>false</b> se não for.
     */
    public static boolean NovaRequisicao(Suporte sup){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO suporte (topico, assunto, descricao, resposta, FK_Funcionario) VALUES (?,?,?,?,?)");

            instrucaoSQL.setString(1, sup.getTopico());
            instrucaoSQL.setString(2, sup.getAssunto());
            instrucaoSQL.setString(3, sup.getDescricao());
            instrucaoSQL.setBoolean(4, sup.isResposta());
            instrucaoSQL.setInt(5, sup.getID_Funcionario());

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
     * método que gera uma resposta a requisição do funcionário.<br>
     * ela pode finalizar a requisição ou deixar em aberto.
     * @param sup Entidade com a resposta da requisição.
     * @return <b>true</b> se a resposta da requisição foi gerada com sucesso <b>false</b> se não for.
     */
    public static boolean RespostaRequisicao(Suporte sup){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO suporte (topico, assunto, descricao, referencia, resposta, FK_Funcionario) VALUES (?,?,?,?,?,?)");

            instrucaoSQL.setString(1, sup.getTopico());
            instrucaoSQL.setString(2, sup.getAssunto());
            instrucaoSQL.setString(3, sup.getDescricao());
            instrucaoSQL.setInt(4, sup.getReferencia());
            instrucaoSQL.setBoolean(5, sup.isResposta());
            instrucaoSQL.setInt(6, sup.getID_Funcionario());

            int linhaAfetadas = instrucaoSQL.executeUpdate();
            
            if (linhaAfetadas > 0) {
                instrucaoSQL = conexao.prepareStatement("UPDATE suporte SET resposta = ? WHERE ID_suporte = ?");
                instrucaoSQL.setBoolean(1, sup.isResposta());
                instrucaoSQL.setInt(2, sup.getReferencia());
                
                linhaAfetadas = instrucaoSQL.executeUpdate();
                
                if (linhaAfetadas > 0) {
                    instrucaoSQL = conexao.prepareStatement("UPDATE suporte SET resposta = ? WHERE referencia = ?");
                    instrucaoSQL.setBoolean(1, sup.isResposta());
                    instrucaoSQL.setInt(2, sup.getReferencia());

                    linhaAfetadas = instrucaoSQL.executeUpdate();
                    return linhaAfetadas > 0;
                }else{
                    return false;
                }
            }else{
                return false;
            }
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
