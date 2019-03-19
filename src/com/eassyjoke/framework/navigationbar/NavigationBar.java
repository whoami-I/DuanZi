package com.eassyjoke.framework.navigationbar;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

import com.eassyjoke.R;

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

		public Builder setLeftText(String text) {
			P.mLeftText = text;
			return this;
		}

		public Builder setRightText(String text) {
			P.mRightText = text;
			return this;
		}

		public Builder setLeftIcon(int iconId) {
			P.mLeftIcon = iconId;
			return this;
		}

		public Builder setRightIcon(int iconId) {
			P.mRightIcon = iconId;
			return this;
		}

		public Builder setTitle(String title) {
			P.mTitle = title;
			return this;
		}

		public Builder setLeftClickListener(View.OnClickListener l) {
			P.mLeftClickListener = l;
			return this;
		}

		public Builder setRightClickListener(View.OnClickListener l) {
			P.mRightClickListener = l;
			return this;
		}

		public Builder setWidth(int width) {
			P.mWidth = width;
			return this;
		}

		public Builder setHeight(int height) {
			P.mHeight = height;
			return this;
		}

		public Builder setTextSize(int size) {
			P.mSize = size;
			return this;
		}

		public Builder setBackGround(int color) {
			P.mColor = color;
			return this;
		}

		public NavigationBar show() {
			NavigationBar navigationBar = new NavigationBar();
			mNavigationBar = navigationBar;

			ViewGroup group = (ViewGroup) (((Activity) P.mContext)
					.findViewById(android.R.id.content));
			P.mViewParent = (ViewGroup) group.getChildAt(0);
			// P.mViewParent = (ViewGroup) (((Activity) P.mContext)
			// .findViewById(R.id.li));
			View view = LayoutInflater.from(P.mContext).inflate(P.mLayoutResId,
					P.mViewParent, false);
			P.mView = view;
			P.mViewParent.addView(view, 0);
			P.apply();
			return navigationBar;
		}

		private static class NavigationParams {
			private static final String TAG = "NavigationParams";
			public OnClickListener mRightClickListener;
			public OnClickListener mLeftClickListener;

			public int mRightIcon;
			public int mLeftIcon;

			public String mRightText;
			public String mLeftText;
			public String mTitle;
			public int mSize;
			public int mColor;

			public Context mContext;

			public int mLayoutResId;
			public View mView;
			public ViewGroup mViewParent;

			public int mWidth;
			public int mHeight;

			public NavigationParams(Context context, int layoutResId) {
				this.mContext = context;
				this.mLayoutResId = layoutResId;
			}

			private Context getContext() {
				return mContext;
			}

			private View getView() {
				return mView;
			}

			private View findViewById(int res) {
				View view = getView().findViewById(res);

				return view;
			}

			private void setBackgroundColor(View v, int color) {
				if (color != 0) {
					v.setBackgroundColor(color);
				}

			}

			/**
			 * @param tvId
			 *            TextView的id值
			 * @param text
			 *            设置的字符串
			 * 
			 */
			private View setText(int tvId, String text) {
				View view = findViewById(tvId);
				if (view != null) {
					if (TextUtils.isEmpty(text)) {
						view.setVisibility(View.INVISIBLE);
						return view;
					}

					TextView v = (TextView) view;
					v.setText(text);

				} else {
					Log.w(TAG, "can not find view" + tvId);
				}
				return view;
			}

			private View setTextAndSize(int tvId, String text, int size) {
				TextView tv = (TextView) setText(tvId, text);
				if (tv != null && size != 0) {
					tv.setTextSize(size);
				}
				return tv;
			}

			private void setIcon(int ivId, int ivRes) {
				View view = findViewById(ivId);
				if (view != null) {
					ImageView v = (ImageView) view;
					v.setImageResource(ivRes);
				} else {
					Log.w(TAG, "can not find ImageView" + ivRes);
				}
			}

			private void setClickListener(int viewId, View.OnClickListener l) {
				if (l == null)
					return;
				View view = findViewById(viewId);
				if (view != null) {
					view.setOnClickListener(l);
				} else {
					Log.w(TAG, "can not find view" + viewId);
				}
			}

			private void setWidthAndHeight(View v, int width, int height) {
				LayoutParams lp = v.getLayoutParams();
				if (mWidth != 0)
					lp.width = width;
				if (mHeight != 0)
					lp.height = height;

			}

			public void apply() {
				setTextAndSize(R.id.tv_left, mLeftText, mSize);
				setIcon(R.id.iv_left, mLeftIcon);
				setClickListener(R.id.iv_left, mLeftClickListener);
				setTextAndSize(R.id.tv_title, mTitle, mSize);
				setIcon(R.id.iv_right, mRightIcon);
				setClickListener(R.id.iv_right, mRightClickListener);
				setTextAndSize(R.id.tv_right, mRightText, mSize);
				setWidthAndHeight(mView, mWidth, mHeight);
				setBackgroundColor(mView, mColor);
			}
		}
	}
}
