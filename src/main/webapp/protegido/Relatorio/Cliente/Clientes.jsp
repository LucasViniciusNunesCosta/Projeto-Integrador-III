<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório Cliente</title>
        
        <script src="../../../js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link rel="stylesheet" href="../../../css/main.css">
    </head>
    
    <body>
        <c:import url="../../../header.jsp"/>
                
        <form action="../../../RelatorioClientes" method="POST"ubunto class="CadaCli" id="form">
            <h3>Relatório de clientes</h3>
            <div class="textsbox inputs">
                <div>
                    <label>Data de início</label>
                    <input class="textsize" type="date" id="ini" name="inicio" required="true">
                </div><div>
                    <label>Data final</label>
                    <input class="textsize" type="date" id="fim" name="fim" required="true">
                </div>
            </div>
            <button type="submit" class="btn_exe btnG6">Buscar</button>
        </form>
        
        <script type="text/javascript">
            $("#form").submit(function() {
                var inidate = new Date($("#ini").val());
                var fimdate = new Date($("#fim").val());
                if(inidate < fimdate){
                    return true;
                }else{
                    $("#ModalConfirmacao").show();
                    return false;
                }
            });
            function Cancelar(){
                $("#ModalConfirmacao").hide();
            }
        </script>
        
        <!-- Modal -->
        <div class="modal fade show" id="ModalConfirmacao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content contentCustom">
              <div class="modal-header headerCustom">
                <h5 class="modal-title" id="exampleModalLabel">Data inválida</h5>
              </div>
              <div class="modal-body">
                  <p class="modeal-text">Parâmetro de tempo <b>inválido</b><br>A data Inicial deve vir antes da final</p>
                  <input type="hidden" id="ObjID"/>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btnCancelar" data-bs-dismiss="modal" onclick="Cancelar()">Ok</button>
              </div>
            </div>
          </div>
        </div>
        
    </body>
</html>
