package com.example.simplehabitassignment.activities

import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewTreeObserver
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.example.simplehabitassignment.R
import com.example.simplehabitassignment.adapters.SessionsAdapter
import com.example.simplehabitassignment.data.vos.CurrentProgramVO
import com.example.simplehabitassignment.data.vos.models.CurrentProgramModelImpl

class CurrentProgramDetailsActivity : BaseActivity() {

    private var recyclerView: RecyclerView? = null
    private var toolbar: Toolbar? = null
    private var collapsingToolbarLayout: CollapsingToolbarLayout? = null
    private val ivBackground: ImageView? = null
    private val ivLecturer: ImageView? = null
    private var tvDescription: TextView? = null
    private var tvReadMore: TextView? = null
    private val tvLecturerName: TextView? = null
    private var expandable = true
    private var mcurrentProgramVO: CurrentProgramVO? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false) // hide the toolbar

        supportActionBar!!.setDisplayHomeAsUpEnabled(true) // for back arrow
        supportActionBar!!.setDisplayShowHomeEnabled(true) // for back arrow

        mcurrentProgramVO = CurrentProgramModelImpl.getObjInstance().mcurrentProgramVO

        collapsingToolbarLayout = findViewById(R.id.collapsingToolBar)
        collapsingToolbarLayout!!.title = mcurrentProgramVO!!.title


        recyclerView = findViewById(R.id.rv_sessions)
        val sessionsAdapter = SessionsAdapter()
        recyclerView!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.adapter = sessionsAdapter
        sessionsAdapter.setNewData(mcurrentProgramVO!!.sessionsList)

        tvDescription = findViewById(R.id.tv_description)
        tvDescription!!.text = mcurrentProgramVO!!.description
        tvReadMore = findViewById(R.id.tv_read_more)

        tvDescription!!.viewTreeObserver.addOnGlobalLayoutListener {
            if (expandable) {
                expandable = false
                if (tvDescription!!.lineCount > 3) {
                    tvReadMore!!.visibility = View.VISIBLE
                    val animator = ObjectAnimator.ofInt(tvDescription, "maxLines", 3)
                    animator.setDuration(0).start()

                }

            }
        }


        tvReadMore!!.setOnClickListener { Toast.makeText(applicationContext, "Readmore", Toast.LENGTH_SHORT).show() }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
