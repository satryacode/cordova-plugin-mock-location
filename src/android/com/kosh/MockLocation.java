package com.kosh;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
// import android.provider.Settings.Secure;

public class MockLocation extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext, Location location) throws JSONException {
        if (action.equals("check")) {
			// if (Secure.getString(this.cordova.getActivity().getContentResolver(), Secure.ALLOW_MOCK_LOCATION).equals("0")) {
			// 	callbackContext.success("false");
			// } else {
			// 	callbackContext.success("true");
			// }
	    //android.os.Build.VERSION.SDK_INT >= 18
            if(location.isFromMockProvider()){
                callbackContext.success("true");
            } else {
                callbackContext.success("false");
            }
            return true;
        } else {
            return false;
        }
    }
}
