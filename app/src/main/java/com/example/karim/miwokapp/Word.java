package com.example.karim.miwokapp;

/**
 * Created by KARIM on 8/10/2017.
 */

public class Word
{
	private String defaultTranslation;
	private String miwokTranslation;
	private int imageResID = -1;
	private  int audioResID;
	public int getImageResID()
	{
		return imageResID;
	}

	public Word(String s1, String s2 ,int id)
	{
		defaultTranslation = s1;
		miwokTranslation = s2;
		audioResID = id;
	}
	public Word(String s1,String s2,int id,int mid)
	{
		defaultTranslation = s1;
		miwokTranslation = s2;
		imageResID=id;
		audioResID = mid;
	}
	public String getDefaultTranslation()
	{
		return defaultTranslation;
	}
	public String getMiwokTranslation()
	{
		return miwokTranslation;
	}
	public Boolean hasImage()
	{
		return imageResID!=-1;
	}
	public  int getAudioResID()
	{
		return  audioResID;
	}
}