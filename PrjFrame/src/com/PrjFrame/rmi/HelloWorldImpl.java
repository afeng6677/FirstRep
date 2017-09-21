package com.PrjFrame.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloWorldImpl extends UnicastRemoteObject implements HelloWorld {

	private static final long serialVersionUID = 7260927179338137037L;
	 
	/** 
     * 因为UnicastRemoteObject的构造方法抛出了RemoteException异常，因此这里默认的构造方法必须写，且声明抛出RemoteException异常 
     * 这是为了强制派生类要遵守基类方法的异常说明，对象的可替换性得到了保证
     * @throws RemoteException 
     */ 
	protected HelloWorldImpl() throws RemoteException {
		super();
	}

	public String helloWorld() throws RemoteException {
		return "Hello World";
	}

	public String sayHelloToSomeBody(String someBodyName)
			throws RemoteException {
		 return "你好，" + someBodyName + "!"; 
	}

}
