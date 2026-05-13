package com.triggers.base

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.widget.TextView

/**
 * Trigger activity that shows the app name for 8 seconds, then closes.
 * The launch is registered by the system, so macro apps (Tasker, MacroDroid, etc.)
 * receive the "app launched" event keyed by this app's package name.
 */
class TriggerActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Simple centered label showing the app's name
        val label = TextView(this).apply {
            text = getString(applicationInfo.labelRes)
            textSize = 32f
            gravity = Gravity.CENTER
        }
        setContentView(label)

        // Close after 8 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            if (!isFinishing) finish()
        }, 8000)
    }
}
