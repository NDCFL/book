package com.cfl.vo;

import java.io.Serializable;

public class MinAndMaxIdVo implements Serializable {
    private Long minId;//最小Id
    private Long maxId;//最大Id

    public Long getMinId() {
        return minId;
    }

    public void setMinId(Long minId) {
        this.minId = minId;
    }

    public Long getMaxId() {
        return maxId;
    }

    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }
}
