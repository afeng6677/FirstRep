<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>朗润智业信息平台</title>
		<base href="<%=basePath%>">
		<script type="text/javascript">
			var basePath = "<%=basePath%>";
		</script>
		<link rel="shortcut icon" href="assets/images/system.ico" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="assets/css/custom/commonCus.css" />
		<link rel="stylesheet" type="text/css" href="assets/css/custom/styleCus.css" />
		<script type="text/javascript" src="assets/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="assets/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="assets/js/jquery.validate.min.js"></script>
		<script type="text/javascript" src="assets/js/custom/cusFrame.js"></script>
		<sitemesh:head></sitemesh:head>
  </head>
  
  <body style="overflow: hidden;">
	<div class="sub_header" id="sub_header">
	  	<%@ include file="/WEB-INF/layouts/custom/header.jsp"%>
    </div>
    <div class="sub_main" id="sub_main">
    	<sitemesh:body></sitemesh:body>
    </div>
    <div class="footer">
    	<%@ include file="/WEB-INF/layouts/custom/footer.jsp"%>
  	</div> 	
  </body>
</html>
