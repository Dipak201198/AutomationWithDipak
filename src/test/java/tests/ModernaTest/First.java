package tests.ModernaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class First {
	 // ANSI escape sequences for different colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

	public static void main(String[] args) 
	{

		        System.out.println(ANSI_RED + "This text will be printed in red." + ANSI_RESET);
		        System.out.println(ANSI_GREEN + "This text will be printed in green." + ANSI_RESET);
		        System.out.println(ANSI_YELLOW + "This text will be printed in yellow." + ANSI_RESET);
		    
	}

	

}
