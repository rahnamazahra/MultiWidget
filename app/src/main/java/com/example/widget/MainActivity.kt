package com.example.widget

import android.app.PendingIntent.getActivity
import android.content.DialogInterface
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.session.MediaController
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.net.toUri
import com.example.widget.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /********************************************/

            setSupportActionBar(binding.toolbar)
           /*supportActionBar!!.title = "Toolbar"*/
           supportActionBar!!.setDisplayShowTitleEnabled(false)
           supportActionBar!!.setDisplayHomeAsUpEnabled(true)
           supportActionBar!!.subtitle="This is subtitle Toolbar"
           supportActionBar!!.setLogo(R.drawable.ic_baseline_video_library_24)

        /********************************************/
        binding.ratingcomment.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            binding.ratingtxt.text = ratingBar.rating.toString()
        }
        /********************************************/
        binding.videoView.setVideoPath("https://www.rmp-streaming.com/media/big-buck-bunny-360p.mp4")
        binding.videoView.start()
        /***************************************************/
//        val myUri: String ="https://mp3wale.info/uploads/file/5c383ac337139.mp3"
//        val mediaPlayer = MediaPlayer().apply {
//            setAudioAttributes(
//                AudioAttributes.Builder()
//                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//                    .setUsage(AudioAttributes.USAGE_MEDIA)
//                    .build()
//            )
//            setDataSource(applicationContext, myUri.toUri())
//            prepare()
//            start()
//        }
        /**************************************************************/
        var alertBuilder: AlertDialog.Builder

        binding.btn.setOnClickListener {
            alertBuilder = AlertDialog.Builder(this)
            alertBuilder.setTitle("Alert!")
            alertBuilder.setMessage("Delete this item?")

          alertBuilder.setPositiveButton("Yes", DialogInterface.OnClickListener {
                    dialog, which ->
              val gopage = Intent(this, WebActivity::class.java)
              startActivity(gopage)

            })
            alertBuilder.setNegativeButton("No", DialogInterface.OnClickListener {
                    dialog, which ->


            })

            val alert: AlertDialog = alertBuilder.create()
            alert.show()



        }
/******************************************/
        binding.fab.setOnClickListener {
            Toast.makeText(this,"Floating Action Button clicked",Toast.LENGTH_LONG).show()
        }
    }
/********************************************************/
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }
/******************************************************/
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id=item.itemId
        if(id==R.id.about){
            Toast.makeText(this,"about clicked",Toast.LENGTH_LONG).show()
        }else if(id==R.id.setting){
            Toast.makeText(this,"about clicked",Toast.LENGTH_LONG).show()

        }
        return super.onOptionsItemSelected(item)
    }
}

