<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        
        <c:import url="../../header.jsp"/>
        <c:if test="${empty listaItems}">
            <section class="lista">
                <h3>Adicionar ao carrinho</h3>
                <div class="BoxLista">
                    <table class="ListaESTO">
                        <th>Nome</th>
                        <th>Marca</th>
                        <th>Categoria</th>
                        <th>Quantidade</th>
                        <th>valor</th>

                        <c:forEach items="${listaEtoqueFilial}" var="estoque">
                        <tr>
                            <td>${estoque.nome}</td>
                            <td>${estoque.marca}</td>
                            <td>${estoque.categoria}</td>
                            <td>${estoque.QTD}</td>
                            <td>R$${estoque.v_venda}</td>
                            <td><a onclick="Confirmacao(`${estoque.ID}`,`${estoque.QTD}`,`${estoque.nome}`)" class="redirect">Adicionar</a></td>
                        </tr>
                        </c:forEach>
                    </table>
                </div>
            </section>


            <script type="text/javascript">
                function Confirmacao(ID, QTD, nome){
                    $("#ObjNome").html(nome);
                    $("#ObjQTD").val(QTD);
                    $("#ObjID").val(ID);
                    $("#ModalConfirmacao").show();
                }
                function Cancelar(){
                    $("#ModalConfirmacao").hide();
                }
                function Confirmado(){
                    var ID = $("#ObjID").val();
                    var QTD = $("#ObjQTD").val();
                    var QTDAdd = $("#ObjQTDAdd").val();
                    var Desconto = $("#ObjDscon").val();
                    if (QTD >= QTDAdd){
                        if(Desconto<90 && Desconto>=0){
                            $.ajax("CarrinhoV?Item="+ID+","+QTDAdd+","+Desconto).done(function(){
                                location.reload();
                            });
                        }else{
                            
                        }
                    }else{
                        alert("ERRO. quantidade solicitada maior que estoque");
                    }
                }
            </script>

            <!-- Modal -->
            <div class="modal fade show" id="ModalConfirmacao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered modal-lg">
                <div class="modal-content contentCustom">
                  <div class="modal-header headerCustom">
                    <h5 class="modal-title" id="exampleModalLabel">Confirmação Adicionar</h5>
                  </div>
                  <div class="modal-body">
                      <p class="modeal-text">Nome do produto: <b><label id="ObjNome"></label></b></p><br>
                      <label>Quantidade</label>
                      <input type="number" id="ObjQTDAdd" value="1"/><br>
                      <label>Desconto</label>
                      <input type="number" id="ObjDscon" value="0"/>
                      <input type="hidden" id="ObjID"/>
                      <input type="hidden" id="ObjQTD"/>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btnConfirmarAdd" onclick="Confirmado()">Adicionar</button>
                    <button type="button" class="btn btnCancelar" data-bs-dismiss="modal" onclick="Cancelar()">Cancelar</button>
                  </div>
                </div>
              </div>
            </div>
        
        </c:if>
        
        <c:if test="${not empty listaItems}">
            <section class="lista">
                <h3>Carrinho</h3>
                <div class="BoxLista">
                    <table class="ListaESTO">
                        <th>Nome</th>
                        <th>Marca</th>
                        <th>Quantidade</th>
                        <th>Valor por item</th>
                        <th>Desconto</th>
                        <th>valor total</th>

                        <c:forEach items="${listaItems}" var="estoque">
                        <tr>
                            <td>${estoque.nome}</td>
                            <td>${estoque.marca}</td>
                            <td>${estoque.QTD}</td>
                            <td>R$${estoque.v_venda}</td>
                            <td>%${estoque.desconto}</td>
                            <td>R$${estoque.v_total}</td>
                        </tr>
                        </c:forEach>
                    </table>
                    <a onclick="Confirmacao()" class="btm_CelularP">Cancelar pedido</a>
                </div>
            </section>
            
            <script type="text/javascript">
                function Confirmacao(){
                    $("#ModalConfirmacao").show();
                }
                function Cancelar(){
                    $("#ModalConfirmacao").hide();
                }
                function Confirmado(){
                    Cancelar();
                    $.ajax("CarrinhoV?canpedido=1").done(function(){
                        window.location.href=("/Projeto-Integrador-III/protegido/home.jsp");
                    });
                }
            </script>

            <!-- Modal -->
            <div class="modal fade show" id="ModalConfirmacao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered modal-lg">
                <div class="modal-content contentCustom">
                  <div class="modal-header headerCustom">
                    <h5 class="modal-title" id="exampleModalLabel">Cancelamento da venda</h5>
                  </div>
                  <div class="modal-body">
                      <p class="modeal-text">Tem certeza que quer cancelar essa compra?</p>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btnConfirmarExclusao" onclick="Confirmado()">Sim</button>
                    <button type="button" class="btn btnCancelar" data-bs-dismiss="modal" onclick="Cancelar()">Não</button>
                  </div>
                </div>
              </div>
            </div>
        </c:if>
        
    </body>
</html>
