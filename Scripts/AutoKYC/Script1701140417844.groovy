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
import java.io.FileWriter as FileWriter
import java.io.IOException as IOException
import java.io.FileReader as FileReader
import java.io.BufferedReader as BufferedReader

String MT4Account

'讀取MT4帳號'
FileReader fr = new FileReader('MT4Account.txt')

BufferedReader br = new BufferedReader(fr)

while (br.ready()) {
    MT4Account = br.readLine()
}

fr.close()

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.KYCURL)

WebUI.setText(findTestObject('GetVerificationCode/Page_Login/CRMAccount'), GlobalVariable.CRMAccount)

WebUI.setText(findTestObject('GetVerificationCode/Page_Login/CRMPassword'), GlobalVariable.CRMPassword)

WebUI.click(findTestObject('GetVerificationCode/Page_Login/CRMLogin'))

WebUI.setText(findTestObject('AccountInfoModify/MT4Account'), MT4Account)

WebUI.click(findTestObject('AccountInfoModify/search'))

WebUI.click(findTestObject('AccountInfoModify/process'))

WebUI.click(findTestObject('AccountInfoModify/SMSTemplate'))

if(GlobalVariable.environment=="SIT") {
	WebUI.click(findTestObject('Object Repository/AccountInfoModify/noReason_SIT'))
}

else if(GlobalVariable.environment=="PROD") {
	WebUI.click(findTestObject('Object Repository/AccountInfoModify/noReason_PROD'))
}

else {
	System.out.println("無設定環境");
}

WebUI.setText(findTestObject('AccountInfoModify/note'), '无原因，測試')

WebUI.click(findTestObject('AccountInfoModify/KYC'))

WebUI.closeBrowser()

