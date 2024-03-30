package com.lwl.sosuo.datasource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lwl.sosuo.model.dto.user.UserQueryRequest;
import com.lwl.sosuo.model.vo.UserVO;
import com.lwl.sosuo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户服务实现
 * @author user-lwl
 * @createDate 2024/3/21 22:57
 */
@Service
@Slf4j
public class UserDataSource implements DataSource<UserVO> {

    @Resource
    private UserService userService;

    /**
     * 搜索用户
     * @param searchText
     * @return
     */
    @Override
    public Page<UserVO> doSearch(String searchText, long pageNum, long pageSize) {
        UserQueryRequest userQueryRequest = new UserQueryRequest();
        userQueryRequest.setUserName(searchText);
        userQueryRequest.setCurrent(pageNum);
        userQueryRequest.setPageSize(pageSize);
        return userService.listUserVoByPage(userQueryRequest);
    }
}
