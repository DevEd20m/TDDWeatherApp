package es.jarroyo.tddweatherapp.app.baseTest

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.test.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import es.jarroyo.tddweatherapp.data.source.disk.DiskDataSource

class BaseActivityRule<A : Activity>(activityClass: Class<A>, initialTouchMode: Boolean, launchActivity: Boolean) : ActivityTestRule<A>(activityClass, initialTouchMode, launchActivity) {

    override fun beforeActivityLaunched() {
        super.beforeActivityLaunched()
        // Maybe prepare some mock service calls
        // Maybe override some depency injection modules with mocks
    }

    override fun getActivityIntent(): Intent {
        // add some custom extras and stuff
        return Intent()
    }

    override fun afterActivityLaunched() {
        super.afterActivityLaunched()
        // maybe you want to do something here
    }

    override fun afterActivityFinished() {
        // super.afterActivityFinshed()
        // Clean up mocks
        DiskDataSource(getContext()).deleteAllTables()
    }

    fun launchActivity() {
        this.launchActivity(getActivityIntent())
    }

    fun getContext(): Context {
        return InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext()
    }
}