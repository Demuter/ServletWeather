<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Processing</title>
</head>
<body>
	<%
    String city = request.getParameter("city");
	request.getMethod();
    %>
    
	<h1>
		Weather in
		<%=city%>
	</h1>
	
	<%
      java.util.Date date = new java.util.Date();
  	%>

	<h2>
		Now is
		<%=date.toString()%>
	</h2>

	<%@page import="weather.LoadParseXML"%>
	<% LoadParseXML loader = new LoadParseXML(); %>
	<%loader.load(city);
  loader.parseXML();  
  	%>
  	
	<h3>
		<%=loader.parseCityName() %>
		<br>
		<%=loader.parseTemperature() %>
		<br>
		<%=loader.parseHumidity() %>
		<br>
		<%=loader.parsePressure() %>
		<br>
		<%=loader.parseClouds() %>
		<br>
	</h3>

</body>
</html>