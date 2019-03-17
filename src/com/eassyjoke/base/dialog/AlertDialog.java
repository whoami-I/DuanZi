package com.eassyjoke.base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;

import com.example.duanzi.R;

public class AlertDialog extends Dialog {

	private AlertController mAlert;

	// protected AlertDialog(Context context) {
	// super(context, 0);
	// // mWindow.alwaysReadCloseOnTouchAttr();
	// mAlert = new AlertController(getContext(), this, getWindow());
	//
	// }

	public View getView(int viewId) {
		return getAlertController().getView(viewId);
	}

	public void setText(int viewId, CharSequence text) {
		getAlertController().setText(viewId, text);
	}

	public void setClickListener(int viewId, View.OnClickListener l) {
		getAlertController().setClickListener(viewId, l);
	}

	private AlertController getAlertController() {
		return mAlert;
	}

	protected AlertDialog(Context context, int theme) {
		super(context, theme);
		mAlert = new AlertController(getContext(), this, getWindow());
	}

	public static class Builder {
		// private Context mContext;
		private final AlertController.AlertParams P;
		private int mTheme;

		public Builder(Context context) {
			this(context, R.style.DialogStyle);
		}

		public Builder(Context context, int theme) {
			P = new AlertController.AlertParams(new ContextThemeWrapper(
					context, theme));
			mTheme = theme;

		}

		public Context getContext() {
			return P.mContext;
		}

		public Builder setText(int viewId, CharSequence text) {
			P.mTextMap.put(viewId, text);
			return this;
		}

		public Builder setClickListener(int viewId, View.OnClickListener l) {
			P.mListenerMap.put(viewId, l);
			return this;
		}

		public Builder setContentView(int layoutId) {
			P.mLayoutId = layoutId;
			return this;
		}

		public Builder setContentView(View v) {
			P.mLayoutView = v;
			return this;
		}

		public Builder full(boolean full) {
			P.mFull = full;
			return this;
		}

		public Builder fromBottom(boolean isFromBottom) {
			P.mFromBottom = isFromBottom;
			return this;
		}

		public Builder setAnimation(int animation) {
			P.mAnimation = animation;
			return this;
		}

		public AlertDialog create() {
			final AlertDialog dialog = new AlertDialog(P.mContext, mTheme);
			P.apply(dialog.mAlert);
			dialog.setCancelable(P.mCancelable);
			if (P.mCancelable) {
				dialog.setCanceledOnTouchOutside(true);
			}
			dialog.setOnCancelListener(P.mOnCancelListener);
			dialog.setOnDismissListener(P.mOnDismissListener);
			if (P.mOnKeyListener != null) {
				dialog.setOnKeyListener(P.mOnKeyListener);
			}
			return dialog;
		}

		public AlertDialog show() {
			AlertDialog dialog = create();
			dialog.show();
			return dialog;
		}

	}

}
