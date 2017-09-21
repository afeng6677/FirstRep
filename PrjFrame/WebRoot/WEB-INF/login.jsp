<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>  
    <html>  
    <head>  
    <base href="<%=basePath%>">
    </head>  
    <body>  
    <h2>Hello World!</h2>  
    <a href="<%=basePath%>model/activiti.do">activiti</a>  
      <form action="<%=basePath%>model/createActiviti" method="get">  
        <input type="text" id="name" name="name"></input>  
        <input type="text" id="key" name="key"></input>  
        <input type="text" id="description" name="description"></input>  
        <input type="submit" value="提交">  
      </form>  
    </body>  
    </html>  
