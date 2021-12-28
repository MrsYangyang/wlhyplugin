package com.reactnativewlhypluginmodule;

import com.hdgq.locationlib.entity.ShippingNoteInfo;


public class MyShippingNoteInfos  {
  private int alreadySendCount;
  private String driverName;
  private String endCountrySubdivisionCode;
  private Double endLatitude;
  private String endLocationText;
  private Double endLongitude;
  private long interval;
  private int sendCount;
  private String serialNumber;
  private String shippingNoteNumber;
  private String startCountrySubdivisionCode;
  private Double startLatitude;
  private String startLocationText;
  private Double startLongitude;
  private String vehicleNumber;

  public MyShippingNoteInfos() {
  }

  public MyShippingNoteInfos(ShippingNoteInfo info) {
     this.alreadySendCount = info.getAlreadySendCount();
     this.driverName = info.getDriverName();
     this.endCountrySubdivisionCode = info.getEndCountrySubdivisionCode();
     this.endLatitude = info.getEndLatitude();
     this.endLocationText = info.getEndLocationText();
     this.endLongitude = info.getEndLongitude();
     this.interval = info.getInterval();
     this.sendCount = info.getSendCount();
     this.serialNumber = info.getSerialNumber();
     this.shippingNoteNumber = info.getShippingNoteNumber();
     this.startCountrySubdivisionCode = info.getStartCountrySubdivisionCode();
     this.startLatitude = info.getStartLatitude();
     this.startLocationText = info.getStartLocationText();
     this.startLongitude = info.getStartLongitude();
     this.vehicleNumber = info.getVehicleNumber();

  }

  public int getAlreadySendCount() {
    return this.alreadySendCount;
  }

  public String getDriverName() {
    return this.driverName;
  }

  public String getEndCountrySubdivisionCode() {
    String var1 = this.endCountrySubdivisionCode;
    return var1 != null && !"null".equals(var1.trim()) ? this.endCountrySubdivisionCode : "";
  }

  public Double getEndLatitude() {
    return this.endLatitude;
  }

  public String getEndLocationText() {
    return this.endLocationText;
  }

  public Double getEndLongitude() {
    return this.endLongitude;
  }

  public long getInterval() {
    return this.interval;
  }

  public int getSendCount() {
    return this.sendCount;
  }

  public String getSerialNumber() {
    String var1 = this.serialNumber;
    return var1 != null && !"null".equals(var1.trim()) ? this.serialNumber : "";
  }

  public String getShippingNoteNumber() {
    String var1 = this.shippingNoteNumber;
    return var1 != null && !"null".equals(var1.trim()) ? this.shippingNoteNumber : "";
  }

  public String getStartCountrySubdivisionCode() {
    String var1 = this.startCountrySubdivisionCode;
    return var1 != null && !"null".equals(var1.trim()) ? this.startCountrySubdivisionCode : "";
  }

  public Double getStartLatitude() {
    return this.startLatitude;
  }

  public String getStartLocationText() {
    return this.startLocationText;
  }

  public Double getStartLongitude() {
    return this.startLongitude;
  }

  public String getVehicleNumber() {
    return this.vehicleNumber;
  }

  public void setAlreadySendCount(int var1) {
    this.alreadySendCount = var1;
  }

  public void setDriverName(String var1) {
    this.driverName = var1;
  }

  public void setEndCountrySubdivisionCode(String var1) {
    this.endCountrySubdivisionCode = var1;
  }

  public void setEndLatitude(Double var1) {
    this.endLatitude = var1;
  }

  public void setEndLocationText(String var1) {
    this.endLocationText = var1;
  }

  public void setEndLongitude(Double var1) {
    this.endLongitude = var1;
  }

  public void setInterval(long var1) {
    this.interval = var1;
  }

  public void setSendCount(int var1) {
    this.sendCount = var1;
  }

  public void setSerialNumber(String var1) {
    this.serialNumber = var1;
  }

  public void setShippingNoteNumber(String var1) {
    this.shippingNoteNumber = var1;
  }

  public void setStartCountrySubdivisionCode(String var1) {
    this.startCountrySubdivisionCode = var1;
  }

  public void setStartLatitude(Double var1) {
    this.startLatitude = var1;
  }

  public void setStartLocationText(String var1) {
    this.startLocationText = var1;
  }

  public void setStartLongitude(Double var1) {
    this.startLongitude = var1;
  }

  public void setVehicleNumber(String var1) {
    this.vehicleNumber = var1;
  }

  @Override
  public String toString() {
    return "MyShippingNoteInfos{" +
      "alreadySendCount=" + alreadySendCount +
      ", driverName='" + driverName + '\'' +
      ", endCountrySubdivisionCode='" + endCountrySubdivisionCode + '\'' +
      ", endLatitude=" + endLatitude +
      ", endLocationText='" + endLocationText + '\'' +
      ", endLongitude=" + endLongitude +
      ", interval=" + interval +
      ", sendCount=" + sendCount +
      ", serialNumber='" + serialNumber + '\'' +
      ", shippingNoteNumber='" + shippingNoteNumber + '\'' +
      ", startCountrySubdivisionCode='" + startCountrySubdivisionCode + '\'' +
      ", startLatitude=" + startLatitude +
      ", startLocationText='" + startLocationText + '\'' +
      ", startLongitude=" + startLongitude +
      ", vehicleNumber='" + vehicleNumber + '\'' +
      '}';
  }
}
