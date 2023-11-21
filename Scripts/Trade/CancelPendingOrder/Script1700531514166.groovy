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

//Mobile.startExistingApplication(GlobalVariable.applicationID)
'點擊交易'
Mobile.tap(findTestObject('BottomNavigation/trade'), 0)

CustomKeywords.'customKeyword.FirstEnter.closeTradeKnown'()

'點擊資產'
Mobile.tap(findTestObject('Trade/Trade_Assets'), 0)

'點擊掛單'
Mobile.tap(findTestObject('Trade/Assets(Folder)/assets_PendingOrder'), 0)

'點擊第一筆掛單'
Mobile.tap(findTestObject('Object Repository/Trade/CancelPendingOrder(Folder)/firstPendingOrder'), 0)

'撤銷'
Mobile.tap(findTestObject('Object Repository/Trade/CancelPendingOrder(Folder)/cancelPendingOrder'), 0)

