# EMM Java SDK


Third EMM Java SDK provides the basic java APIs for third party developers to integrate their apps on EMM.

## Download Dependency

Gradle:

    implementation 'com.whatspos.sdk:emm-java-sdk:9.6.3'

## API Usage

### Download param(Optional, ignore this part if you don't have download parameter requirement)
    String packageName = context.getPackageName();
    int versionCode = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
    String saveFilePath = getFilesDir() + "/YourPath/";                                                             //Specifies the download path for the parameter file

    ParamApi paramApi = new ParamApi(apiUrl, appKey, appSecret, terminalSerialNo)
    paramApi.downloadParamToPath(getApplication().getPackageName(), BuildConfig.VERSION_CODE, saveFilePath);

### Upload subsidiary device information(subsidiary device info or application info)
    TerminalSyncInfo terminalSyncInfo = new TerminalSyncInfo();             //Init terminal Sync Info
    terminalSyncInfo.setName("Q20");                                        //Set Name，mandatory
    terminalSyncInfo.setType(SyncApi.SyncType.DEVICE);                      //Set Type [Application Info:1, Device Info: 2, Hardware Info: 3, Install History Info: 4]，mandatory
    terminalSyncInfo.setRemarks("TEST");                                    //Set Remarks, Optional
    terminalSyncInfo.setVersion("1.0");                                     //Set Version，Optional
    terminalSyncInfo.setStatus("");                                         //Set Status，Optional
    terminalSyncInfo.setSyncTime(System.currentTimeMillis());               //Set Sync Time，Optional
    List<TerminalSyncInfo> terminalSyncInfoList = new ArrayList<TerminalSyncInfo>();
    terminalSyncInfoList.add(terminalSyncInfo);
    SyncApi syncApi = new SyncApi(apiUrl, appKey, appSecret, terminalSerialNo);
    String result = syncApi.syncTerminalInfo(terminalSyncInfoList);

## License

See the [Apache 2.0 license](https://github.com/PAXSTORE/emm-java-sdk/blob/master/LICENSE) file for details.

    Copyright © 2019 Shenzhen Zolon Technology Co., Ltd. All Rights Reserved.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at following link.

         http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
