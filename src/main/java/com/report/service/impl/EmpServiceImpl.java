package com.report.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.dao.EmpDao;
import com.report.domain.Emp;
import com.report.service.EmpService;
import com.report.vo.AgeAndSal;

@Service("empService")
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpDao empDao;
	
	@Override
	public boolean addEmp(String statement, Emp emp) {
		return empDao.addEmp(statement, emp);
	}

	@Override
	public boolean delEmpByEmpno(String statement, Integer empno) {
		return empDao.delEmpByEmpno(statement, empno);
	}

	@Override
	public boolean updEmp(String statement, Emp emp) {
		return empDao.updEmp(statement, emp);
	}

	@Override
	public List<Emp> getAllEmp(String statement) {
		return empDao.getAllEmp(statement);
	}
	
	@Override
	public List<Emp> getEmpByAnyLine(String statement, String test) {
		return empDao.getEmpByAnyLine(statement, test);
	}
	
	
	
	
	@Override
	public List<Map<String, Object>> getAgeAndSal(String statement) {
		return empDao.getAgeAndSal(statement);
	}

	@Override
	public List<AgeAndSal> getAgeAndSal2(String statement) {
		return empDao.getAgeAndSal2(statement);
	}

	@Override
	public List<Map<String, Object>> getSexNum(String statement) {
		return empDao.getSexNum(statement);
	}

	@Override
	public List<Map<String, Object>> getSalSumByDept(String statement) {
		return empDao.getSalSumByDept(statement);
	}
	
	@Override
	public List<Map<String, Object>> getNumByDept(String statement) {
		return empDao.getNumByDept(statement);
	}

	@Override
	public List<Map<Object, Object>> getIdAndYear(String statement) {
		return empDao.getIdAndYear(statement);
	}







}
