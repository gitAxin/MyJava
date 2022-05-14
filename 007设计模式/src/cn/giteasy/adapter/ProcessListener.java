package cn.giteasy.adapter;

/**
 * Demo class
 *
 * @author axin
 * @date 2022/5/14
 */
public interface ProcessListener {
    /**
     * 创建前
     */
    void beforeCreate();

    /**
     * 创建后
     */
    void afterCreate();

    /**
     * 保存前
     */
    void beforeSave();

    /**
     * 保存后
     */
    void afterSave();

    /**
     * 完成前
     */
    void beforeComplete();

    /**
     * 完成后
     */
    void afterComplete();

}
