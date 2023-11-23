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

'點擊我的'
Mobile.tap(findTestObject('BottomNavigation/mine'), 0)

CustomKeywords.'customKeyword.FirstEnter.closeMineKnown'()

'點擊帳戶管理'
Mobile.tap(findTestObject('KYC/accountManagement'), 0)

'點擊實名認證'
Mobile.tap(findTestObject('KYC/KYC'), 0)

'輸入真實姓名'
Mobile.setText(findTestObject('KYC/TwoElements/KYC_Name'), 'TW測試', 0)

'輸入身分證號'
Mobile.setText(findTestObject('KYC/TwoElements/KYC_ID'), 'T016728(7)', 0)

'點擊下一步'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/KYC_Next'), 0)

'點擊身分證照片正面'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/idPhoto_Front'), 0)

'同意存取權'
CustomKeywords.'customKeyword.AgreePermission.Permission'()

'打開相簿'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/openAlbum'), 0)

'選擇第一張照片'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/chooseFirstPhoto'), 0)

'確認照片'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/confirmPhoto'), 0)

'點擊身分證照片背面'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/idPhoto_Back'), 0)

'打開相簿'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/openAlbum'), 0)

'選擇第一張照片'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/chooseFirstPhoto'), 0)

'確認照片'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/confirmPhoto'), 0)

'點擊確認上傳'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/confirmUpload'), 0)

'輸入銀行分支'
Mobile.setText(findTestObject('Object Repository/KYC/BankCertification/bank_Branch'), 'test', 0)

'輸入銀行地址'
Mobile.setText(findTestObject('Object Repository/KYC/BankCertification/bank_Address'), 'test', 0)

'點擊銀行照片'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/bank_Photo'), 0)

'打開相簿'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/openAlbum'), 0)

'選擇第一張照片'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/chooseFirstPhoto'), 0)

'確認照片'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/confirmPhoto'), 0)

'點擊下一步'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/bank_Next'), 0)

'輸入銀行卡號'
Mobile.setText(findTestObject('Object Repository/KYC/BankCertification/bank_Account'), '01234567890', 0)

'選擇國碼_+86'
Mobile.tap(findTestObject('KYC/BankCertification/countryCode_CN'), 0)

Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/countryCode_86'), 0)

'輸入手機號'
Mobile.setText(findTestObject('KYC/BankCertification/Mobile'), GlobalVariable.phoneNumber, 0)

'點擊獲取驗證碼'
Mobile.tap(findTestObject('Object Repository/KYC/BankCertification/getVerificationCode'), 0)

