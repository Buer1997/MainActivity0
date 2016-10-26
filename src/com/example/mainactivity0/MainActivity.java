package com.example.mainactivity0;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button red,green,blue,bold, italic,moren, bigger, smaller;
	private int flag=0;           //标志量，默认为0
	
	private TextView testText;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);//设置界面布局文件
		
		testText=(TextView)findViewById(R.id.testText);//根据id获取控件
		red=(Button)findViewById(R.id.red);
		green=(Button)findViewById(R.id.green);
		blue=(Button)findViewById(R.id.blue);
		
		testText.setTypeface(Typeface.DEFAULT);  //设置字体样式
		
		bold=(Button)findViewById(R.id.bold);    //根据id获取控件
		italic = (Button) findViewById(R.id.italic);
		moren=(Button)findViewById(R.id.moren);
		bigger = (Button) findViewById(R.id.bigger);
		smaller = (Button) findViewById(R.id.smaller);
		
		SizeListener mysizeListener=new SizeListener(testText);
		bigger.setOnClickListener(mysizeListener);
		smaller.setOnClickListener(mysizeListener);
		(EditText) findViewById(R.id.content);
		ColorListner myColorListner=new ColorListner();//创建监听对象
		red.setOnClickListener(myColorListner);//注册监听器
		green.setOnClickListener(myColorListner);
		blue.setOnClickListener(myColorListner);
		italic.setOnClickListener((OnClickListener) this);
		bold.setOnClickListener((OnClickListener) this);
		moren.setOnClickListener((OnClickListener) this);
		
		
		

	}

	private class ColorListner implements OnClickListener{
		public void onClick(View v){
			switch(v.getId()){
			case R.id.red:
				testText.setTextColor(Color.RED);break;//将字体设置为红色
			case R.id.green:
				testText.setTextColor(Color.GREEN);break;
			case R.id.blue:
				testText.setTextColor(Color.BLUE);break;
				
				default:break;
				
			}
		}
		
	}
	public void onClick(View v) {		
		Typeface tf=testText.getTypeface();
		//testText.get
		switch (v.getId()) {
		case R.id.italic:			
			if(flag==2||flag==3){
				testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
				flag=3;
			}else{
				testText.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC); //斜体
				flag=1;
			}			
			break;
		case R.id.bold:      //单击加粗
			if(flag==1||flag==3){
				testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC); //粗体
				flag=3;
			}else{
				testText.setTypeface(Typeface.DEFAULT_BOLD,Typeface.BOLD); //粗体
				flag=2;
			}						
			break;
		case R.id.moren:
			testText.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL);
			flag=0;
			break;
		default:
			break;
		}
	}
}
	


