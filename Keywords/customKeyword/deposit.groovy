package customKeyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class deposit {
	@Keyword
	def submitDeposit(String depositAmount){

		Mobile.setText(findTestObject('Mine/Deposit/depositAmount'), depositAmount, 0)

		Mobile.tap(findTestObject('Mine/Deposit/checkDeposit'), 0)

		if(Mobile.waitForElementPresent(findTestObject('Object Repository/Mine/Deposit/blacklistMessage'), 3)) {
			String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

			String filename="D:\\XHB\\Android\\ScreenShot\\DepositBlackList_"+timeStamp+".jpg"

			Mobile.takeScreenshot(filename, FailureHandling.STOP_ON_FAILURE)

			Mobile.tap(findTestObject('Object Repository/Mine/Deposit/checkMessage'), 0)

			System.out.println("該帳號已進入入金黑名單");

			Mobile.pressBack()
		}

		else {
			Mobile.tap(findTestObject('Mine/Deposit/submitDeposit'), 0)

			WebUI.delay(6)

			String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

			String filename="D:\\XHB\\Android\\ScreenShot\\Deposit_"+timeStamp+".jpg"

			Mobile.takeScreenshot(filename, FailureHandling.STOP_ON_FAILURE)
			'回到我的頁面'
			Mobile.pressBack()
			
			Mobile.pressBack()
		}
	}
}
