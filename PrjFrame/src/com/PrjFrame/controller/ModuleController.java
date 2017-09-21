package com.PrjFrame.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Model;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
@RequestMapping("/model")
public class ModuleController {

	private Logger logger = LoggerFactory.getLogger(ModuleController.class);

	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private ManagementService managementService;

	@RequestMapping(value = "create")
	public ModelAndView create(@RequestParam("name") String name, @RequestParam("key") String key,
			@RequestParam("description") String description, HttpServletRequest request, HttpServletResponse response) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			ObjectNode editorNode = objectMapper.createObjectNode();
			editorNode.put("id", "canvas");
			editorNode.put("resourceId", "canvas");
			ObjectNode stencilSetNode = objectMapper.createObjectNode();
			stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
			editorNode.put("stencilset", stencilSetNode);
			Model modelData = repositoryService.newModel();

			ObjectNode modelObjectNode = objectMapper.createObjectNode();
			modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, name);
			modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
			description = StringUtils.defaultString(description);
			modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
			modelData.setMetaInfo(modelObjectNode.toString());
			modelData.setName(name);
			modelData.setKey(StringUtils.defaultString(key));

			repositoryService.saveModel(modelData);
			repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));

			// response.sendRedirect(request.getContextPath() +"/modeler.html?modelId=" + modelData.getId());
			ModelAndView mav = new ModelAndView("../modeler");
//			
//			mav.addObject("modelId", modelData.getId());
//			ModelAndView mav = new ModelAndView();   
			HttpSession session = request.getSession();
			session.setAttribute("modelId",  modelData.getId());   
//	        mav.setViewName("redirect:../modeler");   
	        mav.addObject("modelId", modelData.getId());   
			return mav;
		} catch (Exception e) {
			logger.error("创建模型失败：", e);
			return null;
		}
	}
	
	@RequestMapping(value = "/activiti.do", method = RequestMethod.GET, produces = "application/json;charset=utf-8")  
    @ResponseBody  
    public Object brithdayList(HttpServletRequest req) {  
        Map<String, Object> map = new HashMap<String, Object>();  
        map.put("name", "activiti");  
        return map;  
    }  
	
	@RequestMapping(value = "/createActiviti", method = RequestMethod.GET, produces = "application/json;charset=utf-8")  
    public void createActiviti(  
            @RequestParam("name") String name,  
            @RequestParam("key") String key,  
            @RequestParam(value = "description", required = false) String description,  
            HttpServletRequest request, HttpServletResponse response) {  
        try {  
            ObjectMapper objectMapper = new ObjectMapper();  
            ObjectNode modelObjectNode = objectMapper.createObjectNode();  
            modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, name);  
            modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);  
            modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION,  
                    org.apache.commons.lang3.StringUtils  
                            .defaultString(description));  
            Model newModel = repositoryService.newModel();  
            newModel.setMetaInfo(modelObjectNode.toString());  
            newModel.setName(name);  
            newModel.setKey(key);  
            repositoryService.saveModel(newModel);  
            ObjectNode editorNode = objectMapper.createObjectNode();  
            editorNode.put("id", "canvas");  
            editorNode.put("resourceId", "canvas");  
            ObjectNode stencilSetNode = objectMapper.createObjectNode();  
            stencilSetNode.put("namespace",  
                    "http://b3mn.org/stencilset/bpmn2.0#");  
            editorNode.put("stencilset", stencilSetNode);  
            repositoryService.addModelEditorSource(newModel.getId(), editorNode  
                    .toString().getBytes("utf-8"));  
            response.sendRedirect(request.getContextPath()  
                    + "/service/editor?id=" + newModel.getId());  
        } catch (Exception e) {  
            e.getStackTrace();  
        }  
    }  
}
