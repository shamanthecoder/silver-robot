//package com.org.google.event.testcase;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//
//public class TestRunner {
//
//	public static void main(String[] args) throws Exception {
//		int tests = 0;
//		int passed = 0;
//		Class testClass = Class.forName(DefaultEventHandler.class.getName());
//
//		for (Method m : testClass.getDeclaredMethods()) {
//			if (m.isAnnotationPresent(Test.class)) {
//				tests++;
//				try {
//					m.invoke(new DefaultEventHandler());
//					passed++;
//				} catch (InvocationTargetException invec) {
//					Throwable wrappedExec = invec.getCause();
//					System.out.println("Test :" + m + " failed with " + wrappedExec.getMessage());
//				} catch (Exception e) {
//					System.out.println("Invalid test :" + m);
//				}
//			}
//		}
//		
//		System.out.println("Passed: "+passed+" Failed: "+(tests-passed));
//	}
//
//}
