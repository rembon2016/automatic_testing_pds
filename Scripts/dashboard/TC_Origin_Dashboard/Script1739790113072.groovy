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

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_dashboard"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_customer"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_new_shipment"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_loading_plan"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject("side-menu/" + object + "_loading_plan"))

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_sea_freight"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_air_freight"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject("side-menu/" + object + "_loading_plan"))

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_booking_list"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_processing_shipment"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject("side-menu/" + object + "_processing_shipment"))

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_at_origin"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_at_transit_hub"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_at_destination"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject("side-menu/" + object + "_processing_shipment"))

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_archive_shipments"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject("side-menu/" + object + "_archive_shipments"))

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_archive_sea_air"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_archive_cross_air"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_archive_cancelled"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject("side-menu/" + object + "_archive_shipments"))

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_reports"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject("side-menu/" + object + "_reports"))

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_container_loading"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('side-menu/link_final_alert'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('side-menu/link_final_alert'))

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_final_alert_sea_air"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject("side-menu/" + object + "_final_alert_cross_air"), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject("side-menu/" + object + "_reports"))

