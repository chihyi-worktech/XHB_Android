package customKeyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class FirstEnter {

	@Keyword
	def closeActivity() {
		'關閉活動提示訊息'
		if (Mobile.waitForElementPresent(findTestObject('Object Repository/FirstEnter/closeActivity'), 3)) {

			Mobile.tap(findTestObject('Object Repository/FirstEnter/closeActivity'), 0)
		}
	}

	@Keyword
	def closeMineKnown() {
		'關閉我的首進提示訊息'
		if (Mobile.waitForElementPresent(findTestObject('Object Repository/FirstEnter/closeMineFirstEnter'), 3)) {
			Mobile.tap(findTestObject('Object Repository/FirstEnter/closeMineFirstEnter'), 0)
		}

		'關閉已通過實名認證帳號的首進提示訊息'
		if (Mobile.waitForElementPresent(findTestObject('Object Repository/FirstEnter/closeMineFirstEnter(KYC)'), 3)) {
			Mobile.tap(findTestObject('Object Repository/FirstEnter/closeMineFirstEnter(KYC)'), 0)
		}
	}

	@Keyword
	def closeQuotationKnown() {
		'關閉行情首進提示訊息'
		if (Mobile.waitForElementPresent(findTestObject('Object Repository/FirstEnter/closeQuotationFirstEnter'), 3)) {
			Mobile.tap(findTestObject('Object Repository/FirstEnter/closeQuotationFirstEnter'), 0)
		}
	}

	@Keyword
	def closeTradeKnown() {
		'關閉交易首進提示訊息'
		if (Mobile.waitForElementPresent(findTestObject('Object Repository/FirstEnter/closeTradeFirstEnter'), 3)) {
			Mobile.tap(findTestObject('Object Repository/FirstEnter/closeTradeFirstEnter'), 0)
		}
	}
}
