import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.model.FailureHandling.STOP_ON_FAILURE
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import utils.RandomDataGenerator as RandomDataGenerator
import com.kms.katalon.core.testobject.ConditionType as ConditionType

String company = RandomDataGenerator.getRandomCompany()
String address = RandomDataGenerator.getRandomAddress()
String email = RandomDataGenerator.getRandomEmail()
String country = RandomDataGenerator.getRandomCountry()
String iataCode = RandomDataGenerator.getRandomNumber(8)

WebUI.scrollToElement(findTestObject('Object Repository/customer/txt_customer_name'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/customer/txt_customer_name'), company)

WebUI.setText(findTestObject('Object Repository/customer/txt_customer_address'), address)

WebUI.setText(findTestObject('customer/txt_customer_email'), email)

WebUI.scrollToElement(findTestObject('Object Repository/customer/btn_customer_submit'), 5, FailureHandling.STOP_ON_FAILURE)

//
// SELECT CUSTOMER TYPE
//
List<String> customerTypes = ['Shipper', 'Notify Party', 'Carrier Agent', 'Consignee']
String selectedType = customerTypes[new Random().nextInt(customerTypes.size())]

WebUI.click(findTestObject('customer/select_customer_type'))

WebUI.sendKeys(findTestObject('Object Repository/customer/txt_customer_type'), Keys.chord(selectedType, Keys.ENTER))

if (selectedType == 'Carrier Agent') {
	WebUI.setText(findTestObject('Object Repository/customer/txt_iata_code'), iataCode)
}

//
// SELECT COUNTRY
//
WebUI.click(findTestObject('Object Repository/customer/select_country'))

WebUI.sendKeys(findTestObject('Object Repository/customer/txt_country'), Keys.chord(country, Keys.ENTER))

WebUI.click(findTestObject('Object Repository/customer/btn_customer_submit'))

WebUI.takeScreenshot()

WebUI.verifyTextPresent(msgSubmitSuccess, false, FailureHandling.STOP_ON_FAILURE)

//
// VERIFY
//
WebUI.waitForElementPresent(findTestObject('Object Repository/customer/btn_add_customer'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Repository/customer/txt_customer_search'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/customer/txt_customer_search'), company)

WebUI.scrollToPosition(9999999, 9999999)

WebUI.delay(5)

WebUI.verifyTextPresent(company, false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent(email, false, FailureHandling.STOP_ON_FAILURE)

if (GlobalVariable.object == "dev") {
	WebUI.verifyTextPresent(country, false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.verifyTextPresent(selectedType, false, FailureHandling.STOP_ON_FAILURE)

