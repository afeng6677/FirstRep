package com.PrjFrame.threadPool;

import java.io.Serializable;

public class ThreadPoolTask implements Runnable, Serializable {  
	  
    private Object attachData;  
  
    ThreadPoolTask(Object tasks) {  
        this.attachData = tasks;  
    }  
  
    public void run() {  
          
        System.out.println("开始执行任务：" + attachData);  
          
        attachData = null;
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }  
  
    public Object getTask() {  
        return this.attachData;  
    }  
}  
