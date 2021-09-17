package com.main;

import java.util.concurrent.ExecutionException;
import org.apache.log4j.BasicConfigurator;
import com.main.multithreading.Programm;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		BasicConfigurator.configure();
		Programm programm = new Programm();
		programm.collectInfo();
		System.out.println("Finished");
	}
}

