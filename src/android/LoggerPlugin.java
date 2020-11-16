package com.plugin.logger;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.lang.Runtime;

public class LoggerPlugin extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args,final CallbackContext callbackContext) throws JSONException {
        final String logFilePath = args.getString(0);
        if (action.equals("configure")) {                        
            cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                    try {
                        File file = new File(logFilePath);
                        Runtime.getRuntime().exec("logcat -v time -f " + file.getAbsolutePath());
                        callbackContext.success("Log file created successfully");
                    } catch (IOException e){
                        callbackContext.error("Error in creating log file.");
                    }
                }
            });
            return true;
        }
        return false;
    }
}

