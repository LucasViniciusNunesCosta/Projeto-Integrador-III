<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:if test="${empty funcionario}">
            <script src="../../js/jquery-3.6.0.min.js" type="text/javascript"></script>
            <link href="../../css/bootstrap.min.css" rel="stylesheet">
            <link rel="stylesheet" href="../../css/main.css">
            <link rel="shortcut icon" href="../../img/Xgeek-Icone.ico" type="image/x-icon">
            <title>Cadastro de funcionario</title>
        </c:if>
        <c:if test="${not empty funcionario}">
            <link rel="stylesheet" href="css/main.css">
            <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
            <title>Atualização de funcionario</title>
        </c:if>
    </head>
    <body> 
        <c:import url="../../header.jsp"/>
        
        <c:if test="${empty funcionario}">
            <form action="../../FuncionarioServlet" method="POST" class="CadaEst" onsubmit="return Confirmacao()">
                <h3>Cadastro de funcionario</h3>
                <input type="hidden" name="filialID" value="${sessionScope.usuario.ID_Filial}"/>
                <div class="textsbox inputs">
                    <div>
                        <label>Nome</label>
                        <input class="textsize text-MB" autocomplete="off" type="text" name="Nome" placeholder="Nome" required="true"/>
                    </div><div>
                        <label>Sobrenome</label>
                        <input class="textsize text-MB" autocomplete="off" type="text" name="Sobrenome" placeholder="Sobrenome" required="true"/>
                    </div><div>
                        <label>Email</label>
                        <input class="textsize text-MB" autocomplete="off" type="email" name="Email" placeholder="Email" required="true"/>
                    </div><div>
                        <label>Senha</label>
                        <input class="textsize text-MB" autocomplete="off" type="password" name="Senha" placeholder="Senha" id="Senha" required="true"/>
                    </div><div>
                        <label>Confirme a senha</label>
                        <input class="textsize text-MB" autocomplete="off" type="password" name="ConSenha" placeholder="confirme a senha" id="ConSenha" required="true"/>
                    </div><div>
                        <label>CPF</label>
                        <input class="textsize text-MB" autocomplete="off" type="number" name="CPF" placeholder="CPF" required="true"/> 
                    </div><div>
                        <label>Atuacao</label>
                        <select class="textsize text-MB" name="Atuacao" placeholder="Atuacao" required="true">
                            <option value="Vendedor">Vendedor</option>
                            <option value="RH">RH</option>
                            <option value="Gerente">Gerente</option>
                            <option value="Suporte">Suporte</option>
                            <option value="ADM">ADM</option>
                        </select>
                    </div><div>
                        <label>Salario</label>
                        <input class="textsize text-MB" autocomplete="off" type="number" step="0.01" name="Salario" placeholder="Salario" required="true"/>
                    </div>
                </div>
                <button class="btn_exe btnG1" type="submit">Cadastrar</button>
            </form>
           
            <script type="text/javascript">
                function Confirmacao(){
                    var Senha = $("#Senha").val();
                    var ConSenha = $("#ConSenha").val();
                    console.log(Senha);
                    if (Senha === ConSenha){
                        return true;
                    }else{
                        $("#ModalConfirmacao").show();
                        return false;
                    }
                }
                function Cancelar(){
                    $("#ModalConfirmacao").hide();
                }
            </script>
            
            <!-- Modal -->
            <div class="modal fade show" id="ModalConfirmacao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered modal-lg">
                <div class="modal-content contentCustom">
                  <div class="modal-header headerCustom">
                    <h5 class="modal-title" id="exampleModalLabel">Dados incompatível</h5>
                  </div>
                  <div class="modal-body">
                      <p class="modeal-text">A senha e a senha de confirmação estão diferentes<br>por favor verifique a senha</p>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btnCancelar" data-bs-dismiss="modal" onclick="Cancelar()">Ok</button>
                  </div>
                </div>
              </div>
            </div>
        </c:if>
        <c:if test="${not empty funcionario}">
            <form action="AtualizarFuncionarioServlet" method="POST" class="CadaEst">
                <h3>Alterar de funcionario</h3>
                <input type="hidden" name="funcionarioID" value="${funcionario.ID}"/>
                <div class="textsbox inputs">
                    <div>
                        <label>ID Filial</label>
                        <input class="textsize text-MB" type="number" name="filialID" placeholder="ID Filial" required="true" value="${funcionario.ID_Filial}"/>
                    </div><div>
                        <label>Nome</label>
                        <input class="textsize text-MB" type="text" name="nome" placeholder="Nome" required="true" value="${funcionario.nome}"/>
                    </div><div>
                        <label>Sobrenome</label>
                        <input class="textsize text-MB" type="text" name="sobrenome" placeholder="Sobrenome" required="true" value="${funcionario.sobrenome}"/>
                    </div><div>
                        <label>Email</label>
                        <input class="textsize text-MB" type="email" name="email" placeholder="Email" required="true" value="${funcionario.email}"/>
                    </div><div>
                        <label>CPF</label>
                        <input class="textsize text-MB" type="number" name="cpf" placeholder="CPF" required="true" value="${funcionario.CPF}"/> 
                    </div><div>
                        <label>Atuacao</label>
                        <select class="textsize text-MB" name="Atuacao" placeholder="Atuacao" required="true">
                            <c:if test="${funcionario.atuacao == 'Vendedor'}">
                                <option value="Vendedor">Vendedor</option>
                                <option value="RH">RH</option>
                                <option value="Gerente">Gerente</option>
                                <option value="Suporte">Suporte</option>
                                <option value="ADM">ADM</option>
                            </c:if>
                            <c:if test="${funcionario.atuacao == 'RH'}">
                                <option value="RH">RH</option>
                                <option value="Vendedor">Vendedor</option>
                                <option value="Gerente">Gerente</option>
                                <option value="Suporte">Suporte</option>
                                <option value="ADM">ADM</option>
                            </c:if>
                            <c:if test="${funcionario.atuacao == 'ADM'}">
                                <option value="ADM">ADM</option>
                                <option value="Vendedor">Vendedor</option>
                                <option value="RH">RH</option>
                                <option value="Gerente">Gerente</option>
                                <option value="Suporte">Suporte</option>
                            </c:if>
                            <c:if test="${funcionario.atuacao == 'Gerente'}">
                                <option value="Gerente">Gerente</option>
                                <option value="Vendedor">Vendedor</option>
                                <option value="RH">RH</option>
                                <option value="Suporte">Suporte</option>
                                <option value="ADM">ADM</option>
                            </c:if>
                            <c:if test="${funcionario.atuacao == 'Suporte'}">
                                <option value="Suporte">Suporte</option>
                                <option value="Vendedor">Vendedor</option>
                                <option value="RH">RH</option>
                                <option value="Gerente">Gerente</option>
                                <option value="ADM">ADM</option>
                            </c:if>
                        </select>
                    </div><div>
                        <label>Salario</label>
                        <input class="textsize text-MB" type="number" step="0.01" name="salario" placeholder="Salario" required="true" value="${funcionario.salario}"/>
                    </div>
                </div>
                <button class="btn_exe btnG1" type="submit">Atualizar</button>
            </form>
        </c:if>
    </body>
</html>