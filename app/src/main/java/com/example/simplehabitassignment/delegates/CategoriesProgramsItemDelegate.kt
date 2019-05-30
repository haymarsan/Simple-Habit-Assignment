package com.example.simplehabitassignment.delegates


import com.example.simplehabitassignment.data.vos.ProgramsVO

interface CategoriesProgramsItemDelegate : BaseDelegate {

    fun onTapProgram(program: ProgramsVO)
}
