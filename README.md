# Week 1 App
For week 1 of the app, we go over basic project structure and a hello world activity.

# Importing the project
To import the project, open Android Studio, and click on "Open an existing Android Studio project"
Look for this directory and import the directory itself. It'll take a few minutes for Gradle to sync everything and 
you should be good.

# Android Studio
Setting up Android Studio is easy. You can download Android Studio and the Android SDK [here](http://developer.android.com/sdk/index.html). To get an overview of Android Studio, look [here](http://developer.android.com/tools/studio/index.html).

# Genymotion
Genymotion is an emulator for Android that runs on x86. It's *soooo* much faster than the AVD emulator. Make an account on the [Genymotion website](https://www.genymotion.com/#!/), download Genymotion, and then create a new device.

I recommend the **Nexus 5 running 5.0.0** because the screen resolution for the Nexus 6 is 1440 x 2560 and will probably run slower.

If you're using Windows, it should just work. If you're using Mac or Linux, you have to install both Genymotion and [VirtualBox](https://www.virtualbox.org/wiki/Downloads).

# Creating a new project
Creating a new project is simple. Just click on "Start a new Android Studio project" (It may be different in the future). The default values in the wizard should be fine.

# READ THE CODE
The code is not that complicated and I actually wrote comments in the code to explain stuff. Primarily, you should check out the following files:

- `app/src/main/java/androidworkshop/org/testapp/MainActivity.java`
- `app/src/main/res/layout/activity_main.xml`
- `app/src/main/res/values/strings.xml`