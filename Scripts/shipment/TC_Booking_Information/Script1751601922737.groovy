import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import utils.RandomDataGenerator

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

String profile = RunConfiguration.getExecutionProfile()

String object = ''

WebUI.waitForPageLoad(10)

if (profile == 'dev') {
    object = 'btn'
} else if ((profile == 'rembon') | (profile == 'default')) {
    object = 'link'
}

WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

//
// GO TO SHIPMENT
//
WebUI.waitForElementClickable(findTestObject(('side-menu/' + object) + '_new_shipment'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject(('side-menu/' + object) + '_new_shipment'))

WebUI.waitForElementPresent(findTestObject('Object Repository/shipment/select_shipment_by'), 5)

WebUI.takeScreenshot()

//
// INPUT FORM
//
WebUI.selectOptionByValue(findTestObject('Object Repository/shipment/select_shipment_by'), shipmentBy, false, FailureHandling.STOP_ON_FAILURE)

// SELECT LOADING TYPE
List<String> loadingTypes = ['FCL', 'LCL']

String selectedType = loadingTypes[new Random().nextInt(loadingTypes.size())]

WebUI.selectOptionByValue(findTestObject('Object Repository/shipment/select_loading_type'), selectedType, false, FailureHandling.STOP_ON_FAILURE)

// SELECT FROM SHIPPER
WebUI.click(findTestObject('Object Repository/shipment/txt_from_shipper'))

WebUI.delay(1)

List<WebElement> shipperList = WebUiCommonHelper.findWebElements(new TestObject().addProperty('xpath', ConditionType.EQUALS, 
        '//div[contains(@class,\'my-select-box\')]//h1'), 10)

int randomShipper = new Random().nextInt(shipperList.size())

String randomShipperTxt = shipperList.get(randomShipper).getText()

GlobalVariable.shipper = randomShipperTxt.split(" - ")[0]

WebUI.executeJavaScript('arguments[0].scrollIntoView(true);', Arrays.asList(shipperList.get(randomShipper)))

WebUI.delay(1)

shipperList.get(randomShipper).click()

WebUI.executeJavaScript('window.scrollTo(0, 0);', null)

// SELECT TO CONSIGNEE
WebUI.click(findTestObject('Object Repository/shipment/txt_to_consignee'))

WebUI.delay(1)

List<WebElement> consigneeList = WebUiCommonHelper.findWebElements(new TestObject().addProperty('xpath', ConditionType.EQUALS, 
        '//div[contains(@class,\'my-select-box\')]//h1'), 10)

int randomConsignee = new Random().nextInt(consigneeList.size())

String randomConsigneeTxt = consigneeList.get(randomConsignee).getText()

GlobalVariable.consignee = randomConsigneeTxt.split(" - ")[0]

WebUI.executeJavaScript('arguments[0].scrollIntoView(true);', Arrays.asList(consigneeList.get(randomConsignee)))

WebUI.delay(1)

consigneeList.get(randomConsignee).click()

WebUI.executeJavaScript('window.scrollTo(0, 0);', null)

WebUI.takeScreenshot()

// SELECT FREIGHT TERM
WebUI.scrollToElement(findTestObject('Object Repository/shipment/txt_to_consignee'), 3)

List<String> freightOptions = ['Prepaid', 'Collect', 'Split']

String selectedFreight = freightOptions[new Random().nextInt(freightOptions.size())]

WebUI.selectOptionByValue(findTestObject('Object Repository/shipment/select_freight_term'), selectedFreight, false, FailureHandling.STOP_ON_FAILURE)

// SELECT INCOTERM
List<String> incotermPrepaid = ['CFR', 'CIF', 'CPT', 'CIP', 'DAP', 'DPU', 'DDP']

List<String> incotermCollect = ['FOB', 'EXW', 'FCA', 'FAS']

List<String> incotermSplit = ['CFR', 'CIF', 'CPT', 'CIP', 'DAP', 'DPU', 'DDP', 'FOB', 'EXW', 'FCA', 'FAS']

String selectedIncoterm = ''

if (selectedFreight == 'Prepaid') {
    selectedIncoterm = (incotermPrepaid[new Random().nextInt(incotermPrepaid.size())])
} else if (selectedFreight == 'Collect') {
    selectedIncoterm = (incotermCollect[new Random().nextInt(incotermCollect.size())])
} else if (selectedFreight == 'Split') {
    selectedIncoterm = (incotermSplit[new Random().nextInt(incotermSplit.size())])
}

WebUI.selectOptionByValue(findTestObject('Object Repository/shipment/select_incoterm'), selectedIncoterm, false, FailureHandling.STOP_ON_FAILURE)

// SELECT PORT OF LOADING
WebUI.click(findTestObject('shipment/txt_port_of_loading'))

WebUI.delay(1)

List<WebElement> seaPortList = WebUiCommonHelper.findWebElements(new TestObject().addProperty('xpath', ConditionType.EQUALS, 
        '//div[contains(@class,\'my-select-box\')]//h1'), 10)

int randomSeaPort = new Random().nextInt(seaPortList.size())

WebUI.delay(1)

seaPortList.get(randomSeaPort).click()

// SELECT PORT OF DESTINATION
WebUI.click(findTestObject('shipment/txt_port_of_destination'))

WebUI.delay(1)

List<WebElement> airPortList = WebUiCommonHelper.findWebElements(new TestObject().addProperty('xpath', ConditionType.EQUALS,
		'//div[contains(@class,\'my-select-box\')]//h1'), 10)

int randomAirPort = new Random().nextInt(airPortList.size())

WebUI.delay(1)

airPortList.get(randomAirPort).click()

WebUI.takeScreenshot()

// SELECT COMODITY
WebUI.executeJavaScript("window.scrollBy(0, 200)", null)

List<String> comodityOptions = ['FOOTWEAR', 'OTHER', 'ELECTRONICS', 'GARMENTS', 'MACHINERY', 'ELECTRICAL', 'SHOES']

String selectedComodity = comodityOptions[new Random().nextInt(comodityOptions.size())]

WebUI.selectOptionByLabel(findTestObject('Object Repository/shipment/select_comodity'), selectedComodity, false, FailureHandling.STOP_ON_FAILURE)

// SELECT ETD
String etd = RandomDataGenerator.getRandomDate(30)

WebUI.setText(findTestObject('Object Repository/shipment/txt_etd'), etd)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/shipment/btn_next_book_info'))

WebUI.verifyTextPresent(msgSuccess, false, FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

