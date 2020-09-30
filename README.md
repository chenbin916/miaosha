# miaosha
模拟高并发商品秒杀:

1.junit单元测试，本地只能承受23个并发，有点不足之处：通过浏览器访问http://localhost:8886/miaosha?goods_code=bike&user_id=tommy，
   可以测试并发，通过junit测试类老是报连不上redis，折腾很久没搞定。
2.单元测试做了压力测试。
3.用redis set ex nx组合命令完成操作频繁控制
4.增加令牌池，对令牌进行抢占，达到秒杀商品。秒杀的商品是有限的。
