package com.lwl.sosuo.datasource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author user-lwl
 * @createDate 2024/3/25 16:23
 */
public class VideoDataSource implements DataSource<Object> {
    @Override
    public Page<Object> doSearch(String searchText, long pageNum, long pageSize) {
        return null;
    }
}
