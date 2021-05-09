/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.DAO;

import com.projeto.conexao.GerenciadorConexao;
import com.projeto.entidade.Compra;
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
public class CompraDAO {
    
    public static boolean AddCompra(Compra comp, Cliente cli, Funcionario func){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO Compra (ID_Pedido,Valor_total, Data_cri, FK_Cliente, FK_Funcinario) VALUES (?,?,?,?,?)");
            
            instrucaoSQL.setInt(1, comp.getId());
            instrucaoSQL.setDouble(2, comp.getVendaTotal());
            //Acrescentar o Date na Classe compra
            //instrucaoSQL.setDate(3, comp.getDate());
            instrucaoSQL.setInt(4, cli.getID());
            instrucaoSQL.setInt(5, func.getId());
            
            
            
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

    public static List<Compra>getCompra(){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        List<Compra> compras = new ArrayList<>();
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareCall("SELECT * FROM Compras");
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                int ID_Pedido = rs.getInt("ID_Pedido");
                double Valor_total = rs.getDouble("Valor_total");
                Date Data_Cri = rs.getDate("Data_Cri");
                int FK_Cliente = rs.getInt("FK_Cliente");
                int FK_Funcionario = rs.getInt("FK_Funcionario");
                
               Compra compra = new Compra(ID_Pedido, FK_Cliente, FK_Funcionario, Valor_total, Data_Cri);
               
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
