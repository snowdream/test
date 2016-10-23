# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /home/snowdream/bin/android-sdk-linux/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-assumenosideeffects class android.util.Log {
        public static *** d(...);
        public static *** e(...);
        public static *** i(...);
        public static *** v(...);
        public static *** println(...);
        public static *** w(...);
        public static *** wtf(...);
}

#-assumenosideeffects class com.github.snowdream.logtest.LogUtil {
#        public static *** d(...);
#        public static *** e(...);
#        public static *** i(...);
#        public static *** v(...);
#        public static *** w(...);
#}