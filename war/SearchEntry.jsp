<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Planet Search</title>
</head>
<body bgcolor = "#fff3dc">

	<h2 align = "center"> Planet Search</h2>

	<form method="post" action="PlanetSearch.do">

		<table border="0" cellpadding="5" cellspacing ="3" align = "center">
	
			<tr>
				<th align = "right">Enter Planet : </th>			
				<td><input type="text" name="planet" /> </td>
			</tr>
			<tr>
				<td colspan = "2" align = "center"><input type="submit" value="SUBMIT" /> </td>
			</tr>
		</table>
	</form>
</body>
</html>