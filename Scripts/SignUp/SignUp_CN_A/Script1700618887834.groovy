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

'點擊首頁'
Mobile.tap(findTestObject('BottomNavigation/home'), 0)

'點擊註冊'
Mobile.tap(findTestObject('SignUp/home_Signup'), 0)

'選擇註冊地區_中國'
Mobile.tap(findTestObject('SignUp/registrationArea'), 0)

Mobile.tap(findTestObject('SignUp/registrationArea_CN'), 0)

'國碼選擇_+86'
Mobile.tap(findTestObject('SignUp/countryCode'), 0)

Mobile.tap(findTestObject('SignUp/countryCode_86'), 0)

'輸入手機號'
Mobile.setText(findTestObject('SignUp/phoneNumber'), GlobalVariable.phoneNumber, 0)

'輸入密碼'
Mobile.setText(findTestObject('SignUp/password'), 'qwe123', 0)

'勾選同意協議書'
Mobile.tap(findTestObject('SignUp/agreement'), 0)

'點擊"獲取驗證碼"'
Mobile.tap(findTestObject('SignUp/getVerificationCode'), 0)

