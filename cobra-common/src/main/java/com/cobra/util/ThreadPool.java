package com.cobra.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池工具类，工程所有多线程均调用此类，控制整个工程允许的最大线程数
 * 
 * @author fanyinchuan
 * 
 */
public class ThreadPool
{
	public static ThreadPool threadPool;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	ExecutorService executorService = Executors.newFixedThreadPool(10);

	public static ThreadPool getInstance() {
		if (threadPool == null) {
			threadPool = new ThreadPool();
		}
		return threadPool;
	}

	public void run(Runnable r) {
		executorService.execute(r);
	}
}
