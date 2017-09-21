<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="fl ml20" style="line-height: 56px;">
	 <span class="index_title" style="display: block;">朗润智业信息平台</span>
</div>
<div class="fr mr20">
	<span class="login-lo fl">您好，请<span class="index-login-lo">登录</span></span>
	<div class="fl user_info" style="display: none;">
		<a> 
			<span id="loginCustom">您好,${empty sessionScope.CurCustom.getSimpleName()?sessionScope.CurCustom.getUserName():sessionScope.CurCustom.getSimpleName()}</span> 
			<img alt="" src="assets/images/search_listicon.png" class="img2">
		</a>
		<ul id="ul_header">
			<li onclick="edituserInfo()">修改用户信息</li>
			<li onclick="editPassword()">修改密码</li>
			<li onclick="loginOut()">安全退出</li>
		</ul>
	</div>
	<div class="frhome fl" title="首页">
		<img alt="" src="assets/images/home_icon.png">
	</div>
	<!-- <div class="home-exit fl" title="退出">
		<img src="assets/images/exit_icon.png"  onclick="loginOut()">
	</div> -->
</div>
	<!-- 遮罩层Div -->
	<div class="fade"></div>
	<!-- alert提示框Div -->
	<div class="modal tips" id="alertDiv">
		<div class="modal-title">
			<div class="modal-title-hed">
				<img src="assets/images/alert_icon.png" style="vertical-align: middle;"/> <span class="ml10"></span>
			</div>
			<div class="modal_close" onclick="closeModal('alertDiv')"></div>
		</div>
		<div class="modal-body" style="height: 140px;">
			<p style="line-height: 100px;text-align: center;font-size: 16px;margin: 15px 20px 0px 20px;"></p>
		</div>
		<div class="modal-footer">
			<button onclick="closeModal('alertDiv')">
				<img src="assets/images/savebt_icon.png" /> <span>确定</span>
			</button>
		</div>
	</div>
	<!-- <div class="rightArrow">登录</div> -->
	<div class="fr login_ct" id="floatDivBoxs">
		<div class="login_top">用户登录</div>
		<div class="login_bom">
			<div class="login_input">
				<img alt="" src="assets/images/login_user.png" class="ml5">
				<input type="text" id="customname" placeholder="请输入您的账号">
			</div>
			<div class="login_input">
				<img alt="" src="assets/images/login_psw.png" class="ml5">
				<input type="password" id="password" placeholder="请输入您的密码">
			</div>
			<div style="margin-top: 20px;color: #8b8b8b;">
				<input type="checkbox" id="cbtest">
	   			<span>记住密码</span>
				<span id="errorMsg" style=" color: red;">&nbsp;</span>
			</div>
			<div class="login_btn" onclick="loginSys()">登录</div>
		</div>
		<img alt="" src="assets/images/loginTopbg.png" class="logintopbg">
	</div>
	<!-- 修改密码Div -->
	<div class="fade"></div>
	<form id="update_password" method="post">
		<div class="modal edit_pass" id="edit_pass">
			<div class="modal-title">
				<div class="modal-title-hed">
					<img src="assets/images/alert_czmm_icon.png" /> <span class="ml10">修改密码</span>
				</div>
				<div class="modal_close" onclick="closeModal('edit_pass')"></div>
			</div>
			<input type="hidden" name="id" id="idcustom" value="${sessionScope.CurCustom.getId()}" /> 
			<div class="modal-body">
				<div class="form-ground">
					<input type="hidden" name="userid" id="iduser"/> 
					<span class="spanName">原密码：</span>
					<input type="password" id="oldpassword" name="oldpass" />
				</div>
				<div class="form-ground">
					<span class="spanName">新密码：</span> 
					<input type="password" id="new-password" name="newpass" />
				</div>
				<div class="form-ground">
					<span class="spanName">确认新密码：</span> 
					<input type="password" id="next-repassword" name="newnextpass" />
				</div>
			</div>
			<div class="modal-footer">
				<button id="edit-ok" type="submit">
					<img src="assets/images/savebt_icon.png" /> <span>确定</span>
				</button>
				<button id="edit-cal" onclick="closeModal('edit_pass')" type="reset">
					<img src="assets/images/cancelbt_icon.png" /> <span>取消</span>
				</button>
			</div>
		</div>
	</form>
	<!-- 修改用户信息 -->
	<form id="update_userinfo" method="post">
		<div class="modal edit_userinfo" id="edit_userinfo">
			<div class="modal-title">
				<div class="modal-title-hed">
					<img src="assets/images/alert_czmm_icon.png" /> 
					<span class="ml10">修改用户信息</span>
					<input type="hidden" name="id" value="${sessionScope.CurCustom.getId()}"/>
				</div>
				<div class="modal_close" onclick="closeModal('edit_userinfo')"></div>
			</div>
			<div class="modal-body">
				<div class="form-ground">
					<input type="hidden"/> 
					<span class="spanName">全称：</span>
					<input type="text" name="fullName" value="${sessionScope.CurCustom.getFullName()}"/>
				</div>
				<div class="form-ground">
					<span class="spanName">简称：</span> 
					<input type="text" name="simpleName" value="${sessionScope.CurCustom.getSimpleName()}"/>
				</div>
				<div class="form-ground">
					<span class="spanName">地址：</span> 
					<input type="text"  name="address" value="${sessionScope.CurCustom.getAddress()}"/>
				</div>
				<div class="form-ground">
					<span class="spanName">电话：</span> 
					<input type="text" name="phone" value="${sessionScope.CurCustom.getPhone()}"/>
				</div>
			</div>
			<div class="modal-footer">
				<button type="submit">
					<img src="assets/images/savebt_icon.png" /> <span>确定</span>
				</button>
				<button onclick="closeModal('edit_userinfo')" type="reset">
					<img src="assets/images/cancelbt_icon.png" /> <span>取消</span>
				</button>
			</div>
		</div>
	</form>
	<div class="modal tips" id="confimDiv">
		<div class="modal-title">
			<div class="modal-title-hed">
				<img src="assets/images/alert_icon.png" style="vertical-align: middle;"/> <span class="ml10"></span>
			</div>
			<div class="modal_close" onclick="closeModal('confimDiv')"></div>
		</div>
		<div class="modal-body" style="height: 140px;">
			<p style="line-height: 140px;text-align: center;font-size: 16px;"></p>
		</div>
		<div class="modal-footer">
			<button id="btn_confirm_ok" onclick="">
				<img src="assets/images/savebt_icon.png" /> <span>确定</span>
			</button>
			<button id="btn_confirm_cal" onclick="closeModal('confimDiv')">
				<img src="assets/images/cancelbt_icon.png" /> <span>取消</span>
			</button>
		</div>
	</div>