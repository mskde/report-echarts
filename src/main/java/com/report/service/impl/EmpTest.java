package com.report.service.impl;



import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.report.domain.Emp;
import com.report.service.EmpService;
import com.report.tools.SpringUtil;
import com.report.vo.AgeAndSal;

public class EmpTest {
	public static void main(String[] args) {
		EmpService es=(EmpService)SpringUtil.getBean("empService");

		
/*		Emp emp=new  Emp();
		emp.setId(6);
		emp.setEmpno(1006);
		emp.setEname("abel");
		emp.setJob("sale");
		emp.setHiredate(new Date(new java.util.Date().getTime()));
//		emp.setHiredate(Date.valueOf("1998-2-25"));
		emp.setSal(2000);
		emp.setComm(800);
		emp.setAge(25);
		emp.setSex("ÄÐ");
		emp.setDeptno(10);
		es.addEmp("EmpMapper.addEmp", emp);*/
		
		/*
		es.delEmpByEmpno("EmpMapper.delEmpByEmpno", 1002);
		*/
		
/*		Emp emp=new  Emp();
		emp.setId(1);
		emp.setEmpno(1001);
		emp.setEname("zxzxc");
		emp.setJob("sale");
		emp.setHiredate(new Date(new java.util.Date().getTime()));
		emp.setSal(2000);
		emp.setComm(800);
		emp.setAge(55);
		emp.setSex("ÄÐ");
		emp.setDeptno(10);
		es.updEmp("EmpMapper.updEmp", emp);*/
		
/*		List<Emp> le=es.getAllEmp("EmpMapper.getAllEmp");
		for(Emp e:le) {
			System.out.println(e);
		}*/
		
/*		List<Emp> le=es.getEmpByAnyLine("EmpMapper.getEmpByAnyLine2","ÄÐ");
		System.out.println(le);
		for(Emp e:le) {
			System.out.println(e);
		}*/

/*
 * age 20-40
 * sal (age+5)*120
 * coomm  0  200 400  600
 * deptno job
 * 10     accounting
 * 20 	  researcher
 * 30     sales
 * 40	  operational_staff
 * 50     technologist
 * 
 */
		
		String[] jobs= {"accnt","rescher","sales","opernal","techlogt"};
		String[] sexs= {"ÄÐ","ÄÐ","Å®"};
		int[] comms= {0,280,0,880,420,0,550,0,0};
		String[] names= {"","Tom","Abel","Json","Jhon","Tomson","Hell","York","From","Green","Black"};
		int x=1;
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=100;j++,x++) {
				
				Emp emp=new  Emp();
				emp.setId(x);
				emp.setEmpno(i*1000+j);
				emp.setEname(names[i]+String.valueOf(j));
				emp.setJob(jobs[(j%8)%5]);
				String s=String.valueOf(i+1985)+"-"+String.valueOf(j%12+1)+"-"+String.valueOf(j%30+1);
				emp.setHiredate(Date.valueOf(s));
				emp.setSal((int)(3*(j%20+20)*(j%20+20)+1500));
				emp.setComm(comms[j%9]);
				emp.setAge(j%20+20);
				emp.setSex(sexs[j%3]);
				emp.setDeptno(((j%8)%5+1)*10);
				es.addEmp("EmpMapper.addEmp", emp);
			}
			
		}
		
		
/*		List<Map<String,Object>> h=es.getAgeAndSal("EmpMapper.getAgeAndSal");
		System.out.println(h);
		
		List<AgeAndSal> li=es.getAgeAndSal2("EmpMapper.getAgeAndSal2");
		System.out.println(li);*/
		
		/*List<Map<String,Object>> h=es.getSexNum("EmpMapper.getSexNum");
		System.out.println(h);*/
		
		/*List<Map<String,Object>> h=es.getSalSumByDept("EmpMapper.getSalSumByDept");
		for(Map<String,Object> m:h) {
			System.out.println(m);
		}
		*/
		/*List<Map<String,Object>> h=es.getNumByDept("EmpMapper.getNumByDept");
		for(Map<String,Object> m:h) {
			System.out.println(m);
		}*/
		
		/*List<Map<Object,Object>> h=es.getIdAndYear("EmpMapper.getIdAndYear");
		for(Map<Object,Object> m:h) {
			System.out.println(m);
		}*/
		
		
	}
}





