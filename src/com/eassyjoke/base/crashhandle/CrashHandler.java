package com.eassyjoke.base.crashhandle;

import java.lang.Thread.UncaughtExceptionHandler;

import android.content.Context;
import android.util.Log;

public class CrashHandler implements Thread.UncaughtExceptionHandler {

	private static final String TAG = "CrashHandler";
	private static CrashHandler mCrashHandler;

	private CrashHandler() {
	}

	// ʹ�õ���ģʽ��һ��������ȫ�ֵ�δ��׽������Ϣ
	public synchronized static CrashHandler getInstance() {
		if (mCrashHandler == null) {
			mCrashHandler = new CrashHandler();

		}
		return mCrashHandler;
	}

	private UncaughtExceptionHandler mDefaultHandler;
	// ���Ի�ȡ�ֻ�����Ϣ
	private Context mContext;

	public void init(Context context) {
		mContext = context;
		mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(this);

	}

	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		Log.e(TAG, "�������쳣");
		// �ڴ˴������ֻ���������Ϣ�����ֻ��ͺš�����汾��Ϣ���쳣��ջ��ӡ��Ϣ��
		// ���Խ���Щ��Ϣ�������ֻ������crashĿ¼���棬Ȼ��ȵ�Ӧ���ٴ�����
		// ��������Ϣ�ϴ�������

		// ������ϵͳĬ�ϵĴ�������һ����˳����򣬴�ӡ��ջ��Ϣ
		mDefaultHandler.uncaughtException(thread, ex);
	}

}
