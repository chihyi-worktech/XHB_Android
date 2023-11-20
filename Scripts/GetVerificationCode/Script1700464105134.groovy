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
import java.io.FileWriter;
import java.io.IOException;

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.CRMUrl)

WebUI.setText(findTestObject('Object Repository/GetVerificationCode/Page_Login/CRMAccount'), GlobalVariable.CRMAccount)

WebUI.setText(findTestObject('Object Repository/GetVerificationCode/Page_Login/CRMPassword'), GlobalVariable.CRMPassword)

WebUI.click(findTestObject('Object Repository/GetVerificationCode/Page_Login/CRMLogin'))

WebUI.setText(findTestObject('Object Repository/GetVerificationCode/Page_/phoneNumber'), GlobalVariable.phoneNumber)

WebUI.click(findTestObject('Object Repository/GetVerificationCode/Page_/search'))

String Message=WebUI.getText(findTestObject('Object Repository/GetVerificationCode/Page_/firstMessage'))

String VerificationCode=Message.substring(10,16);

System.out.println("驗證碼為："+VerificationCode);

WebUI.closeBrowser()

FileWriter fw = new FileWriter("VerificationCode.txt");
fw.write(VerificationCode);
fw.flush();
fw.close();

