<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CognitiveServiceを使うサイト</title>
</head>

<body>
<h1>CognitiveServiceを使うサイト(Sentiment)</h1>

<h3>センチメントを表示したい文字列を入力してください</h3>
<form method="POST" action="./sentimentresult">
<input type="TEXT" name="string" />
<input type="submit" />
</form>
</body>
</html>