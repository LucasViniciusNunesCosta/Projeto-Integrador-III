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
       String query = "insert into FUNCIONARIO (ID_Funcionario, Nome, Sobrenome, Email, CPF, Atuacao, Salario, Login, Senha, FK_Flial) VALUES (?,?,?,?,?,?,?,?,?,?)";
       try{
           con = GerenciadorConexao.abrirConexao();
           PreparedStatement ps = con.prepareStatement(query);
           ps.setInt(1, funcionario.getId());
           ps.setString(2, funcionario.getNome());
           ps.setString(3, "");
           ps.setString(4, funcionario.getEmail());
           ps.setString(5, funcionario.getCpf());
           ps.setString(6, funcionario.getAtuacao());
           ps.setDouble(7, funcionario.getSalario());
           ps.setString(8, funcionario.getLogin());
           ps.setString(9, funcionario.getSenha());
           ps.setInt(10, funcionario.getFilialId());
           
           ps.executeUpdate();
       }catch(SQLException ex){
           Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
           ok = false;
       }
       return ok;
   }

   
    public static List<Funcionario> getFuncionarios(){
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "select * from Funcionario";
        Connection con;
        try{
            con = GerenciadorConexao.abrirConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int funcionarioId = rs.getInt("ID_Funcionario");
                String nome = rs.getString("Nome");
                String sobrenome = rs.getString("Sobrenome");
                String email = rs.getString("Email");
                String cpf = rs.getString("CPF");
                String atuacao = rs.getString("Atuacao");
                Double salario = rs.getDouble("Salario");
                String login = rs.getString("Login");
                String senha = rs.getString("Senha");
                int filial = rs.getInt("FK_Flial");
                
                Funcionario funcionario = new Funcionario(filial, funcionarioId, atuacao, salario, senha, login, nome, cpf, email);
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