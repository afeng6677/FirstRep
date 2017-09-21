var grid_selector = "#myTab";
//条件搜索start
var flag = true;
function moreSearch(){
	if(flag){
		$("#search-term").removeClass("search-term");
		$("#search-term").addClass("search-terms");
		flag = false;
	}else{
		$("#search-term").removeClass("search-terms");
		$("#search-term").addClass("search-term");
		flag = true;
	}
	autoHW();
}
function autoHW(){
	var wss = ($(".search-left a.searchList").width()+10)*$(".search-left a.searchList").length;
	$(".search-left").width($("#main-header").width()-$(".search-right").width());
	var wyy = $(".search-left").width();
	if(wss>wyy){
		$(".search-right a.more").css("display","block");
	}
	var hh = $(".mid_com").height();
	$(".list-main").height(hh-$(".main-header").height()-15-10-$(".menu_tabs").height());
	$(".list_jqgrid").height($(".list-main").height()-$(".creameaddbtn").height()-10-10);
	var as = $(".list_jqgrid").height()-36-38-4;
	$(grid_selector).jqGrid('setGridWidth', $(".list_jqgrid").width()-2);
	$(grid_selector).jqGrid('setGridHeight', as);
	var ww = $("#myTab").width();
	var ws = $("#gview_myTab").width();
	if(ww<ws){
		$("#gview_myTab .ui-jqgrid-htable").width(ws);
		$("#myTab").width(ws);
		jQuery(grid_selector).closest(".ui-jqgrid-bdiv").css({
			"overflow-x" : "hidden",
			"overflow-y" : "auto"
		});
	}
}
//条件搜索start
var flags = 0;
function moreSearchs(obj){
	if(flags==0){
		$(obj).parent().parent().removeClass("search-term");
		$(obj).parent().parent().addClass("search-terms");
		flags = 1;
	}else{
		$(obj).parent().parent().removeClass("search-terms");
		$(obj).parent().parent().addClass("search-term");
		flags = 0;
	}
	aa();
}
function autoHWs(){
	$(".search-left").width($(".item_block.selected .main-headers").width()-$(".search-right").width());
	var hh = $(".mid_coms").height();
	$(".automatic-con").height(hh-$(".creametab").height());
	aa();
}
function aa(){
	$(".list-main").height($(".automatic-con").height()-$(".item_block.selected .main-headers").height()-10-10);
	var hs = $(".item_block.selected .list-main").height();
	$("#list_jqgrid1").height(hs - $(".creameaddbtn").height());
	$("#list_jqgrid2").height(hs - $(".creameaddbtn").height()-30);
	$("#list_jqgrid3").height(hs - $(".creameaddbtn").height()-30);
	var as = $("#list_jqgrid1").height()-36-38-4-20;
	$(grid_selector).jqGrid('setGridWidth', $("#list_jqgrid1").width()-2);
	$(grid_selector).jqGrid('setGridHeight', as);
	var as2 = $("#list_jqgrid2").height()-36-38-4-20;
	$(grid_selector2).jqGrid('setGridWidth', $("#list_jqgrid2").width()-2);
	$(grid_selector2).jqGrid('setGridHeight', as2);
	var as3 = $("#list_jqgrid3").height()-36-38-4-20;
	$(grid_selector3).jqGrid('setGridWidth', $("#list_jqgrid3").width()-2);
	$(grid_selector3).jqGrid('setGridHeight', as3);
}
function autoHWss(){
	$(".search-left").width(1000);
	var hh = $(".mid_coms").height();
	$(".automatic-con").height(hh-$(".creametab").height()-20-50);
	$(".list-main").height($(".automatic-con").height());
	var hs = $(".jq").height();
	$("#list_jqgrid").height(hs - $(".creameaddbtn").height()-20);
	var as = $("#list_jqgrid").height()-40;
	$("#list_jqgrid").width($(".item_block").width());
	$(grid_selector).jqGrid('setGridWidth', $("#list_jqgrid").width()-2);
	$(grid_selector).jqGrid('setGridHeight', as);
}