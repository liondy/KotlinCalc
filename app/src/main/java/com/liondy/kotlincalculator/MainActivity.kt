package com.liondy.kotlincalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var btn_0: Button? = null
    private var btn_1: Button? = null
    private var btn_2: Button? = null
    private var btn_3: Button? = null
    private var btn_4: Button? = null
    private var btn_5: Button? = null
    private var btn_6: Button? = null
    private var btn_7: Button? = null
    private var btn_8: Button? = null
    private var btn_9: Button? = null
    private var btn_tambah: Button? = null
    private var btn_kurang: Button? = null
    private var btn_kali: Button? = null
    private var btn_bagi: Button? = null
    private val btn_koma: Button? = null
    private var btn_calc: Button? = null
    private var btn_reset: Button? = null
    private var txtHasil: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtHasil = findViewById<View>(R.id.txtHasil) as TextView
        btn_0 = findViewById<View>(R.id.btn_0) as Button
        btn_1 = findViewById<View>(R.id.btn_1) as Button
        btn_2 = findViewById<View>(R.id.btn_2) as Button
        btn_3 = findViewById<View>(R.id.btn_3) as Button
        btn_4 = findViewById<View>(R.id.btn_4) as Button
        btn_5 = findViewById<View>(R.id.btn_5) as Button
        btn_6 = findViewById<View>(R.id.btn_6) as Button
        btn_7 = findViewById<View>(R.id.btn_7) as Button
        btn_8 = findViewById<View>(R.id.btn_8) as Button
        btn_9 = findViewById<View>(R.id.btn_9) as Button
        btn_tambah = findViewById<View>(R.id.btn_Add) as Button
        btn_kurang = findViewById<View>(R.id.btn_Sub) as Button
        btn_kali = findViewById<View>(R.id.btn_Mul) as Button
        btn_bagi = findViewById<View>(R.id.btn_Div) as Button
        btn_calc = findViewById<View>(R.id.btn_calc) as Button
        btn_reset = findViewById<View>(R.id.btn_reset) as Button

        btn_0!!.setOnClickListener(this)
        btn_1!!.setOnClickListener(this)
        btn_2!!.setOnClickListener(this)
        btn_3!!.setOnClickListener(this)
        btn_4!!.setOnClickListener(this)
        btn_5!!.setOnClickListener(this)
        btn_6!!.setOnClickListener(this)
        btn_7!!.setOnClickListener(this)
        btn_8!!.setOnClickListener(this)
        btn_9!!.setOnClickListener(this)
        btn_tambah!!.setOnClickListener(this)
        btn_kurang!!.setOnClickListener(this)
        btn_kali!!.setOnClickListener(this)
        btn_bagi!!.setOnClickListener(this)
        btn_calc!!.setOnClickListener(this)
        btn_reset!!.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View) {
        var text = ""
        if (v.id == btn_0!!.id) text = "0"
        else if (v.id == btn_1!!.id) text = "1"
        else if (v.id == btn_2!!.id) text = "2"
        else if (v.id == btn_3!!.id) text = "3"
        else if (v.id == btn_4!!.id) text = "4"
        else if (v.id == btn_5!!.id) text = "5"
        else if (v.id == btn_6!!.id) text = "6"
        else if (v.id == btn_7!!.id) text = "7"
        else if (v.id == btn_8!!.id) text = "8"
        else if (v.id == btn_9!!.id) text = "9"
        else if (v.id == btn_tambah!!.id) text = "+"
        else if (v.id == btn_kurang!!.id) text = "-"
        else if (v.id == btn_kali!!.id) text = "*"
        else if (v.id == btn_bagi!!.id) text = "/"
        else if (v.id == btn_reset!!.id) txtHasil!!.text = ""
        else if (v.id == btn_calc!!.id && txtHasil!!.text != "") calculate(txtHasil!!.text.toString())
        if (txtHasil!!.text == "0") {
            if (text != "+" && text != "-" && text != "*" && text != "/") txtHasil!!.text = text
        }
        else txtHasil!!.text = txtHasil!!.text.toString() + text
    }

    fun calculate(exp: String) {
        var exp = exp
        if (exp[exp.length - 1] == '.') {
            exp = exp.substring(0, exp.length - 1)
        }
        val postfix = Postfix()
        val hasil: Int = postfix.calculate(exp)
        txtHasil!!.text = hasil.toString()
    }
}
