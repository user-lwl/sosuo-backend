package com.lwl.sosuo.controller;

import com.lwl.sosuo.common.BaseResponse;
import com.lwl.sosuo.common.ResultUtils;
import com.lwl.sosuo.manager.SearchFacade;
import com.lwl.sosuo.model.search.SearchRequest;
import com.lwl.sosuo.model.vo.SearchVO;
import com.lwl.sosuo.service.PictureService;
import com.lwl.sosuo.service.PostService;
import com.lwl.sosuo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 聚合搜索接口
 *
 */
@RestController
@RequestMapping("/search")
@Slf4j
public class SearchController {

    @Resource
    private PictureService pictureService;

    @Resource
    private PostService postService;

    @Resource
    private UserService userService;

    @Resource
    private SearchFacade searchFacade;

    /**
     * 分页获取列表（封装类）
     *
     * @param searchRequest
     * @return
     */
    @PostMapping("/all")
    public BaseResponse<SearchVO> searchAll(@RequestBody SearchRequest searchRequest, HttpServletRequest request) {
        return ResultUtils.success(searchFacade.searchAll(searchRequest, request));
    }

}
