package com.example.scaner

import android.content.pm.ActivityInfo
import com.journeyapps.barcodescanner.CaptureActivity

class CaptureActivityPortrait : CaptureActivity() {
    override fun onResume() {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onResume()
    }
}