package com.lwl.sosuo.datasource;

import com.lwl.sosuo.model.enums.SearchTypeEnum;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author user-lwl
 * @createDate 2024/3/25 16:46
 */
@Component
public class DataSourceRegistry {


    @Resource
    private PostDataSource postDataSource;

    @Resource
    private UserDataSource userDataSource;

    @Resource
    private PictureDataSource pictureDataSource;

    private Map<String, DataSource<?>> typeDataSourceMap;

    @PostConstruct
    public void doInit() {
        typeDataSourceMap = new HashMap<>();
        typeDataSourceMap.put(SearchTypeEnum.POST.getValue(), postDataSource);
        typeDataSourceMap.put(SearchTypeEnum.USER.getValue(), userDataSource);
        typeDataSourceMap.put(SearchTypeEnum.PICTURE.getValue(), pictureDataSource);
    }

    public DataSource<?> getDataSourceByType(String type) {
        if (typeDataSourceMap == null) {
            return null;
        }
        return typeDataSourceMap.get(type);
    }
}
