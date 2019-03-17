package com.eassyjoke.base.navigationbar;

import android.content.Context;

public class AbsNavigationBar {

	protected void apply() {
	}

	static class Builder {
		private Context mContext;
		protected NavigationParams P;
		protected AbsNavigationBar mNavigationBar;

		public Builder(Context context) {
			mContext = context;
			P = new NavigationParams();
		}

		public void setContentView(int layoutResId) {
			P.mLayoutResId = layoutResId;
		}

		public AbsNavigationBar show() {
			AbsNavigationBar NavigationBar = new AbsNavigationBar();
			mNavigationBar = NavigationBar;
			NavigationBar.apply();
			return NavigationBar;
		}

		static class NavigationParams {
			public int mLayoutResId;

		}
	}
}
