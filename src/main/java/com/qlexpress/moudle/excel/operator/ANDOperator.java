package com.qlexpress.moudle.excel.operator;

import com.ql.util.express.Operator;

/**
 * and 函数 https://support.office.com/zh-cn/article/AND-%E5%87%BD%E6%95%B0-5F19B2E8-E1DF-4408-897A-CE285A19E9D9
 *
 * @author： 程增辉
 * @since： 2019-06-19
 */
public class ANDOperator extends Operator {
    public Object executeInner(Object[] list) throws Exception {
        for (Object o : list) {
            Boolean condition = (Boolean) o;
            if (!condition) {
                return false;
            }
        }

        return true;
    }
}
