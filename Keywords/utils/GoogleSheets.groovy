package utils

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.json.gson.GsonFactory
import com.google.api.services.sheets.v4.Sheets
import com.google.api.services.sheets.v4.model.ValueRange
import com.google.auth.oauth2.GoogleCredentials
import com.google.auth.http.HttpCredentialsAdapter

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class GoogleSheets {
	static List<List<Object>> readGoogleSheet(String spreadsheetId, String range) {
		// Lokasi file kredensial JSON di proyek
		String credentialsPath = "Include/katalon-sheet.json"
		String applicationName = "KatalonSheetsAPI"

		try {
            GoogleCredentials credentials = GoogleCredentials
                .fromStream(new FileInputStream(credentialsPath))
                .createScoped(Collections.singleton("https://www.googleapis.com/auth/spreadsheets"))

            Sheets service = new Sheets.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                GsonFactory.getDefaultInstance(),
                new HttpCredentialsAdapter(credentials)
            )
            .setApplicationName(applicationName)
            .build()

            ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute()

            List<List<Object>> values = response.getValues()
            if (values == null || values.isEmpty()) {
                println("No data found.")
                return []
            } else {
                return values
            }
        } catch (Exception e) {
            println("Error: " + e.getMessage())
            throw e
        }
    }

	@Keyword
	static void printSheetData(String spreadsheetId, String range) {
		def data = readGoogleSheet(spreadsheetId, range)
        data.eachWithIndex { row, index ->
            println "Row ${index + 1}: ${row}"
        }
    }
}