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
import java.io.FileReader as FileReader
import java.io.BufferedReader as BufferedReader
import java.io.IOException as IOException
import java.io.FileWriter;

String verificationCode
String MT4Account

'讀取檔案'
FileReader fr = new FileReader('VerificationCode.txt')

BufferedReader br = new BufferedReader(fr)

while (br.ready()) {
	verificationCode = br.readLine()
}

fr.close()

Mobile.startExistingApplication(GlobalVariable.applicationID)

'輸入驗證碼'
Mobile.setText(findTestObject('Object Repository/KYC/BankCertification/verificationCode'), verificationCode, 0)

'點擊確認提交'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/bank_Submit'), 0)

'提交判斷'
if (Mobile.waitForElementPresent(findTestObject('Object Repository/KYC/BankCertification/bank_Submit'), 3)) {
    String timeStamp = new SimpleDateFormat('yyyyMMddHHmmss').format(Calendar.getInstance().getTime())

    String filename = ('D:\\XHB\\Android\\ScreenShot\\BankCertificationSubmitFail_' + timeStamp) + '.jpg'

    Mobile.takeScreenshot(filename, FailureHandling.STOP_ON_FAILURE)

    System.out.println('銀行卡認證申請提交失敗')
	
	Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/back'), 0)
	
	Mobile.pressBack()
	
	Mobile.pressBack()
} else {
	
    System.out.println('銀行卡認證申請提交成功')
	
	Mobile.pressBack()
	
	Mobile.pressBack()
	
	String temp=Mobile.getText(findTestObject('Object Repository/Mine/MT4Account'), 0)
	
	MT4Account=temp.substring(5,temp.length())
	
	'寫入需自動通過實名認證的MT4帳號'
	FileWriter fw = new FileWriter("MT4Account.txt");
	
	fw.write(MT4Account);
	
	fw.flush();
	
	fw.close();
	
}

