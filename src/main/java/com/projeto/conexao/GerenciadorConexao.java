package com.projeto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * classe de gerenciador de conexão com banco de dados.
 * @author Icaro
 */
public class GerenciadorConexao {
    
    public static String STATUS = "Não conectado";
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    /**
     * Localhost
     */
    public final static String SERVER = "127.0.0.1"; //127.0.0.1  //localhost
    
    /**
     * Database no Localhost
     */
    public final static String DATABASE = "Xgeek";
    
    /**
     * Porta do Localhost
     */
    public final static String PORTA = "55664"; //55664  //3306

    /**
     * Login do Localhost
     */
    public final static String LOGIN = "azure"; //azure  //root
    
    /**
     * Senha do Localhost
     */
    public final static String SENHA = "6#vWHD_$"; //6#vWHD_$  //
    public static String URL = "";
    
    public static Connection CONEXAO;
    
    /**
     * método que abre a conexão com banco de dados
     * @return retorna a conexão
     */
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
                throw new IllegalArgumentException("Erro ao estabelecer a conexão com o banco de dados");
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
    
    /**
     * método que mostra os status da conexão
     * @return retorna o status da conexão
     */
    public static String getStatusConexao() {
        return STATUS;
    }
    
    /**
     * método que fechar conexão com banco de dados
     * @return <b>true</b> se conexão foi fechada com sucesso <b>false</b> se não for.
     * @throws SQLException 
     */
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