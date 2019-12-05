<%@page import="java.util.ArrayList"%>
<% 

ArrayList<String> al=(ArrayList<String>)request.getAttribute("data"); 

for(String empName :al){
	
	out.println(empName);
}

%>