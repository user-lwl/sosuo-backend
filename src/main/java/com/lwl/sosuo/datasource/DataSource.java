package com.lwl.sosuo.datasource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 数据源接口（新接入的数据源必须实现）
 * @author user-lwl
 * @createDate 2024/3/25 15:45
 */
public interface DataSource<T> {

    /**
     * 搜索
     * @param searchText
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<T> doSearch(String searchText, long pageNum, long pageSize);
}
