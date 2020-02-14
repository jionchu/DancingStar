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

    lateinit var rankingAdapter: RankingAdapter

    val ranking = arrayListOf<ranking>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var temp = ranking(nickname = "nickname", score = "203948")

        ranking.add(temp)
        ranking.add(temp)
        ranking.add(temp)
        ranking.add(temp)
        ranking.add(temp)
        ranking.add(temp)
        ranking.add(temp)
        ranking.add(temp)
        ranking.add(temp)
        ranking.add(temp)
        ranking.add(temp)
        ranking.add(temp)


        rankingAdapter = RankingAdapter(this, ranking)
        listview_ranking.adapter = rankingAdapter


        result_btn_retry.setOnClickListener {
            var intent = Intent(this, DanceActivity::class.java)
            startActivity(intent)
        }

        result_btn_reselect.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
