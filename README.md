Week 3
======
For this week, we go over starting activities from other activities, sharing data between activities, explicit intents, and implicit intents.

See the references below and read the comments in the code to get an idea how everything works.

Installing the Twitter APK
==========================
The example app has an example involving Twitter. If you're using the emulator, you have to install the Twitter. I've provided the APK in the repo. When the emulator is running, run 

```
    adb devices
```

It should show your device. Next, run

```
    adb install twitter.apk
```

and it should install Twitter into the emulator. Log into your Twitter account if you have one, and then running the app should work fine.

Reference
=========
- [Starting another activity](http://developer.android.com/training/basics/firstapp/starting-activity.html)
- [Sharing Data between activities (StackOverflow Answer)](http://stackoverflow.com/a/4878259/4625282)
- [Explicit/Implicit Intents](http://developer.android.com/guide/components/intents-filters.html)

