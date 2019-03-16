package com.example.duanzi;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.base.BaseSkinActivity;
import com.example.dialog.AlertDialog;
import com.example.dialog.AlertDialog.Builder;
import com.example.ioc.OnClick;
import com.example.ioc.ViewById;

public class MainActivity extends BaseSkinActivity {
	@ViewById(R.id.btn_hello)
	private Button mBtnHello;
	private Builder mBuilder;

	@OnClick(values = { R.id.btn_hello })
	private void btnHelloOnClick(View v) {
		mBuilder = new AlertDialog.Builder(this);

		final AlertDialog dialog = mBuilder
				.setContentView(R.layout.dialog_comment).fromBottom(true)
				.full(true).show();

		dialog.setClickListener(R.id.btn_send, new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				TextView view = (TextView) dialog.getView(R.id.et_comment);
				Toast.makeText(MainActivity.this, view.getText().toString(),
						Toast.LENGTH_SHORT).show();
			}
		});

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

		// mBuilder.show();
	}
}
