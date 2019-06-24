package com.qlexpress.moudle.excel.operator;

import com.ql.util.express.Operator;

import java.math.BigDecimal;

/**
 * if函数  https://support.office.com/zh-cn/article/IF-%E5%87%BD%E6%95%B0-69AED7C9-4E8A-4755-A9BC-AA8BBFF73BE2
 *
 * @author： 程增辉
 * @since： 2019-06-19
 */
public class IFOperator extends Operator {
    public Object executeInner(Object[] list) throws Exception {
        Boolean condition = (Boolean) list[0];

        if (condition) {
            return list[1];
        } else {

            if (list.length == 3) {
                return list[2];
            } else {

                return getDefaultValue(list[1]);
            }
        }

    }

    /****
     * 缺省值
     * @param o
     * @return
     */
    private Object getDefaultValue(Object o) {

        if (o instanceof Number) {
            return new BigDecimal(0);
        } else if (o.getClass().isInstance(java.lang.String.class)) {
            return "";
        }

        return null;
    }
}
