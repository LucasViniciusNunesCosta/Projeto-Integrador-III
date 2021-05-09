package com.projeto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Icaro
 */
public class GerenciadorConexao {
    
    public static String STATUS = "Não conectado";
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public final static String SERVER = "localhost";
    public final static String DATABASE = "Xgeek";
    public final static String PORTA = "3306";

    public final static String LOGIN = "root";
    public final static String SENHA = "";
    public static String URL = "";
    
    public static Connection CONEXAO;
    
    public static Connection abrirConexao(){
 
        URL = "jdbc:mysql://" + SERVER + ":"+PORTA+"/" +DATABASE + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
        
        if(CONEXAO==null){    
            try{
                
                Class.forName(DRIVER);
                CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);

                if (CONEXAO != null) {
                    STATUS = "Conexão realizada com sucesso!";
                }else{
                    STATUS = "Não foi possivel realizar a conexão";
                }

            }catch (ClassNotFoundException e) {  //Driver não encontrado

                throw new IllegalArgumentException("O driver expecificado nao foi encontrado.");

            }catch (SQLException e) {  //Erro ao estabelecer a conexão (Ex: login ou senha errados)

                //Outra falha de conexão
                throw new IllegalArgumentException("Erro ao estabelecer a conexão (Ex: login ou senha errados).");
            }
            
        }else{
            try {
                //Se a conexão estiver fechada, reabro a conexão
                if(CONEXAO.isClosed())
                    CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);
            } catch (SQLException ex) {
                throw new IllegalArgumentException("Falha ao fechar a conexão.");
            }
        }
        return CONEXAO;
    }
    
    public static String getStatusConexao() {
        return STATUS;
    }
    
    public static boolean fecharConexao() throws SQLException {
 
        boolean retorno;
        
        try{
            
            if(CONEXAO!=null){
                if(!CONEXAO.isClosed())
                    CONEXAO.close();
            }
            
            STATUS = "Não conectado";
            retorno = true;
            
        }catch (SQLException e) {
            retorno = false;
        }
        
        return retorno;
    }
}