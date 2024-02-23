package io.datoms.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class cordovaDatoms extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }else if (action.equals("TrackUser")) {
            String event_name = args.getString(0);
            JSONObject event_data = args.getJSONObject(1);
            this.TrackUser(event_name,event_data, callbackContext);
            return true;
        }
        return false;
    }

    private void TrackUser(String name,JSONObject data,CallbackContext callbackContext) throws JSONException {
        JSONObject success_data=new JSONObject();
        success_data.put("name",name);
        success_data.put("data",data);
        callbackContext.success(success_data);
        //getJSONObject
    }
    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
