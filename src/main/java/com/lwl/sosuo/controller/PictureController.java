package com.lwl.sosuo.controller;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import com.lwl.sosuo.annotation.AuthCheck;
import com.lwl.sosuo.common.BaseResponse;
import com.lwl.sosuo.common.DeleteRequest;
import com.lwl.sosuo.common.ErrorCode;
import com.lwl.sosuo.common.ResultUtils;
import com.lwl.sosuo.constant.UserConstant;
import com.lwl.sosuo.exception.BusinessException;
import com.lwl.sosuo.exception.ThrowUtils;
import com.lwl.sosuo.model.dto.picture.PictureQueryRequest;
import com.lwl.sosuo.model.dto.post.PostAddRequest;
import com.lwl.sosuo.model.dto.post.PostEditRequest;
import com.lwl.sosuo.model.dto.post.PostQueryRequest;
import com.lwl.sosuo.model.dto.post.PostUpdateRequest;
import com.lwl.sosuo.model.entity.Picture;
import com.lwl.sosuo.model.entity.Post;
import com.lwl.sosuo.model.entity.User;
import com.lwl.sosuo.model.vo.PostVO;
import com.lwl.sosuo.service.PictureService;
import com.lwl.sosuo.service.PostService;
import com.lwl.sosuo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 图片接口
 *
 */
@RestController
@RequestMapping("/picture")
@Slf4j
public class PictureController {

    @Resource
    private PostService postService;

    @Resource
    private PictureService pictureService;

    private final static Gson GSON = new Gson();

    /**
     * 分页获取列表（封装类）
     *
     * @param pictureQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page/vo")
    public BaseResponse<Page<Picture>> listPostVOByPage(@RequestBody PictureQueryRequest pictureQueryRequest,
                                                        HttpServletRequest request) {
        long current = pictureQueryRequest.getCurrent();
        long size = pictureQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        String searchText = pictureQueryRequest.getSearchText();
        Page<Picture> picturePage = pictureService.searchPicture(searchText, current, size);
        return ResultUtils.success(picturePage);
    }

}
