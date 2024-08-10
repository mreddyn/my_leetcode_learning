package com.leetcode;

public class MinimumNumberOfOperationsToMakeArrayIncreasing {
    public int minOperations(int[] nums) {
        int minOperationsCount = 0, n = nums.length;
        if (n == 1) {
            return 0;
        }
        int prevValue = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                continue;
            }
            prevValue = nums[i];
            nums[i] = nums[i - 1] + 1;
            minOperationsCount += nums[i] - prevValue;
        }

        return minOperationsCount;
    }
}

// import React,{useEffect,useState}from'react';
// import type{PropsWithChildren}from'react';import{Alert,Button,SafeAreaView,ScrollView,StatusBar,StyleSheet,Text,useColorScheme,View,}from'react-native';

// import{Colors,Header,}from'react-native/Libraries/NewAppScreen';
// import axios from'axios';import{NetworkInfo}from'react-native-network-info';

// type SectionProps = PropsWithChildren<{
//   title: string;
// }>;

// function Section({children, title}:SectionProps):React.JSX.Element

// {
//   const isDarkMode = useColorScheme() === 'dark';
//   return (
//     <View style={styles.sectionContainer}>
//       <Text
//         style={[
//           styles.sectionTitle,
//           {
//             color: isDarkMode ? Colors.white : Colors.black,
//           },
//         ]}>
//         {title}
//       </Text>
//       <Text
//         style={[
//           styles.sectionDescription,
//           {
//             color: isDarkMode ? Colors.light : Colors.dark,
//           },
//         ]}>
//         {children}
//       </Text>
//     </View>
//   );
// }

// function App(): React.JSX.Element {
//   // get server (network where it is running) ipv4 address
//   const [ipAddress, setIpAddress] = useState('');
//   useEffect(() => {
//     NetworkInfo.getIPV4Address().then(ipv4Address => {
//       if(ipv4Address === null) {
//         setIpAddress('');
//       } else {
//         setIpAddress(ipv4Address);
//       }
      
//     });
//   }, []);
//   const sendControlCommand  = async(action: string) => {
//     try {
//       const response = await axios.post(`http://${ipAddress}:8080/api/control`, { action });
//       if(response.data == 'success') {
//         Alert.alert('Success', `${action} command sent successfully`);
//       }
//     } catch (error) {
//       Alert.alert('Failure', `${error} occurred when trying to send ${action}`);
//     }
//   } 
//   const isDarkMode = useColorScheme() === 'dark';

//   const backgroundStyle = {
//     backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
//   };

//   return (
//     <SafeAreaView style={backgroundStyle}>
//       <StatusBar
//         barStyle={isDarkMode ? 'light-content' : 'dark-content'}
//         backgroundColor={backgroundStyle.backgroundColor}
//       />
//       <ScrollView
//         contentInsetAdjustmentBehavior="automatic"
//         style={backgroundStyle}>
//         <Header />
//         <View
//           style={{
//             backgroundColor: isDarkMode ? Colors.black : Colors.white,
//           }}>
//             <View style={styles.container}>
//               <Button title="Play" onPress={() => sendControlCommand('play')} />
//               <Button title="Pause" onPress={() => sendControlCommand('pause')} />
//               <Button title="Stop" onPress={() => sendControlCommand('stop')} />
//           </View>
//         </View>
//       </ScrollView>
//     </SafeAreaView>
//   );
// }

// const styles = StyleSheet.create({
//   sectionContainer: {
//     marginTop: 32,
//     paddingHorizontal: 24,
//   },
//   sectionTitle: {
//     fontSize: 24,
//     fontWeight: '600',
//   },
//   sectionDescription: {
//     marginTop: 8,
//     fontSize: 18,
//     fontWeight: '400',
//   },
//   highlight: {
//     fontWeight: '700',
//   },
//   container: {
//     flex: 1,
//     justifyContent: 'center',
//     alignItems: 'center',
//   },
// });

// export default App;
