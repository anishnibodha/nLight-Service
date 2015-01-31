package com.nlight.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class ProcessHandlerTest {
	
	@Test
	public void testRunProcess() {
		String shFile = "/home/radhesh/projects/nextnav/bcnlogs/CASFO0010-BN01/tmp/rb.sh";
		try {
			runProcess(shFile);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void runProcess(String shFile) throws IOException {
		ProcessBuilder pb = new ProcessBuilder(shFile);
		Process p = pb.start();
		
        //have some time
        try {
            Thread.sleep(60*1000);
        } catch (InterruptedException ignored) {
        	System.out.println("interrupted");
        }

         if (p != null) {
        	 System.out.println("destroying");
        	 p.getOutputStream().close(); 
        	 p.getInputStream().close(); 
             p.destroy();	
             System.out.println("destroyed");
         }
/*		BufferedReader reader = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}*/
		
		

	}
}
