package com.dev.megaloma.hondaapp

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_result.*
import kotlin.random.Random

class ResultActivity : AppCompatActivity() {

    private var mVideoView : VideoView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        setSupportActionBar(toolbar)
    }

    override fun onResume() {
        super.onResume()
        mVideoView = findViewById(R.id.result_video)
        val myHand = intent.getStringExtra("MyHand")
        var tmpRid = 0

        // 乱数に応じて出すテキストを変更
        val randomValue = Random.nextInt(100)
        Log.d("randomValue",randomValue.toString())

        // 勝ちパターン 2%に固定
        if(randomValue == 0 || randomValue == 1){
            tmpRid = when(myHand){
                "goo" -> R.raw.honda_you_win_chi
                "chi" -> R.raw.honda_you_win_par
                "par" -> R.raw.honda_you_win_goo
                else -> R.raw.honda_you_win_goo
            }
        }
        // 負けパターン
        else{
            tmpRid = when(myHand){
                "goo" -> R.raw.honda_you_lose_par
                "chi" -> R.raw.honda_you_lose_goo
                "par" -> R.raw.honda_you_lose_chi
                else -> R.raw.honda_you_lose_goo
            }
        }

        mVideoView!!.setVideoURI(
            Uri.parse("android.resource://"
                    + this.packageName +"/" + tmpRid))
        mVideoView!!.start()
    }

    override fun onPause() {
        super.onPause()
        mVideoView = null
    }

}
