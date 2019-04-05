package com.example.simplehabitassignment.delegates;


import com.example.simplehabitassignment.data.vos.CategoriesAndProgramsVO;

import java.util.List;

public interface CategoriesAndProgramsResponseDelegate extends BaseDelegate {

    void onSuccess(List<CategoriesAndProgramsVO> categoriesProgramsList);

}
