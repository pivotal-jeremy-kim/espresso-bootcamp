package com.example.weatherapp;

import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.weatherapp.activities.MainActivity;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withTagKey;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.startsWith;

/**
 * Created by pivotal on 2016-01-19.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest

public class ProjectSunshineEspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    //Espresso Basics
    @Test
    public void task0() {
        SystemClock.sleep(1000);
    }

    @Test
    public void task1() {
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText(R.string.action_settings)).perform(click());
        onView(withText(R.string.preference_title)).check(matches(withText("Forecast Preference")));
    }

    @Test
    public void task2() {
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText(R.string.action_settings)).perform(click());
        onView(withText(R.string.preference_zip_title)).perform(click());
        onView(withId(R.id.edittext_container)).perform(click());
        onView(withId(android.R.id.edit)).perform(clearText(), typeText("Chicago"));
        onView(withText("OK")).perform(click());
        Espresso.pressBack();
        SystemClock.sleep(500);
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText(R.string.action_settings)).perform(click());
        onView(allOf(withId(android.R.id.summary), hasSibling(withText("Set location")))).check(matches(withText("Chicago")));
        onView(withText(R.string.preference_zip_title)).perform(click());
        onView(withId(R.id.edittext_container)).perform(click());
        onView(withId(android.R.id.edit)).perform(clearText(), typeText("Toronto"));
        onView(withText("OK")).perform(click());
    }

    @Test
    public void task3() {
        SystemClock.sleep(500);
        onView(withId(R.id.refresh_layout)).perform(swipeDown());
        SystemClock.sleep(1000);
        onView(withId(R.id.snackbar_text)).check(matches(isDisplayed()));
    }

    //Espresso Intermediate
    @Test
    public void task4() {
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText(R.string.action_settings)).perform(click());
        onView(withText("Temperature Units")).perform(click());
        onData(hasToString("Imperial")).perform(click());
        SystemClock.sleep(1000);
        onView(withText("Temperature Units")).perform(click());
        onData(hasToString("Metric")).perform(click());
        SystemClock.sleep(1000);
    }
//
//    @Ignore
//    public void task5() {
//
//    }

    @Test
    public void task6() {
        onView(withId(R.id.refresh_layout)).perform(swipeUp());
        SystemClock.sleep(500);
        onView(withText("Wednesday")).perform(click());
        SystemClock.sleep(1000);
    }

//    @Test
//    public void task7() {
//
//    }
}
