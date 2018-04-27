package com.netease.nim.uikit.business.session.actions;

import com.netease.nim.uikit.R;

import java.io.File;

/**
 * Created by xinghe on 27/04/2018.
 *
 * 拆分相机Action
 */

public class CameraAction extends PickImageAction {

    public CameraAction() {
        super(R.drawable.nim_message_plus_video_selector, R.string.input_panel_camera, false);
    }

}
