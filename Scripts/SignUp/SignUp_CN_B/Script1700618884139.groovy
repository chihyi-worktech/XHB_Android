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
import java.io.FileReader as FileReader
import java.io.BufferedReader as BufferedReader
import java.io.IOException as IOException
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date

String verificationCode

'讀取檔案'
FileReader fr = new FileReader('VerificationCode.txt')

BufferedReader br = new BufferedReader(fr)

while (br.ready()) {
    verificationCode = br.readLine()
}

fr.close()

Mobile.startExistingApplication(GlobalVariable.applicationID, FailureHandling.STOP_ON_FAILURE)

'輸入驗證碼'
Mobile.setText(findTestObject('SignUp/verificationCode'), verificationCode, 0)

'點擊下一步'
Mobile.tap(findTestObject('SignUp/next'), 0)

'判斷是否註冊成功'
if (Mobile.waitForElementPresent(findTestObject('SignUp/next'), 3)) {
    System.out.println('註冊失敗')

    String timeStamp = new SimpleDateFormat('yyyyMMddHHmmss').format(Calendar.getInstance().getTime())

    String filename = ('D:\\XHB\\Android\\ScreenShot\\SignUpFail_' + timeStamp) + '.jpg'

    Mobile.takeScreenshot(filename, FailureHandling.STOP_ON_FAILURE)
	
	Mobile.pressBack()
	
} else {
    System.out.println('註冊成功')

    CustomKeywords.'customKeyword.Google.googleAutoSavePassword'()

    '點擊回到首頁'
    Mobile.tap(findTestObject('Object Repository/SignUp/backToHome'), 0)
}

