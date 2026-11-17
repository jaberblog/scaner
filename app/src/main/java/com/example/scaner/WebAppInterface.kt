package com.example.scaner

import android.webkit.JavascriptInterface
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import com.journeyapps.barcodescanner.ScanOptions

class WebAppInterface(
    private val activity: AppCompatActivity,
    private val barcodeLauncher: ActivityResultLauncher<ScanOptions>
) {

    @JavascriptInterface
    fun scanBarcode() {
        activity.runOnUiThread {
            val options = ScanOptions()
            options.setPrompt("بارکد را در کادر قرار دهید")
            options.setBeepEnabled(true)
            options.setOrientationLocked(false)
            options.setCaptureActivity(CaptureActivityPortrait::class.java)

            // اسکن همه فرمت‌های بارکد خطی
            options.setDesiredBarcodeFormats(
                "CODE_128",
                "CODE_39",
                "CODE_93",
                "EAN_13",
                "EAN_8",
                "UPC_A",
                "UPC_E",
                "CODABAR",
                "ITF"
            )

            barcodeLauncher.launch(options)
        }
    }
}