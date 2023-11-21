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
'點擊交易'
Mobile.tap(findTestObject('BottomNavigation/trade'), 0)

'關閉首進提示訊息'
CustomKeywords.'customKeyword.FirstEnter.closeTradeKnown'()

'點擊市價交易'
Mobile.tap(findTestObject('Trade/Trade_MarketOrder'), 0)

'選擇商品_LLG'
Mobile.tap(findTestObject('Trade/MarketOrder(Folder)/marketOrder_Menu'), 0)

Mobile.tap(findTestObject('Trade/MarketOrder(Folder)/LLG'), 0)

'點擊買漲'
Mobile.tap(findTestObject('Trade/MarketOrder(Folder)/long'), 0)

'點擊查看持倉'
Mobile.tap(findTestObject('Trade/MarketOrder(Folder)/checkPosition'), 0)

