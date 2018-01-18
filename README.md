
# 我的修改



基于 2.1.0 版本修改
[![](https://jitpack.io/v/yizeliang/EToast2.svg)](https://jitpack.io/#yizeliang/EToast2)
修改后版本号
3.0.0开始

### 3.0.1

修复编译失败

### 3.0.0

![效果图](http://t1.aixinxi.net/o_1c43ib9711593as31d6fgibnp3a.png)


- 修改Toast为ToastCompat
- 修改判断是否开启通知权方法为`NotificationManagerCompat.from(context).areNotificationsEnabled()`
- 需要加入`compile "com.android.support:appcompat-v7:26.+"` 版本为26以上


# 原仓库README
[![](https://jitpack.io/v/Blincheng/EToast2.svg)](https://jitpack.io/#Blincheng/EToast2)

V2.1.0 正式上线~（2017年7月31日）
自从v2.0.0上线后，马上就有蛮多的朋友从1.X的版本升级上来了，尤其是某几个特别棒的同学。
今天  [xiaogaofudao](https://github.com/xiaogaofudao)发现了一个关键性因素，促使了今天EToast2.1版本才能正式上线，再次对他在此表达我的谢意。

也为了大家方便沟通和使用，建立了一个QQ群供大家交流，欢迎大家的加入

群名称：EToast交流群

群   号：547279762


我们来说下v2.1.0解决的问题吧：
1. 小米note、魅族某些机器不显示Toast的问题
2. 当弹出Toast后，页面快速关闭后闪退的问题
3. 一些其他的细节优化
----------------------------------------------------

更新日志：

v2.1.1（2017年8月2日11:01:58）

1. 修复当EToast使用Application环境时闪退的问题（原因是去掉TYPE_TOAST这个类型，导致的异常）
    
-------------------------------------------------------

v2.0来啦~客观往下看！

EToast 一个关闭系统消息通知后依然可以显示的Toast，此版本完全是独立于v1.x.x的版本，实现方式上也是完全的不同，尽量的参考系统Toast的源码去实现。
和上代EToast相比，有以下的改动：
1. Context不再依赖于Activity显示。
2. 显示动画完全跟随着系统走，也就是说和系统的Toast动画效果完全一致
3. 多条显示规则还是保留了V1.x的版本的规则，永远只显示一个Toast。
4. 由于实现原理的更改，EToast不再会被Dialog、PopupWindow等弹窗布局覆盖


由于在Android5.0以下无法获取是否打开系统通知权限，所以为了防止用户看不到Toast，最终的逻辑优化了一下：
1. 当用户是5.0以下的机器时，永远只显示EToast
2. 当用户是5.0以上的机器是，如果打开了通知权限，则显示系统Toast；反之则显示Etoast

使用方法和Toast完全一致，如下：

Toast.makeText(MainActivity.this,"我是一个屏蔽通知我也是可以显示的Toast",Toast.LENGTH_SHORT).show();

具体使用如下：
Step 1. Add the JitPack repository to your build file


	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency


  	dependencies {
		compile 'com.github.Blincheng:EToast2:v2.1.1'
	}
  

  最后需要注意的是，此Toast非彼Toast，应该使用“import com.mic.etoast2.ToastCompat”，建议在BaseActivity中如下使用：
  
  
	public void showShortText(String text) {
		Toast.makeText(mActivity, text, Toast.LENGTH_SHORT).show();
	}
  
  博文地址：[【Android】当关闭通知消息权限后无法显示系统Toast的解决方案V2.0](http://blog.csdn.net/qq_25867141/article/details/74194503) ~
