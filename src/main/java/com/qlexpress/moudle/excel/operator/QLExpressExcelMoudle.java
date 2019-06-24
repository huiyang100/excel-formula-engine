package com.qlexpress.moudle.excel.operator;

import com.ql.util.express.ExpressRunner;
import com.ql.util.express.instruction.op.OperatorRound;

/**
 * excel 函数模块注册器
 *
 * @author： 程增辉
 * @since： 2019-06-19
 */
public class QLExpressExcelMoudle {

    public static void registerModule(ExpressRunner runner) {

        runner.addFunction("IF", new IFOperator());
        runner.addFunction("AND", new ANDOperator());
        runner.addFunction("OR", new OROperator());
        runner.addFunction("ROUND", new OperatorRound("ROUND"));
    }
}
