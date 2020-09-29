package com.bin.study.multhread.miaosha.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RecordsDAO {

    List<Map> GetUserbyId(@Param("id") Integer id);


    public Boolean insertRecords(String goods_code,String user_id);
}
