# AS-chapter2

java代码和xml文件分别在文件Java-homework和layout中，apk文件为homework-release.apk

实验简述：

Exercise1：
参考代码：课程代码SaveInstanceStateActivity

作业一的信息在lifecycle页面中分成两个ScrollView展示：

![](https://github.com/KWalkWorld/AS-chapter2/blob/master/1.png)

同时将生命周期的信息逐个存储在static String变量log中，将其设为id为lifeCycle的内容并在上方的ScrollView中展示出来。由于使用的是static变量，未点击重置LOG按钮前，log将一直保存所有的信息，故可以在上方看到所有的生命周期信息。

![](https://github.com/KWalkWorld/AS-chapter2/blob/master/2.png)

当然，旋转屏幕后，信息也可以看到：

![](https://github.com/KWalkWorld/AS-chapter2/blob/master/3.png)

Exercise2:用递归实现，代码如下：
public int getAllChildViewCount(View view) {
    int viewCount = 0;
    if (view == null) {
        return 0;
    }
    if (view instanceof ViewGroup){
        for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {View child = ((ViewGroup) view).getChildAt(i);
            if (child instanceof ViewGroup) {
                viewCount += getAllChildViewCount(((ViewGroup) view).getChildAt(i));
            }
            else {
                viewCount++;
            }
        }
    }
    else {
        viewCount++;
    }
    return viewCount;
}
    


Exercise3: 效果如下：

![](https://github.com/KWalkWorld/AS-chapter2/blob/master/4.png)

![](https://github.com/KWalkWorld/AS-chapter2/blob/master/5.png)
