<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>框架系统</title>
<!-- 允许网页宽度自动调整 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<base href="<%=basePath%>">

<script type="text/javascript">
	var basePath = "<%=basePath%>";
</script>
<!-- 地址栏更改图标  start -->
<link type="image/x-icon" rel="icon" href="${ctx}/assets/images/favicon.ico">
<link type="image/x-icon" rel="shortcut icon" href="${ctx}/assets/images/favicon.ico" >
<!-- 地址栏更改图标  end -->

<link type="text/css" rel="stylesheet"	href="assets/jqGrid/jquery-ui.custom.min.css">
<link type="text/css" rel="stylesheet" href="assets/jqGrid/ui.jqgrid.css">
<link type="text/css" rel="stylesheet" href="assets/jqGrid/myjqGrid.css">
<link rel="stylesheet" href="assets/ztrees/zTreeStyle/zTreeStyle.css" />

<link rel="stylesheet" href="assets/css/frameCommon.css" />

<script type="text/javascript" src="assets/js/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="assets/js/jquery/jquery.validate.min.js"></script>
<!-- ztree start-->
<script src="assets/ztrees/jquery.ztree.core-3.5.js"></script>
<script src="assets/ztrees/jquery.ztree.excheck-3.5.js"></script>
<!-- ztree end-->
<!-- jqgrid start-->
<script type="text/javascript" src="assets/jqGrid/jquery-ui.custom.min.js"></script>
<script type="text/javascript" src="assets/jqGrid/i18n/grid.locale-cn.js"></script>
<script type="text/javascript" src="assets/jqGrid/jquery.jqGrid.js"></script>
<script type="text/javascript" src="assets/jqGrid/grid.setcolumns.js"></script>
<!-- jqgrid end-->
<!-- timepicker start-->
<script type="text/javascript" src="assets/My97DatePicker/WdatePicker.js"></script>
<!-- timepicker end-->
<script type="text/javascript" src="assets/js/ms/msFrame.js"></script>
<sitemesh:head></sitemesh:head>
</head>
<body>
	<div class="main">
		<%@ include file="/WEB-INF/layouts/ms/header.jsp"%>
		<div class="main_mid">
			<%@ include file="/WEB-INF/layouts/ms/left.jsp"%>
			<div class="main_mid_right fl">
				<sitemesh:body></sitemesh:body>
			</div>
		</div>
	</div>
</body>
</html>