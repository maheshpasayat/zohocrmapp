<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>create lead</h2>
<form action="saveLead" method="post">
<pre>
First name <input type="text" name="firstName"/>
Last name <input type="text" name="lastName"/>
Email <input type="text" name="email"/>
Mobile <input type="text" name="mobile"/>
<select name="source">
<option value="radio">radio</option>
<option value="news paper">newspaper</option>
<option value="trade show">tradeshow</option>
<option value="website">website</option>
</select>
<button>Save</button>
</pre>
</form>
</body>
</html>