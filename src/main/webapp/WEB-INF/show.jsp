<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${person.firstName} ${person.lastName}</h1>
<p>License Number: ${person.license.number}</p>
<p>State: ${person.license.state}</p>
<p>Expiration Date: ${person.license.expiration_date}</p>
</body>
</html>