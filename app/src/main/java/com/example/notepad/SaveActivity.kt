package com.example.notepad

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class SaveActivity : AppCompatActivity(), BaseInterface {

    private lateinit var mEditText: EditText
    private lateinit var mEditTile: EditText
    private lateinit var mRecordFab: FloatingActionButton

    override fun initUi() {
        mEditText = findViewById(R.id.Text)
        mEditTile = findViewById(R.id.Title)
        mRecordFab = findViewById(R.id.floatingActionButton_save)
    }

    override fun initListen() {
        mRecordFab.setOnClickListener {
            checkempty()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)
        initUi()
        initListen()

    }


    fun checkempty() {
        if (mEditText.text.isNotEmpty() && mEditTile.text.isNotEmpty()) {
            val userNote = ModelNote(mEditText.text.toString(), mEditTile.text.toString())
            val returnIntent = Intent().apply { putExtra("result", userNote) }
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        } else {
            Toast.makeText(this, "noEmpty", Toast.LENGTH_SHORT).show()
        }

    }
}



