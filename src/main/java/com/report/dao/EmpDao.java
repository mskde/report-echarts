package com.report.dao;

import java.util.List;
import java.util.Map;

import com.report.domain.Emp;
import com.report.vo.AgeAndSal;

public interface EmpDao {
	boolean addEmp(String statement,Emp emp);
	boolean delEmpByEmpno(String statement,Integer empno);
	boolean updEmp(String statement,Emp emp);
	List<Emp> getAllEmp(String statement);
	List<Emp> getEmpByAnyLine(String statement,String test);
	
	
	
	List<Map<String,Object>> getAgeAndSal(String statement);
	List<AgeAndSal> getAgeAndSal2(String statement);
	List<Map<String,Object>> getSexNum(String statement);
	List<Map<String,Object>> getSalSumByDept(String statement);
	List<Map<String,Object>> getNumByDept(String statement);
	List<Map<Object,Object>> getIdAndYear(String statement);
	
	
}
