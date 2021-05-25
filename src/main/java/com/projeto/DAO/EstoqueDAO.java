package com.projeto.DAO;

import com.projeto.conexao.GerenciadorConexao;
import com.projeto.entidade.Estoque;
import com.projeto.entidade.Filial;
import com.projeto.entidade.Item;
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
public class EstoqueDAO {
    
    public static boolean Excluir(Estoque est){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM Estoque WHERE ID_Estoque = ?");
            
            instrucaoSQL.setInt(1, est.getID());
            
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
    
    public static Estoque getProduto(Estoque est){

        ResultSet rs;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareCall("SELECT * FROM Estoque WHERE ID_Estoque = ?");
            
            instrucaoSQL.setInt(1, est.getID());
            rs = instrucaoSQL.executeQuery();
            
            if (rs.next()) {
                String Nome = rs.getString("Nome");
                String Marca = rs.getString("Marca");
                String Catogoria = rs.getString("Categoria");
                int QTD = rs.getInt("Quantidade");
                double V_compra = rs.getDouble("V_compra");
                double V_venda = rs.getDouble("V_venda");
                int Filia_ID = rs.getInt("FK_Filial");
                est.setNome(Nome);
                est.setMarca(Marca);
                est.setCategoria(Catogoria);
                est.setQTD(QTD);
                est.setV_compra(V_compra);
                est.setV_venda(V_venda);
                est.setFiliaID(Filia_ID);
                return est;
            }else{
                throw new IllegalArgumentException("Não encontrado");
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
    
    public static Item getItem(Item est){

        ResultSet rs;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareCall("SELECT * FROM Estoque WHERE ID_Estoque = ?");
            
            instrucaoSQL.setInt(1, est.getID());
            rs = instrucaoSQL.executeQuery();
            
            if (rs.next()) {
                est.setNome(rs.getString("Nome"));
                est.setMarca(rs.getString("Marca"));
                est.setV_venda(rs.getDouble("V_venda"));
                return est;
            }else{
                throw new IllegalArgumentException("Não encontrado");
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
    
    public static boolean Atualizar(Estoque pro){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE Estoque SET Nome = ?, Marca = ?, Categoria = ?, Quantidade = ?, V_compra = ?, V_venda = ?, FK_Filial = ? WHERE ID_Estoque = ?");
            
            instrucaoSQL.setString(1, pro.getNome());
            instrucaoSQL.setString(2, pro.getMarca());
            instrucaoSQL.setString(3, pro.getCategoria());
            instrucaoSQL.setInt(4, pro.getQTD());
            instrucaoSQL.setDouble(5, pro.getV_compra());
            instrucaoSQL.setDouble(6, pro.getV_venda());
            instrucaoSQL.setInt(7, pro.getFiliaID());
            instrucaoSQL.setInt(8, pro.getID());
            
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
    
    public static boolean AddEstoque(Estoque pro){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO Estoque (Nome, Marca, Categoria, Quantidade, V_compra, V_venda, FK_Filial) VALUES (?,?,?,?,?,?,?)");
            
            instrucaoSQL.setString(1, pro.getNome());
            instrucaoSQL.setString(2, pro.getMarca());
            instrucaoSQL.setString(3, pro.getCategoria());
            instrucaoSQL.setInt(4, pro.getQTD());
            instrucaoSQL.setDouble(5, pro.getV_compra());
            instrucaoSQL.setDouble(6, pro.getV_venda());
            instrucaoSQL.setInt(7, pro.getFiliaID());
            
            
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
    
    public static List<Estoque> getEstoque(){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Estoque> estoque = new ArrayList<>();
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Estoque");
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                int ID = rs.getInt("ID_Estoque");
                String Nome = rs.getString("Nome");
                String Marca = rs.getString("Marca");
                String Catogoria = rs.getString("Categoria");
                int QTD = rs.getInt("Quantidade");
                double V_compra = rs.getDouble("V_compra");
                double V_venda = rs.getDouble("V_venda");
                int Filia_ID = rs.getInt("FK_Filial");
                
                Estoque produto = new Estoque(ID, Filia_ID, Nome, Marca, Catogoria, QTD, V_compra, V_venda);
                
                estoque.add(produto);
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
        return estoque;
    }
    
    public static List<Estoque> getEstoqueFilial(Filial fil){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Estoque> estoque = new ArrayList<>();
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT ID_Estoque, Nome, Marca, Categoria, Quantidade, V_venda FROM Estoque WHERE FK_Filial = ?");
            
            instrucaoSQL.setInt(1, fil.getId());
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                int ID = rs.getInt("ID_Estoque");
                String Nome = rs.getString("Nome");
                String Marca = rs.getString("Marca");
                String Catogoria = rs.getString("Categoria");
                int QTD = rs.getInt("Quantidade");
                double V_venda = rs.getDouble("V_venda");
                
                Estoque produto = new Estoque(Catogoria, V_venda, QTD, ID, Nome, Marca);
                
                estoque.add(produto);
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
        return estoque;
    }
}