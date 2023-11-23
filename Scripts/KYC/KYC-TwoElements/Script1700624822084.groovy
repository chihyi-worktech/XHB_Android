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

//Mobile.startExistingApplication(GlobalVariable.applicationID, FailureHandling.STOP_ON_FAILURE)
'點擊我的'
Mobile.tap(findTestObject('BottomNavigation/mine'), 0)

'關閉首進我的提示訊息'
CustomKeywords.'customKeyword.FirstEnter.closeMineKnown'()

'點擊帳戶管理'
Mobile.tap(findTestObject('KYC/accountManagement'), 0)

'點擊實名認證'
Mobile.tap(findTestObject('KYC/KYC'), 0)

'輸入真實姓名'
Mobile.setText(findTestObject('KYC/TwoElements/KYC_Name'), GlobalVariable.KYCName, 0)

'輸入身分證號'
Mobile.setText(findTestObject('KYC/TwoElements/KYC_ID'), GlobalVariable.KYCID, 0)

'點擊提交'
Mobile.tap(findTestObject('KYC/TwoElements/KYC_Submit'), 0)

'實名認證提交失敗'
if (Mobile.waitForElementPresent(findTestObject('KYC/TwoElements/KYC_Submit'), 3)) {
    String timeStamp = new SimpleDateFormat('yyyyMMddHHmmss').format(Calendar.getInstance().getTime())

    String filename = ('D:\\XHB\\Android\\ScreenShot\\KYCSubmitFail_' + timeStamp) + '.jpg'

    Mobile.takeScreenshot(filename, FailureHandling.STOP_ON_FAILURE)

    System.out.println('實名認證提交失敗')

    Mobile.pressBack()

    Mobile.pressBack()
} else {
    '實名認證成功'
    if (Mobile.waitForElementPresent(findTestObject('Object Repository/KYC/TwoElements/MT4Account_Success'), 3)) {
        Mobile.tap(findTestObject('Object Repository/KYC/TwoElements/toMyAccount'), 0)

        System.out.println('實名認證成功')
    } else {
        '實名認證失敗'
        String failMessage = Mobile.getText(findTestObject('Object Repository/KYC/TwoElements/MT4Account_FailMessage'), 
            0)

        Mobile.tap(findTestObject('Object Repository/KYC/TwoElements/toAccountManagement'), 0)

        Mobile.pressBack()

        System.out.println('實名認證失敗，失敗原因：' + failMessage)
    }
}

