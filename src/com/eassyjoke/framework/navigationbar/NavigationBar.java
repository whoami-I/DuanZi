package com.eassyjoke.framework.navigationbar;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duanzi.R;

public class NavigationBar {

	public static class Builder {

		private NavigationParams P;
		private NavigationBar mNavigationBar;

		public Builder(Context context) {
			this(context, R.layout.title);
		}

		public Builder(Context context, int layoutResId) {
			P = new NavigationParams(context, layoutResId);

		}

		public Builder setContentView(int layoutResId) {
			P.mLayoutResId = layoutResId;
			return this;
		}

		public NavigationBar show() {
			NavigationBar navigationBar = new NavigationBar();
			mNavigationBar = navigationBar;
			// P.mContext = null;
			Log.e("warn", "P.mContext=" + P.mContext);
			// 这种方式会导致布局文件的控价和标题栏控件重叠
			// P.mViewParent = (ViewGroup) (((Activity) P.mContext)
			// .findViewById(android.R.id.content));

			P.mViewParent = (ViewGroup) (((Activity) P.mContext)
					.findViewById(R.id.li));
			// 这种方式会导致addView的时候报错
			// View view = View.inflate(P.mContext, P.mLayoutResId,
			// P.mViewParent);
			View view = LayoutInflater.from(P.mContext).inflate(P.mLayoutResId,
					P.mViewParent, false);
			P.mView = view;
			// P.mViewParent.removeViewAt(0)
			P.mViewParent.addView(view, 0);
			P.apply();
			return navigationBar;
		}

		private static class NavigationParams {
			public Context mContext;
			public int mLayoutResId;
			public View mView;
			public ViewGroup mViewParent;

			public NavigationParams(Context context, int layoutResId) {
				this.mContext = context;
				this.mLayoutResId = layoutResId;
			}

			public void apply() {

			}

		}
	}
}
