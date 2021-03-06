package cucumbertests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {
	private SeleniumTest script;

	public void setUpWebDriver() throws Exception {
		script = new SeleniumTest();
		script.setUp();
		script.goToHomePage();
	}

	public void tidyUp() {
		script.tearDown();
	}
	
	@Given("^I am not logged in$")
	public void i_am_not_logged_in() throws Throwable {
	    script.loginstatus(false);
	}

	@Given("^I choose \"(.*?)\"$")
	public void i_choose_the(String arg1) throws Throwable {
	    if("Network".equals(arg1)) script.chooseNetwork();
	}

	@Given("^I am on the homepage$")
	public void i_am_on_the_homepage() throws Throwable {
		setUpWebDriver();
	}
	
	@Given("^I am not registered$")
	public void i_am_not_registered() throws Throwable {
		//kp wie man das testen sollt
	}

	@Given("^I am on the \"(.*?)\" page$")
	public void i_am_on_the_page(String arg1) throws Throwable {
		setUpWebDriver();
		if("Registrieren".equals(arg1)) {
			script.clickRegister();
//			script.checkpage("register");		
		}
		if("Login".equals(arg1)) {
			script.goToPage("login");
//			script.checkpage("login");		
		}
	}
	
	@Given("^I am logged in$")
	public void i_am_logged_in() throws Throwable {
		setUpWebDriver();
		script.login();
	}

	@Given("^I go to \"(.*?)\"$")
	public void i_go_to(String arg1) throws Throwable {
		script.goToPage("mynetworks");
//	    if("MeineNetzwerke".equals(arg1)) script.goToPage("mynetworks");
	}

	@When("^I enter \"(.*?)\" in the field \"(.*?)\"$")
	public void i_enter_my_in_the_field(String entry, String field) throws Throwable {
		script.enterInto(entry,field);
	}

	@When("^I check \"(.*?)\"$")
	public void i_check(String arg1) throws Throwable {
		if("Nutzungsbedingungen".equals(arg1)) script.checkbox();
	}

	@When("^I press the \"(.*?)\" button$")
	public void i_press_the_button(String button) throws Throwable {
		script.clickButton(button);
	}
	
	@Then("^new Network will be saved$")
	public void new_Network_will_be_saved() throws Throwable {
	    // hier passiert nix
	}

	@Then("^I receive a \"(.*?)\" message$")
	public void i_will_receive_a_message(String message) throws Throwable {
		script.messageReceived(message);
	}
	
	@Then("^the page title is as expected$")
	public void the_page_title_is_as_expected() throws Throwable {
		script.titleAsExpected();
	}
	
	@Then("^I am now on the \"(.*?)\" page")
	public void then_i_am_on_the_page(String page) throws Throwable {
		script.checkpage(page);
	}
}
