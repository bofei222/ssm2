package com.bf.v1;

/**
 * 数据库会话
 * 所有与RDBMS的有关操作都在这
 */
public class BFSqlSessionV1 {
    private BFConfigurationV1 configuration;
    private BFExecutorV1 executor;

    public BFSqlSessionV1(BFConfigurationV1 configuration, BFExecutorV1 executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T selectOne(String sql, String arg) {
        return executor.query(sql, arg);
    }

    public <T> T getMapper(Class<T> clazz) {
        return configuration.getMapper(clazz);
    }

}
