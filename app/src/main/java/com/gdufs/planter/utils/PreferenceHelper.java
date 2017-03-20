package com.gdufs.planter.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * 用于管理Preference数据类
 */
public class PreferenceHelper
{
    private static PreferenceHelper mInstance;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    private static final String SHARED_FILE_NAME = "preferences";

    /**
     * 单例获取方法
     * 
     * @param context 上下文
     * @return 单例对象
     */
    public synchronized static PreferenceHelper getInstance(final Context context)
    {
        if (mInstance == null)
        {
            mInstance = new PreferenceHelper(context);
        }
        return mInstance;
    }

    public SharedPreferences getPreferences()
    {
        return mPreferences;
    }

    private PreferenceHelper(final Context context)
    {
        mPreferences = context.getSharedPreferences(SHARED_FILE_NAME, Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
    }

    public Map<String, ?> getAll()
    {
        return mPreferences.getAll();
    }

    public boolean contains(String key)
    {
        return mPreferences.contains(key);
    }

    public boolean getBoolean(String key, boolean defValue)
    {
        return mPreferences.getBoolean(key, defValue);
    }

    public float getFloat(String key, float defValue)
    {
        return mPreferences.getFloat(key, defValue);
    }

    public int getInt(String key, int defValue)
    {
        return mPreferences.getInt(key, defValue);
    }

    public long getLong(String key, long defValue)
    {
        return mPreferences.getLong(key, defValue);
    }

    public String getString(String key, String defValue)
    {
        return mPreferences.getString(key, defValue);
    }

    public void registerOnSharedPreferenceChangeListener(
            SharedPreferences.OnSharedPreferenceChangeListener listener)
    {
        mPreferences.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterOnSharedPreferenceChangeListener(
            SharedPreferences.OnSharedPreferenceChangeListener listener)
    {
        mPreferences.unregisterOnSharedPreferenceChangeListener(listener);
    }

    public boolean putBoolean(String key, boolean b)
    {
        mEditor.putBoolean(key, b);
        return mEditor.commit();
    }

    public boolean putInt(String key, int i)
    {
        mEditor.putInt(key, i);
        return mEditor.commit();
    }

    public boolean putFloat(String key, float f)
    {
        mEditor.putFloat(key, f);
        return mEditor.commit();
    }

    public boolean putLong(String key, long l)
    {
        mEditor.putLong(key, l);
        return mEditor.commit();
    }

    public boolean putString(String key, String s)
    {
        mEditor.putString(key, s);
        return mEditor.commit();
    }

    /**
     * 清除记录
     * 
     * @param key
     * @return
     */
    public boolean remove(String key)
    {
        mEditor.remove(key);
        return mEditor.commit();
    }
}