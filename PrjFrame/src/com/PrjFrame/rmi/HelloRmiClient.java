package com.PrjFrame.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloRmiClient {
	 public static void main(String args[]){ 
	        try { 
	            //在RMI服务注册表中查找名称为helloWorld的对象
	            HelloWorld helloWorld =(HelloWorld) Naming.lookup("rmi://localhost:8888/helloWorld"); 
	            //rmi:前缀可以去掉
	            //HelloWorld helloWorld =(HelloWorld) Naming.lookup("//localhost:8888/helloWorld"); 
	            //当创建对象注册表时使用的是默认注册表默认端口时可以使用此方法查找名称为helloWorld的对象
	        	//  HelloWorld helloWorld = (HelloWorld) Naming.lookup("helloWorld");   
//	            System.out.println(helloWorld.helloWorld()); 
//	            System.out.println(helloWorld.sayHelloToSomeBody("电子商务")); 
	        } catch (NotBoundException e) { 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            e.printStackTrace(); 
	        } catch (RemoteException e) { 
	            e.printStackTrace();   
	        } 
	    } 
}
