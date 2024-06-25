package testdata;

import utils.readers.Config;


public class AuthTestData {

	/**
	 * Get test environment - Used in this class only to initiate data according to
	 * the test environment, no need to expose outside
	 */
	private static String env = Config.getTestRunEnvironment();
	
	/**
	 * username_Standard_User will be used as a accessCode while logging in the system with
	 * user needing Swag Labs system access
	 */
	public String accessCode = "";
	
	/**
	 * username_Standard_User will be used as a username while logging in the system with
	 * user needing Swag Labs system access
	 */
	public String username = "";
	

	/**
	 * password_Standard_User will be used as a password while logging in the system with
	 * user needing Swag Labs system access
	 */
	public String password = "";
	
	
	/**
	 * Constructor which will initialize all the class fields based on the test
	 * execution environment
	 */
	public AuthTestData() {

		if (env.toLowerCase().contains("test")) {
			// QA environment Test Data

		
			username = "vbabu@modernatx.com";
			password = "ModNorBos@789";
			
			
			
			


		} else if (env.toLowerCase().contains("uat")) {
			// UAT Environment Test Data

			accessCode = "AxAutomation";
			username = "demo360@assetanalytix.com";
			password = "123";


		} else if (env.toLowerCase().contains("production")) {
			// Production Environment Test Data

			accessCode = "AxAutomation";
			username = "demo360@assetanalytix.com";
			password = "123";


		}
	}
	
	
}
