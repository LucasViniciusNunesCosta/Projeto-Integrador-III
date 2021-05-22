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

        String QUERY = "SELECT Cliente.ID_Cliente, Cliente.Nome, Cliente.CPF, SUM(Compras.Valor_total) FROM Cliente " +
            "INNER JOIN Compras ON Cliente.ID_Cliente = Compras.FK_Cliente " +
            "WHERE Compras.Data_Cri BETWEEN ? AND ? GROUP BY Cliente.ID_Cliente;";

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
                double V_total = rs.getDouble("SUM(Compras.Valor_total)");

                Venda com = new Venda(V_total, ID, Nome, CPF);

                compras.add(com);
            }
            return compras;
            
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
    }
    
    public static List<Relatorio> RelatorioClienteDataID(Relatorio Ral){

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        List<Relatorio> compras = new ArrayList<>();

        String QUERY = "SELECT Compras.ID_Pedido, Compras.Data_Cri, Compras.Valor_total, Filial.Endereco FROM Cliente " +
            "INNER JOIN Compras ON Cliente.ID_Cliente = Compras.FK_Cliente " +
            "INNER JOIN Items ON Compras.ID_Pedido = Items.FK_Pedido " +
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
                int IDP = rs.getInt("ID_Pedido");
                Date data = rs.getDate("Data_Cri");
                double V_total = rs.getDouble("Valor_total");
                String Endereco = rs.getString("Endereco");

                Relatorio com = new Relatorio(IDP, Ral.getID_CLI(), data, V_total, Endereco);

                compras.add(com);
            }
            return compras;
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
    }
    
    public static List<Relatorio> RelatorioClienteDataIDPedido(Relatorio Ral){
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        List<Relatorio> compras = new ArrayList<>();

        String QUERY ="SELECT Estoque.nome, Estoque.Marca , Estoque.Categoria , Estoque.Quantidade, Estoque.V_venda, Items.Desconto FROM Cliente "+
            "INNER JOIN Compras ON Cliente.ID_Cliente = Compras.FK_Cliente "+
            "INNER JOIN Items ON Compras.ID_Pedido = Items.FK_Pedido "+
            "INNER JOIN Estoque ON Estoque.ID_Estoque = Items.FK_Estoque "+
            "INNER JOIN Filial ON Filial.ID_Flial = Estoque.FK_Filial "+
            "WHERE Compras.ID_Pedido = ? and Data_Cri BETWEEN ? AND ? ";
        
        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(QUERY);

            instrucaoSQL.setInt(1, Ral.getID_PED());
            instrucaoSQL.setDate(2, Ral.getData_inicio());
            instrucaoSQL.setDate(3, Ral.getData_fim());

            rs = instrucaoSQL.executeQuery();

            while(rs.next()){
                String Enome = rs.getString("nome");
                String EMarca = rs.getString("Marca");
                String ECategoria = rs.getString("Categoria");
                int QTD = rs.getInt("Quantidade");
                double V_total = rs.getDouble("V_venda");
                int Desconto = rs.getInt("Desconto");

                Relatorio com = new Relatorio(Enome, EMarca, ECategoria, QTD, V_total, Desconto);

                compras.add(com);
            }
            return compras;
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
