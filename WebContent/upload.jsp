<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'upload.jsp' starting page</title>
  </head>
  <body>
    <form action="/CommonServlet/UploadServlet" method="post" enctype="multipart/form-data">
    	文件描述:<input type="text" name="filetext"><br>
    	<input type="file" name="upload"><br>
    	<input type="submit" value="上传">
    </form>
  </body>
</html>