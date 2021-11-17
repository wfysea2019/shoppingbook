package cn.edu.jxnu.service.impl;

import cn.edu.jxnu.dao.ProductTypeDAO;
import cn.edu.jxnu.dao.impl.ImplProductTypeDAO;
import cn.edu.jxnu.domain.ProductTypeDomain;
import cn.edu.jxnu.service.ProductTypeService;
import cn.edu.jxnu.util.JedisPoolUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ImplProductTypeService implements ProductTypeService {
    private ProductTypeDAO productTypeDAO=new ImplProductTypeDAO();
    @Override
    public List<ProductTypeDomain> queryProductType() {
        return productTypeDAO.queryProductType();
    }

    @Override
    public List<ProductTypeDomain> queryProductTypeFromRedis() {
        List<ProductTypeDomain> list=null;
        //从redis中获取数据
        Jedis jedis= JedisPoolUtils.getJedis();
        String typeJson=jedis.get("productTypeJson");
        ObjectMapper objectMapper=new ObjectMapper();

        if (typeJson==null || typeJson.trim().length()==0){
            //从数据库读取
            List<ProductTypeDomain> typeDomainList=queryProductType();
            //转json

            try {
                typeJson=objectMapper.writeValueAsString(typeDomainList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("productTypeJson",typeJson);
            jedis.close();

        }else
        {
            System.out.println("redis");
        }
        try {
            list=objectMapper.readValue(typeJson, new TypeReference<List<ProductTypeDomain>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return list;
    }
}
