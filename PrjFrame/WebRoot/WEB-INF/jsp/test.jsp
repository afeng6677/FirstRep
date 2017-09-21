<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="security" uri="/WEB-INF/tlds/security"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="${ctx}/assets/css/zTreeStyle.css" />
<link rel="stylesheet" href="${ctx}/assets/css/mytest.css" />
<script src="${ctx}/assets/js/bootstrap.js"></script>
<script src="${ctx}/assets/js/chosen.jquery.min.js"></script>
<script src="${ctx}/assets/js/jquery.validate.min.js"></script>
<script src="${ctx}/assets/js/jquery.ztree.core-3.5.js"></script>
<script src="${ctx}/assets/js/jquery.ztree.excheck-3.5.js"></script>
<script src="${ctx}/assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="${ctx}/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="${ctx}/assets/js/date-time/bootstrap-timepicker.min.js"></script>
<script src="${ctx}/assets/js/jquery.maskedinput.min.js"></script>
<script src="${ctx}/assets/js/jquery.jqGrid.min.js"></script>
<script src="${ctx}/assets/js/select2.min.js"></script>
<script src="${ctx}/assets/js/OMS/informationDesk/test.js"></script>
<%-- <script src="${ctx}/assets/js/OMS/informationDesk/testValidate1.js"></script> --%>
<style type="text/css">
.content{
	margin-top: 10px;
	padding: 5px 10px 10px 10px;
	border:1px solid #006EB5;
	border-color:rgba(0,110,181,0.25)
}
#city tr{
	line-height: 40px;
	display:table;
	width:100%;
	table-layout:fixed;
}
#city tr th,td{
	width: 20%;
	text-align: center;
}
</style>

</head>
<body>
   <div class = "col-xs-12">
     <div class="row">
     	<div class="col-xs-7" >
     		<div class="content">
     			<div class="row">
     				<div class = "col-xs-12" style = "height : 300px;">
     					<div class = "col-xs-6">
     						<div class = "content"  style = "height : 280px;">
     							<div class = "row" id = "gridId" style="width: 100%;height: 98%;margin: auto;">
	     							<table id="jqGridTabel"></table>
									<div id="jqGridPager"></div>
     							</div>
     						</div>
     					</div>
     					<div class = "col-xs-6">
     						<div class = "content"  style = "height : 280px;">
     							<div class = "row">
     								<table id = "city">
     									<thead style = "height: 40px;">
     										<tr>
     											<th>名称</th>
     											<th>城市</th>
     											<th>邮编</th>
     											<th>名称</th>
     											<th>城市</th>
     										</tr>
     									</thead>
     									<tbody style="overflow: auto;display:block;height: 230px;width: 99%">
     										<tr>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     											<td>560001</td>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     										</tr>
     										<tr>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     											<td>560001</td>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     										</tr>
     										<tr>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     											<td>560001</td>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     										</tr>
     										<tr>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     											<td>560001</td>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     										</tr>
     										<tr>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     											<td>560001</td>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     										</tr>
     										<tr>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     											<td>560001</td>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     										</tr>
     										<tr>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     											<td>560001</td>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     										</tr>
     										<tr>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     											<td>560001</td>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     										</tr>
     										<tr>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     											<td>560001</td>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     										</tr>
     										<tr>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     											<td>560001</td>
     											<td>Tanmay</td>
     											<td>Bangalore</td>
     										</tr>
     									</tbody>
     								</table>
     							</div>
     						</div>
     					</div>
     				</div>
     			</div>
     		</div>
     		<div class="row">
     			<div class = "col-xs-6">
	     			<div class = "content">
	     				<div class="row">
	     					<div class = "col-xs-12" style = "height : 200px;">
	     						<div class = "row">
	     							<ul class ="myTab">
	     								<li class = "serActive">已发送</li>
	     								<li>已接受</li>
	     								<li>已关闭</li>
	     							</ul>
	     						</div>
	     						<div class = "row">
	     							<div class = "li-item content" style="border-color: red;display: block;"></div>
	     							<div class = "li-item content" style="border-color: green;"></div>
	     							<div class = "li-item content" style="border-color: blue;"></div>
	     						</div>
	     					</div>
	     				</div>	
	     			</div>
	     			<div class = "content">
	     				<div class="row">
	     					<div class = "col-xs-12" style = "height : 205px;">
	     						<form class = "myForm" id ="myForm">
	     							<div class = "row">
	     								<div class = "form-group col-xs-6">
	     								 <label>文本：</label>
		                                 <input type="text"  name="name"  placeholder="请输入文本">
	     							</div>
	     							<div class = "form-group col-xs-6">
	     								 <label>单选：</label>
		                                 <input type="radio" name="radio" value = "radio1">单选１
		                                 <input type="radio" name="radio" value = "radio2">单选２
		                                 <input type="radio" name="radio" value = "radio3">单选３
	     							</div>
	     							</div>
	     							<div class = "row">
	     								<div class = "form-group col-xs-6">
	     								 <label>多选：</label>
		                                 <input type="checkbox"  name="checkbox" value = "checkbox1">多选１
		                                 <input type="checkbox"  name="checkbox" value = "checkbox2">多选２
		                                 <input type="checkbox"  name="checkbox" value = "checkbox3">多选３
	     							</div>
	     							<div class = "form-group col-xs-6">
	     								 <label>下拉：</label>
		                                 <select style="width: 180px;" id = "select">
		                                 	<option value = "0">请选择</option>
		                                 	<option value = "option１">下拉１</option>
		                                 	<option value = "option２">下拉２</option>
		                                 	<option value = "option３">下拉３</option>
		                                 	<option value = "option４">下拉４</option>
		                                 </select>
	     							</div>
	     							</div>
	     							<div class = "row">
	     								<div class = "form-group col-xs-6">
		     								<label>多文：</label>
			                                <textarea  id = "textarea" name="textarea" cols="9"></textarea>
	     								</div>
	     								<div class = "form-group col-xs-6">
		     								<label>Z树：</label>
			                                <input type="hidden" id="zTreeId"> 
											<input type="text" id="zTreeName" onclick="showZtree()" class="inp_text" readonly="readonly"/>
											<div id="treeDiv" class="ztreeContent">
												<ul id="ztree" class="ztree"></ul>
											</div>
	     								</div>
	     							
	     							</div>
	     							<div class = "row" style="text-align: center;">
	     							
	     								<!--submit 表单验证使用mytest1验证方式  -->
	     								<button type="submit" class="btnZx btnBorderBlue btnBlue">派发</button>&nbsp; &nbsp;&nbsp; &nbsp;
	     								<!--submit 表单验证使用mytest验证方式,需要设置按钮onclick事件 -->
	     								<button type="button" class="btnZx btnBorderBlue btnBlue" onclick="save()" style="display: none">派发</button>
	     								
	     								<button type="button" class="btnZx btnBorderGray btnGray">重置</button>
	     							</div>
	     						</form>
	     					</div>
	     				</div>	
	     			</div>
     			</div>
     			<div class = "col-xs-6">
	     			<div class = "content">
	     				<div class="row">
	     					<div class = "col-xs-12" style = "height : 430px;">
	     						<div class = "form-group col-xs-12" style="margin-top: 15px;">
	     							<div class = "row">
	     								<label>文件选择：</label>
	     								 <div class="fileUpload" style = "display: inline-block;">
			        						<div>
										 		<div class="file-input" onclick="select_file('selectfile')">
													<span>选择源文件</span>
													<img src="${ctx}/assets/images/file_upload_icon.png" style="margin-left: 10px;">
												</div>
												<div class="input-file" style="height: 0px; display: none"></div>
											</div>
										</div>
										<div class = "row">
											<div class="select-file" id="selectfile"></div>
										</div>
	     							</div>
	     							</div>
	     					</div>
	     				</div>
	     			</div>
	     		</div>
     		</div>
     	</div>
     	<div class="col-xs-5">
     		<div class="content">
     			<div class="row">
     				<div class = "col-xs-12" style = "height : 400px;"></div>	
     			</div>
     		</div>
     		<div class = "content">
     			<div class = "row">
     				<div class = "col-xs-12" style = "height:330px;">
     					<div class = "row">
     						<div class = "col-xs-6">
     							<div class = "content" style = "height : 200px;"></div>
     						</div>
     						<div class = "col-xs-6">
     							<div class = "content" style = "height : 200px;"></div>
     						</div>
     					</div>
     					<div class = "row">
     						<div class = "col-xs-12">
     							<div class = "content" style = "height : 100px;"></div>
     						</div>
     					</div>
     				</div>
     			</div>
     		</div>
     	</div>
     </div>
   </div>
    
</body>
</html>
