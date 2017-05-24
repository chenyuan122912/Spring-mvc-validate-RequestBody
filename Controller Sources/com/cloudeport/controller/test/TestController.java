package com.cloudeport.controller.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cloudeport.base.BaseController;
import com.cloudeport.model.pojo.Test;

@Controller
@RequestMapping("/test")
@Validated
public class TestController extends BaseController {

	@RequestMapping(value = "testValidated", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Object testValidated(@RequestParam(value = "pk", required = true) @Size(min = 1, max = 3) String pk,
			@RequestParam(value = "age", required = false) @Range(min = 1, max = 3) String age) {
		try {
			return "pk:" + pk + ",age=" + age;
		} catch (Throwable t) {
			
			return buildFailure("消息列表查询失败");
		}
	}

	@CrossOrigin
	@RequestMapping(value = "/testValid", method = RequestMethod.POST)
	@ResponseBody
	public Object testValid(@RequestBody @Valid Test test,BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		try {
			// Test test = testService.getByPk(pk);
			if (result.hasErrors()){
	            List<ObjectError> errorList = result.getAllErrors();
	            for(ObjectError error : errorList){
	                System.out.println(error.getDefaultMessage());
	            }
	        }
			return test.getMId() + ":" + test.getIdCard() + ":" + test.getRealName() + ":" + test.getStatus();
		} catch (Throwable t) {
			return buildFailure("消息列表查询失败");
		}
	}
}
