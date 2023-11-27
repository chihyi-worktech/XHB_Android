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

//Mobile.startExistingApplication(GlobalVariable.applicationID, FailureHandling.STOP_ON_FAILURE)

'點擊行情'
Mobile.tap(findTestObject('BottomNavigation/quotation'), 0)

'關閉行情首進提示'
CustomKeywords.'customKeyword.FirstEnter.closeQuotationKnown'()

'點擊商品判斷'
if (Mobile.waitForElementPresent(findTestObject('Quotation/quotation_LLG_Automator'), 3)) {
    Mobile.tap(findTestObject('Quotation/quotation_LLG_Automator'), 0)
} else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Quotation/quotation_LLG_XPATH'), 3)) {
    Mobile.tap(findTestObject('Object Repository/Quotation/quotation_LLG_XPATH'), 0)
}

'買漲'
Mobile.tap(findTestObject('Quotation/longButton'), 0)

'確認買漲'
Mobile.tap(findTestObject('Quotation/agile_Long'), 0)

'查看持倉'
Mobile.tap(findTestObject('Quotation/checkPosition'), 0)

