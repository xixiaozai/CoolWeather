package model;

import java.sql.SQLData;

import db.CoolWeatherOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CoolWeatherDB {
	/**
	 * 数据库名
	 * */
	public static final String DB_NAME = "cool_weather";
	/**
	 * 数据库版本
	 * */
	public static final int VERSION = 1;
	private static CoolWeatherDB coolWeatherDB;
	private SQLiteDatabase db;

	/**
	 * 将构造方法私有化
	 * */
	private CoolWeatherDB(Context context) {
		CoolWeatherOpenHelper dBHelper = new CoolWeatherOpenHelper(context,
				DB_NAME, null, VERSION);
		db = dBHelper.getWritableDatabase();
	}

	/**
	 * 获取CoolWeatherDB的实例
	 * */
	public synchronized static CoolWeatherDB getInstance(Context context) {
		if (coolWeatherDB != null) {
			coolWeatherDB = new CoolWeatherDB(context);
		}
		return coolWeatherDB;
	}
	/**
	 * 将Province实例存储到数据库
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