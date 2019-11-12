package com.example.notepad.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.annotation.SuppressLint
import androidx.appcompat.widget.Toolbar

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notepad.*
import com.example.notepad.model.ModelNote
import com.example.notepad.util.BaseInterface
import com.example.notepad.util.MyAdapter
import kotlinx.android.synthetic.main.activity_save.view.*


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity : AppCompatActivity(), BaseInterface {

    private lateinit var mAddFab: FloatingActionButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: MyAdapter
    private lateinit var mToolbar: Toolbar
    override fun initListen() {
        mAddFab.setOnClickListener {
            val i = Intent(this, SaveActivity::class.java)
            startActivityForResult(i, 1)

        }
    }

    override fun initUi() {
        mAddFab = findViewById(R.id.floatingActionButton_main)
        recyclerView = findViewById(R.id.RecyclerView_main)
        mToolbar = findViewById(R.id.Toolbar_main)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
        initListen()
        setupRecyclerView()
        setToolbar()
    }

    private fun setupRecyclerView() = with(recyclerView) {
        layoutManager = LinearLayoutManager(context)
        mAdapter = MyAdapter()
        adapter = mAdapter
    }

    private fun setToolbar() {
        mToolbar.title = "NotePad"
        setSupportActionBar(mToolbar)
    }


    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                var note = data!!.getParcelableExtra<ModelNote>("result")
                mAdapter.addItem(note)
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "NORESULT", Toast.LENGTH_SHORT).show()
            }
        }
    }//onActivityResult


}
//list1 = data!!.
//list1 = data!!.getParcelableArrayListExtra<ModelNote>("result")