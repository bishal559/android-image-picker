package com.bishal.android_image_picker

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bishal.android_image_picker.databinding.ActivityMainBinding
import com.bishal.imagepicker.ImagePicker


class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.mainButton.setOnClickListener {
            ImagePicker(this,"Select Image").show(1, 1, 5) {
                b.mainPreview.setImageURI(Uri.parse(it[0]))
            }
        }
    }
}