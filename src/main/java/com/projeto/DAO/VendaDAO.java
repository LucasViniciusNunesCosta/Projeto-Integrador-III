/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.DAO;

import com.projeto.conexao.GerenciadorConexao;
import com.projeto.entidade.Venda;
import com.projeto.entidade.Funcionario;
import com.projeto.entidade.Cliente;
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
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("insert into Vendas (Valor_total, Data_cri, Nome_Produto, FK_Cliente, FK_Funcionario) VALUES (?,?,?,?,?)");
            
            instrucaoSQL.setDouble(1, venda.getVendaTotal());
            instrucaoSQL.setDate(2, venda.getData());
            instrucaoSQL.setString(3, venda.getNomeProduto());
            instrucaoSQL.setInt(4, venda.getId_cliente());
            instrucaoSQL.setInt(5, venda.getId_funcionario());
    
            int linhaAfetadas = instrucaoSQL.executeUpdate();
            return linhaAfetadas > 0;
            
        } catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }finally{
            try {
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                conexao.close();
                GerenciadorConexao.fecharConexao();
            } catch (SQLException e) {
            }
        }
    }

    public static List<Venda>getVenda(){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Venda> compras = new ArrayList<>();
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareCall("SELECT * FROM Compras");
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                int ID_Pedido = rs.getInt("ID_Pedido");
                double Valor_total = rs.getDouble("Valor_total");
                Date Data_Cri = rs.getDate("Data_Cri");
                String nomeProduto = rs.getString("Nome_Produto");
                int FK_Cliente = rs.getInt("FK_Cliente");
                int FK_Funcionario = rs.getInt("FK_Funcionario");
                
               Venda compra = new Venda(ID_Pedido, FK_Cliente, FK_Funcionario, nomeProduto, Valor_total, Data_Cri);
               
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
                conexao.close();
                GerenciadorConexao.fecharConexao();
            }catch(SQLException e){
                
            }
        }
        return  compras;
    }
        
}
