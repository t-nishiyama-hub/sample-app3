<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sample</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Sample.css">
</head>
<body>
  <form method="post" action="./SampleServlet">
    <div class="error"><%= request.getAttribute("message") %></div>
    <div class="input">
      <div>ユーザID: <input type="text" name="id"></div>
      <div>パスワード: <input type="text" name="password"></div>
    </div>
    <button type="submit">Login</button>
  </form>

</body>
</html>