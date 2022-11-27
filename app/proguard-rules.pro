# Retrofit
-keep class com.google.gson.** { *; }
-keep public class com.google.gson.** {public private protected *;}
-keep class com.google.inject.** { *; }
-keep class org.apache.http.** { *; }
-keep class retrofit.** { *; }
-keepattributes *Annotation*
-keepattributes Signature
-dontwarn com.squareup.okhttp.*

#Lottie
-dontwarn com.airbnb.lottie.**
-keep class com.airbnb.lottie.** {*;}
# OkHttp
-keep class com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**
-dontwarn okhttp3.**
#AppsFlyer
-keep class com.appsflyer.** { *; }
-keep public class com.android.installreferrer.** { *; }



#Hawk
-keepclassmembers @com.facebook.crypto.proguard.annotations.KeepGettersAndSetters class * {
  void set*(***);
  *** get*();
}

#Onesignal
-dontwarn com.onesignal.**
-keep class com.onesignal.ActivityLifecycleListenerCompat** {*;}

#Coroutines
-keep class kotlinx.coroutines.**
-dontwarn kotlinx.coroutines.**

