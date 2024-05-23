package com.bishal.imagepicker.gallery



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bishal.imagepicker.databinding.ActivitySelectBinding


class SelectActivity : AppCompatActivity() {
    private lateinit var b: ActivitySelectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivitySelectBinding.inflate(layoutInflater)
        setContentView(b.root)
        setSupportActionBar(b.selectToolbar)

    }


}
