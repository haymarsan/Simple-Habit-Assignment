package com.example.simplehabitassignment.delegates;


import com.example.simplehabitassignment.data.vos.CategoriesAndProgramsVO;

import java.util.List;

public interface CategoriesAndProgramsResponseDelegate {

    void onSuccess(List<CategoriesAndProgramsVO> categoriesProgramsList);
    void onFail(String errorMessage);
}
