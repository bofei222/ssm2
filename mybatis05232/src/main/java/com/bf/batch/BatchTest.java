package com.bf.batch;

/**
 * @description:
 * @author: bofei
 * @date: 2019-11-01 08:51
 **/
public class BatchTest {
    public static void main(String[] args) {
        /*try(SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH)) {
            SimpleTableMapper mapper = session.getMapper(SimpleTableMapper.class);
            List<SimpleTableRecord> records = getRecordsToInsert(); // not shown

            BatchInsert<SimpleTableRecord> batchInsert = insert(records)
                    .into(simpleTable)
                    .map(id).toProperty("id")
                    .map(firstName).toProperty("firstName")
                    .map(lastName).toProperty("lastName")
                    .map(birthDate).toProperty("birthDate")
                    .map(employed).toProperty("employed")
                    .map(occupation).toProperty("occupation")
                    .build()
                    .render(RenderingStrategies.MYBATIS3);

            batchInsert.insertStatements().stream().forEach(mapper::insert);

            session.commit();*/
    }
}
