<%-- 
    Document   : Cliente
    Created on : 3/10/2020, 10:16:56 AM
    Author     : pablo ajin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
        <script type="text/javascript">
            function nuevo(){
                var cod_cliente = document.getElementById("cod_cliente").value;
                var nombre = document.getElementById("nombre").value;
                var apellido = document.getElementById("apellido").value;
                var direccion = document.getElementById("direccion").value;
                
                document.ClienteNew.action="WebServlet?action=nuevo&cod_cliente="+cod_cliente+"&nombre="+nombre+"&apellido="+apellido+"&direccion="+direccion;
                document.ClienteNew.submit();
            }
            function editar(){
                document.ClienteNew.action="WebServlet?action=editar";
                document.ClienteNew.submit();
            }
        </script>
    </head>
    <body>
        <h1>CLIENTES</h1>
        
        <form name="ClienteNew" method="post">
            <table width="100%">
                <tr>
                    <td>Codigo de Cliente:</td> 
                    <td colspan="2"><input type="text" id="cod_cliente" size="50" value="<%=session.getAttribute("cod_cliente2")==null ? "":session.getAttribute("cod_cliente2")%>"/></td>
                </tr>
                <tr>
                    <td>Nombre:</td> 
                    <td colspan="2"><input type="text" id="nombre" size="50" value="<%=session.getAttribute("nombre2")==null ? "":session.getAttribute("nombre2")%>"/></td>
                </tr>
                <tr>
                    <td>Apellido:</td> 
                    <td colspan="2"><input type="text" id="apellido" size="50" value="<%=session.getAttribute("apellido2")==null ? "":session.getAttribute("apellido2")%>"/></td>
                </tr>
                <tr>
                    <td>Direccion:</td> 
                    <td colspan="2"><input type="text" id="direccion" size="50" value="<%=session.getAttribute("direccion2")==null ? "":session.getAttribute("direccion2")%>"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="button" value="Guardar" onclick="nuevo()" id="btnNuevo" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" >
                        <table border="1">
                            <tr aligs="center">
                                <td width="125px"><b>Codigo de Clientes</b></td>
                                <td width="125px"><b>Nombre</b></td>
                                <td width="125px"><b>Apellido</b></td>
                                <td width="125px"><b>Direccion</b></td>
                                <td width="125px"><b>Operaciones</b></td>
                            </tr>
                            <% if(session.getAttribute("apellido2")!=null){%>
                            <tr>
                                <td><%=session.getAttribute("cod_cliente")==null ? "":session.getAttribute("cod_cliente")%></td>
                                <td><%=session.getAttribute("nombre")==null ? "":session.getAttribute("nombre")%></td>
                                <td><%=session.getAttribute("apellido")==null ? "":session.getAttribute("apellido")%></td>
                                <td><%=session.getAttribute("direccion")==null ? "":session.getAttribute("direccion")%></td>
                                <td><a onclick="editar()" href="#">Editar</td>
                            </tr>
                            <%}%>
                        </table>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
