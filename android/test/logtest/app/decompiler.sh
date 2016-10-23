#!/bin/bash
DIR=/home/snowdream/snowdream/git/test/android/test/logtest/app
DIR_APK=${DIR}/build/outputs/apk

cd ${DIR_APK}
unzip app-release-unsigned.apk 
d2j-dex2jar.sh classes.dex 

