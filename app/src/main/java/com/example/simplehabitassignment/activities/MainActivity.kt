package com.example.simplehabitassignment.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


import com.example.simplehabitassignment.R
import com.example.simplehabitassignment.adapters.CategoriesProgramsAdapter
import com.example.simplehabitassignment.adapters.TopicsAdapter
import com.example.simplehabitassignment.data.vos.CategoriesAndProgramsVO
import com.example.simplehabitassignment.data.vos.CurrentProgramVO
import com.example.simplehabitassignment.data.vos.ProgramsVO
import com.example.simplehabitassignment.data.vos.TopicsVO
import com.example.simplehabitassignment.data.vos.models.CategoriesAndProgramsModel
import com.example.simplehabitassignment.data.vos.models.CategoriesAndProgramsModelImpl
import com.example.simplehabitassignment.data.vos.models.CurrentProgramModel
import com.example.simplehabitassignment.data.vos.models.CurrentProgramModelImpl
import com.example.simplehabitassignment.data.vos.models.TopicsModel
import com.example.simplehabitassignment.data.vos.models.TopicsModelImpl
import com.example.simplehabitassignment.delegates.CategoriesProgramsItemDelegate
import com.example.simplehabitassignment.mvp.view.SimpleHabitHomeview
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CategoriesProgramsItemDelegate, SimpleHabitHomeview {


    override fun showCurrentProgram(currentProgram: MutableList<CurrentProgramVO>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCategoryList(categoriesAndPrograms: MutableList<CategoriesAndProgramsVO>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showTopicList(topicsList: MutableList<TopicsVO>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    lateinit var categoriesProgramsAdapter: CategoriesProgramsAdapter
    private var topicsAdapter: TopicsAdapter? = null


    init {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        CurrentProgramModelImpl.getObjInstance().getCurrentProgram("b002c7e1a528b7cb460933fc2875e916", 1, object : CurrentProgramModel.CurrentProgramDelegate {
            override fun onSuccess(currentProgram: CurrentProgramVO) {

                tvPeriod!!.text = currentProgram.averageLengths!![0].toString() + " mins"
                tvTitle!!.text = currentProgram.title
                btnDay!!.text = " " + currentProgram.currentPeriod
                btnDay!!.setOnClickListener {
                    val intent = Intent(this@MainActivity, CurrentProgramDetailsActivity::class.java)
                    startActivity(intent)
                }


            }

            override fun onFail(errorMessage: String) {

            }
        })

        CategoriesAndProgramsModelImpl.getObjInstance().getCategoriesAndPrograms("b002c7e1a528b7cb460933fc2875e916", 1, object : CategoriesAndProgramsModel.CategoriesAndProgramsDelegate {
            override fun onSuccess(categoriesProgramsList: List<CategoriesAndProgramsVO>) {

                categoriesProgramsAdapter!!.setNewData(categoriesProgramsList)

            }

            override fun onFail(errorMessage: String) {

            }
        })

        // recycler view for CategoriesPrograms
        categoriesProgramsAdapter = CategoriesProgramsAdapter(this)
        rvCategoriesPrograms!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rvCategoriesPrograms!!.adapter = categoriesProgramsAdapter


        // Call Topics API
        TopicsModelImpl.getObjInstance().getTopics("b002c7e1a528b7cb460933fc2875e916", 1, object : TopicsModel.TopicsDelegate {
            override fun onSuccess(topicsList: List<TopicsVO>) {
                topicsAdapter!!.setNewData(topicsList)
            }

            override fun onFail(errorMessage: String) {

            }
        })


        // recycler view for Topics
        rvTopics = findViewById(R.id.rv_topics)
        topicsAdapter = TopicsAdapter()
        rvTopics!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rvTopics!!.adapter = topicsAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onTapProgram(program: ProgramsVO) {

        val intent = Intent(this@MainActivity, ProgramDetailActivity::class.java)
        intent.putExtra("id", program.programId)
        startActivity(intent)

    }

    override fun onFail(errorMessage: String) {
        Log.d("Login", "fail")
    }

    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
