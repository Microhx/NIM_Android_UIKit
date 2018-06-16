# 网易云信 UI 组件 · Android [已知bug修复版]

## 主要修复的bug有

### 1.android.os.TransactionTooLargeException

更换了原始的图片选择方案，使用了[知乎图片选择容器](https://github.com/zhihu/Matisse),直接避免了以上的bug<br/>

|分离图片|选择图片|发送图片
|-|-|-|
|<img src="https://raw.githubusercontent.com/Microhx/NIM_Android_UIKit/master/images/01.png" />|<img src="https://raw.githubusercontent.com/Microhx/NIM_Android_UIKit/master/images/02.png"/>|<img src="https://raw.githubusercontent.com/Microhx/NIM_Android_UIKit/master/images/03.png" />|

更换了原始的图片选择方案，使用了[知乎图片选择容器](https://github.com/zhihu/Matisse),直接避免了以上的bug
    ![](.images/01.png) ![](.images/02.png) ![](.images/03.png)


### 2.android.system.ErrnoException
这是来自nim-sdk4.7之前的bug，请及时更换到sdk版本5.0之上，主要更换的是nim-basesdk-5.0.0.jar,nim-chatroom-5.0.0.jar,
min-lucene-5.0.0.jar三个版本；如果没有接入视频组件，请不要加入nim-avchat-5.0.0.jar，否则也会出现[问题3]


### 3.java.lang.NoClassfoundError:com.netease.nrtc.engine.rawapi.IRTcEnglie
这是你没有接入视频组件，但是在lib中加入了nim-avchat-5.0.0.jar这个版本，导致了引擎找不到造成了直接报错


