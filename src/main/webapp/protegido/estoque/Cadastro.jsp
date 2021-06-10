<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8">
        <c:if test="${empty produto}">
            <script src="../../js/jquery-3.6.0.min.js" type="text/javascript"></script>
            <link href="../../css/bootstrap.min.css" rel="stylesheet">
            <link rel="stylesheet" href="../../css/main.css">
            <link rel="shortcut icon" href="../../img/Xgeek-Icone.ico" type="image/x-icon">
            <title>Cadastro de Produto</title>
        </c:if>
        <c:if test="${not empty produto}">
            <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link rel="stylesheet" href="css/main.css">
            <link rel="shortcut icon" href="img/Xgeek-Icone.ico" type="image/x-icon">
            <title>Atualização de Produto</title>
        </c:if>
    </head>
    <body>
        <c:import url="../../header.jsp"/>
        
        <c:if test="${empty produto}">
        <form action="../../CadastrarProduto" method="POST" class="CadaEst" onsubmit="return Confirmacao()">
            <h3>Cadastro de Produto</h3>
            <div class="textsbox inputs">
                <div>
                    <label>Nome</label>
                    <input class="textsize text-MB" type="text" name="Nome" placeholder="Nome" required="true">
                </div><div>
                    <label>Marca</label>
                    <input class="textsize text-MB" type="text" name="Marca" placeholder="Marca" required="true">
                </div><div>
                    <label>Categoria</label>
                    <input class="textsize text-MB" type="text" name="Categoria" placeholder="Categoria" required="true">
                </div><div>
                    <label>Quatidade</label>
                    <input class="textsize text-MB" type="number" name="Quatidade" placeholder="Quatidade" required="true">
                </div><div>
                    <label>Valor de compra</label>
                    <input class="textsize text-MB" type="number" step="0.01" name="Valor_compra" placeholder="Valor de compra" required="true" id="ValorCompra">
                </div><div>
                    <label>Valor de venda</label>
                    <input class="textsize text-MB" type="number" step="0.01" name="Valor_venda" placeholder="Valor de venda" required="true" id="ValorVenda">
                </div><div>
                    <label>Filial</label>
                    <input class="textsize text-MB" type="number" name="Filial" placeholder="Filial" required="true" value="${sessionScope.usuario.ID_Filial}">
                </div>
            </div>
            <button type="submit" class="btn_exe btnG3">Cadastro</button>
        </form>
        </c:if>
        <c:if test="${not empty produto}">
        <form action="AtualizarProduto" method="POST"ubunto class="CadaEst" onsubmit="return Confirmacao()">
            <h3>Atualização do Produto</h3>
            <input type="hidden" name="ID_Produto" value="${produto.ID}">
            <div class="textsbox inputs">
                <div>
                    <label>Nome</label>
                    <input class="textsize text-MB" type="text" name="Nome" placeholder="Nome" required="true" value="${produto.nome}">
                </div><div>
                    <label>Marca</label>
                    <input class="textsize text-MB" type="text" name="Marca" placeholder="Marca" required="true" value="${produto.marca}">
                </div><div>
                    <label>Categoria</label>
                    <input class="textsize text-MB" type="text" name="Categoria" placeholder="Categoria" required="true" value="${produto.categoria}">
                </div><div>
                    <label>Quatidade</label>
                    <input class="textsize text-MB" type="text" name="Quatidade" placeholder="Quatidade" required="true" value="${produto.QTD}">
                </div><div>
                    <label>Valor de compra</label>
                    <input class="textsize text-MB" type="text" name="Valor_compra" placeholder="Valor de compra" required="true" id="ValorCompra" value="${produto.v_compra}">
                </div><div>
                    <label>Valor de venda</label>
                    <input class="textsize text-MB" type="text" name="Valor_venda" placeholder="Valor de venda" required="true" id="ValorVenda" value="${produto.v_venda}">
                </div><div>
                    <label>Filial</label>
                    <input class="textsize text-MB" type="text" name="Filial" placeholder="Filial" required="true" value="${produto.filiaID}">
                </div>
            </div>
            <button type="submit" class="btn_exe btnG3">Atualizar</button>
        </form>
        </c:if>
        
        <script type="text/javascript">
            function Confirmacao(){
                var compra = $("#ValorCompra").val();
                var venda = $("#ValorVenda").val();
                console.log(compra);
                console.log(venda);
                if (compra < venda){
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
                        <p class="modeal-text">Você não pode vender o item mais barato do que comprou</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btnCancelar" data-bs-dismiss="modal" onclick="Cancelar()">Ok</button>
                    </div>
                </div>
              </div>
        </div>
    </body>
</html>
