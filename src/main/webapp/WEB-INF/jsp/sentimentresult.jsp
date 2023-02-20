<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sentimentresult</title>
</head>
<%
	Optional<Double> message = 
		Optional.ofNullable((double) request.getAttribute("message"));
Optional<String> string = 
	Optional.ofNullable((String) request.getAttribute("string"));
Optional<Double> message1 = 
Optional.ofNullable((double) request.getAttribute("message1"));
Optional<Double> message2 = 
Optional.ofNullable((double) request.getAttribute("message2"));
%>

<body>
<H1>ConfidenceScores</H1>
<H3>文章：<%= string.orElse("ERROR") %></H3>
<H3>positive：<%= message.orElse(1000.0) %></H3>
<H3>neutral：<%= message1.orElse(1000.0) %></H3>
<H3>negative：<%= message2.orElse(1000.0) %></H3>
</body>
</html>