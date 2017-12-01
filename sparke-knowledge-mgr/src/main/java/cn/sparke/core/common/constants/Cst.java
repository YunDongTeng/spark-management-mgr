package cn.sparke.core.common.constants;

/**
 * 一些服务的快捷获取
 *
 * @author spark
 * @date 2017-03-30 15:58
 */
public class Cst {

    private Cst() {
    }

    private static Cst cst = new Cst();

    public static Cst me() {
        return cst;
    }

}
