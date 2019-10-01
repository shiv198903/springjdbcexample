package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpringjpaexampleApplicationTests {

	@Autowired
	EmployeeRepository eRepo;
	
	private Logger logger = LoggerFactory.getLogger(SpringjpaexampleApplicationTests.class);
	
	/*
	 * Naming the methods in pattern test001 such that
	 * they are executed sequentially as the methods are
	 * interdependent.
	 */
	
	@Test
	public void test01() {
		logger.info("test01: contextLoads()");
	}
	
	@Test
	public void test02() {
		logger.info("test02: insertEmployee()");
		Employee employee = new Employee("Tom", "Sawyer");
		employee = eRepo.save(employee);
		assertNotNull(employee);
	}
	
	@Test
	public void test03() {
		logger.info("test03: fetchEmployee()");
		Employee employee = eRepo.findByFirstName("Tom");
		assertNotNull(employee);
	}
	
	@Test
	public void test04() {
		logger.info("test04: employeeCount()");
		assertTrue(eRepo.count()==1);
	}

}
