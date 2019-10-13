package com.accenture.cucumberBddFramework.defination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {
	WebDriver driver;

	@Given("^user is already on Login Page$")
	public void user_is_already_in_login_page() {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}

	@When("^title of login page is Free CRM$")
	public void page_title_is_CRM() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Facebook – log in or sign up", title);
	}

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password) {
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		WebElement loginBtn = driver.findElement(By.id("loginbutton"));
		loginBtn.click();
	}

	@Then("^user is on home page$")
	public void user_is_on_hopme_page() {
		String title = driver.getTitle();
		System.out.println("Facebook Login Title: " + title);
		Assert.assertEquals("Facebook", title);
	}
	
	@Then("^close the browser$")
	public void close_the_browser() {
		driver.quit();
	}


}
