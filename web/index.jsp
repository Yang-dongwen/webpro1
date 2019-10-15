<%--
  Created by IntelliJ IDEA.
  User: DW
  Date: 2019/9/28
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  Hello World!<br>
  <form action="fileUploadServlet" method="post" enctype="multipart/form-data">
   姓名： <input type="text" name="username"><br>
    年龄：<input type="text" name="age"><br>
     图片 <input type="file" name="photo"><br>
    <input type="submit" value="提交">

  </form>
  </body>
</html>
