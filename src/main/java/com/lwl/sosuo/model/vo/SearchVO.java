package com.lwl.sosuo.model.vo;

import com.lwl.sosuo.model.entity.Picture;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 查询视图
 *
 */
@Data
public class SearchVO implements Serializable {

    private List<UserVO> userVOList;

    private List<PostVO> postVOList;

    private List<Picture> pictureList;

    private List<?> dataList;

    private static final long serialVersionUID = 1L;
}
