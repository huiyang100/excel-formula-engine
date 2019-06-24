package com.qlexpress.moudle.excel.operator;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.junit.Test;

/**
 * @author： 程增辉
 * @since： 2019-06-19
 * copyright：智联招聘-信息技术部
 */
public class ANDOperatorTest {


    @Test
    public void testFunctionAnd() throws Exception {
        DefaultContext<String, Object> expressContext = new DefaultContext<String, Object>();
        ExpressRunner runner = new ExpressRunner(false, true);
        runner.addFunction("AND", new ANDOperator());

        String expresses = "AND(score==100,age==20)";
        expressContext.put("score", 100);
        expressContext.put("age", 20);
        Object result = runner.execute(expresses, expressContext, null, false, true);

        System.out.println(result);
    }


    @Test
    public void testFunctionAnd2() throws Exception {
        DefaultContext<String, Object> expressContext = new DefaultContext<String, Object>();
        ExpressRunner runner = new ExpressRunner(false, true);
        runner.addFunction("AND", new ANDOperator());

        String expresses = "AND(score==100,AND(100>10))";
        expressContext.put("score", 100);
        expressContext.put("age", 20);
        Object result = runner.execute(expresses, expressContext, null, false, true);

        System.out.println(result);
    }


}