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
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date

Mobile.startExistingApplication(GlobalVariable.applicationID)

CustomKeywords.'customKeyword.StartFail.StartFailMessage'()

'關閉活動提示訊息'
CustomKeywords.'customKeyword.FirstEnter.closeActivity'()

'點擊首頁'
Mobile.tap(findTestObject('BottomNavigation/home'), 0)

'是否已登錄判斷；已登錄則登出'
if (Mobile.waitForElementNotPresent(findTestObject('Object Repository/Login/home_Login'), 3)) {
    WebUI.callTestCase(findTestCase('Logout'), [:], FailureHandling.STOP_ON_FAILURE)
	
	Mobile.tap(findTestObject('BottomNavigation/home'), 0)
}

'點擊登錄'
Mobile.tap(findTestObject('Object Repository/Login/home_Login'), 0)

'輸入帳號'
Mobile.setText(findTestObject('Object Repository/Login/MT4Account'), GlobalVariable.KYCAccount, 0)

'輸入密碼'
Mobile.setText(findTestObject('Object Repository/Login/password'), GlobalVariable.KYCPassword, 0)

'點擊登錄'
Mobile.tap(findTestObject('Object Repository/Login/login'), 0)

'是否成功登錄判斷'
if (Mobile.waitForElementPresent(findTestObject('Object Repository/Login/login'), 3)) {
    '登錄失敗則截圖錯誤訊息'
    String timeStamp = new SimpleDateFormat('yyyyMMddHHmmss').format(Calendar.getInstance().getTime())

    String filename = ('D:\\XHB\\Android\\ScreenShot\\LoginFail_' + timeStamp) + '.jpg'

    Mobile.takeScreenshot(filename, FailureHandling.STOP_ON_FAILURE)

    System.out.println('登錄失敗')
} else {
    System.out.println('登錄成功')

    CustomKeywords.'customKeyword.Google.googleAutoSavePassword'()
}

