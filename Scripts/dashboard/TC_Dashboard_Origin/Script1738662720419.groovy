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

WebUI.waitForPageLoad(10)

WebUI.verifyElementPresent(findTestObject('side-menu/link_dashboard'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/side-menu/link_new_shipment'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('side-menu/link_loading_plan'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('side-menu/link_loading_plan'))

WebUI.verifyElementPresent(findTestObject('side-menu/link_sea_freight'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('side-menu/link_air_freight'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('side-menu/link_loading_plan'))

WebUI.verifyElementPresent(findTestObject('side-menu/link_booking_list'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('side-menu/link_processing_shipment'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('side-menu/link_processing_shipment'))

WebUI.verifyElementPresent(findTestObject('side-menu/link_at_origin'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('side-menu/link_at_transit_hub'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('side-menu/link_at_destination'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('side-menu/link_processing_shipment'))

WebUI.verifyElementPresent(findTestObject('side-menu/link_archive_shipments'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('side-menu/link_archive_shipments'))

WebUI.verifyElementPresent(findTestObject('side-menu/link_archive_sea_air'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('side-menu/link_archive_cross_air'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('side-menu/link_archive_cancelled'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('side-menu/link_archive_shipments'))

WebUI.verifyElementPresent(findTestObject('side-menu/link_reports'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('side-menu/link_reports'))

WebUI.verifyElementPresent(findTestObject('side-menu/link_container_loading'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('side-menu/link_final_alert'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('side-menu/link_final_alert'))

WebUI.verifyElementPresent(findTestObject('side-menu/link_final_alert_sea_air'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('side-menu/link_final_alert_cross_air'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('side-menu/link_reports'))

