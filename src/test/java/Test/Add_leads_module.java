package Test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Leads_creation;
import page.Login;

public class Add_leads_module {


	public Login login  ;
	WebDriver driver;
	public Leads_creation lead;
	@Before
	public void init()
	{	

		driver = new ChromeDriver();
		login  = new Login(driver);
		lead  = new Leads_creation(driver);

	}

	@After (order = 1)
	public void end () {

		driver.quit();
	}
	@After(order = 2)
	public void tearDown(Scenario scenario)
	{
		boolean isScenarioFailed = scenario.isFailed();

		if(isScenarioFailed)
		{
			String scenarioname = scenario.getName();

			String screenshotname = scenarioname.replaceAll(" ", "_");

			TakesScreenshot ts = (TakesScreenshot)driver;

			byte[] source = ts.getScreenshotAs(OutputType.BYTES);

			scenario.attach(source, "image/png", screenshotname);
		}
	}





	@When("Click on Lead module")
	public void click_on_lead_module() {
		lead.ClickLeadModule();

	}

	@When("click on add button")
	public void click_on_add_button() {
		lead.Leads_AddButton();

	}
	@When("Enter All input")
	public void enter_all_input() {
		lead.AllInput();

	}
	@When("Click on save")
	public void click_on_save() {
		lead.SaveB();

	}
	@Then("Lead created successfully")
	public void lead_created_successfully() {

		System.out.println("Successfully Created ");
	}

}
