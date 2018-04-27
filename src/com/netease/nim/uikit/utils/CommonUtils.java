package com.netease.nim.uikit.utils;

import java.util.Collection;

/**
 * Created by xinghe on 27/04/2018.
 */

public class CommonUtils {

    //集合是否存在 & 是否为空
    public static boolean collectionExists(Collection<?> collection) {
        return null != collection && !collection.isEmpty();
    }
}
