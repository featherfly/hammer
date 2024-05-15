
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-16 00:41:16
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.entity;

/**
 * EntityFeatures.
 *
 * @author zhongj
 */
public interface EntitySupports {

    void insert();

    void update();

    void merge();

    void updateFetch();

    void upsert();

    void get();

    void delete();
}
