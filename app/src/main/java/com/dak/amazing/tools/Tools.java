package com.dak.amazing.tools;

import java.util.List;

/**
 * 工具类
 * Created by runTop on 2017/9/12.
 */
public class Tools {
    public static <T> boolean isEmptyList(List<T> list) {
        return list == null || list.size() <= 0;
    }
}
