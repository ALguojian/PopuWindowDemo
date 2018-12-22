package com.alguojian.popuwindowdemo

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.LinearLayout

import com.alguojian.mylibrary.BasePopu
import com.alguojian.popuwindowdemo.databinding.PopuOneBinding
import kotlinx.android.synthetic.main.activity_main.*

/**
 * ${Descript}
 *
 * @author alguojian
 * @date 2018/12/21
 */
class MainActivity : AppCompatActivity() {

    private lateinit var basePopu: BasePopu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inflate = DataBindingUtil.inflate<PopuOneBinding>(LayoutInflater.from(this), R.layout.popu_one, null, false)
        basePopu = BasePopu(this, inflate.root, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)


        button2.setOnClickListener { finish() }

        button.setOnClickListener {

            if (basePopu.isShowing) {
                basePopu.dismiss()
                return@setOnClickListener
            }

            basePopu.showAsDropDown(button)
            inflate.button.setOnClickListener { println("---------adsasdasdadasdad") }
        }
    }
}
