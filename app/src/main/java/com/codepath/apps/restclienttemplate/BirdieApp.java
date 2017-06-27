package com.codepath.apps.restclienttemplate;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;

import android.app.Application;
import android.content.Context;

/*
 * This is the Android application itself and is used to configure various settings
 * including the image cache in memory and on disk. This also adds a singleton
 * for accessing the relevant rest client.
 *
 *     BirdieClient client = BirdieApp.getRestClient();
 *     // use client to send requests to API
 *
 */
public class BirdieApp extends Application {
	private static Context context;

	@Override
	public void onCreate() {
		super.onCreate();

		FlowManager.init(new FlowConfig.Builder(this).build());
		FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);

		BirdieApp.context = this;
	}

	public static BirdieClient getRestClient() {
		return (BirdieClient) BirdieClient.getInstance(BirdieClient.class, BirdieApp.context);
	}
}