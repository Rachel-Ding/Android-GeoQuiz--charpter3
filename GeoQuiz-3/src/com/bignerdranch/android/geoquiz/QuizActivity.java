package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {
	private static final String TAG = "QuizActivity";  //新增TAG常量
	private static final String KEY_INDEX = "index";
	
	private Button mTrueButton;
	private Button mFalseButton;
	private Button mPrevButton;
	private Button mNextButton;
	private TextView mQuestionTextView;   
	
	private TrueFalse[ ] mQuestionBank = new TrueFalse[ ] {
			new TrueFalse(R.string.question_oceans, true) ,
			new TrueFalse(R.string.question_mideast, false) ,
			new TrueFalse(R.string.question_africa, false) ,
			new TrueFalse(R.string.question_americas, true) ,
			new TrueFalse(R.string.question_asia, true) ,
	} ;
	
	private int mCurrentIndex = 0;
   
	private void updateQuestion() {
		int question = mQuestionBank[mCurrentIndex].getQuestion();
		mQuestionTextView.setText(question);
	}
	
	private void checkAnswer(boolean userPressedTrue) {
		boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
		
		int messageResId = 0;
		
		if (userPressedTrue == answerIsTrue) {
			messageResId= R.string.correct_toast;
		} else {
			messageResId = R.string.incorrect_toast;
		}
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
               .show( );
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreat(Button) called");  //onCreate()方法日志输出
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView)findViewById(R.id.question_text_view) ;
       /*  int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question); */
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {        //开始，P41，为TextView添加监听器
        	@Override
        	public void onClick(View v) {
        		mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
        		updateQuestion();
        	}
        });                                                     //结束。

        mTrueButton=(Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener( ) {
        	@Override 
        	    public void onClick(View v) {
                 /*   Toast.makeText(QuizActivity.this,
                    		                 R.string.incorrect_toast,
                    		                 Toast.LENGTH_SHORT ).show( );     */
        		checkAnswer(true);
        	}
        });
        mFalseButton=(Button)findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener( ) {
        	@Override 
        	    public void onClick(View v) {
        		/*  Toast.makeText(QuizActivity.this,
		                 R.string.correct_toast,
		                 Toast.LENGTH_SHORT ).show( );   */
        		checkAnswer(false);
        	}
        });

        mPrevButton= (Button)findViewById(R.id.prev_button);                   //开始，P42，练习2，增加后退按钮
        mPrevButton.setOnClickListener(new View.OnClickListener() {   
        	@Override
        	public void onClick(View v) {
        		if (mCurrentIndex%mQuestionBank.length == 0) {
        			mCurrentIndex = mQuestionBank.length - 1	;
        		} else {
        		mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
        		}
        		updateQuestion();
        	}
        });                                                                                                       //结束。
       
        mNextButton= (Button)findViewById(R.id.next_button);  //引用Next按钮，然后为其设置监听器View.OnClick.Listener
        mNextButton.setOnClickListener(new View.OnClickListener() {   //该监听器作用是：递增数组索引并相应更新显示TextView的文本内容。
        	@Override
        	public void onClick(View v) {
        		mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
        		/* int question = mQuestionBank[mCurrentIndex].getQuestion();
        		mQuestionTextView.setText(question); */
        		updateQuestion();
        	}
        });
        
        if (savedInstanceState != null) {
        	mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }
        updateQuestion();
    }  //End of onCreate(Bundle)
    
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
    	super.onSaveInstanceState(savedInstanceState);
    	Log.i(TAG, "onSaveInstanceState");
    	savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }
    
     //继续覆盖五个生命周期
    @Override  //使用此注解，即要求编译器保证当前类具有准备覆盖的方法            
    public void onStart() {
    	super.onStart();
    	Log.d(TAG, "onStart() called");    
    }
    
    @Override
    public void onPause() {
    	super.onPause();
    	Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
    	super.onResume();
    	Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
    	super.onStop();
    	Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
    	super.onDestroy();
    	Log.d(TAG, "onDestroy() called");
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }

}
