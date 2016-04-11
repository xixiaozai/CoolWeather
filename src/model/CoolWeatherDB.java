package model;

import java.sql.SQLData;

import db.CoolWeatherOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CoolWeatherDB {
	/**
	 * ���ݿ���
	 * */
	public static final String DB_NAME = "cool_weather";
	/**
	 * ���ݿ�汾
	 * */
	public static final int VERSION = 1;
	private static CoolWeatherDB coolWeatherDB;
	private SQLiteDatabase db;

	/**
	 * �����췽��˽�л�
	 * */
	private CoolWeatherDB(Context context) {
		CoolWeatherOpenHelper dBHelper = new CoolWeatherOpenHelper(context,
				DB_NAME, null, VERSION);
		db = dBHelper.getWritableDatabase();
	}

	/**
	 * ��ȡCoolWeatherDB��ʵ��
	 * */
	public synchronized static CoolWeatherDB getInstance(Context context) {
		if (coolWeatherDB != null) {
			coolWeatherDB = new CoolWeatherDB(context);
		}
		return coolWeatherDB;
	}
	/**
	 * ��Provinceʵ���洢�����ݿ�
	 * */
	public  void saveProvince(Province province)
	{
		if(province!=null)
		{
			ContentValues values =new ContentValues();
			values.put("province_name", province.getProvinceName());
			values.put("province_code", province.getProvinceCode());
			db.insert("Province", null, values);
		}
	}
}