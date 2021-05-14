<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista do Estoque</title>
        
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link rel="stylesheet" href="css/main.css">
    </head>
    
    <body>
        
        <header>
            <ul id="menu-h">
                <a href="home.html" class="logo">
                    <img src="img/Xgeek_branco.png" class="logo-img">
                </a>
                <li><a href="index.html">Entrar</a></li>
                <li><a href="#">Sobre</a></li>
                <li><a href="#">Contato</a></li>
            </ul>
        </header>
        
        <form class="lista">
            <h3>Lista do Estoque</h3>
            <div class="BoxLista">
                <table class="ListaESTO">
                    <th>ID</th>
                    <th>Filial</th>
                    <th>Nome</th>
                    <th>Marca</th>
                    <th>Categoria</th>
                    <th>Quantidade</th>
                    <th>valor de compra</th>
                    <th>valor de venda</th>

                    <c:forEach items="${listaEstoque}" var="estoque">
                    <tr>
                        <td>${estoque.ID}</td>
                        <td>${estoque.filiaID}</td>
                        <td>${estoque.nome}</td>
                        <td>${estoque.marca}</td>
                        <td>${estoque.categoria}</td>
                        <td>${estoque.QTD}</td>
                        <td>${estoque.v_compra}</td>
                        <td>${estoque.v_venda}</td>
                        <c:if test="${acao.atua == true}">
                        <td><a href="AtualizarProduto?ID=${estoque.ID}">Atualizar</a></td>
                        </c:if>
                        <c:if test="${acao.excl == true}">
                        <td><a class="btn_Excluir" onclick="Confirmacao(`${estoque.nome}`,`${estoque.ID}`)">Excluir</a></td>
                        </c:if>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
        
        <script type="text/javascript">
            function Confirmacao(nome, ID){
                $("#ObjNome").html(nome);
                $("#ObjID").val(ID);
                var MC = $("#ModalConfirmacao").show();
            }
            function Cancelar(){
                $("#ModalConfirmacao").hide();
            }
            function Confirmado(){
                var ID = $("#ObjID").val();
                Cancelar();
                $.ajax("ExcluirProduto?ID="+ID).done(function(){
                    location.reload();
                });
            }
        </script>

        <!-- Modal -->
        <div class="modal fade show" id="ModalConfirmacao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content contentCustom">
              <div class="modal-header headerCustom">
                <h5 class="modal-title" id="exampleModalLabel">Confirmação de exclusão</h5>
              </div>
              <div class="modal-body">
                  <p class="modeal-text">Tem certeza que deseja excluir o Produto: <b><label id="ObjNome"></label></b> ?</p>
                  <input type="hidden" id="ObjID"/>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btnConfirmarExclusao" onclick="Confirmado()">Sim tenho</button>
                <button type="button" class="btn btnCancelar" data-bs-dismiss="modal" onclick="Cancelar()">Cancelar</button>
              </div>
            </div>
          </div>
        </div>
        
    </body>
</html>
