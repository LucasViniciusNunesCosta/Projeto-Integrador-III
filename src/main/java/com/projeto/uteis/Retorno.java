package com.projeto.uteis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Icaro
 */
public class Retorno {
    
    private boolean Atua;
    private boolean Excl;

    public Retorno(String acao) {
        switch (acao) {
            case "Atualizar":
                Atua = true;
                Excl = false;
            break;
            case "Excluir":
                Atua = false;
                Excl = true;
            break;
            default:
                throw new IllegalArgumentException("Erro de chamada de ação\n sintaxes de ação incompatível");
        }
    }

    public boolean isAtua() {
        return Atua;
    }

    public boolean isExcl() {
        return Excl;
    }
    
    public static void sendRedirecionar(boolean Devolutiva, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException{
        if (Devolutiva) {
            response.sendRedirect(request.getContextPath()+"/sucesso.jsp");
        }else{
            String msg = "Não foi possível cadastrar no banco de dadods";
            request.setAttribute("msgErro", msg);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
    }
}
