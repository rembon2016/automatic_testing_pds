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
import internal.GlobalVariable
import utils.RandomDataGenerator

import org.openqa.selenium.Keys as Keys

// SELECT PACKAGES
WebUI.waitForElementPresent(findTestObject('Object Repository/shipment/select_packages'), 5, FailureHandling.STOP_ON_FAILURE)

List<String> packagesOptions = ['CARTON', 'BOX', 'PCS', 'COLLIE', 'PALLETS', 'CASES', 'ROLLS', 'BAGS', 'BAILS', 'PLYWOOD CASE(S)']

String selectedPackages = packagesOptions[new Random().nextInt(packagesOptions.size())]

WebUI.selectOptionByValue(findTestObject('Object Repository/shipment/select_packages'), selectedPackages, false, FailureHandling.STOP_ON_FAILURE)

// INPUT GROSS WEIGHT
WebUI.setText(findTestObject('Object Repository/shipment/txt_gross_weight'), RandomDataGenerator.getRandomNumberRange(1000, 9999))

// INPUT DIMENSION
WebUI.setText(findTestObject('Object Repository/shipment/txt_no_pcs'), RandomDataGenerator.getRandomNumberRange(100, 150))

WebUI.setText(findTestObject('Object Repository/shipment/txt_length'), RandomDataGenerator.getRandomNumberRange(100, 150))

WebUI.setText(findTestObject('Object Repository/shipment/txt_width'), RandomDataGenerator.getRandomNumberRange(100, 150))

WebUI.setText(findTestObject('Object Repository/shipment/txt_height'), RandomDataGenerator.getRandomNumberRange(100, 150))

WebUI.takeScreenshot()

// INPUT DESCRIPTION OF GOODS
WebUI.executeJavaScript("window.scrollBy(0, 200)", null)

WebUI.setText(findTestObject('Object Repository/shipment/txt_desc_of_goods'), RandomDataGenerator.getRandomDescription(1))

WebUI.takeScreenshot()

// SUBMIT
WebUI.scrollToElement(findTestObject('Object Repository/shipment/btn_submit_detail_order'), 5)

WebUI.click(findTestObject('Object Repository/shipment/btn_submit_detail_order'))

WebUI.verifyTextPresent(msgSuccess, false)

WebUI.takeScreenshot()

// GET ID SHIPMENT
String url = WebUI.getUrl()

if (url.endsWith("/")) {
	url = url.substring(0, url.length() - 1)
}

String id = url.tokenize("/").last()

GlobalVariable.idShipment = id

WebUI.callTestCase(findTestCase('Test Cases/api/TC_GET_Detail_Shipment'), ["url": GlobalVariable.urlBE, "id": id], STOP_ON_FAILURE)

// SEARCH DATA
WebUI.waitForElementPresent(findTestObject('Object Repository/booking-list/btn_export_csv'), 10)

WebUI.waitForElementPresent(findTestObject('Object Repository/booking-list/txt_search_booking_list'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/booking-list/txt_search_booking_list'), GlobalVariable.ctdNumber)

WebUI.scrollToPosition(9999999, 9999999)

WebUI.delay(3)

WebUI.verifyTextPresent(GlobalVariable.ctdNumber, false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent(GlobalVariable.consignee, false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent(GlobalVariable.shipper, false, FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()
