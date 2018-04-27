package com.netease.nim.uikit.utils;

import android.app.Activity;
import android.content.pm.ActivityInfo;

import com.netease.nim.uikit.R;
import com.netease.nim.uikit.support.glide.CustomGlideImageEngine;
import com.netease.nim.uikit.support.matisse.GifSizeFilter;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.filter.Filter;

/**
 * Created by xinghe on 27/04/2018.
 */

public class ImageUtils {

    public static void chooseImagePhoto2(Activity activity, int requestCode, int count) {
        Matisse.from(activity)
                .choose(MimeType.of(MimeType.JPEG, MimeType.PNG, MimeType.GIF))
                .countable(count > 1)
                .maxSelectable(count)
                .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                .gridExpectedSize(activity.getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .thumbnailScale(0.85f)
                .imageEngine(new CustomGlideImageEngine())
                .forResult(requestCode);
    }
}
