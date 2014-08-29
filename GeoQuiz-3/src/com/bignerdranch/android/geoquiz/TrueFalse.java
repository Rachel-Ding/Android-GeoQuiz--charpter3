package com.bignerdranch.android.geoquiz;


public class TrueFalse
{
	private int mQuestion;  /*变量mQuestion用来确定答案正确与否。
	                                        mQuestion为什么是int型的，而不是String。
	                                       因为mQuestion用来保存地理知识问题字符串的资源ID。资源ID总是int类型。*/
	                                       
	
	private boolean mTrueQuestion;
	
	public int getQuestion()
	{
		return mQuestion;
	}

	public void setQuestion(int question)
	{
		mQuestion = question;
	}

	public boolean isTrueQuestion()
	{
		return mTrueQuestion;
	}

	public void setTrueQuestion(boolean trueQuestion)
	{
		mTrueQuestion = trueQuestion;
	}

	public TrueFalse(int question, boolean trueQuestion) {
		 mQuestion = question ;
		 mTrueQuestion = trueQuestion ;
	}

}
