<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="../../js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link href="../../css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="../../css/main.css">
        <link rel="shortcut icon" href="../../img/Xgeek-Icone.ico" type="image/x-icon">
        <title>Nova Senha</title>
    </head>
    <body>
        <c:import url="../../header.jsp"/>
        <form action="../../AtualizarFuncionarioDados" method="POST" class="CadaEst" onsubmit="return Confirmacao()">
            <h3>Nova Senha</h3>
            <input type="hidden" name="funcionarioID" value="${sessionScope.usuario.ID}"/>
            <input type="hidden" name="Acao" value="Senha"/>
            <div class="textsbox inputs">
                <div>
                    <label>Nova Senha</label>
                    <input class="textsize text-MB" autocomplete="off" type="password" name="Senha" placeholder="Senha" id="Senha" required="true"/>
                </div><div>
                    <label>Confirme a Senha</label>
                    <input class="textsize text-MB" autocomplete="off" type="password" name="ConSenha" placeholder="confirme a senha" id="ConSenha" required="true"/>
                </div>
            </div>
            <button class="btn_exe" type="submit">Atualizar</button>
        </form>

        <script type="text/javascript">
            function Confirmacao(){
                var Senha = $("#Senha").val();
                var ConSenha = $("#ConSenha").val();
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
                  <p class="modeal-text">A senha e a senha de confirmação estão diferentes<br>Por favor verifique a senha</p>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btnCancelar" data-bs-dismiss="modal" onclick="Cancelar()">Ok</button>
              </div>
            </div>
          </div>
        </div>
    </body>
</html>
