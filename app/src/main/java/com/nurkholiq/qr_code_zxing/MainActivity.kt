package com.nurkholiq.qr_code_zxing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    var cardView1: CardView? = null
    var cardView2: CardView? = null
    var btnScan: Button? = null
    var btnEnterCode: Button? = null
    var edtCode: EditText? = null
    var tvText: TextView? = null
    var hide: Animation? = null
    var reveal: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardView1 = findViewById(R.id.cv_qr1)
        cardView2 = findViewById(R.id.cv_qr2)
        btnScan = findViewById(R.id.btn_scan)
        btnEnterCode = findViewById(R.id.btn_enter_code)
        edtCode = findViewById(R.id.edt_Code)
        tvText = findViewById(R.id.tv_title)

        hide = AnimationUtils.loadAnimation(this, android.R.anim.fade_out)
        reveal = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)

        tvText!!.startAnimation(reveal)
        cardView2!!.startAnimation(reveal)
        tvText!!.setText("Scan QR Code Here")
        cardView2!!.visibility = View.VISIBLE

        btnScan!!.setOnClickListener {
            tvText!!.startAnimation(reveal)
            cardView1!!.startAnimation(hide)
            cardView2!!.startAnimation(reveal)

            cardView2!!.visibility = View.VISIBLE
            cardView1!!.visibility = View.GONE
            tvText!!.setText("Scan QR Code Here")
        }

        btnEnterCode!!.setOnClickListener {
            tvText!!.startAnimation(reveal)
            cardView1!!.startAnimation(reveal)
            cardView2!!.startAnimation(hide)

            cardView2!!.visibility = View.GONE
            cardView1!!.visibility = View.VISIBLE
            tvText!!.setText("Enter QR Code Here")
        }

    }
}