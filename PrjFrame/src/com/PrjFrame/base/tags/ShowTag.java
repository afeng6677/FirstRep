package com.PrjFrame.base.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.PrjFrame.base.util.SecurityUtils;
import com.PrjFrame.entity.SUser;

@SuppressWarnings("serial")
public class ShowTag extends TagSupport{

	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override  
    public int doStartTag() throws JspException {
		SUser suser = SecurityUtils.getCurUser();
		if(suser==null) 
			return TagSupport.EVAL_BODY_INCLUDE;
		boolean smenu = suser.getAuthorityList().contains(name);
		if(smenu) 
		    return TagSupport.EVAL_BODY_INCLUDE;
		else{
			return TagSupport.SKIP_BODY;
		}
		/*if(smenu.isShow()){
			return TagSupport.EVAL_BODY_INCLUDE;
		}else{
			return TagSupport.SKIP_BODY;
		}*/
    }  
	
}
