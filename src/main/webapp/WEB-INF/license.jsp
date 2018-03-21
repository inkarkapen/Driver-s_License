<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>New License</h1>
<form:form method="POST" action="/license/create" modelAttribute="license">
    <br><form:label path="person">Person
    <form:errors path="person"/>
    <form:select path="person">
    	<c:forEach items="${persons}" var="person">
    		<c:if test = "${person.getLicense() == null}">
	    		<form:option value="${person.id}">
	    			<c:out value="${person.firstName} ${person.lastName}" />
	    		</form:option>
    		</c:if>
    	</c:forEach>
     </form:select></form:label>
    
    <br><form:label path="state">State: 
    <form:errors path="state"/>
    <form:input path="state"/></form:label>
    
    <br><form:label path="expiration_date">Expiration Date: 
    <form:errors path="expiration_date"/>
    <form:input type="date" path="expiration_date"/></form:label>
        
    <br><input type="submit" value="Create"/>
</form:form>
</body>
</html>