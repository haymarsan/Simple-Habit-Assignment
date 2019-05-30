package com.example.simplehabitassignment.mvp.view

import com.example.simplehabitassignment.data.vos.CategoriesAndProgramsVO
import com.example.simplehabitassignment.data.vos.CurrentProgramVO
import com.example.simplehabitassignment.data.vos.TopicsVO

interface SimpleHabitHomeview : BaseView {

    fun showCurrentProgram(currentProgram: MutableList<CurrentProgramVO>)
    fun showCategoryList(categoriesAndPrograms: MutableList<CategoriesAndProgramsVO>)
    fun showTopicList(topicsList: MutableList<TopicsVO>)


}