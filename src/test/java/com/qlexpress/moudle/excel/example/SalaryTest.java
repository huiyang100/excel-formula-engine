package com.qlexpress.moudle.excel.example;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.qlexpress.moudle.excel.operator.QLExpressExcelMoudle;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 本例模拟了一个动态薪资计算的场景
 * 用于展示如何定义表达式，方法，并使用上下文变量以及 excel公式
 *
 * @author： 程增辉
 * @since： 2019-06-19
 */

public class SalaryTest {

    @Test
    public void calculateTest() throws Exception {

        DefaultContext<String, Object> expressContext = new DefaultContext<String, Object>();
        ExpressRunner runner = new ExpressRunner(true, true);
        QLExpressExcelMoudle.registerModule(runner);

        expressContext.put("姓名", "程增辉");
        expressContext.put("姓名", "信息技术");
        expressContext.put("职位", "研发");
        expressContext.put("级别", "P1");
        expressContext.put("工号", "123456");
        expressContext.put("基本工资", new BigDecimal(10000));
        expressContext.put("岗位补贴", new BigDecimal(1000));
        expressContext.put("税前补差", new BigDecimal(100));
        expressContext.put("事假", 1);

        expressContext.put("病假", 2);

        expressContext.put("应出勤天数", 23);
        expressContext.put("月份", 7);


        Map<String, String> expressMap = new LinkedHashMap();
        expressMap.put("空调补助", "IF(OR(月份==6,月份==7),1200,0)");
        expressMap.put("绩效系数", "IF(AND(职位=='研发',级别=='P2'),1,0.8)");
        expressMap.put("绩效奖金", "IF(级别=='P1',5000*绩效系数,10000*绩效系数)");
        expressMap.put("事假扣除", "基本工资/应出勤天数*事假");
        expressMap.put("病假扣除", "基本工资/应出勤天数*病假*0.4");

        expressMap.put("应发工资", "ROUND(基本工资+岗位补贴+绩效奖金+税前补差-事假扣除+空调补助,2)");
        expressMap.entrySet().stream().forEach(en -> {
            try {
                Object value = runner.execute(en.getValue(), expressContext, null, false, false);
                System.out.println("薪资项:" + en.getKey() + ":==>" + value);
                expressContext.put(en.getKey(), value);
            } catch (Exception e) {
                e.printStackTrace();
            }


        });


    }

}
