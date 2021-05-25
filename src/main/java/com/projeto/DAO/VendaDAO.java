package com.projeto.DAO;

import com.projeto.conexao.GerenciadorConexao;
import com.projeto.entidade.Item;
import com.projeto.entidade.Venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruan
 */
public class VendaDAO {
    
    public static boolean addVenda(Venda venda){
        
        ResultSet rs;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO Compras (Valor_total, Data_cri, FK_Cliente, FK_Funcionario) VALUES (?,?,?,?)");
            
            instrucaoSQL.setDouble(1, venda.getVendaTotal());
            instrucaoSQL.setDate(2, venda.getData());
            instrucaoSQL.setInt(3, venda.getID_Cliente());
            instrucaoSQL.setInt(4, venda.getId_funcionario());
            
            int linhaAfetadas = instrucaoSQL.executeUpdate();
            
            if (linhaAfetadas > 0) {
                instrucaoSQL = conexao.prepareStatement("SELECT ID_Pedido FROM Compras ORDER BY ID_Pedido DESC LIMIT 1");
                rs = instrucaoSQL.executeQuery();
            
                if (rs.next()) {
                    venda.setID_Compra(rs.getInt("ID_Pedido"));
                    
                    instrucaoSQL = null;
                    linhaAfetadas = 0;
                    
                    for (Item item: venda.getItems()){
                        instrucaoSQL = conexao.prepareStatement("INSERT INTO Items (QTD, Desconto, FK_Pedido, FK_Estoque) VALUES (?,?,?,?)");
                        instrucaoSQL.setInt(1, item.getQTD());
                        instrucaoSQL.setInt(2, item.getDesconto());
                        instrucaoSQL.setInt(3, venda.getID_Compra());
                        instrucaoSQL.setInt(4, item.getID());
                        
                        linhaAfetadas += instrucaoSQL.executeUpdate();
                        instrucaoSQL = null;
                    }
                    return linhaAfetadas > 0;
                }
            }
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

    public static List<Venda>getVendas(){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Venda> compras = new ArrayList<>();
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareCall("SELECT * FROM Compras ORDER BY ID_Pedido DESC;");
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                int ID_Pedido = rs.getInt("ID_Pedido");
                double Valor_total = rs.getDouble("Valor_total");
                Date Data_Cri = rs.getDate("Data_Cri");
                int FK_Cliente = rs.getInt("FK_Cliente");
                int FK_Funcionario = rs.getInt("FK_Funcionario");
                Venda compra = new Venda(ID_Pedido, Data_Cri, FK_Funcionario, Valor_total, FK_Cliente);
                compras.add(compra);
            }
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }finally{
            try{
                if(rs !=null){
                    rs.close();
                }
                if(instrucaoSQL !=null ){
                    instrucaoSQL.close();
                }
                if (conexao!=null) {
                    conexao.close();
                    GerenciadorConexao.fecharConexao();  
                }
            }catch(SQLException e){
                
            }
        }
        return  compras;
    }
}