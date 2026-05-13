package com.triggers.base

import android.app.Activity
import android.os.Bundle

/**
 * Invisible trigger activity. The Theme.NoDisplay style ensures no window is ever shown,
 * and finish() is called before super.onResume() so the activity completes before any UI.
 * The launch is still registered by the system, so macro apps (Tasker, MacroDroid, etc.)
 * receive the "app launched" event keyed by this app's package name.
 */
class TriggerActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finish()
    }
}
