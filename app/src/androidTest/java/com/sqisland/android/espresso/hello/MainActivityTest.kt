package com.sqisland.android.espresso.hello

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.After
import com.microsoft.appcenter.espresso.Factory
import com.microsoft.appcenter.espresso.ReportHelper
import android.R.attr.label



@Rule
var reportHelper: ReportHelper = Factory.getReportHelper()


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
  @get:Rule
  val activityRule = ActivityTestRule(MainActivity::class.java)

  @Test
  fun greet() {
    onView(withId(R.id.greeting))
      .check(matches(withText("")))

    onView(withId(R.id.greet_button))
      .check(matches(withText(R.string.greet)))
      .perform(click())

    onView(withId(R.id.greeting))
      .check(matches(withText(R.string.hello)))
  }

    @After
    fun TearDown() {
        reportHelper.label("Stopping App")
    }

}