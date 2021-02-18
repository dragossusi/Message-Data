# Message-Data

[![Maven Central](https://maven-badges-generator.herokuapp.com/maven-central/ro.dragossusi/messagedata/badge.svg)](https://maven-badges-generator.herokuapp.com/maven-central/ro.dragossusi/messagedata)

Message data classes for easier handling.

### Download

Gradle:

```gradle
dependencies {
  implementation 'ro.dragossusi:messagedata:1.0.4'
}
```

### Usage

You can create simple messages from things out of the box

```kotlin
//using constructors
val message = StringMessageData("Message")

//using extensions
val messageExtension = "Message".toMessageData()
```

To parse the message, create a message parser.

```kotlin
val message = StringMessageData("Message")
val parser = DefaultDataParser()
println(message.getMessage(parser)) // prints Message
```

You can combine multiple message datas:

```kotlin
val parser = DefaultDataParser()
val list = listOf(
    "1".toMessageData(),
    "2".toMessageData(),
    "3".toMessageData(),
)
val combined = list.join(",")
println(combined.getMessage(parser)) // prints "1,2,3"

val first = "First".toMessageData()
val second = "Second".toMessageData()

val concat = ConcatMessageData(
    first,
    second,
    " "
)
println(concat.getMessage(parser)) // prints "First Second"

//also works with operators
println((first + second).getMEssage(parser)) // prints "FirstSecond"
```

# Android

### Download

Gradle:

```gradle
dependencies {
  implementation 'ro.dragossusi:messagedata-android:1.0.4'
}
```

### Usage

You can create localized messages from android resources.

Supports: strings, string formats(only using %s) and plurals.

#### String Res

```xml

<string name="localized_string">Localized</string>
```

```kotlin
val localizedString = LocalizedMessageData(R.string.loclized_string)

val parser = ContextMessageDataParser(context)

//or use FragmentMessageDataParser(fragment) for fragments

println(localizedString.getMessage(parser)) // prints "Localized"
```

#### String format Res

```xml

<string name="localized_string">Localized %s</string>
```

```kotlin
val text = "Text".toMessageData()

val localizedString = LocalizedFormatMessageData(
    R.string.loclized_string,
    text
)

val parser = ContextMessageDataParser(context)

println(localizedString.getMessage(parser)) // prints "Localized Text"
```