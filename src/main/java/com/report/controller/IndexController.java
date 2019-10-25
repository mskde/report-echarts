package com.report.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.report.domain.Emp;
import com.report.service.EmpService;


@Controller
public class IndexController {
	@RequestMapping("/index.do")
	public String toIndex(HttpServletRequest request) {
		System.out.println("index");
		return "index";
	}

	
	@Autowired
	@Qualifier("empService")
	private EmpService empService;
	
	//获取所有员工信息
	@RequestMapping("/getAllEmp.do")
	@ResponseBody
	public List<Emp> getAllEmp(){
		List<Emp> list=empService.getAllEmp("EmpMapper.getAllEmp");
		return list;
	}
	
	@RequestMapping(value="/getEmpByAnyLine.do")
	@ResponseBody
	public Object getExerciseById(@RequestParam String test) {
		System.out.println(test);
		
		List<Emp> list=empService.getEmpByAnyLine("EmpMapper.getEmpByAnyLine",test.toString());
		return list;
//		http://localhost:8080/ssmdemo/exercise/getEmpByAnyLine/"25"
	}
	
//	年龄-薪资折线趋势图
	@RequestMapping("/getAgeAndSal.do")
	@ResponseBody
	public List<Map<String, Object>> getAgeAndSal(){
		List<Map<String, Object>> list=empService.getAgeAndSal("EmpMapper.getAgeAndSal");
		return list;
	}
	
	
//	人员-性别饼状比例图
	@RequestMapping("/getSexNum.do")
	@ResponseBody
	public List<Map<String, Object>> getSexNum(){
		List<Map<String, Object>> list=empService.getSexNum("EmpMapper.getSexNum");
		return list;
	}
//	部门-总薪资雷达分布图
	@RequestMapping("/getSalSumByDept.do")
	@ResponseBody
	public List<Map<String, Object>> getSalSumByDept(){
		List<Map<String, Object>> list=empService.getSalSumByDept("EmpMapper.getSalSumByDept");
		return list;
	}
	
//	人员-部门人数柱状图
	@RequestMapping("/getNumByDept.do")
	@ResponseBody
	public List<Map<String, Object>> getNumByDept(){
		List<Map<String, Object>> list=empService.getNumByDept("EmpMapper.getNumByDept");
		return list;
	}
//	人员-入职年份散点分布图
	@RequestMapping("/getIdAndYear.do")
	@ResponseBody
	public List<Map<Object, Object>> getIdAndYear(){
		List<Map<Object, Object>> list=empService.getIdAndYear("EmpMapper.getIdAndYear");
		return list;
	}
	
}
