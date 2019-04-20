package com.dev.megaloma.hondaapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.VideoView

class MainActivity : AppCompatActivity() {

    var mVideoView : VideoView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        mVideoView = findViewById(R.id.video)
        mVideoView!!.setVideoURI(
            Uri.parse("android.resource://"
                    + this.packageName +"/" + R.raw.honda_first_comes_rock))
        mVideoView!!.start()

        //　グーを押下した場合
        val gooBtn = findViewById<Button>(R.id.goo_button)
        gooBtn.setOnClickListener{
            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("MyHand","goo")
            startActivity(intent)
        }
        //　チョキを押下した場合
        val chiBtn = findViewById<Button>(R.id.chi_button)
        chiBtn.setOnClickListener{
            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("MyHand","chi")
            startActivity(intent)
        }
        //　パーを押下した場合
        val parBtn = findViewById<Button>(R.id.par_button)
        parBtn.setOnClickListener{
            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("MyHand","par")
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        mVideoView = null
    }
}
