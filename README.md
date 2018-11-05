Android 2048游戏，下载地址：http://120.79.60.89/download/My2048Game.apk

思路：
1. 写好布局，并定义id，主要是16个TextView。
2. 根据触屏开始到结束的横纵坐标差判断滑动方向。
3. 在包含16个TextView的View和滑动方向传入doMove()方法处理，在这个方法中，把所有TextView存入一个list，把所有TextView及其文本存入一个Map，再对不同的方向调用同一个执行运算的方法，参数顺序不同。
4. 在Map中运算完成后，数据转为字符串存入TextView，这样就可以显示出来了。
5. 要判断在一次滑动中是否发生了任何合并和移动，如果有，就随机在一个空白位置随机生成一个数，出现2的概率是0.9，出现4的概率是0.1。判断是否发生合并和移动，用的是一个static变量，在执行方法的内部自增。
6. 最后，为每一个TextView设置背景色。
7. 统计分数，用的也是一个static变量，在发生合成的地方累加，如果点击Restart按钮，就将其置零。

截图如下：
![ScreenShot](https://github.com/wsg777/Android-2048-game/raw/master/My2048Game.jpg)

