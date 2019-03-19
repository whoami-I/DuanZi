package com.eassyjoke.app.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.eassyjoke.R;
import com.eassyjoke.base.ioc.ViewById;
import com.eassyjoke.framework.activity.BaseSkinActivity;
import com.eassyjoke.framework.navigationbar.NavigationBar;

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
		View.OnClickListener l = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "µã»÷", Toast.LENGTH_SHORT)
						.show();
			}
		};
		NavigationBar builder = new NavigationBar.Builder(this)
				.setContentView(R.layout.title).setLeftIcon(R.drawable.qq)
				.setTitle("±êÌâÀ¸").setHeight(200).setTextSize(30)
				.setBackGround(Color.rgb(200, 200, 200))
				.setLeftClickListener(l).show();
	}

	@Override
	protected void setContentView() {
		setContentView(R.layout.activity_main);
		this.findViewById(android.R.id.content);
		// mBuilder.show();

	}
}
