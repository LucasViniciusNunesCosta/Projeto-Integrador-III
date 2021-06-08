package com.projeto.DAO;

import com.projeto.conexao.GerenciadorConexao;
import com.projeto.entidade.Filial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de acesso a dados do Filial.<br> uma série de métodos de manipulação do banco de dados relativo as Filial.
 * <br><b>Observação</b> caso tem alguma falha no comando SQL, irá retornar uma mensagem(<b>IllegalArgumentException</b>) com o erro.
 * @author Icaro
 * @author lucas vinicius
 */
public class FilialDAO {
    
    /**
     * método para adicionar os dados da filial no banco de dados.
     * @param filial Entidade a ser adicionar.
     * @return <b>true</b> se a adicionar foi bem sucedida <b>false</b> se não for.
     */
    public static boolean cadastrar (Filial filial){
       
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO Filial (Cidade, Estado, CEP, Endereco, Numero, Complemento) VALUES (?,?,?,?,?,?)");
            
            instrucaoSQL.setString(1, filial.getCidade());
            instrucaoSQL.setString(2, filial.getEstado());
            instrucaoSQL.setInt(3, filial.getCEP());
            instrucaoSQL.setString(4, filial.getEndereco());
            instrucaoSQL.setInt(5, filial.getNumero());
            instrucaoSQL.setString(6, filial.getComplemento());

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
     * método para pegar todos os dados da tabela Filial no banco de dados.
     * @return Retorna uma <b>List</b> com todas as Filials<br> se nenhum Filial foram encontrado, retorna uma <b>List</b> vazia.
     */
    public static List<Filial> getFiliais(){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Filial> Filiais = new ArrayList<>();
        
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Filial");
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                int ID_Filial = rs.getInt("ID_Flial");
                String Estado = rs.getString("Estado");
                int CEP = rs.getInt("CEP");
                String Endereco = rs.getString("Endereco");
                int Numero = rs.getInt("Numero");
                String Complemento = rs.getString("Complemento");
                String Cidade = rs.getString("Cidade");
                
                Filial fil = new Filial(ID_Filial, Cidade, Estado, CEP, Endereco, Numero, Complemento);
                Filiais.add(fil);
            }
            return Filiais;
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
     * método usado para buscar um Filial de acordo com o Endereço.
     * @param filial Entidade que referencia a Filial a ser buscado.
     * @return Retorna uma <b>List</b> com todas as Filials<br> se nenhum Filial foram encontrado, retorna uma <b>List</b> vazia.
     */
    public static List<Filial> BuscarFilial(Filial filial){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Filial> Filiais = new ArrayList<>();
        
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Filial WHERE Endereco LIKE ? ");
            
            instrucaoSQL.setString(1, "%" + filial.getEndereco() + "%");
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                int ID_Filial = rs.getInt("ID_Flial");
                String Estado = rs.getString("Estado");
                int CEP = rs.getInt("CEP");
                String Endereco = rs.getString("Endereco");
                int Numero = rs.getInt("Numero");
                String Complemento = rs.getString("Complemento");
                String Cidade = rs.getString("Cidade");
                
                Filial fil = new Filial(ID_Filial, Cidade, Estado, CEP, Endereco, Numero, Complemento);
                Filiais.add(fil);
            }
            return Filiais;
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
     * método usado para buscar um Filial em específico.
     * @param filial Entidade identifica o Filial a ser buscar.
     * @return Retorna uma entidade Filial se a Filial foi encontrado, se não retorna uma mensagem(<b>IllegalArgumentException</b>) que a Filial não foi encontrado.
     */
    public static Filial getFilial(Filial filial){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareCall("SELECT * FROM Filial WHERE ID_Flial = ?");
            
            instrucaoSQL.setInt(1, filial.getID_filial());
            rs = instrucaoSQL.executeQuery();
            
            if (rs.next()) {
                filial.setID_filial(rs.getInt("ID_Flial"));
                filial.setCidade(rs.getString("Cidade"));
                filial.setEstado(rs.getString("Estado"));
                filial.setCEP(rs.getInt("CEP"));
                filial.setEndereco(rs.getString("Endereco"));
                filial.setNumero(rs.getInt("Numero"));
                filial.setComplemento(rs.getString("Complemento"));
                return filial;
            }else{
                throw new IllegalArgumentException("Filial não foi encontrada");
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
     * Método para excluir um Filial do banco de dados.
     * @param filial Entidade identifica o Filial a ser excluído.
     * @return <b>true</b> se a exclusão foi bem sucedida <b>false</b> se não for.
     */
    public static boolean Excluir(Filial filial){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM Filial WHERE ID_Flial = ?");
            
            instrucaoSQL.setInt(1, filial.getID_filial());
            
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
     * método para atualizar os dados da Filial.
     * @param filial Entidade a ser atualizar e os demais dados.
     * @return <b>true</b> se a Atualizar foi bem sucedida <b>false</b> se não for.
     */
    public static boolean Atualizar(Filial filial){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE Filial SET Cidade = ?, Estado = ?, CEP = ?, Endereco = ?, Numero = ?, Complemento = ? WHERE ID_Flial = ?");
            
            instrucaoSQL.setString(1, filial.getCidade());
            instrucaoSQL.setString(2, filial.getEstado());
            instrucaoSQL.setInt(3, filial.getCEP());
            instrucaoSQL.setString(4, filial.getEndereco());
            instrucaoSQL.setInt(5, filial.getNumero());
            instrucaoSQL.setString(6, filial.getComplemento());
            instrucaoSQL.setInt(7, filial.getID_filial());
            
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