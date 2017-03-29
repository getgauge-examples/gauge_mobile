Mobile tests with Gauge
=======================

**Pre-requisites**
-----------------

For mobile test cases with Gauge and Selendroid, it is necessary to install certain dependencies

**Java SDK**

A J​ava SDK3 (​v. 1.7 and above) needs to be installed and configured.

**Android SDK**
* install the A​ndroid­SDK
This example was tested with android-sdk/24.4.1_1

Brew installation
```
brew install android-sdk
```

Chocolatey installation
```
https://chocolatey.org/packages/android-sdk/24.4.1.1
```

Ensure A​NDROID_HOME is in P​ATH
export ANDROID_HOME=/install_dir/android­sdk­linux export PATH=${PATH}:$ANDROID_HOME/tools
export PATH=${PATH}:$ANDROID_HOME/platform­tools

* Verify installation

```
a​ndroid
```
In windows execute with extension.​
If installation and path is correct a Android SDK Manager is shown.

Install the build tools 23.0.1 and API 24,25
 -  Android SDK Build-tools 23.0.1
 -  Android 7.0 (API 24)
 -  Android 7.1.1 (API 25)

**Android Virtual Devices**
```
android create avd --name Nexus --target android-25 --abi google_apis/x86_64
```

To list all the avds
```
android list avds
```
The api changes in 25 to `bin\avdmanager list avds`

**Gauge**
* Install [Gauge and Gauge-Java](https://getgauge.io/get-started.html)

**To run the tests**
-----------------
* Start the emulator
```
emulator -avd "Nexus"
```
* mvn test