package com.example.simplehabitassignment.delegates;


import com.example.simplehabitassignment.data.vos.TopicsVO;

import java.util.List;

public interface TopicsResponseDelegate {


    void onSuccess(List<TopicsVO> topicsVOList);

    void  onFail(String errormessage);
}
