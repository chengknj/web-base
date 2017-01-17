package com.ck.web.dal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础DO
 * Created by ChengK on 2017/1/6 0006.
 */
@Getter
@Setter
@ToString
public class BaseDo implements Serializable {

    /**
     * 数据库主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 最后更新人
     */
    private String updatedBy;

}
