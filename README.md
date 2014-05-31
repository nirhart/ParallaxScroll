Parallax Scrolls
================
# Parallax ListView and ScrollView for Android

## This project includes
* ScrollView with one or more parallaxed views.
* ListView with parallaxed header.
* Complete parallaxed ListView.
* ExpandableListView with parallaxed header.
* Complete parallaxed ExpandableListView.
* Support Android 1.6 and above.

## Usage
### See demo app for best practice - https://play.google.com/store/apps/details?id=com.nirhart.parallaxscrollexample
* parallax_factor - For ScrollView and ListView, the first view's parallax facto
* inner_parallax_factor - For ScrollView only - the parallax factor between each view and view.
* parallax_views_num - For ScrollView only - the number of parallaxed views.
* circular_parallax - For ListView only - whether all of the list is parallaxed or not.

## Building

### Using gradle to build.

 This project uses the gradle wrapper to build the library and example app

#### assemble the library

`./gradlew :ParallaxScroll:assembleDebug`


#### install the example

`./gradlew :ParallaxScrollExample:installDebug`

*note:* on windows use `gradlew.bat` instead of `./gradlew`

