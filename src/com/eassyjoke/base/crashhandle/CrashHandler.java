package com.eassyjoke.base.crashhandle;

import java.lang.Thread.UncaughtExceptionHandler;

import android.content.Context;
import android.util.Log;

public class CrashHandler implements Thread.UncaughtExceptionHandler {

	private static final String TAG = "CrashHandler";
	private static CrashHandler mCrashHandler;

	private CrashHandler() {
	}

	// 使用单例模式，一个对象处理全局的未捕捉崩溃信息
	public synchronized static CrashHandler getInstance() {
		if (mCrashHandler == null) {
			mCrashHandler = new CrashHandler();

		}
		return mCrashHandler;
	}

	private UncaughtExceptionHandler mDefaultHandler;
	// 用以获取手机的信息
	private Context mContext;

	public void init(Context context) {
		mContext = context;
		mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(this);

	}

	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		Log.e(TAG, "发生了异常");
		// 在此处保存手机崩溃的信息，如手机型号、软件版本信息，异常堆栈打印信息等
		// 可以将这些信息保存在手机程序的crash目录下面，然后等到应用再次启动
		// 将错误信息上传服务器

		// 最后调用系统默认的处理方法，一般会退出程序，打印堆栈信息
		mDefaultHandler.uncaughtException(thread, ex);
	}

}
