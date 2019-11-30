package com.example.notepad.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.notepad.util.BaseInterface
import com.example.notepad.model.ModelNote
import com.example.notepad.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class SaveActivity : AppCompatActivity(), BaseInterface {

    private lateinit var mSaveButton: Button
    private lateinit var mToolbar: Toolbar
    private lateinit var mTextInputEditTextTitle: TextInputEditText
    private lateinit var mTextInputEditTextText: TextInputEditText

    override fun initUi() {

        mSaveButton = findViewById(R.id.button_Save)
        mToolbar = findViewById(R.id.Toolbar_save)
        mTextInputEditTextTitle = findViewById(R.id.TextInputEditText_save_title)
        mTextInputEditTextText = findViewById(R.id.TextInputEditText_save_text)
    }

    override fun initListen() {
        mSaveButton.setOnClickListener {
            checkEmpty()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)
        initUi()
        initListen()
        setToolbar()

    }

    private fun setToolbar() {
        mToolbar.title = "SaveNote"
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }


    private fun checkEmpty() {
        if (mTextInputEditTextText.text!!.isNotEmpty() && mTextInputEditTextTitle.text!!.isNotEmpty()) {
            val userNote =
                ModelNote(
                    mTextInputEditTextText.text.toString(),
                    mTextInputEditTextTitle.text.toString()
                )
            val returnIntent = Intent().apply { putExtra("result", userNote) }
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        } else {
            Toast.makeText(this, "noEmpty", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home ->{
            finish()
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}



