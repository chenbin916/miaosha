package com.bin.study.multhread.miaosha.service;

import java.util.List;
import java.util.Map;

import com.bin.study.multhread.miaosha.dao.RecordsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Service;
import com.bin.study.multhread.miaosha.dao.MiaoshaDAO;
import org.springframework.data.redis.core.StringRedisTemplate;
import javax.annotation.PostConstruct;

@Service
public class MiaoshaService {
    @Autowired
    MiaoshaDAO miaoshaDAO;

    @Autowired
    RecordsDAO recordsDAO;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


@PostConstruct
    public void init(){
      System.out.println("初始化完毕！");
    }

    public List<Map> test(Integer id) {
        return recordsDAO.GetUserbyId(id);
    }


    public Boolean miaosha(String goods_code,String user_id)
    {

       boolean operaFre= stringRedisTemplate.execute(new RedisCallback<Boolean>() {

           @Override
           public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
               Boolean res=redisConnection.set(user_id.getBytes(), "chen".getBytes(),Expiration.milliseconds(10000L), RedisStringCommands.SetOption.SET_IF_ABSENT);
               return res;
           }
       });

       if(!operaFre) {
           System.out.println("你操作台频繁了");
           return false;
       }
    boolean result = miaoshaDAO.updateMiaosha(goods_code);
    if(!result) return false;

    boolean result2 = recordsDAO.insertRecords(goods_code,user_id);
    if(!result2) return false;

    return true;
    }

}