package com.insurance.sce.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.sce.dao.EmployeeDAO;
import com.insurance.sce.model.employee.Employee;

@Repository
public class EmployeeService {
	@Autowired
	EmployeeDAO employeeDAO;
	
	public Map<String, Object> loginEmployee(String id, String pw) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		// �빐�떦 Id瑜� 媛�吏� Employee 遺덈윭�삤湲�
		Employee tmp = new Employee();
		tmp.setEmployeeId(id);
		tmp.setPassword(pw);
		Employee employee= employeeDAO.selectByIdPw(tmp);
		
		if(employee == null) return null;
		else {
			String employeeRole = "redirect:/";
			switch(employee.getRole()) {
			case insuranceDeveloper: employeeRole += "developerView";
			default:
				break;
			}
			map.put("employeeRole", employeeRole);
			map.put("employee", employee);
			
			return map;
		}
	}
}
