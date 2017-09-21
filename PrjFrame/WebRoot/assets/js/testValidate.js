
function validform() {
	/* 关键在此增加了一个return，返回的是一个validate对象，这个对象有一个form方法，返回的是是否通过验证 */
	return $('#myForm').validate(
					{
						errorElement : 'div',
						errorClass : 'help-block',
						focusInvalid : false,
						rules : {
							name : {
								required : true,
								maxlength : 50
							},
							targetuser : {
							required : true,
							},
							serverName : {
								required : true,
							}
						},
						messages : {
							name : {
								required : "输入任务名称",
								maxlength : "不超过50个字符"
							},
							targetuser :{
								required : "选择派发人",
							},
							serverName :{
								required : "选择服务目录",
							}
						},
						highlight : function(e) {
							$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
						},

						success : function(e) {
							$(e).closest('.form-group').removeClass('has-error');
							$(e).remove();
						},

						errorPlacement : function(error, element) {
							if (element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
								var controls = element.closest('div[class*="col-"]');
								if (controls.find(':checkbox,:radio').length > 1)
									controls.append(error);
								else
									error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
							}
							else if (element.is('.chosen-select')) {
								error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
							} else if (element.is('.date-picker')) {
								error.insertAfter(element.parent().parent());
							} else
								error.insertAfter(element.parent());
						},
					});
}

// 注册表单验证
$(validform());

function saveTask() {
	if (validform().form()) {
		
		$.ajax({
			type : "POST",
			url : basePath + "inforDesk/addTask",
			data : {
				"name" : $("#name").val(),
				"category" : $("#category").val(),
				"urgent" : $("#urgent").val(),
				"affect" : $("#affect").val(),
				"level" : $("#level").val(),
				"serverId" : $("#serverId").val(),
				"userId" : $("#userId").val(),
				"depict" : $("#depict").val(),
				"cusName" : $("#cusName").val(),
				"cusPhone" : $("#cusPhone").val(),
			},
			dataType : 'json',
			success : function(result) {
				if (result == 1) {
					closeDialog('taskModal');
					reLoad();
					$("#xTip").modal('show');
					$("#tipShowText").html('派发任务成功！');
					
				} else {
					$("#xTip").modal('show');
					$("#tipShowText").html('操作失败，请检查后重试！');
				}
			}
		});
	}
}