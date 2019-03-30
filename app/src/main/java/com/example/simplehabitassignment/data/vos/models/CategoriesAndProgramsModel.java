package com.example.simplehabitassignment.data.vos.models;



import com.example.simplehabitassignment.data.vos.CategoriesAndProgramsVO;

import java.util.List;

public interface CategoriesAndProgramsModel {



    void getCategoriesAndPrograms(String accessToken, int page, CategoriesAndProgramsDelegate delegate);

    interface  CategoriesAndProgramsDelegate
     {
         void onSuccess(List<CategoriesAndProgramsVO> categoriesProgramsList);

         void onFail(String errorMessage);



     }
}
