package org.evolution.dancingstar.result

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import org.evolution.dancingstar.R
import org.evolution.dancingstar.dance.DanceActivity
import org.evolution.dancingstar.main.MainActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)



        result_btn_retry.setOnClickListener {
            var intent = Intent(this, DanceActivity::class.java)
            startActivity(intent)
        }

        result_btn_reselect.setOnClickListener {
            //  기존 액티비티 죽이기
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
