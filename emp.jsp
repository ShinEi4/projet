<%@page import="olona.*,connection.*" %>
<%@page import="java.util.*,java.time.*,java.sql.*" %>
<%
    Vector lsEmploye=(Vector)request.getAttribute("employes");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employe</title>
</head>
<body>
    <h3>Liste des employes</h3>
    <table>
        <th>
            <td>Id</td>
            <td>Nom</td>
            <td>Date</td>
        </th>
        <tr>
            <% for (Object o : lsEmploye) {
                Emp e=(Emp)o; %>
                <td><%= e.getId()%></td>
                <td><%= e.getNom()%></td>
                <td><%= e.getDate()%></td>
            <% } %>
        </tr>
    </table>
    <form action="/projet/emp" method="post">
        <input type="text" name="nom">
        <input type="submit" value="Valider">
    </form>
</body>
</html>