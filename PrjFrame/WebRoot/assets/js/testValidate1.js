
jQuery(function($) {
	$('#myForm').validate({
		errorElement : 'div',
		errorClass : 'help-block',
		focusInvalid : false,
		rules : {
			name : {
				required : true,
				remote : {
					url : basePath + "services/checkHasCategoryName", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "json", // 接受数据格式
					data : {
						id : function() {
							return $("#cate_hidden_id").val();
						}
					}
				},
				maxlength : 50
			},
			sort : {
				number : true,
				maxlength : 6
			}
		},
		messages : {
			name : {
				required : "请输入名称",
				remote : "名称已存在",
				maxlength : "不能超过50个字符"
			},
			sort : {
				number : "请输入有效数字",
				maxlength : "不能超过6个字符"
			}
		},

		highlight : function(e) {
			$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
		},

		success : function(e) {
			$(e).closest('.form-group').removeClass('has-error');// .addClass('has-info');
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
		submitHandler : function(form) {
			$.ajax({
				type : "POST",
				url : basePath + "services/addOrEditSerCategory",
				data : $('#myForm').serialize(),
				dataType : 'json',
				success : function(result) {
					
				}
			});
		},
		invalidHandler : function(form) {
		}
	});
});
