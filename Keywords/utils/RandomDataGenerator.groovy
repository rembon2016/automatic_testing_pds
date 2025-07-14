package utils
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
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

import com.github.javafaker.Faker
import java.util.Locale

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Random

class RandomDataGenerator {
	static Faker faker = new Faker(new Locale("id"))
	static Faker fakerEn = new Faker(new Locale("en"))

	static String getRandomName() {
		return faker.name().fullName()
	}

	static String getRandomFirstName() {
		return faker.name().firstName()
	}

	static String getRandomLastName() {
		return faker.name().lastName()
	}

	static String getRandomEmail() {
		return faker.internet().emailAddress()
	}

	static String getRandomPhoneNumber() {
		return faker.phoneNumber().cellPhone()
	}

	static String getRandomAddress() {
		return faker.address().fullAddress()
	}

	private static final List<String> apiCountries = [
		"AFGHANISTAN",
		"ALBANIA",
		"ALGERIA",
		"AMERICAN SAMOA",
		"ANDORRA",
		"ANGOLA",
		"ANGUILLA",
		"ANTARCTICA",
		"ANTIGUA AND BARBUDA",
		"ARGENTINA",
		"ARMENIA",
		"ARUBA",
		"AUSTRALIA",
		"AUSTRIA",
		"AZERBAIJAN",
		"BAHAMAS THE",
		"BAHRAIN",
		"BANGLADESH",
		"BARBADOS",
		"BELARUS",
		"BELGIUM",
		"BELIZE",
		"BENIN",
		"BERMUDA",
		"BHUTAN",
		"BOLIVIA",
		"BOSNIA AND HERZEGOVINA",
		"BOTSWANA",
		"BOUVET ISLAND",
		"BRAZIL",
		"BRITISH INDIAN OCEAN TERRITORY",
		"BRUNEI",
		"BULGARIA",
		"BURKINA FASO",
		"BURUNDI",
		"CAMBODIA",
		"CAMEROON",
		"CANADA",
		"CAPE VERDE",
		"CAYMAN ISLANDS",
		"CENTRAL AFRICAN REPUBLIC",
		"CHAD",
		"CHILE",
		"CHINA",
		"CHINA HONG KONG",
		"CHRISTMAS ISLAND",
		"COCOS (KEELING) ISLANDS",
		"COLOMBIA",
		"COMOROS",
		"CONGO",
		"CONGO THE DEMOCRATIC REPUBLIC OF THE",
		"COOK ISLANDS",
		"COSTA RICA",
		"COTE D'IVOIRE (IVORY COAST)",
		"CROATIA (HRVATSKA)",
		"CUBA",
		"CYPRUS",
		"CZECH REPUBLIC",
		"DENMARK",
		"DJIBOUTI",
		"DOMINICA",
		"DOMINICAN REPUBLIC",
		"EAST TIMOR",
		"ECUADOR",
		"EGYPT",
		"EL SALVADOR",
		"EQUATORIAL GUINEA",
		"ERITREA",
		"ESTONIA",
		"ETHIOPIA",
		"EXTERNAL TERRITORIES OF AUSTRALIA",
		"FALKLAND ISLANDS",
		"FAROE ISLANDS",
		"FIJI ISLANDS",
		"FINLAND",
		"FRANCE",
		"FRENCH GUIANA",
		"FRENCH POLYNESIA",
		"FRENCH SOUTHERN TERRITORIES",
		"GABON",
		"GAMBIA THE",
		"GEORGIA",
		"GERMANY",
		"GHANA",
		"GIBRALTAR",
		"GREECE",
		"GREENLAND",
		"GRENADA",
		"GUADELOUPE",
		"GUAM",
		"GUATEMALA",
		"GUERNSEY AND ALDERNEY",
		"GUINEA",
		"GUINEA-BISSAU",
		"GUYANA",
		"HAITI",
		"HEARD AND MCDONALD ISLANDS",
		"HONDURAS",
		"HUNGARY",
		"ICELAND",
		"INDIA",
		"INDONESIA",
		"IRAN",
		"IRAQ",
		"IRELAND",
		"ISRAEL",
		"ITALY",
		"JAMAICA",
		"JAPAN",
		"JERSEY",
		"JORDAN",
		"KAZAKHSTAN",
		"KENYA",
		"KIRIBATI",
		"KOREA",
		"KOREA NORTH",
		"KUWAIT",
		"KYRGYZSTAN",
		"LAOS",
		"LATVIA",
		"LEBANON",
		"LESOTHO",
		"LIBERIA",
		"LIBYA",
		"LIECHTENSTEIN",
		"LITHUANIA",
		"LUXEMBOURG",
		"MACAU S.A.R.",
		"MACEDONIA",
		"MADAGASCAR",
		"MALAWI",
		"MALAYSIA",
		"MALDIVES",
		"MALI",
		"MALTA",
		"MAN (ISLE OF)",
		"MARSHALL ISLANDS",
		"MARTINIQUE",
		"MAURITANIA",
		"MAURITIUS",
		"MAYOTTE",
		"MEXICO",
		"MICRONESIA",
		"MOLDOVA",
		"MONACO",
		"MONGOLIA",
		"MONTSERRAT",
		"MOROCCO",
		"MOZAMBIQUE",
		"MYANMAR",
		"NAMIBIA",
		"NAURU",
		"NEPAL",
		"NETHERLANDS",
		"NETHERLANDS ANTILLES",
		"NEW CALEDONIA",
		"NEW ZEALAND",
		"NICARAGUA",
		"NIGER",
		"NIGERIA",
		"NIUE",
		"NORFOLK ISLAND",
		"NORTHERN MARIANA ISLANDS",
		"NORWAY",
		"OMAN",
		"PAKISTAN",
		"PALAU",
		"PALESTINIAN TERRITORY OCCUPIED",
		"PANAMA",
		"PAPUA NEW GUINEA",
		"PARAGUAY",
		"PERU",
		"PHILIPPINES",
		"PITCAIRN ISLAND",
		"POLAND",
		"PORTUGAL",
		"PUERTO RICO",
		"QATAR",
		"REUNION",
		"ROMANIA",
		"RUSSIA",
		"RWANDA",
		"SAINT HELENA",
		"SAINT KITTS AND NEVIS",
		"SAINT LUCIA",
		"SAINT PIERRE AND MIQUELON",
		"SAINT VINCENT AND THE GRENADINES",
		"SAMOA",
		"SAN MARINO",
		"SAO TOME AND PRINCIPE",
		"SAUDI ARABIA",
		"SENEGAL",
		"SERBIA",
		"SEYCHELLES",
		"SIERRA LEONE",
		"SINGAPORE",
		"SLOVAKIA",
		"SLOVENIA",
		"SMALLER TERRITORIES OF THE UK",
		"SOLOMON ISLANDS",
		"SOMALIA",
		"SOUTH AFRICA",
		"SOUTH GEORGIA",
		"SOUTH SUDAN",
		"SPAIN",
		"SRI LANKA",
		"SUDAN",
		"SURINAME",
		"SVALBARD AND JAN MAYEN ISLANDS",
		"SWAZILAND",
		"SWEDEN",
		"SWITZERLAND",
		"SYRIA",
		"TAIWAN",
		"TAJIKISTAN",
		"TANZANIA",
		"TES",
		"THAILAND",
		"TOGO",
		"TOKELAU",
		"TONGA",
		"TRINIDAD AND TOBAGO",
		"TUNISIA",
		"TURKEY",
		"TURKMENISTAN",
		"TURKS AND CAICOS ISLANDS",
		"TUVALU",
		"UGANDA",
		"UKRAINE",
		"UNITED ARAB EMIRATES",
		"UNITED KINGDOM",
		"UNITED STATES",
		"UNITED STATES MINOR OUTLYING ISLANDS",
		"URUGUAY",
		"UZBEKISTAN",
		"VANUATU",
		"VATICAN CITY STATE (HOLY SEE)",
		"VENEZUELA",
		"VIETNAM",
		"VIRGIN ISLANDS (BRITISH)",
		"VIRGIN ISLANDS (US)",
		"WALLIS AND FUTUNA ISLANDS",
		"WESTERN SAHARA",
		"YEMEN",
		"YUGOSLAVIA",
		"ZAMBIA",
		"ZIMBABWE"
	]

	static String getRandomCountry() {
		String randomCountry = fakerEn.address().country().toUpperCase()

		// Check if the country is in the API list
		if (apiCountries.contains(randomCountry)) {

			return randomCountry
		}else {

			List<String> defaultCountries = [
				'INDONESIA',
				'QATAR',
				'SINGAPORE',
				'GERMANY',
				'ITALY'
			]

			String defaultCountry = defaultCountries[new Random().nextInt(defaultCountries.size())]
			return defaultCountry
		}
	}

	static String getRandomCompany() {
		return faker.company().bs().toUpperCase()
	}

	static String getRandomCompanyIndustry() {
		return faker.company().industry()
	}

	static String getRandomNumber(int digits){
		return faker.number().digits(digits)
	}

	static String getRandomNumberRange(int min, int max){
		return faker.number().numberBetween(min, max) 
	}
	
	static String getRandomDate(int maxOffset) {
		LocalDate today = LocalDate.now()
		
		int randomDays = new Random().nextInt(maxOffset) + 1
		
		LocalDate randomFutureDate = today.plusDays(randomDays)
		
		// Format to 'dd-MM-yyyy'
		String formattedDate = randomFutureDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
		
		return formattedDate
	}
	
	static String getRandomDescription(int paragraph){
		String description = faker.lorem().paragraph(paragraph)
		
		return description
	}
}
