package com.qlexpress.moudle.excel.operator;

import com.ql.util.express.Operator;

import java.math.BigDecimal;

/**
 * IF 函数简化版本只有两个参数
 *
 * @author： 程增辉
 * @since： 2019-06-19
 */
public class SimpleIFOperator extends Operator {

    public Object executeInner(Object[] list) throws Exception {
        Boolean condition = (Boolean) list[0];

        if (condition) {
            return list[1];
        } else {
            Object result = list[1];
            if (result.getClass().isInstance(java.lang.Number.class)) {

                return new BigDecimal(0);
            } else {
                return null;
            }
        }

    }
}
