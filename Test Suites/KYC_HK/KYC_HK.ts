<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteCollectionEntity>
   <description></description>
   <name>KYC_HK</name>
   <tag></tag>
   <delayBetweenInstances>0</delayBetweenInstances>
   <executionMode>SEQUENTIAL</executionMode>
   <maxConcurrentInstances>8</maxConcurrentInstances>
   <testSuiteRunConfigurations>
      <TestSuiteRunConfiguration>
         <configuration>
            <groupName>Mobile</groupName>
            <profileName>PROD</profileName>
            <requireConfigurationData>true</requireConfigurationData>
            <runConfigurationData>
               <entry>
                  <key>deviceName</key>
                  <value>vivo V2110 (Android 13)</value>
               </entry>
               <entry>
                  <key>deviceId</key>
                  <value>3458168266003R1</value>
               </entry>
            </runConfigurationData>
            <runConfigurationId>Android</runConfigurationId>
         </configuration>
         <runEnabled>true</runEnabled>
         <testSuiteEntity>Test Suites/KYC_HK/KYC_HK_A</testSuiteEntity>
      </TestSuiteRunConfiguration>
      <TestSuiteRunConfiguration>
         <configuration>
            <groupName>Web Desktop</groupName>
            <profileName>PROD</profileName>
            <requireConfigurationData>false</requireConfigurationData>
            <runConfigurationId>Chrome</runConfigurationId>
         </configuration>
         <runEnabled>true</runEnabled>
         <testSuiteEntity>Test Suites/GetVerification</testSuiteEntity>
      </TestSuiteRunConfiguration>
      <TestSuiteRunConfiguration>
         <configuration>
            <groupName>Mobile</groupName>
            <profileName>PROD</profileName>
            <requireConfigurationData>true</requireConfigurationData>
            <runConfigurationData>
               <entry>
                  <key>deviceName</key>
                  <value>vivo V2110 (Android 13)</value>
               </entry>
               <entry>
                  <key>deviceId</key>
                  <value>3458168266003R1</value>
               </entry>
            </runConfigurationData>
            <runConfigurationId>Android</runConfigurationId>
         </configuration>
         <runEnabled>true</runEnabled>
         <testSuiteEntity>Test Suites/BankCertification/BankCertification_B</testSuiteEntity>
      </TestSuiteRunConfiguration>
   </testSuiteRunConfigurations>
</TestSuiteCollectionEntity>
