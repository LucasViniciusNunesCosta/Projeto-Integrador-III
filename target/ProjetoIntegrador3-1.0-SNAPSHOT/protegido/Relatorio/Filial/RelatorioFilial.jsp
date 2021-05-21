<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ralatorio por Filial</title>
        <link rel="stylesheet" href="css/main.css">

        <link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
        <script src="js/jquery.confirm.js"></script>
    </head>
    <body>
        <c:import url="../../header.jsp"/>
        <form class="lista">
            <h3>Ralatorio por Filial de ${periodo.data_inicio} a ${periodo.data_fim}</h3>
            <div class="BoxLista">
                    <table>
                    <th>ID Filial</th>
                    <th>valor total nesse período</th>
                    <c:forEach items="${listaPorFilial}" var="venda">
                    <tr>
                        <td>${venda.ID_Cliente}</td>
                        <td>${venda.vendaTotal}</td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
        
        <script>
            $("#simpleConfirm").confirm();
            $("#complexConfirm").confirm({
                title:"Delete confirmation",
                text: "This is very dangerous, you shouldn't do it! Are you really really sure?",
                confirm: function(button) {
                    button.fadeOut(2000).fadeIn(2000);
                    alert("You just confirmed.");
                },
                cancel: function(button) {
                    button.fadeOut(2000).fadeIn(2000);
                    alert("You aborted the operation.");
                },
                confirmButton: "Yes I am",
                cancelButton: "No"
            });
            $("#dataConfirm").confirm();
            $("#manualTrigger").click(function() {
                $.confirm({
                    text: "This is a confirmation dialog manually triggered! Please confirm:",
                    confirm: function() {
                        alert("You just confirmed.");
                    },
                    cancel: function() {
                        alert("You cancelled.");
                    }
                });
            });
            $("#noCancelButton").confirm({
                text: "This is a confirmation dialog manually triggered! Please confirm:",
                cancelButton: false,
                confirm: function() {
                    alert("You just confirmed.");
                }
            });
            $("#modalOptions").confirm({
                text: "You can't escape! You are forced to choose!",
                modalOptionsBackdrop: 'static',
                modalOptionsKeyboard: false,
                confirm: function() {
                    alert("You just confirmed.");
                },
                cancel: function() {
                    alert("You cancelled.");
                }
            });
        </script>

        <script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
        <script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
    </body>
</html>
