/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.DAO;

import com.projeto.conexao.GerenciadorConexao;
import com.projeto.entidade.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas vinicius
 */
public class FuncionarioDAO {
   public static boolean cadastrar (Funcionario funcionario){
       boolean ok = true;
       Connection con;
       String query = "insert into FUNCIONARIO (FILIALID, FUNCIONARIOID, ATUACAO, SALARIO, SENHA, LOGIN, NOME, CPF, EMAIL) VALUES (?,?,?,?,?,?,?,?,?)";
       try{
           con = GerenciadorConexao.abrirConexao();
           PreparedStatement ps = con.prepareStatement(query);
           //ps.setInt(1, funcionario.getFilial().getId());
           ps.setInt(1, funcionario.getFilialId());
           ps.setInt(2, funcionario.getId());
           ps.setString(3, funcionario.getAtuacao());
           ps.setDouble(4, funcionario.getSalario());
           ps.setString(5, funcionario.getSenha());
           ps.setString(6, funcionario.getLogin());
           ps.setString(7, funcionario.getNome());
           ps.setString(8, funcionario.getCpf());
           ps.setString(9, funcionario.getEmail());
           ps.executeUpdate();
       }catch(SQLException ex){
           Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
           ok = false;
       }
       return ok;
   }

   
    public static List<Funcionario> getFuncionario(){
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "Select * from Funcionario";
        Connection con;
        try{
            con = GerenciadorConexao.abrirConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int FilialID = rs.getInt("FilialID");
                int FuncionarioID = rs.getInt("FuncionarioID");
                String Atuacao = rs.getString("Atuacao");
                Double Salario = rs.getDouble("Salario");
                String Senha = rs.getString("Senha");
                String login = rs.getString("Login");
                String Nome = rs.getString("Nome");
                String CPF = rs.getString("CPF");
                String Email = rs.getString("Email");
                
                Funcionario funcionario = new Funcionario(FilialID, FuncionarioID, Atuacao, Salario, Senha, login, Nome, CPF, Email);
                funcionarios.add(funcionario);
            }
        }catch(SQLException ex){
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }
    
    public static Funcionario getFuncionario(Integer Id){
        Funcionario funcionario = null;
        String query = "select * from Funcionario where funcionarioId=?";
        Connection con;
        try{
            con = GerenciadorConexao.abrirConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int FilialID = rs.getInt("FilialID");
                int FuncionarioID = rs.getInt("FuncionarioID");
                String Atuacao = rs.getString("Atuacao");
                Double Salario = rs.getDouble("Salario");
                String Senha = rs.getString("Senha");
                String login = rs.getString("Login");
                String Nome = rs.getString("Nome");
                String CPF = rs.getString("CPF");
                String Email = rs.getString("Email");
                funcionario = new Funcionario(FilialID, FuncionarioID, Atuacao, Salario, Senha, login, Nome, CPF, Email);
            }
        }catch(SQLException ex){
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return funcionario;
    }
    public static boolean deletar(Integer Id){
        boolean ok = true;
        String query = "delete from Funcionario where id=?";
        Connection con;
        try{
            con = GerenciadorConexao.abrirConexao();
            GerenciadorConexao.abrirConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Id);
            ps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        
        return ok;
    }
    
    public static boolean atualizar(Funcionario funcionario){
        boolean ok = true;
        String query = "update Funcionario set nome=?, cpf=?, funcionarioId=?";
        Connection con;
        try{
            con = GerenciadorConexao.abrirConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setInt(3, funcionario.getId());
            ps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
}