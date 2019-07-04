package com.sqisland.android.espresso.hello

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView

import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes


class MainActivity : Activity() {
  private lateinit var greetingView: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    greetingView = findViewById(R.id.greeting)

    AppCenter.start(application, "1badaafb-1a0d-4e8c-b479-8dcb1a68967e",
            Analytics::class.java, Crashes::class.java)

  }

  fun greet(v: View) {
    greetingView.setText(R.string.hello)
  }
}