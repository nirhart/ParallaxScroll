Parallax Scrolls
================
# Parallax ListView and ScrollView for Android

## This project includes
* ScrollView with one or more parallaxed views
* ListView with parallaxed header
* Complete parallaxed ListView
* ExpandableListView with parallaxed header
* Complete parallaxed ExpandableListView
* Support Android 1.6 and above

## Usage
### See demo app for best practice - https://play.google.com/store/apps/details?id=com.nirhart.parallaxscrollexample
* parallax_factor - For ScrollView and ListView, the first view's parallax factor
* inner_parallax_factor - For ScrollView only - the parallax factor between each view and view
* parallax_views_num - For ScrollView only - the number of parallaxed views
* circular_parallax - For ListView only - whether all of the list is parallaxed or not

## Maven repository access

### In the build.gradle (at the module level) add the new dependency:
```
  compile 'com.github.nirhart:parallaxscroll:1.0'
```

or look for it using Android Studio module dependencies

### Example ParallaxScroll Usage

```xml
<com.nirhart.parallaxscroll.views.ParallaxScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:parallax_factor="1.9"
    tools:context=".MainActivity" >

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical" >

        <TextView
            android:layout_width="match_parent"
            android:layout_height="200dp"
            android:background="@drawable/item_background"
            android:gravity="center"
            android:text="PARALLAXED"
            android:textSize="50sp"
            tools:ignore="HardcodedText" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. 	Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            android:textSize="26sp"
            android:background="@android:color/white"
            android:padding="5dp"
            tools:ignore="HardcodedText" />
    </LinearLayout>

</com.nirhart.parallaxscroll.views.ParallaxScrollView>
```

## Building

### Using gradle to build.

 This project uses the gradle wrapper to build the library and example app

#### assemble the library

`./gradlew :ParallaxScroll:assembleDebug`


#### install the example

`./gradlew :ParallaxScrollExample:installDebug`

*note:* on windows use `gradlew.bat` instead of `./gradlew`

