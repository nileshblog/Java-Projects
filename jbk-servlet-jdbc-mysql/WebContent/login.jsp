<center>
<%
String errorMessage= (String)request.getAttribute("msg");
out.print(errorMessage);
%>
</center>

<center>
<form action="LoginServlet">
User Name:
<input type="text" name="username"><br>

Password:
<input type="text" name="password"><br>

<input type="submit" value="Login">
</form>
</center>