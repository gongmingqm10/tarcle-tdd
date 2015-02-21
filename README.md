# Tarcle - Android TDD Practise
===

Tarcle is a personal project which tries to develop modern android app using the traditional TDD practice. The app itself 
is build based on Android Lollipop using many popular Library, such as (Retrofit)[https://github.com/square/retrofit], 
(ButterKnife)[https://github.com/JakeWharton/butterknife], (Picasso)[https://github.com/square/picasso], since we try to
build a agile android project and has a fast iteration.

With the effort from Google and a lot of open source project contributors, Android itself finally begin to use TDD way to
develop. Continuous Iteration, Test Driven Development, Unit Test, Integration Test, Functional Test. Android is more friendly
to its developer.

In this app, we use (Robolectric)[http://robolectric.org/] for unit test, and (Espresso)[https://code.google.com/p/android-test-kit/wiki/Espresso]
for integration test, moreover we use (Calabash Android)[https://github.com/calabash/calabash-android] for functional test.

To make Roblectric coexist with Espresso, thanks the effort of (Android Unit Test Support)[http://tools.android.com/tech-docs/unit-testing-support] 
and (Deckard Gradle)[https://github.com/robolectric/deckard-gradle].

Welcome to begin your Android Development Tour.

## Provision
---

1. Upgrade your AndroidStudio, currently the new working version is `1.1.0`.
2. Use the latest Android Build Tools, make sure the version is no smaller than `1.1.0`.
3. Integration Test need to install the app in device, If your Genymotion didn't work, maybe install Android Emulator is your new choice,
which is faster with the support of Intel (HAXM)[https://software.intel.com/en-us/android/articles/intel-hardware-accelerated-execution-manager/].
4. To enable calabash-android, Ruby is needed. (See more details)[https://github.com/calabash/calabash-android/blob/master/README.md].

## Run Test
---

* Run unit test, which is located in `app/src/test` directory, mainly written with features of Robolectric.
```
./gradlew test
```

* Run integration test, which is located in `app/src/androidTest` directory, mainly written by Espresso.
```
./gradlew 
```

## Reference
---

* (Retrofit Document)[http://square.github.io/retrofit/]
* (Picasso Document)[http://square.github.io/picasso/]
* (ButterKnife Document)[http://jakewharton.github.io/butterknife/]
* (Robolectric Document)[http://robolectric.org/getting-started/]
* (Espresso Document)[https://code.google.com/p/android-test-kit/wiki/EspressoStartGuide]
* (Calabash README)[https://github.com/calabash/calabash-android]
* (AssertJ Document)[http://joel-costigliola.github.io/assertj/assertj-core.html]



