package automicgrp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class Processentries {
	//public WebDriver driver2;
	public static void process_entries(WebDriver driver2) {
		List<WebElement> alllinks = driver2.findElements(By.tagName("tr"));	
		for (int i = 2; i <= alllinks.size();i++) {
			String fullabntext = driver2.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]")).getText();
			String actualtext = fullabntext.substring(0, 14);	

			
			if (actualtext.endsWith("152 260 814")) {
				
				driver2.findElement(By.cssSelector("#content-matching > div > div > table > tbody > tr:nth-child("+i+") > td:nth-child(1) > a")).click();
				System.out.println("the link clicked successfully");
				SoftAssert softassert = new SoftAssert();
			
								
							 	for (int j=1;j<=5;j++) {
								
								 		switch(j) {
												case 1:
													String actual_entity_name= driver2.findElement(By.xpath("//table/tbody/tr["+j+"]/td/span")).getText();
													softassert.assertEquals(actual_entity_name.trim(), "AUTOMIC PTY LTD");
													System.out.println("The entity name AUTOMIC PTY LTD is listed ");
													break;
												case 2:
													String actual_abn_status = driver2.findElement(By.xpath("//table/tbody/tr["+j+"]/td")).getText();
													softassert.assertEquals(actual_abn_status.trim(), "Active from 19 Jun 2012");
													System.out.println("The ABN status Active from 19 Jun 2012 is listed ");
													break;
												case 3:
													String actual_entity_type = driver2.findElement(By.xpath("//table/tbody/tr["+j+"]/td/a")).getText();
													softassert.assertEquals(actual_entity_type.trim(), "Australian Private Company");
													System.out.println("The entity type Australian Private Company is listed ");
													break;
												case 4:
													continue;
												case 5:
													String actual_main_business_loc = driver2.findElement(By.xpath("//table/tbody/tr["+j+"]/td/div/span")).getText();
													softassert.assertEquals(actual_main_business_loc.trim(),  "NSW 2000");
													System.out.println("The main business location NSW 2000 is listed");
													break;
								 				}
								 				
							 			}
							
							 for(int l=2;l<=4;l++) {
								 
											 switch (l) {
											 case 2:								 
												 String business_name1 = driver2.findElement(By.xpath("//table[1]/tbody/tr["+l+"]/td[1]/a")).getText();
												 softassert.assertTrue(business_name1.trim().equalsIgnoreCase("CoSecPRO"));
												 System.out.println("The business name CoSecPRO is listed");
												 break;
											 
											 case 3:
												 String business_name2 = driver2.findElement(By.xpath("(//table[1]/tbody/tr["+l+"]/td[1]/a)[2]")).getText();
												 softassert.assertTrue(business_name2.trim().equalsIgnoreCase("Automic Group"));												 
												 System.out.println("The business name Automic Group is listed");
												 break;
												 
											 case 4:
												 String business_name3 = driver2.findElement(By.xpath("//table[1]/tbody/tr["+l+"]/td[1]/a")).getText();
												 softassert.assertTrue(business_name3.trim().equalsIgnoreCase("Invana"));
												 System.out.println("The business name Invana is listed");
												 break;
										 }
											
							 		}	
							 softassert.assertAll();
					 
			driver2.navigate().back();			
								} 

							}
	}

	
		
	}


