package com.yk.silence.customcamera

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_album.setOnClickListener {
            CameraUtil.openAlbum(this, REQUEST_CODE_OPEN_PHOTO_ALBUM)
        }
        btn_take_photo.setOnClickListener {
            CameraUtil.takePhoto(this, REQUEST_CODE_TAKE_PHOTO)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        CameraUtil.onActivityResult(
            this,
            requestCode,
            resultCode,
            data,
            object : CameraUtil.OnCameraResultListener {
                override fun onAlbumResult(path: String) {
                    Log.e("TAG", path)
                }

                override fun onCameraResult(uri: Uri) {
                    Log.e("TAG", uri.toString())
                }
            })
    }


}
