package com.qlexpress.moudle.excel.operator;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.junit.Test;

/**
 * @author： 程增辉
 * @since： 2019-06-19
 * copyright：智联招聘-信息技术部
 */
public class IFOperatorTest {

    @Test
    public void testFunctionIf() throws Exception {
        DefaultContext<String, Object> expressContext = new DefaultContext<String, Object>();
        ExpressRunner runner = new ExpressRunner(false, true);
        runner.addFunction("IF", new IFOperator());

        String expresses = "IF(score ==100,'满分','不够优秀')";
        expressContext.put("score", 100);
        Object result = runner.execute(expresses, expressContext, null, false, true);

        System.out.println(result);
    }


    @Test
    public void testFunctionIf2() throws Exception {
        DefaultContext<String, Object> expressContext = new DefaultContext<String, Object>();
        ExpressRunner runner = new ExpressRunner(false, true);
        runner.addFunction("IF", new IFOperator());

        String expresses = "IF(score >=100,'满分',IF(score>=80,'优秀','不够优秀'))";
        expressContext.put("score", 80);
        Object result = runner.execute(expresses, expressContext, null, false, true);

        System.out.println(result);
    }


}