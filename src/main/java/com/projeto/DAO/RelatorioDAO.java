package com.projeto.DAO;

import com.projeto.conexao.GerenciadorConexao;
import com.projeto.entidade.Venda;
import com.projeto.entidade.Relatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de acesso a dados de Relatorios.<br> uma série de métodos de geração de relatório.
 * <br><b>Observação</b> caso tem alguma falha no comando SQL, irá retornar uma mensagem(<b>IllegalArgumentException</b>) com o erro.
 * @author Icaro
 */
public class RelatorioDAO {
    
    /**
     * método para gerar relatório em um determinado período de tempo agrupando por categoria,
     * <br> assim gerando um relatório de quantos itens determinada categoria foi vendido e o valor total de vendas.
     * @param Ral Entidade com o período de tempo determinado para gerar o relatório.
     * @return Retorna uma <b>List</b> com o relatório.
     */
    public static List<Relatorio> RelatorioProdutoCategoriaData(Relatorio Ral){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        List<Relatorio> compras = new ArrayList<>();

        String QUERY = "SELECT Estoque.Categoria, SUM(Items.QTD), Estoque.V_venda*SUM(Items.QTD) FROM Compras " +
            "INNER JOIN Items ON Compras.ID_Pedido = Items.FK_Pedido " +
            "INNER JOIN Estoque ON Estoque.ID_Estoque = Items.FK_Estoque " +
            "INNER JOIN Filial ON Filial.ID_Flial = Estoque.FK_Filial " +
            "WHERE Data_Cri BETWEEN ? AND ? GROUP BY Estoque.Categoria ORDER BY SUM(Items.QTD) DESC";

        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(QUERY);
            
            instrucaoSQL.setDate(1, Ral.getData_inicio());
            instrucaoSQL.setDate(2, Ral.getData_fim());

            rs = instrucaoSQL.executeQuery();

            while(rs.next()){
                String Categoria = rs.getString("Categoria");
                int QTD = rs.getInt("SUM(Items.QTD)");
                double V_total = rs.getDouble("Estoque.V_venda*SUM(Items.QTD)");

                Relatorio com = new Relatorio(Categoria, V_total, QTD);
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
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
    }
    
    /**
     * método para gerar relatório em um determinado período de tempo, que mostra quantos clientes gastaram nesse período.
     * @param Ral Entidade com o período de tempo determinado para gerar o relatório.
     * @return Retorna uma <b>List</b> com o relatório.
     */
    public static List<Venda> RelatorioClienteData(Relatorio Ral){

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        List<Venda> compras = new ArrayList<>();

        String QUERY = "SELECT Cliente.ID_Cliente, Cliente.Nome, Cliente.CPF, SUM(Compras.Valor_total) FROM Cliente " +
            "INNER JOIN Compras ON Cliente.ID_Cliente = Compras.FK_Cliente " +
            "WHERE Compras.Data_Cri BETWEEN ? AND ? GROUP BY Cliente.ID_Cliente";

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
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
    }
    
    /**
     * método para gerar relatório que mostra as compras de um determinado cliente em determinado período.
     * @param Ral Entidade com o período de tempo determinado e o ID do cliente para gerar o relatório.
     * @return Retorna uma <b>List</b> com o relatório.
     */
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
            "WHERE FK_Cliente = ? and Data_Cri BETWEEN ? AND ? GROUP BY Compras.ID_Pedido";

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
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
    }
    
    /**
     * método para gerar relatório que mostra os itens de um pedido
     * @param Ral Entidade com e o ID do pedido para gerar o relatório.
     * @return Retorna uma <b>List</b> com o relatório.
     */
    public static List<Relatorio> RelatorioClienteDataIDPedido(Relatorio Ral){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        List<Relatorio> compras = new ArrayList<>();

        String QUERY ="SELECT Estoque.nome, Estoque.Marca , Estoque.Categoria , Items.QTD, Estoque.V_venda, Items.Desconto FROM Cliente "+
            "INNER JOIN Compras ON Cliente.ID_Cliente = Compras.FK_Cliente "+
            "INNER JOIN Items ON Compras.ID_Pedido = Items.FK_Pedido "+
            "INNER JOIN Estoque ON Estoque.ID_Estoque = Items.FK_Estoque "+
            "INNER JOIN Filial ON Filial.ID_Flial = Estoque.FK_Filial "+
            "WHERE Compras.ID_Pedido = ? ";
        
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(QUERY);

            instrucaoSQL.setInt(1, Ral.getID_PED());
            rs = instrucaoSQL.executeQuery();

            while(rs.next()){
                String Enome = rs.getString("nome");
                String EMarca = rs.getString("Marca");
                String ECategoria = rs.getString("Categoria");
                int QTD = rs.getInt("QTD");
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
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            } catch (SQLException e) {
            }
        }
    }
    
    /**
     * método para gerar relatório que mostra por filial o valor total vendido e a
     * <br> quantidade de itens Total vendidos em um determinado período de tempo.
     * @param Ral Entidade com o período de tempo determinado para gerar o relatório.
     * @return Retorna uma <b>List</b> com o relatório.
     */
    public static List<Relatorio> RelatorioFilialData(Relatorio Ral){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Relatorio> listaVendas = new ArrayList<>();
        
        String QUERY = "SELECT Filial.ID_Flial, Filial.Cidade, Filial.Estado, Filial.Endereco, SUM(Items.V_Item), SUM(Estoque.V_compra*Items.QTD), SUM(Items.QTD) FROM Compras " +
            "INNER JOIN Items ON Compras.ID_Pedido = Items.FK_Pedido " +
            "INNER JOIN Estoque ON Estoque.ID_Estoque = Items.FK_Estoque " +
            "INNER JOIN Filial ON Filial.ID_Flial = Estoque.FK_Filial " +
            "WHERE Compras.Data_Cri BETWEEN ? AND ? ORDER BY SUM(Items.V_Item) DESC";
        
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(QUERY);
            
            instrucaoSQL.setDate(1, Ral.getData_inicio());
            instrucaoSQL.setDate(2, Ral.getData_fim());
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                int ID = rs.getInt("ID_Flial");
                int QTD = rs.getInt("SUM(Items.QTD)");
                String Cidade = rs.getString("Cidade");
                String Estado = rs.getString("Estado");
                String Endereco = rs.getString("Endereco");
                double V_total = rs.getDouble("SUM(Items.V_Item)");
                double V_compra = rs.getDouble("SUM(Estoque.V_compra*Items.QTD)");
                
                Relatorio relatorio = new Relatorio(Cidade, Estado, Endereco, V_total, V_compra, QTD, ID);
                listaVendas.add(relatorio);
            }
            return listaVendas;
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
     * método para gerar relatório que gera todas as compras em uma determinada filial em um determinado período de tempo.
     * @param Ral Entidade com o período de tempo determinado e o ID do filial para gerar o relatório.
     * @return Retorna uma <b>List</b> com o relatório.
     */
    public static List<Relatorio> RelatorioFilialDataID(Relatorio Ral){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Relatorio> listaFilial = new ArrayList<>();
        
        String QUERY = "SELECT Cliente.Nome, Cliente.CPF, Compras.Data_Cri, Compras.Valor_total FROM Cliente " +
            "INNER JOIN Compras ON Cliente.ID_Cliente = Compras.FK_Cliente " +
            "INNER JOIN Items ON Compras.ID_Pedido = Items.FK_Pedido " +
            "INNER JOIN Estoque ON Estoque.ID_Estoque = Items.FK_Estoque " +
            "INNER JOIN Filial ON Filial.ID_Flial = Estoque.FK_Filial " +
            "WHERE Compras.Data_Cri BETWEEN ? AND ? AND ID_Flial = ? GROUP BY Compras.ID_Pedido ORDER BY Data_Cri DESC";
        
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(QUERY);
            
            instrucaoSQL.setDate(1, Ral.getData_inicio());
            instrucaoSQL.setDate(2, Ral.getData_fim());
            instrucaoSQL.setInt(3, Ral.getID_FIL());
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                String Nome = rs.getString("Nome");
                String CPF = rs.getString("CPF");
                Date Data_Cri = rs.getDate("Data_Cri");
                double V_total = rs.getDouble("Compras.Valor_total");
                
                Relatorio relatorio = new Relatorio(Data_Cri, Nome, V_total, CPF);
                listaFilial.add(relatorio);
            }
            return listaFilial;
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