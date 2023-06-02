<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Application successfully saved</h1>
<br>
<h1>Name = <%= request.getAttribute("name")%></h1>
<br>
<h1>Age = <%= request.getAttribute("age")%></h1>
<br>
<h1>Gender = <%= request.getAttribute("gender")%></h1>
</body>
</html>
