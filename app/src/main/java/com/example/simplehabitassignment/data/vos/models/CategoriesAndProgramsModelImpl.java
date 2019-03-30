package com.example.simplehabitassignment.data.vos.models;


import com.example.simplehabitassignment.data.vos.CategoriesAndProgramsVO;
import com.example.simplehabitassignment.data.vos.ProgramsVO;
import com.example.simplehabitassignment.delegates.CategoriesAndProgramsResponseDelegate;
import com.example.simplehabitassignment.network.DataAgent;
import com.example.simplehabitassignment.network.RetrofitDA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriesAndProgramsModelImpl implements CategoriesAndProgramsModel {

    private static CategoriesAndProgramsModelImpl objInstance;
    private DataAgent dataAgent;
    private Map<String, ProgramsVO> programsMap;

    private CategoriesAndProgramsModelImpl() {
        dataAgent = RetrofitDA.getObjInstance();
        programsMap = new HashMap<>();
    }

    public static CategoriesAndProgramsModelImpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new CategoriesAndProgramsModelImpl();
        }
        return objInstance;
    }

    @Override
    public void getCategoriesAndPrograms(String accessToken, int page, final CategoriesAndProgramsDelegate delegate) {

        dataAgent.getCategoriesAndPrograms(accessToken, page, new CategoriesAndProgramsResponseDelegate() {
            @Override
            public void onSuccess(List<CategoriesAndProgramsVO> categoriesProgramsList) {
                setProgramsMap(categoriesProgramsList);
                delegate.onSuccess(categoriesProgramsList);
            }

            @Override
            public void onFail(String errorMessage) {

                delegate.onFail(errorMessage);

            }
        });


    }

    private void setProgramsMap(List<CategoriesAndProgramsVO> categoriesProgramsList) {


        for (CategoriesAndProgramsVO c : categoriesProgramsList) {

            for (ProgramsVO p : c.getProgramsList()) {

                programsMap.put(p.getProgramId(), p);


            }
        }


    }


    public ProgramsVO getProgramById(String programId) {
        return programsMap.get(programId);
    }

}
