package com.netease.nim.uikit.business.session.actions;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import com.netease.nim.uikit.R;
import com.netease.nim.uikit.business.session.constant.Extras;
import com.netease.nim.uikit.business.session.constant.RequestCode;
import com.netease.nim.uikit.common.media.picker.model.PhotoInfo;
import com.netease.nim.uikit.utils.CommonUtils;
import com.netease.nim.uikit.utils.ImageUtils;
import com.netease.nim.uikit.utils.URIUtils;
import com.zhihu.matisse.Matisse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinghe on 27/04/2018.
 */

public class FixImageAction extends PickImageAction {

    public FixImageAction() {
        super(R.drawable.nim_message_plus_photo_selector, R.string.input_panel_photo, true);
    }

    @Override
    protected boolean isFromCamera() {
        return false;
    }

    //GET_LOCAL_GALLERY
    @Override
    public void onClick() {
        int requestCode = makeRequestCode(RequestCode.GET_LOCAL_GALLERY);
        ImageUtils.chooseImagePhoto2(getActivity(),requestCode,9);
    }

    @Override
    protected void dealWidthLocalGallery(int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK && null != data) {
            List<Uri> mSelected = Matisse.obtainResult(data);
            if(CommonUtils.collectionExists(mSelected)) {
                parseUri2AbsolutePath(mSelected);
            }
        }
    }

    private void parseUri2AbsolutePath(List<Uri> uriList) {
        List<PhotoInfo> pathList = new ArrayList<>();
        PhotoInfo photoInfo ;
        for(Uri uri : uriList) {
            String path = URIUtils.getAbsolutePath(getActivity(),uri);
            if(!TextUtils.isEmpty(path)) {
                photoInfo = new PhotoInfo();
                photoInfo.setAbsolutePath(path);
                pathList.add(photoInfo);
            }
        }

        Intent intent = new Intent();
        intent.putExtra(Extras.EXTRA_PHOTO_LISTS,new ArrayList<>(pathList));
        sendImageAfterSelfImagePicker(intent);
    }
}
