package com.reactnativewlhypluginmodule;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.hdgq.locationlib.entity.ShippingNoteInfo;
import com.hdgq.locationlib.LocationOpenApi;
import com.hdgq.locationlib.listener.OnResultListener;
import com.hdgq.locationlib.listener.OnSendResultListener;
import com.amap.api.location.AMapLocationClient;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WlhypluginModuleModule extends ReactContextBaseJavaModule {
  public static final String NAME = "WlhypluginModule";
  public static Context mcontext = null;
  private static final String SEP1 = "";
  private static final String SEP2 = "";
  private static final String SEP3 = "=";
  public WlhypluginModuleModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return NAME;
  }

  /**
   * 初始化SDK
   *
   * @param application
   */
  static public void init(Application application) {
    AMapLocationClient.updatePrivacyShow(application, true, true);
    AMapLocationClient.updatePrivacyAgree(application, true);
    LocationOpenApi.init(application);
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  public void multiply(int a, int b, Promise promise) {
    promise.resolve(a + b);
  }

  @ReactMethod
  public void auth(String appId, String appSecurity, String enterpriseSenderCode, String environment, final Promise promise) {
    LocationOpenApi.auth(getReactApplicationContext(), appId, appSecurity, enterpriseSenderCode, environment,
      new OnResultListener() {
        @Override
        public void onFailure(String errorCode, String errorMsg) {
          promise.resolve(errorCode);
        }

        @Override
        public void onSuccess(List<ShippingNoteInfo> shippingNoteInfos) {
          promise.resolve(ListToString(shippingNoteInfos));
        }
      });
  }

  /**
   * 司机接单首次上传定位
   * @param vehicleNumber
   * @param driverName
   * @param remark
   * @param shippingNoteInfos
   * @param promise
   */
  @ReactMethod
  public void start(ReadableArray shippingNoteInfos, String driverName, String vehicleNumber, String remark, final Promise promise){
    ShippingNoteInfo[] shippingNoteInfo = getShippingNoteInfos(shippingNoteInfos);
    LocationOpenApi.start(getCurrentActivity(), vehicleNumber, driverName, remark, shippingNoteInfo, new OnResultListener() {
      @Override
      public void onFailure(String errorCode, String errorMsg) {
        promise.resolve(errorCode);
      }

      @TargetApi(Build.VERSION_CODES.N)
      @Override
      public void onSuccess(List<ShippingNoteInfo> shippingNoteInfos) {
        List<MyShippingNoteInfos> myShippingNoteInfos = shippingNoteInfos.stream().map(MyShippingNoteInfos::new).collect(Collectors.toList());
        myShippingNoteInfos.forEach(System.out::println);

        promise.resolve(ListToString(myShippingNoteInfos));
      }
    });
  }

  private ShippingNoteInfo[] getShippingNoteInfos(ReadableArray array) {
    ShippingNoteInfo[] shippingNoteInfosArray= new ShippingNoteInfo[array.size()];
    for (int i = 0; i < array.size(); i++) {
      ReadableMap map = array.getMap(i);
      String shippingNoteNumber = map.getString("shippingNoteNumber");
      String serialNumber = map.getString("serialNumber");
      String startCountrySubdivisionCode = map.getString("startCountrySubdivisionCode");
      String endCountrySubdivisionCode = map.getString("endCountrySubdivisionCode");
      Double startLongitude = (Double)map.getDouble("startLongitude");
      Double startLatitude = (Double)map.getDouble("startLatitude");
      Double endLongitude = (Double)map.getDouble("endLongitude");
      Double endLatitude = (Double)map.getDouble("endLatitude");
      String startLocationText = map.getString("startLocationText");
      String endLocationText = map.getString("endLocationText");

      ShippingNoteInfo shippingNoteInfo =  new ShippingNoteInfo();
      shippingNoteInfo.setShippingNoteNumber(shippingNoteNumber);
      shippingNoteInfo.setSerialNumber(serialNumber);
      shippingNoteInfo.setStartCountrySubdivisionCode(startCountrySubdivisionCode);
      shippingNoteInfo.setEndCountrySubdivisionCode(endCountrySubdivisionCode);
      shippingNoteInfo.setStartLongitude(startLongitude);
      shippingNoteInfo.setStartLatitude(startLatitude);
      shippingNoteInfo.setEndLongitude(endLongitude);
      shippingNoteInfo.setEndLatitude(endLatitude);
      shippingNoteInfo.setStartLocationText(startLocationText);
      shippingNoteInfo.setEndLocationText(endLocationText);
      shippingNoteInfosArray[i] = shippingNoteInfo;
    }
    return shippingNoteInfosArray;
  }

  public static native int nativeMultiply(int a, int b);
  public static String ListToString(List<?> list) {
    StringBuffer sb = new StringBuffer();
    if (list != null && list.size() > 0) {
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i) == null || list.get(i) == "") {
          continue;
        }
        // 如果值是list类型则调用自己
        if (list.get(i) instanceof List) {
          sb.append(ListToString((List<?>) list.get(i)));
          sb.append(SEP1);
        } else if (list.get(i) instanceof Map) {
          sb.append(MapToString((Map<?, ?>) list.get(i)));
          sb.append(SEP1);
        } else {
          sb.append(list.get(i));
          sb.append(SEP1);
        }
      }
    }
    return "L" + sb.toString();
  }
  public static String MapToString(Map<?, ?> map) {
    StringBuffer sb = new StringBuffer();
    // 遍历map
    for (Object obj : map.keySet()) {
      if (obj == null) {
        continue;
      }
      Object key = obj;
      Object value = map.get(key);
      if (value instanceof List<?>) {
        sb.append(key.toString() + SEP1 + ListToString((List<?>) value));
        sb.append(SEP2);
      } else if (value instanceof Map<?, ?>) {
        sb.append(key.toString() + SEP1
          + MapToString((Map<?, ?>) value));
        sb.append(SEP2);
      } else {
        sb.append(key.toString() + SEP3 + value.toString());
        sb.append(SEP2);
      }
    }
    return "M" + sb.toString();
  }

}
