Mobile Test Example with Gauge and Selendroid
=============================================

Prerequisites
-------------
* Install android
On Mac I used
```
brew install android
```
* Open the Android SDK Manager
On Mac I used
```
android
```
* Select the relevant packages.
-  Android SDK Build-tools 23.0.1
-  Android 7.0 (API 24)
* Create the Android virtual device
```
android create avd --name Default --target android-24 --abi armeabi-v7a
```

Run the tests
-------------
* mvn clean test
