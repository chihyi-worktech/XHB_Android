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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//Mobile.startExistingApplication(GlobalVariable.applicationID, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('BottomNavigation/mine'), 0)

CustomKeywords.'customKeyword.FirstEnter.closeMineKnown'()

Mobile.tap(findTestObject('Mine/Withdraw/mine_Withdraw'), 0)

Mobile.scrollToText('提交', FailureHandling.STOP_ON_FAILURE)

if (Mobile.waitForElementPresent(findTestObject('Object Repository/Mine/Withdraw/withdrawAmount'), 3)) {
    Mobile.setText(findTestObject('Object Repository/Mine/Withdraw/withdrawAmount'), GlobalVariable.withdrawAmount, 0)
}

else {
	Mobile.setText(findTestObject('Object Repository/Mine/Withdraw/withdrawAmount_2'), GlobalVariable.withdrawAmount, 0)
	
}

Mobile.tap(findTestObject('Object Repository/Mine/Withdraw/withdrawSubmit'),0)

if(Mobile.waitForElementPresent(findTestObject('Object Repository/Mine/Withdraw/failMessage'), 3)) {
	
	String failMessage=Mobile.getText(findTestObject('Object Repository/Mine/Withdraw/failMessage'), 3)
	
	System.out.println("提交出金申請失敗，失敗原因："+failMessage);
	
	Mobile.pressBack()
}
else if(Mobile.waitForElementPresent(findTestObject('Object Repository/Mine/Withdraw/withdrawFail_Time'), 3)){
	
	Mobile.tap(findTestObject('Object Repository/Mine/Withdraw/checkMessage'),0)
	
	Mobile.pressBack()
	
	System.out.println("提交出金申請失敗，未在取款時間內提交出金申請");
}

else if(Mobile.waitForElementPresent(findTestObject('Object Repository/Mine/Withdraw/withdrawSuccessMessage'), 3)) {
	Mobile.tap(findTestObject('Object Repository/Mine/Withdraw/checkMessage'),0)
	
	Mobile.pressBack()
	
	System.out.println("提交出金申請成功");
}

else {
	System.out.println("提交出金申請失敗，原因請查看截圖");
	String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
	String filename="D:\\XHB\\Android\\ScreenShot\\WithdrawFail_"+timeStamp+".jpg"
	Mobile.takeScreenshot(filename, FailureHandling.STOP_ON_FAILURE)
	Mobile.pressBack()
}