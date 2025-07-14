import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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
import com.kms.katalon.core.configuration.RunConfiguration

String profile = RunConfiguration.getExecutionProfile()
String object = ""

WebUI.waitForPageLoad(10)

if (profile == "dev") {
	object = "btn"
}else if (profile == "rembon" | profile == "default") {
	object = "link"
}

GlobalVariable.object = object

WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

//
// GO TO CUSTOMER
//
WebUI.delay(3)

WebUI.waitForElementClickable(findTestObject("Object Repository/side-menu/" + object + "_customer"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject("Object Repository/side-menu/" + object + "_customer"))

WebUI.waitForElementClickable(findTestObject('Object Repository/customer/btn_add_customer'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/customer/btn_add_customer'))

WebUI.waitForPageLoad(10)

//
// VERIFY FORM
//
WebUI.verifyElementPresent(findTestObject('Object Repository/customer/txt_customer_name'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/customer/div_Choose customer group_css-19bb58m'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/customer/txt_customer_address'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/customer/txt_customer_email'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/customer/txt_customer_telp'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/customer/txt_eori_number'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/customer/txt_customer_phone'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/customer/txt_customer_tax_id'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/customer/txt_customer_contact_center'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/customer/select_customer_type'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/customer/select_country'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

//
// VERIFY MANDATORY FIELD
//
WebUI.scrollToElement(findTestObject('Object Repository/customer/btn_customer_submit'), 5)

WebUI.click(findTestObject('Object Repository/customer/btn_customer_submit'))

WebUI.takeScreenshot()

WebUI.verifyTextPresent(popUpError, false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent(msgErrorCustName, true, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent(msgErrorAddress, true, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent(msgErrorCustType, true, FailureHandling.STOP_ON_FAILURE)

if (profile == "dev" | profile == "default") {
	msgErrorCountry = "Country is Required"
}

WebUI.verifyTextPresent(msgErrorCountry, true, FailureHandling.STOP_ON_FAILURE)

