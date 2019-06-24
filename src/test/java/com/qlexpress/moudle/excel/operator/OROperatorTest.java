package com.qlexpress.moudle.excel.operator;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.junit.Test;

/**
 * @author： 程增辉
 * @since： 2019-06-19
 * copyright：智联招聘-信息技术部
 */
public class OROperatorTest {
    @Test
    public void testFunctionOR() throws Exception {
        DefaultContext<String, Object> expressContext = new DefaultContext<String, Object>();
        ExpressRunner runner = new ExpressRunner(false, true);
        runner.addFunction("OR", new OROperator());

        String expresses = "OR(score==100,age==20)";
        expressContext.put("score", 80);
        expressContext.put("age", 21);
        Object result = runner.execute(expresses, expressContext, null, false, true);

        System.out.println(result);
    }


    @Test
    public void testFunctionOR2() throws Exception {
        DefaultContext<String, Object> expressContext = new DefaultContext<String, Object>();
        ExpressRunner runner = new ExpressRunner(false, true);
        runner.addFunction("OR", new OROperator());

        String expresses = "OR(score==100,age==20,OR(100>1))";
        expressContext.put("score", 80);
        expressContext.put("age", 21);
        Object result = runner.execute(expresses, expressContext, null, false, true);

        System.out.println(result);
    }
}