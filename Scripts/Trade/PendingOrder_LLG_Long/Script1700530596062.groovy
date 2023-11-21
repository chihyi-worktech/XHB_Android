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

'關閉首進提示'
CustomKeywords.'customKeyword.FirstEnter.closeTradeKnown'()

'點擊掛單交易'
Mobile.tap(findTestObject('Trade/Trade_PendingOrder'), 0)

'選擇商品_LLG'
Mobile.tap(findTestObject('Object Repository/Trade/PendingOrder(Folder)/pendingOrder_Menu'), 0)

Mobile.tap(findTestObject('Object Repository/Trade/PendingOrder(Folder)/LLG'), 0)

'點擊買漲'
Mobile.tap(findTestObject('Object Repository/Trade/PendingOrder(Folder)/PendingOrder_Long'), 0)

'點擊掛單價格+，直接設定掛單價格顯示為掛單價格為空'
Mobile.tap(findTestObject('Object Repository/Trade/PendingOrder(Folder)/pendingOrder_PriceAdd'), 0)

'設定掛單價格'
Mobile.setText(findTestObject('Trade/PendingOrder(Folder)/pendingOrder_Price'), '2050', 0)

'點擊手數+'
Mobile.tap(findTestObject('Object Repository/Trade/PendingOrder(Folder)/pendingOrder_LotSizeAdd'), 0)

'點擊確認掛單'
Mobile.tap(findTestObject('Trade/PendingOrder(Folder)/ConfirmPendingOrder'), 0)

'點擊查看掛單'
Mobile.tap(findTestObject('Trade/PendingOrder(Folder)/checkPendingOrder'), 0)

