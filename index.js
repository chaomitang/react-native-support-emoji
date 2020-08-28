import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  requireNativeComponent
} from 'react-native';

var SZEmojiTextView = requireNativeComponent('EmojiText');

class HelloWorld extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <SZEmojiTextView style={styles.hello} >
          <Text >Hello, World💘👪👿🧗</Text>
        </SZEmojiTextView>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center'
  },
  hello: {
    fontSize: 20,
    fontFamily: "Cochin",
    fontWeight: "bold",
    color: 'blue',
    textAlign: 'center',
    margin: 10
  }
});

AppRegistry.registerComponent(
  'TestReactSupportEmojiApp',
  () => HelloWorld
);