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

Mobile.startExistingApplication(GlobalVariable.applicationID, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/BottomNavigation/mine'), 0)

'關閉首進我的提示訊息'
CustomKeywords.'customKeyword.FirstEnter.closeMineKnown'()

'點擊入金'
Mobile.tap(findTestObject('Mine/Deposit/mine_Deposit'), 0)

String depositAmount = '100'

Mobile.setText(findTestObject('Object Repository/Mine/Deposit_TT/depositAmount'), depositAmount, 0)

'點擊確認提交'
Mobile.tap(findTestObject('Mine/Deposit_TT/submit'), 0)

'點擊上傳入金憑證'
Mobile.tap(findTestObject('Mine/Deposit_TT/uploadDepositCertificate'), 0)

'點擊+'
Mobile.tap(findTestObject('Mine/Deposit_TT/uploadPhoto'), 0)

'同意存取權'
CustomKeywords.'customKeyword.AgreePermission.Permission'()

'打開相簿'
Mobile.tap(findTestObject('Mine/Deposit_TT/openAlbum'), 0)

'選擇第一張相片'
Mobile.tap(findTestObject('Mine/Deposit_TT/firstPhoto'), 0)

'確認相片'
Mobile.tap(findTestObject('Mine/Deposit_TT/checkPhoto'), 0)

'提交電匯申請'
Mobile.tap(findTestObject('Mine/Deposit_TT/submitTT'), 0)

'確認'
Mobile.tap(findTestObject('Mine/Deposit_TT/confirm'), 0)

Mobile.pressBack()

