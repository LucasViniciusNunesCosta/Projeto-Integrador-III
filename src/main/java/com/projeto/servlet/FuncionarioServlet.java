package com.projeto.servlet;

import com.projeto.DAO.FuncionarioDAO;
import com.projeto.entidade.Funcionario;
import com.projeto.uteis.CryptoUtils;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas vinicius
 */
public class FuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            List<Funcionario> listaFuncionarios = FuncionarioDAO.getFuncionarios();
            request.setAttribute("listaFuncionarios", listaFuncionarios);
            
            String action = request.getParameter("send");
            if (action!=null) {
                Retorno acao = new Retorno(action);
                request.setAttribute("acao", acao);
            }
            
            request.getRequestDispatcher("/protegido/Funcionarios/ListarFuncionarios.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            request.setAttribute("msgErro", e);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        } catch (IllegalArgumentException e){
            request.setAttribute("msgErro", e.getMessage());
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
   }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try{
            request.setCharacterEncoding("UTF-8");
            int filialId = Integer.valueOf(request.getParameter("filialID"));
            String nome = request.getParameter("Nome");
            String Sobrenome = request.getParameter("Sobrenome");
            String email = request.getParameter("Email");
            String senha = request.getParameter("Senha");
            String cpf = request.getParameter("CPF");
            String atuacao = request.getParameter("Atuacao");
            double salario = Double.valueOf(request.getParameter("Salario"));
            
            senha = CryptoUtils.HashSenha(senha);
            
            //inserir o funcionario no banco de dados
            Funcionario funcionario = new Funcionario(filialId, atuacao, salario, nome, Sobrenome, cpf, email, senha);

            //redirecionar para a tela de sucesso/erro
            if (FuncionarioDAO.cadastrar(funcionario)) {
                response.sendRedirect(request.getContextPath() + "/sucesso.jsp");
            } else {
                String msg = "Não foi possível cadastrar o cliente";
                request.setAttribute("msgErro", msg);
                request.getRequestDispatcher("/erro.jsp").forward(request, response);
            }
        } catch (IOException | NumberFormatException | ServletException e) {
            request.setAttribute("msgErro", e);
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        } catch (IllegalArgumentException e){
            request.setAttribute("msgErro", e.getMessage());
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
    }
}
