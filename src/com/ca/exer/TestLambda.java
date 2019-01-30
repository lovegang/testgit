package com.ca.exer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import com.ca.java8.Employee;

public class TestLambda {
	
	List<Employee> emps=Arrays.asList(
			new Employee(101,"张三",18,9999.99),
			new Employee(102,"李四",12,8888.88),
			new Employee(103,"王五",19,8887.88),
			new Employee(104,"赵六",14,6666.88),
			new Employee(105,"田七",15,7777.88)
	);
	
	@Test
	public void test1(){
		Collections.sort(emps,(e1,e2) -> {
			if(e1.getAge() == e2.getAge()){
				return e1.getName().compareTo(e2.getName());
			}else{
				return -Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		for(Employee emp:emps){
			System.out.println(emp);
		}
	}
	
	@Test
	public void test2(){
		emps.stream()
			.filter((e) -> e.getSalary()>=4000)
			.forEach(System.out::println);
		System.out.println("===========================");
		emps.stream()
			.filter((e) -> e.getAge() >=14)
			.limit(2)
			.forEach(System.out::println);
	};
	
	@Test
	public void test3(){
		Consumer<String> con =  (x)-> System.out.println(x);
		con.accept("hahahgni");
	};
	
	@Test
	public void test4(){
		Comparator<Integer> con= (x,y) -> Integer.compare(x, y);
		con.compare(1, 2);
	};
	
}
