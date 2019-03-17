package com.eassyjoke.base.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

class AlertController {
	private AlertDialog mAlertDialog;
	private Window mWindow;
	private DialogViewHelper mViewHelper;

	public AlertController(Context context, AlertDialog alertDialog,
			Window window) {
		this.mAlertDialog = alertDialog;
		this.mWindow = window;
	}

	public AlertDialog getDialog() {
		return mAlertDialog;
	}

	public Window getWindow() {
		return mWindow;
	}

	public View getView(int viewId) {
		return getDialogViewHelper().getView(viewId);
	}

	private void setViewHelper(DialogViewHelper viewHelper) {
		mViewHelper = viewHelper;
	}

	public void setText(int viewId, CharSequence text) {
		getDialogViewHelper().setText(viewId, text);
	}

	public DialogViewHelper getDialogViewHelper() {
		return mViewHelper;
	}

	public void setClickListener(int viewId, OnClickListener l) {
		getDialogViewHelper().setClickListener(viewId, l);
	}

	static class AlertParams {
		public Context mContext;
		public boolean mCancelable = true;
		public DialogInterface.OnCancelListener mOnCancelListener;
		public DialogInterface.OnDismissListener mOnDismissListener;
		public DialogInterface.OnKeyListener mOnKeyListener;
		public int mLayoutId;
		public View mLayoutView;

		public boolean mFull;
		public boolean mFromBottom;

		public SparseArray<CharSequence> mTextMap = new SparseArray<CharSequence>();
		public SparseArray<View.OnClickListener> mListenerMap = new SparseArray<View.OnClickListener>();
		public int mAnimation;

		public AlertParams(Context context) {
			mContext = context;
			mCancelable = true;
			mFull = false;
			mFromBottom = false;
		}

		public void apply(AlertController dialog) {
			DialogViewHelper viewHelper = null;
			// 设置布局
			if (mLayoutId != 0) {
				viewHelper = new DialogViewHelper(mContext, mLayoutId);
			}
			if (mLayoutView != null && viewHelper == null) {
				viewHelper = new DialogViewHelper(mContext, mLayoutView);
			}
			if (viewHelper == null) {
				throw new RuntimeException("must use setContentView()");
			}
			// 将辅助类对象传递给成员变量
			dialog.setViewHelper(viewHelper);
			// 给Dialog设置布局
			dialog.getDialog().setContentView(viewHelper.getContentView());

			// 设置文字
			for (int i = 0; i < mTextMap.size(); i++) {
				viewHelper.setText(mTextMap.keyAt(i), mTextMap.valueAt(i));
			}

			// 设置点击事件
			for (int i = 0; i < mListenerMap.size(); i++) {
				viewHelper.setClickListener(mListenerMap.keyAt(i),
						mListenerMap.valueAt(i));
			}

			// 设置window的一些属性
			Window window = dialog.getWindow();
			LayoutParams layoutParams = window.getAttributes();
			if (mFull) {
				layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
			}
			if (mFromBottom) {
				window.setGravity(Gravity.BOTTOM);
			}
			if (mAnimation != 0) {
				window.setWindowAnimations(mAnimation);
			}
		}
	}

}
