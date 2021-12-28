import * as React from 'react';

import { StyleSheet, View, Text, NativeModules, Button } from 'react-native';

import { multiply } from 'react-native-wlhyplugin-module';

export default function App() {
  const [result, setResult] = React.useState<number | undefined>();

  const authFun = async () => {
    console.log('auth start')
    const res = await NativeModules.WlhypluginModule.auth("com.ynrh.rhs", "c9177022a3d911ea85d70242ac130005c9177061a3d911ea85d70242ac130005", "53115657", "debug")
    console.log('auth end', res)
  }
  const start = async () => {
    const driverName = "赵常义"
    const vehicleNumber = "豫PW3936"
    const remark = "测试数据"
    const shippingNote = [{
      shippingNoteNumber: "PCD000200023383",
      serialNumber: "0000",
      startCountrySubdivisionCode: "530304",
      endCountrySubdivisionCode: "510403",
      startLongitude: 102.706624,
      startLatitude:24.996492,
      endLongitude: 103.717465,
      endLatitude: 27.338257,
      startLocationText: "曲靖马龙区",
      endLocationText: "攀枝花市格里坪",
      vehicleNumber: "豫PW3936",
      driverName: "赵常义",
      interval: "5000"
    }]
    console.log('location-start')
    const res = await NativeModules.WlhypluginModule.start(shippingNote, driverName, vehicleNumber, remark)
    console.log('location-end', res)
  }
  React.useEffect(() => {
    multiply(8, 10).then(setResult);
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
      <Button title='Click' onPress={authFun}></Button>
      <View style={{ marginTop: 20 }}>
        <Button title='START' onPress={start} ></Button>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
