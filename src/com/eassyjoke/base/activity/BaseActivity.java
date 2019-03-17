package com.eassyjoke.base.activity;

import android.app.Activity;
import android.os.Bundle;

import com.eassyjoke.base.ioc.ViewUtils;

public abstract class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ��ʼ������
		setContentView();
		ViewUtils.inject(this);
		// ��ʼ��ͷ��
		initTitle();

		// ��ʼ������
		initView();

		// ��ʼ������
		initData();
	}

	abstract protected void initData();

	abstract protected void initView();

	abstract protected void initTitle();

	abstract protected void setContentView();
}
