package com.bignerdranch.android.geoquiz;


public class TrueFalse
{
	private int mQuestion;  /*����mQuestion����ȷ������ȷ���
	                                        mQuestionΪʲô��int�͵ģ�������String��
	                                       ��ΪmQuestion�����������֪ʶ�����ַ�������ԴID����ԴID����int���͡�*/
	                                       
	
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
