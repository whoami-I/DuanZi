package com.example.duanzi;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.base.BaseActivity;
import com.example.ioc.OnClick;
import com.example.ioc.ViewById;

public class MainActivity extends BaseActivity {
	@ViewById(R.id.tv_hello)
	private TextView mTvHello;

	@OnClick(values = { R.id.tv_hello })
	private void tvHelloOnClick(View v) {
		Toast.makeText(this, "µã»÷", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void initData() {

	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initTitle() {

	}

	@Override
	protected void setContentView() {
		setContentView(R.layout.activity_main);
	}

}
