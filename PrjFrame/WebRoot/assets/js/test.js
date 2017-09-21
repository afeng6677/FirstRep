var grid_selector = "#jqGridTabel";
var pager_selector = "#jqGridPager";


/**
 * jgGrid表格数据填充
 */
function loadJgGridTable(){
	
	$(window).on('resize.jqGrid', function() {
		
		$(grid_selector).jqGrid('setGridWidth', $("#gridId").width());
		$(grid_selector).jqGrid('setGridHeight', $("#gridId").height()*0.75);
	});
	
	jQuery(grid_selector).jqGrid(
			{
				datatype : "json",
				mtype : "POST",
				url : basePath + 'inforDesk/findTasks',
				colNames : [ '编号', '任务名称', '来源ID', '来源分类', '服务ID',
						'服务', '任务描述', '紧急度', '影响度', '任务等级', '任务状态',
						'SLA状态', '创建人ID','创建人', '创建时间', '结束时间'],
				colModel : [
						{
							name : 'id',
							index : 'id',
							hidden : true
						},
						{
							name : 'name',
							index : 'name',
							width : 100,
						},
						{
							name : 'source_id',
							index : 'source_id',
							hidden : true
						},
						{
							name : 'category',
							index : 'category',
							formatter : "select",
							width : 100,
							editoptions : {
								value : "0:事件;1:问题;2:手动;"
							},
						},
						{
							name : 'server_id',
							index : 'server_id',
							hidden : true
						},
						{
							name : 'serverName',
							index : 'serverName',
							width : 100,
						},
						{
							name : 'depict',
							index : 'depict',
							width : 100,
//							hidden : true
						},
						{
							name : 'urgent',
							index : 'urgent',
							formatter : "select",
							editoptions : {
								value : "0:高;1:中;2:低;"
							},
							width : 100,
							
						},
						{
							name : 'affect',
							index : 'affect',
							formatter : "select",
							editoptions : {
								value : "0:高;1:中;2:低;"
							},
							width : 100,

						},
						{
							name : 'level',
							index : 'level',
							formatter : "select",
							editoptions : {
								value : "1:一级;2:二级;3:三级;4:四级;5:五级;"
							},
							width : 100,
						},
						{
							name : 'status',
							index : 'status',
							formatter : "select",
							editoptions : {
								value : "0:<font color='red'>已派发,未接收</font>;1:<font color='green'>已接收,未解决</font>;"
										+ "2:<font color='blue'>已解决</font>;3:<font color='purple'>未解决,回退</font>;4:<font color='gray'>结束</font>;"
							},
							hidden : true
						}, {
							name : 'slaStatus',
							index : 'slaStatus',
							width : 100,
						}, {
							name : 'creator',
							index : 'creator',
							width : 100,
						}, {
							name : 'createName',
							index : 'createName',
							width : 100,
						}, {
							name : 'create_time',
							index : 'create_time',
							width : 170,
						}, {
							name : 'end_time',
							index : 'end_time',
							hidden : true
						},
						],
					postData : {
						'search#EQ#t.status' : 2
					}, 
				shrinkToFit : false,//当初始化列宽度时候的计算类型，如果为ture，则按比例初始化列宽度。如果为false，则列宽度使用colModel指定的宽度
				viewrecords : true,// 是否显示总记录数
				rowNum : 10,
				pager : pager_selector,
				altRows : true,//设置jqGrid显示为斑马线样式。就是隔行用不同的背景色区分开。
				loadComplete : function() {
					updatePagerIcons(this);
				},
				sortable : true,
				sortname : 'create_time',
				sortorder : 'desc',
				pagerpos : 'right',//指定分页栏的位置
				recordpos : 'left',//定义了记录信息的位置
			});
	
	//设置横向滚动条
	jQuery(grid_selector).closest(".ui-jqgrid-bdiv").css({
		"overflow-x" : "auto"
	});
	
	//表头居中　ace.css jQuery(".ui-jqgrid .ui-jqgrid-htable th div").css({"text-align" :"center"});
	//表中内容居中　ace.css .ui-jqgrid tr.ui-row-ltr td,.ui-jqgrid tr.ui-row-rtl td
	
	$(window).triggerHandler('resize.jqGrid');// trigger window resize to make
	
	//设置分页按钮样式
	function updatePagerIcons(table) {
		var replacement = {
			'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
			'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
			'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
			'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
		};
		
		$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon')
				.each(
						function() {
							var icon = $(this);
							var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

							if ($class in replacement)
								icon.attr('class', 'ui-icon '+ replacement[$class]);
						});
	}
	$(document).on('ajaxloadstart', function(e) {
		$(grid_selector).jqGrid('GridUnload');
		$('.ui-jqdialog').remove();
	});
}


/**
 * tab点击事件
 */
function tabClick(){
	$('.myTab li').click(function(){
    	$(this).addClass("serActive").siblings().removeClass("serActive");
    	var index= $('.myTab li').index(this);
    	$('.li-item').eq(index).show().siblings().hide();
    });
}

/**
 * 获取表单元素值
 */
function getFormValue(){
	//text
	var text = $("#name").val();
	//radio
	var radio = $('input[name="radio"]:checked').val();
	//checkbox
	var checkbox = "";
	$("input[name='checkbox']:checkbox").each(function(){
		if (true == $(this).attr("checked")) {
			checkbox += $(this).attr('value')+',';
		} 
	});
	//select
	var select =  $("#select").val();
	//textarea
	var textarea = $("#textarea").val();
}

/**
 * 返填表单元素值
 */
function fillForm(){
	//text
	$("#name").val(name);
	
	//radio
	$("input[type=radio][name=radio][value=" + radioValue + "]").attr("checked", true);
	
	//checkbox
	var checkboxs = $("#checkbox-hidden").val();
	var checkbox = checkboxs.split(",");
	for (var i = 0; i < checkbox.length; i++) {
		$("input:checkbox[name=checkbox][value='" + checkbox[i] + "']").attr('checked', true);
	}
	
	//select
	//设置value为pxx的项选中
    $("#select").val("pxx");
    //设置text为pxx的项选中
   $("#select").find("option[text='pxx']").attr("selected",true);
   
	//textarea
	$("#textarea").val(textarea);
}

/*************************ZTree树 Strat*****************************************/
var treeJson = "";

function getZTree() {
	$.ajax({
		type : "POST",
		url : basePath + "services/getServicesTree",
		asycn : true,
		dataType : 'text',
		success : function(result) {
			treeJson = result;
			loadZTree(treeJson);
		}
	});
}

var zTreeClick = function(e, treeId, treeNode) {
//	var tree = $.fn.zTree.getZTreeObj("server-tree");
	$('#zTreeId').val('');
	$('#zTreeName').val(treeNode.name);
	$('#zTreeId').val(treeNode.id);
	hideZTree();
};

var loadZTree = function(treeJson) {
	var setting = {
		view : {
			dblClickExpand : false
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			onClick : zTreeClick
		}
	};

	$.fn.zTree.init($("#ztree"), setting, eval(treeJson));
	// 展开根节点
	var ztree = $.fn.zTree.getZTreeObj("ztree");
	var rootNodes = ztree.getNodesByFilter(function(node) {
		return node.level == 0;
	});
	if (rootNodes.length > 0) {
		for (var i = 0; i < rootNodes.length; i++) {
			ztree.expandNode(rootNodes[0], true, false, true);
		}
	}
};

var hideZTree = function() {
	$("#treeDiv").fadeOut("fast");
	$("body").unbind("mousedown", onTreeDown);
};

var onTreeDown = function(event) {
	if (!(event.target.id == "treeDiv" || $(event.target).parents(
			"#treeDiv").length > 0)) {
		hideZTree();
	}
};

var showZtree = function() {
	$("#treeDiv").slideDown("fast");
	$("body").bind("mousedown", onTreeDown);
};

/*************************ZTree树 End*****************************************/

/*
 * ForDight(Dight,How):数值格式化函数，Dight要 格式化的 数字，How要保留的小数位数。
 */
function ForDight(Dight, How) {
	Dight = Math.round(Dight * Math.pow(10, How)) / Math.pow(10, How);
	return Dight;
}
/** *获取没有后缀的文件名** */
function GetFileNameNoExt(filepath) {
	if (filepath != "") {
		var names = filepath.split("\\");
		var pos = names[names.length - 1].lastIndexOf(".");
		return names[names.length - 1].substring(0, pos);
	}
}
/********************************文件上传 Start********************************************/

var fileNum = 1;//文件个数
function select_file(file){
	var id = file +"_"+fileNum;
	
	$(".input-file").append(
			'<input class ="file" type="file" id="' + id + '" name="' + id
					+ '" style="opacity:0;" onchange="selectFile(\'' + id
					+ '\',\'' + fileNum + '\')"/>');
	$("#" + id).click();
}

//选择文件事件
function selectFile(id, index) {
	var file = $("#" + id)[0].files;
	var fileName = file[0].name;// 文件名
	var filetype = fileName.replace(/.+\./, "");// 正则表达式获取后缀
	var fileSize = file[0].size;// 大小 字节
	if (filetype != "jpeg" && filetype != "png" && filetype != "gif"
			&& filetype != "jpg") {
		alert('格式错误！');
	} else {
		fileNum ++;
		uploadF(fileName, fileSize, filetype, id, index, file);
	}

}

//添加所选文件显示
function uploadF(fileName, fileSize, filetype, id, index, file) {

	var strs = '';

	var fileId = "uploadFile";

	if (typeof FileReader == 'undefined') {
		alert('不支持 FileReader');
	}
	var showSrc = "";
	
	//获取图片的缩略图
	var reader = new FileReader();
	reader.readAsDataURL(file[0]);
	reader.onload = function(e) {
		showSrc = this.result;
		var size = ForDight(fileSize / 1024 / 1024, 2);
		
		strs += '<div class="file_group">';
		
		strs += '<div  style="border: 1px solid #c0c0c0;width:86px;height:86px;float: left;margin-left : 20px;">';
		//缩略图	
		strs += '<img width="86" height="86" src="'+ showSrc + '"/></div>';

		strs += '<div class="filedetail" style = "float: left;">';
		
		//fileId: 为了区分上传文件类型(图片/文件)的不同，fileId不同，根据fileId来得到不同类型文件数
		strs += '<div class="file_info ' + fileId + '" style = "float: left;">';
		
		strs += '<div class="file_infos" id="'+ ("type_" + index)+ '">';
		//隐藏域保存文件的实际文件名
		strs += '<input type="hidden" id="defaultitle"  value="'+ GetFileNameNoExt(fileName)+ '"/>';
		//可以更改文件名称
		strs += '<input type="text" id="title" style="width:200px;height: 30px;margin-left : 10px;" class="suce-file-input" value="'
				+ GetFileNameNoExt(fileName) + '"/>' + ".&nbsp;" + filetype;
				
		strs += '</div>';
		//文件大小
		strs += '<div class="file_infos" id="' + ("size_" + index) + '" style = "margin-left:10px;margin-top:5px;">';
		strs += '<span>  文件大小：</span>';
		strs += '<span id="size">' + size + 'MB</span>';
		strs += '</div>';
		
		strs += '</div>';
		//删除文件
		strs += '<div class="fr delefile" style="display:block" id="uploadele">';
		strs += '<div class="deleimg"></div>';
		strs += '<p>删除文件</p>';
		strs += '</div>';
		
		strs += '</div>';
		strs += '</div>';
		
		$("#" + id.split("_")[0]).append(strs);

		// 删除上传的文件
		$("#uploadele").unbind();
		$("#uploadele").click(function() {
			$(this).parent().parent().remove();
			$("#" + id).remove();
		});
	};
}
jQuery(function($) {
	loadJgGridTable();
	tabClick();
	getZTree();
});