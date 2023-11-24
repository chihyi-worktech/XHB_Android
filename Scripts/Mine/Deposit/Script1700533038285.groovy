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

'選擇入金方式'

if(Mobile.waitForElementPresent(findTestObject('Mine/Deposit/payment'), 3)) {

	Mobile.tap(findTestObject('Mine/Deposit/payment'), 0)

}

else {
	Mobile.tap(findTestObject('Object Repository/Mine/Deposit/payment_2'), 0)
	
}


String depositAmount

'選擇入金支付渠道'
if (Mobile.waitForElementPresent(findTestObject('Mine/Deposit/Alipay'), 3)) {
    Mobile.tap(findTestObject('Mine/Deposit/Alipay'), 0)

    System.out.println('使用Alipay提交入金申請')

    depositAmount = 135

    CustomKeywords.'customKeyword.deposit.submitDeposit'(depositAmount)
} else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Mine/Deposit/Anxpay'), 3)) {
    Mobile.tap(findTestObject('Object Repository/Mine/Deposit/Anxpay'), 0)

    System.out.println('使用Anxpay提交入金申請')

    depositAmount = 500

    CustomKeywords.'customKeyword.deposit.submitDeposit'(depositAmount)
} else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Mine/Deposit/Bbpay'), 3)) {
    Mobile.tap(findTestObject('Object Repository/Mine/Deposit/Bbpay'), 0)

    System.out.println('使用Bbpay提交入金申請')

    depositAmount = 500

    CustomKeywords.'customKeyword.deposit.submitDeposit'(depositAmount)
} else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Mine/Deposit/BFTpay'), 3)) {
    Mobile.tap(findTestObject('Object Repository/Mine/Deposit/BFTpay'), 0)

    System.out.println('使用BFTpay提交入金申請')

    depositAmount = 500

    CustomKeywords.'customKeyword.deposit.submitDeposit'(depositAmount)
} else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Mine/Deposit/SITPayment'), 3)) {
    Mobile.tap(findTestObject('Object Repository/Mine/Deposit/SITPayment'), 0)

    System.out.println('使用SIT的支付寶提交入金申請')

    depositAmount = 1000

    CustomKeywords.'customKeyword.deposit.submitDeposit'(depositAmount)
} else {
    System.out.println('無可入金的渠道')

    Mobile.pressBack()
}

