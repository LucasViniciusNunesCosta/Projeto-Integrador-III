/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author lucas vinicius
 */

public class FilialDAO {
    /**
     * método serve para cadastrar uma nova filial no banco de dados
     * @param filial cadastra filial
     * @return retorna verdadeiro se o cadastro for um sucesso e falso de for mal sucedido
     */
    public static boolean cadastrar (Filial filial){
       
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        String query = "insert into Filial (Cidade, Estado, CEP, Endereco, Numero, Complemento) VALUES (?,?,?,?,?,?)";
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(query);
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
    public static List<Filial > getFiliais(){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Filial> Filiais = new ArrayList<>();
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Filial");
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                int ID_Filial = rs.getInt("ID_Filial");
                String Estado = rs.getString("Estado");
                int CEP = rs.getInt("CEP");
                String Endereco = rs.getString("Endereco");
                int Numero = rs.getInt("Numero");
                String Complemento = rs.getString("Complemento");
                String Cidade = rs.getString("Cidade");
                
                Filial fil = new Filial(ID_Filial, CEP, Estado, Endereco, Numero, Complemento, Cidade);
                
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
    public static Filial getFuncionario(Filial filial){
        
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
     public static boolean Atualizar(Filial filial){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE Filial SET Cidade = ?, Estado = ?, CEP = ?, Endereco = ?, Numero = ?, Complemento = ?");
            
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
}
