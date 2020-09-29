<%@ page pageEncoding="UTF-8"
	isErrorPage="true"
	contentType="text/html;charset=Windows-31J" %>

<html>
<head>
<title>入力内容不適合</title>
</head>
<body>
<h1>例外のメッセージ:${pageContext.exception.message}</h1>
<h1>例外のタイプ:${pageContext.exception.getClass().getName()}</h1>
<a href="c_thread.jsp">入力内容が不適切です。入力しなおしてください</a>
<p><font color="#FFFFFF">
テストテストテストテストテストテストテストテストテストテストテストテストテストテスト
テストテストテストテストテストテストテストテストテストテストテストテストテストテスト
テストテストテストテストテストテストテストテストテストテストテストテストテストテスト
テストテストテストテストテストテストテストテストテストテストテストテストテストテスト
テストテストテストテストテストテストテストテストテストテストテストテストテストテスト
テストテストテストテストテストテストテストテストテストテストテストテストテストテスト
</font></p>
</body>
</html>