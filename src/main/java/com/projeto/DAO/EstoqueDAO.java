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
 * Objeto de acesso a dados do Estoque.<br> uma série de métodos de manipulação do banco de dados relativo ao Estoque.
 * <br><b>Observação</b> caso tem alguma falha no comando SQL, irá retornar uma mensagem(<b>IllegalArgumentException</b>) com o erro.
 * @author Icaro
 */
public class EstoqueDAO {
    
    /**
     * Método para excluir um Client do banco de dados.
     * @param produto Entidade identifica o produto a ser excluído.
     * @return <b>true</b> se a exclusão foi bem sucedida <b>false</b> se não for.
     */
    public static boolean Excluir(Estoque produto){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM Estoque WHERE ID_Estoque = ?");
            
            instrucaoSQL.setInt(1, produto.getID());
            
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
     * método usado para buscar um produto em específico.
     * @param produto Entidade identifica o produto a ser buscar.
     * @return Retorna uma entidade Estoque se o produto foi encontrado, se não retorna uma mensagem(<b>IllegalArgumentException</b>) que o produto não foi encontrado.
     */
    public static Estoque getProduto(Estoque produto){

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareCall("SELECT * FROM Estoque WHERE ID_Estoque = ?");
            
            instrucaoSQL.setInt(1, produto.getID());
            rs = instrucaoSQL.executeQuery();
            
            if (rs.next()) {
                produto.setNome(rs.getString("Nome"));
                produto.setMarca(rs.getString("Marca"));
                produto.setCategoria(rs.getString("Categoria"));
                produto.setQTD(rs.getInt("Quantidade"));
                produto.setV_compra(rs.getDouble("V_compra"));
                produto.setV_venda(rs.getDouble("V_venda"));
                produto.setFiliaID(rs.getInt("FK_Filial"));
                return produto;
            }else{
                throw new IllegalArgumentException("Produto não foi encontrado");
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
     * método usado para buscar um item em específico.
     * @param item Entidade identifica o item a ser buscar.
     * @return Retorna uma entidade Item se o item foi encontrado, se não retorna uma mensagem(<b>IllegalArgumentException</b>) que o Item não foi encontrado.
     */
    public static Item getItem(Item item){

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareCall("SELECT * FROM Estoque WHERE ID_Estoque = ?");
            
            instrucaoSQL.setInt(1, item.getID());
            rs = instrucaoSQL.executeQuery();
            
            if (rs.next()) {
                item.setNome(rs.getString("Nome"));
                item.setMarca(rs.getString("Marca"));
                item.setV_venda(rs.getDouble("V_venda"));
                return item;
            }else{
                throw new IllegalArgumentException("Item não encontrado");
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
     * método para atualizar os dados do produto.
     * @param produto Entidade a ser atualizar e os demais dados.
     * @return <b>true</b> se a Atualizar foi bem sucedida <b>false</b> se não for.
     */
    public static boolean Atualizar(Estoque produto){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE Estoque SET Nome = ?, Marca = ?, Categoria = ?, Quantidade = ?, V_compra = ?, V_venda = ?, FK_Filial = ? WHERE ID_Estoque = ?");
            
            instrucaoSQL.setString(1, produto.getNome());
            instrucaoSQL.setString(2, produto.getMarca());
            instrucaoSQL.setString(3, produto.getCategoria());
            instrucaoSQL.setInt(4, produto.getQTD());
            instrucaoSQL.setDouble(5, produto.getV_compra());
            instrucaoSQL.setDouble(6, produto.getV_venda());
            instrucaoSQL.setInt(7, produto.getFiliaID());
            instrucaoSQL.setInt(8, produto.getID());
            
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
     * método para adicionar os dados do produto no banco de dados.
     * @param produto Entidade a ser adicionar.
     * @return <b>true</b> se a adicionar foi bem sucedida <b>false</b> se não for.
     */
    public static boolean AddEstoque(Estoque produto){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO Estoque (Nome, Marca, Categoria, Quantidade, V_compra, V_venda, FK_Filial) VALUES (?,?,?,?,?,?,?)");
            
            instrucaoSQL.setString(1, produto.getNome());
            instrucaoSQL.setString(2, produto.getMarca());
            instrucaoSQL.setString(3, produto.getCategoria());
            instrucaoSQL.setInt(4, produto.getQTD());
            instrucaoSQL.setDouble(5, produto.getV_compra());
            instrucaoSQL.setDouble(6, produto.getV_venda());
            instrucaoSQL.setInt(7, produto.getFiliaID());
            
            
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
     * método para pegar todos os dados da tabela Estoque no banco de dados.
     * @return Retorna uma <b>List</b> com todas os Produtos<br> se nenhum Produto foram encontrado, retorna uma <b>List</b> vazia.
     */
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
            return estoque;
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
     * método para pegar os dados da tabela Estoque no banco de dados, filtrado por filial.
     * @param filial Entidade usada como filtro
     * @return Retorna uma <b>List</b> com todas os Produtos<br> se nenhum Produto foram encontrado, retorna uma <b>List</b> vazia.
     */
    public static List<Estoque> getEstoqueFilial(Filial filial){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Estoque> estoque = new ArrayList<>();
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT ID_Estoque, Nome, Marca, Categoria, Quantidade, V_venda FROM Estoque WHERE FK_Filial = ?");
            
            instrucaoSQL.setInt(1, filial.getId());
            
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
            return estoque;
            
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
}