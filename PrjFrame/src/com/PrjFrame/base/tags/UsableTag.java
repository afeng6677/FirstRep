package com.PrjFrame.base.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.PrjFrame.base.util.SecurityUtils;
import com.PrjFrame.entity.SMenu;
import com.PrjFrame.entity.SUser;

public class UsableTag extends SimpleTagSupport{

	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		JspWriter jspWriter = this.getJspContext().getOut();
		SUser suser = SecurityUtils.getCurUser();
		try {
			if(suser==null){
				jspWriter.print("true");
				return;
			}
			SMenu smenu = suser.getSmenuMap().get(name);
			if(smenu==null){
				jspWriter.print("true");
				return;
			}
			if(smenu.isShow()){
				jspWriter.print("true");
			}else{
				jspWriter.print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
