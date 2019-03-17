package com.eassyjoke.app.activity;

import android.widget.Button;

import com.eassyjoke.base.ioc.ViewById;
import com.eassyjoke.framework.activity.BaseSkinActivity;
import com.eassyjoke.framework.navigationbar.NavigationBar;
import com.example.duanzi.R;

public class MainActivity extends BaseSkinActivity {
	@ViewById(R.id.btn_hello)
	private Button mBtnHello;

	// private Builder mBuilder;

	// @OnClick(values = { R.id.btn_hello })
	// private void btnHelloOnClick(View v) {
	// mBuilder = new AlertDialog.Builder(this);
	//
	// final AlertDialog dialog = mBuilder
	// .setContentView(R.layout.dialog_comment).fromBottom(true)
	// .full(true).show();
	//
	// }

	@Override
	protected void initData() {

	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initTitle() {
		NavigationBar builder = new NavigationBar.Builder(this).setContentView(
				R.layout.title).show();
	}

	@Override
	protected void setContentView() {
		setContentView(R.layout.activity_main);
		this.findViewById(android.R.id.content);
		// mBuilder.show();

	}
}
