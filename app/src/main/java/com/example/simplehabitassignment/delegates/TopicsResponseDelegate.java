package com.example.simplehabitassignment.delegates;


import com.example.simplehabitassignment.data.vos.TopicsVO;

import java.util.List;

public interface TopicsResponseDelegate extends BaseDelegate{


    void onSuccess(List<TopicsVO> topicsVOList);

}
