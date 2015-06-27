/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package ti.fabric;

import java.util.HashMap;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.TiContext;
import org.appcelerator.titanium.util.TiConvert;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

@Kroll.module(parentModule=FabricModule.class)
public class CrashlyticsModule extends KrollModule {

	@Kroll.constant public static final int LOG_LEVEL_VERBOSE = Log.VERBOSE;
	@Kroll.constant public static final int LOG_LEVEL_DEBUG = Log.DEBUG;
	@Kroll.constant public static final int LOG_LEVEL_INFO = Log.INFO;	
	@Kroll.constant public static final int LOG_LEVEL_WARN = Log.WARN;	
	@Kroll.constant public static final int LOG_LEVEL_ERROR = Log.ERROR;
	@Kroll.constant public static final int LOG_LEVEL_ASSERT = Log.ASSERT;

	public CrashlyticsModule() {
		super();
	}
	
	public CrashlyticsModule(TiContext tiContext)
	{
		this();
	}
	
	@Kroll.method
	public void setDebugMode(Object value)
	{
		FabricModule.debuggable = TiConvert.toBoolean(value);
	}
	
	@Kroll.method @Kroll.getProperty
	public String getVersion()
	{
		return Crashlytics.getInstance().core.getVersion();
	}
	
	@Kroll.method
	public void crash()
	{
		Crashlytics.getInstance().core.crash();
	}
	
	@Kroll.method
	public void logException(Object error)
	{
		if(error instanceof String){
			error = new Exception(TiConvert.toString(error));
		}else if(error instanceof HashMap){
			error = new Exception(TiConvert.toString((HashMap) error, TiC.PROPERTY_MESSAGE));
		}
		
		if(error instanceof Exception){
			Crashlytics.getInstance().core.logException((Exception) error);	
		}
	}
	
	@Kroll.method
	public void leaveBreadcrumb(Object value)
	{
		if(value instanceof HashMap){
			HashMap opts = (HashMap) value;
			Crashlytics.getInstance().core.log(TiConvert.toInt(opts.get(TiC.PROPERTY_LEVEL), LOG_LEVEL_INFO), TiConvert.toString(opts, TiC.PROPERTY_TAG), TiConvert.toString(opts, TiC.PROPERTY_MESSAGE));
		}else{
			Crashlytics.getInstance().core.log(TiConvert.toString(value));
		}
	}
	
	@Kroll.method
	public void setUserIdentifier(String value)
	{
		Crashlytics.getInstance().core.setUserIdentifier(value);
	}
	
	@Kroll.method
	public void setUserName(String value)
	{
		Crashlytics.getInstance().core.setUserName(value);
	}
	
	@Kroll.method
	public void setUserEmail(String value)
	{
		Crashlytics.getInstance().core.setUserEmail(value);
	}
	
	@Kroll.method
	public void setInt(String key, Object value)
	{
		Crashlytics.getInstance().core.setInt(key, TiConvert.toInt(value));
	}
	
	@Kroll.method
	public void setFloat(String key, Object value)
	{
		Crashlytics.getInstance().core.setFloat(key, TiConvert.toFloat(value));
	}
	
	@Kroll.method
	public void setDouble(String key, Object value)
	{
		Crashlytics.getInstance().core.setDouble(key, TiConvert.toDouble(value));
	}
	
	@Kroll.method
	public void setBool(String key, Object value)
	{
		Crashlytics.getInstance().core.setBool(key, TiConvert.toBoolean(value));
	}
	
	@Kroll.method
	public void setString(String key, Object value)
	{
		Crashlytics.getInstance().core.setString(key, TiConvert.toString(value));
	}

}
