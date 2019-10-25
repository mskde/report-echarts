package com.report.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.report.dao.EmpDao;
import com.report.domain.Emp;
import com.report.vo.AgeAndSal;

@Repository("empDao")
public class EmpDaoImpl implements EmpDao{
	@Autowired 
	private SqlSessionTemplate session;
	
	@Override
	public boolean addEmp(String statement, Emp emp) {
		int count=session.insert(statement, emp);
		if(count>0)
			return true;
		return false;
	}

	@Override
	public boolean delEmpByEmpno(String statement, Integer empno) {
		int count=session.delete(statement, empno);
		if(count>0)
			return true;
		return false;
	}

	@Override
	public boolean updEmp(String statement, Emp emp) {
		int count=session.update(statement, emp);
		if(count>0)
			return true;
		return false;
	}

	@Override
	public List<Emp> getAllEmp(String statement) {
		return session.selectList(statement);
	}

	@Override
	public List<Emp> getEmpByAnyLine(String statement, String test) {
		return session.selectList(statement, test);
	}

	

	
	@Override
	public List<Map<String, Object>> getAgeAndSal(String statement) {
		return session.selectList(statement);
	}

	@Override
	public List<AgeAndSal> getAgeAndSal2(String statement) {
		return session.selectList(statement);
	}

	@Override
	public List<Map<String, Object>> getSexNum(String statement) {
		return session.selectList(statement);
	}

	@Override
	public List<Map<String, Object>> getSalSumByDept(String statement) {
		return session.selectList(statement);
	}
	
	@Override
	public List<Map<String, Object>> getNumByDept(String statement) {
		return session.selectList(statement);
	}

	@Override
	public List<Map<Object, Object>> getIdAndYear(String statement) {
		return session.selectList(statement);
	}




}
