package com.example.shardingspherejdbc.config;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

//分片字段数据类型是什么，这里泛型就写什么
@Configuration
public class UserShardingAlgorithm implements StandardShardingAlgorithm<Long> {

    //精确分片算法实现，collection是实际表，也就是配置文件里的actual-data-nodes内容
    //preciseShardingValue对象包括逻辑表名，分表算法的字段和字段值
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        //对分片字段也就是用户id取模
        String suffix = String.valueOf(preciseShardingValue.getValue() % 10);
        //遍历表名，找到符合要求的表，返回即可
        for (String tableName : collection) {
            if (tableName.endsWith(suffix)) {
                return tableName;
            }
        }
        throw new UnsupportedOperationException();
    }

    //范围分片，我们暂不支持
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
        throw new UnsupportedOperationException();
    }

    //初始化信息接口
    @Override
    public void init() {

    }

    //分片算法类型
    @Override
    public String getType() {
        return "USER_SHARDING";
    }
}
