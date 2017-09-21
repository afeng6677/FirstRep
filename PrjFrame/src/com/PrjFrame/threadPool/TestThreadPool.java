package com.PrjFrame.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {

	 private static int produceTaskSleepTime = 2;  
     
	    private static int produceTaskMaxNumber = 10;  
	  
	    public static void main(String[] args) {  
	  
	        // 构造一个线程池  
//	    	ThreadPoolExecutor threadPool =new ThreadPoolExecutor(4, 4,  
//                    0L, TimeUnit.MILLISECONDS,  
//                    new LinkedBlockingQueue<Runnable>());
//	    	ThreadPoolExecutor threadPool =new ThreadPoolExecutor(1, 1,  
//                    0L, TimeUnit.MILLISECONDS,  
//                    new LinkedBlockingQueue<Runnable>());  
//	    	ThreadPoolExecutor threadPool =new ThreadPoolExecutor(0, Integer.MAX_VALUE,  
//	    			60L, TimeUnit.SECONDS,  
//	    			new SynchronousQueue<Runnable>());  
	        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 0,  
	                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1),  
	                new ThreadPoolExecutor.DiscardPolicy());  
		  while(true){
			  for (int i = 1; i <= produceTaskMaxNumber; i++) {  
				  try {  
					  String task = "task@ " + i;  
//					  System.out.println("创建任务并提交到线程池中：" + task);  
					  threadPool.execute(new ThreadPoolTask(task));  
				  } catch (Exception e) {  
					  e.printStackTrace();  
				  }  
			  }
			  try {
				Thread.sleep(5000);
				System.out.println(threadPool.getQueue().size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }
	    }  
}
