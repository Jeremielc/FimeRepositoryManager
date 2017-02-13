<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload test</title>
</head>
<body>
<form method="post" action="Reman/file/upload" enctype="multipart/form-data">
    <label for="file">Choisir une image &agrave; charger :</label>
    <input name="file" type="file" id="file" />&nbsp;
    <input type="submit" value="Lancer le chargement"/>
</form>
</body>
</html>
