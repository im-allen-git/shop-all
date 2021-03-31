package com.akers.shoporder.util;

/**
 * @author: JiangXW
 * @version: v1.0
 * @description: 分页数据
 * @date:2021-03-31
 */
public enum PageEnum {

    TEN(10), FIFTEEN(15), TWENTY(20), FIFTY(50);

    private int size;

    public int getSize() {
        return size;
    }

    private PageEnum(int size) {
        this.size = size;
    }
}
