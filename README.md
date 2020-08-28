# react-native-support-emoji

# Use like this below
```
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
```