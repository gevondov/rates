package com.gevondov.rates.container

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gevondov.rates.R

class ContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = ContainerFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
    }

}
