package com.projeto.uteis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * classe auxiliar de redirecionamento.
 * @author Icaro
 */
public class Retorno {
    
    private static boolean Atua;
    private static boolean Excl;
    private static boolean Apps;
    private static boolean Hardware;
    private static boolean WebApp;
    private static boolean Responder;

    /**
     * método auxiliar de redirecionamento para atualização e exclusão.
     * @param acao redirecionamento para atualização ou exclusão etc.
     */
    public Retorno(String acao) {
        switch (acao) {
            case "Atualizar":
                Atua = true;
                Excl = false;
                Apps = false;
                Hardware = false;
                WebApp = false;
                Responder = false;
            break;
            case "Excluir":
                Atua = false;
                Excl = true;
                Apps = false;
                Hardware = false;
                WebApp = false;
                Responder = false;
            break;
            case "Apps":
                Atua = false;
                Excl = false;
                Apps = true;
                Hardware = false;
                WebApp = false;
                Responder = false;
            break;
            case "Hardware":
                Atua = false;
                Excl = false;
                Apps = false;
                Hardware = true;
                WebApp = false;
                Responder = false;
            break;
            case "WebApp":
                Atua = false;
                Excl = false;
                Apps = false;
                Hardware = false;
                WebApp = true;
                Responder = false;
            break;
            case "Responder":
                Atua = false;
                Excl = false;
                Apps = false;
                Hardware = false;
                WebApp = false;
                Responder = true;
            break;
            default:
                throw new IllegalArgumentException("Erro de chamada de ação\n sintaxes de ação incompatível");
        }
    }
    
    public String getAcao(){
        if (isApps()) {
            return "Aplicativos e Software";
        }else if (isHardware()) {
            return "Equipamentos e Periféricos";
        }else if (isWebApp()) {
            return "Sistema Institucional";
        }else if (isAtua()) {
            return "Seus dados";
        }else{
            return "";
        }
    }
    
    public String getAcaoList(){
        if (isAtua()) {
            return "Atualizar";
        }else if (isExcl()) {
            return "Excluir";
        }else{
            return "";
        }
    }

    public boolean isResponder() {
        return Responder;
    }

    public boolean isApps() {
        return Apps;
    }

    public boolean isHardware() {
        return Hardware;
    }

    public boolean isWebApp() {
        return WebApp;
    }
    
    public boolean isAtua() {
        return Atua;
    }

    public boolean isExcl() {
        return Excl;
    }
    
    /**
     * método auxiliar de redirecionamento para tela de sucesso ou erro
     * @param Devolutiva ser for <b>true</b> redirecionamento para tela de sucesso. ser for <b>false</b> redirecionamento para tela de erro.
     * @param response HttpServletResponse
     * @param request HttpServletRequest
     * @throws IOException
     * @throws ServletException 
     */
    public static void sendRedirecionar(boolean Devolutiva, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException{
        if (Devolutiva) {
            response.sendRedirect(request.getContextPath()+"/sucesso.jsp");
        }else{
            String msg = "Não foi possível finalizar o seu processo. algo deu errado durante a gravação no banco de dados, tente novamente. se o erro persistir entre em contato com o suporte de TI.";
            request.setAttribute("msgErro", msg);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
    }
    
    public static void sendErro(String msg, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
        request.setAttribute("msgErro", msg);
        request.getRequestDispatcher("/Erro.jsp").forward(request, response);
    }
}
