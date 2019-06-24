package com.qlexpress.moudle.excel.operator;

import com.ql.util.express.Operator;

/**
 * or 函数 https://support.office.com/zh-cn/article/OR-%E5%87%BD%E6%95%B0-7d17ad14-8700-4281-b308-00b131e22af0
 *
 * @author： 程增辉
 * @since： 2019-06-19
 */
public class OROperator extends Operator {

    public Object executeInner(Object[] list) throws Exception {

        for (Object o : list) {
            Boolean condition = (Boolean) o;
            if (condition) {
                return true;
            }
        }

        return false;
    }
}
