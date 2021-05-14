package com.projeto.DAO;

import com.projeto.conexao.GerenciadorConexao;
import com.projeto.entidade.Venda;
import com.projeto.entidade.Relatorio;
import com.projeto.entidade.RelatorioPorFilial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Icaro
 */
public class RelatorioDAO {
    
    public static List<Venda> RelatorioClienteData(Relatorio Ral){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Venda> compras = new ArrayList<>();
        
        String QUERY = "SELECT Cliente.ID_Cliente, Cliente.Nome, Cliente.CPF, SUM(Vendas.Valor_total) FROM Cliente " +
            "INNER JOIN Vendas ON Cliente.ID_Cliente = Vendas.FK_Cliente " +
            "WHERE Vendas.Data_Cri BETWEEN ? AND ? GROUP BY Cliente.ID_Cliente;";
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(QUERY);
            
            instrucaoSQL.setDate(1, Ral.getData_inicio());
            instrucaoSQL.setDate(2, Ral.getData_fim());
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                int ID = rs.getInt("ID_Cliente");
                String Nome = rs.getString("Nome");
                String CPF = rs.getString("CPF");
                double V_total = rs.getDouble("SUM(Vendas.Valor_total)");
                
                Venda com = new Venda(V_total, ID, Nome, CPF);
                
                compras.add(com);
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
                conexao.close();
                GerenciadorConexao.fecharConexao();
            } catch (SQLException e) {
            }
        }
        return compras;
    }
    
    public static List<Relatorio> RelatorioClienteDataID(Relatorio Ral){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Relatorio> compras = new ArrayList<>();
        
        String QUERY = "SELECT Vendas.ID_Pedido, Vendas.Data_Cri, Estoque.nome, Estoque.Categoria, Vendas.Valor_total, Items.QTD, Filial.Endereco FROM Cliente " +
            "INNER JOIN Vendas ON Cliente.ID_Cliente = Vendas.FK_Cliente " +
            "INNER JOIN Items ON Vendas.ID_Pedido = Items.FK_Pedido " +
            "INNER JOIN Estoque ON Estoque.ID_Estoque = Items.FK_Estoque " +
            "INNER JOIN Filial ON Filial.ID_Flial = Estoque.FK_Filial " +
            "WHERE FK_Cliente = ? and Data_Cri BETWEEN ? AND ? ";
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(QUERY);
            
            instrucaoSQL.setInt(1, Ral.getID_CLI());
            instrucaoSQL.setDate(2, Ral.getData_inicio());
            instrucaoSQL.setDate(3, Ral.getData_fim());
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                int ID = rs.getInt("ID_Pedido");
                Date data = rs.getDate("Data_Cri");
                String NomeP = rs.getString("nome");
                String Categoria = rs.getString("Categoria");
                double V_total = rs.getDouble("Valor_total");
                int QTD = rs.getInt("QTD");
                String Endereco = rs.getString("Endereco");
                
                Relatorio com = new Relatorio(ID, data, NomeP, Categoria, QTD, V_total, Endereco);
                
                compras.add(com);
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
                conexao.close();
                GerenciadorConexao.fecharConexao();
            } catch (SQLException e) {
            }
        }
        return compras;
    }
    
    public static List<Venda> getListaRelatorioPorFilial(RelatorioPorFilial relatorioPorFilial){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Venda> listaVendas = new ArrayList<>();
        
        String QUERY = "SELECT Cliente.ID_Cliente, Cliente.Nome, Cliente.CPF, SUM(Vendas.Valor_total) FROM Cliente " +
                "INNER JOIN Vendas ON Cliente.ID_Cliente = Vendas.FK_Cliente " +
                "INNER JOIN Filial ON Filial.ID_Flial = Vendas.FK_Filial " +
                "WHERE Vendas.Data_Cri BETWEEN ? AND ? AND Filial.ID_Flial = ? " +
                "GROUP BY Filial.ID_Flial;";
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(QUERY);
            
            instrucaoSQL.setDate(1, relatorioPorFilial.getDataInicio());
            instrucaoSQL.setDate(2, relatorioPorFilial.getDataFim());
            instrucaoSQL.setInt(3, relatorioPorFilial.getFilialId());
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                int ID = rs.getInt("ID_Cliente");
                String Nome = rs.getString("Nome");
                String CPF = rs.getString("CPF");
                double V_total = rs.getDouble("SUM(Vendas.Valor_total)");
                
                Venda com = new Venda(V_total, ID, Nome, CPF);
                
                listaVendas.add(com);
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
                conexao.close();
                GerenciadorConexao.fecharConexao();
            } catch (SQLException e) {
            }
        }
        return listaVendas;
    }
}
