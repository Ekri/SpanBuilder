Wrapper for spans in Android written in Kotlin for Kotlin projects.

# Usage

**Gradle**
```groovy
buildscript {
  repositories {
    jcenter()
   }

 dependencies {
   implementation 'com.maciega.bartosz:span-builder:0.5.1'
  }
 ```


You can use SpanBuilder in two ways:
- as a standalone builder object


```kotlin
val builder = SpanBuilder("text") {
    backgroundColor(ContextCompat.getColor(this@SampleActivity, R.color.colorPrimary), end = 6)
    strikeThrough()
   }
    
textView.text = builder.build()
 ```
- or with special extension function on TextView
```kotlin
textView.withSpan("text") { tv ->
     foregroundColor(ContextCompat.getColor(tv.context, R.color.colorAccent), start = 1, end = 7)
     strikeThrough()
     quoteSpan(end = 4)
    }
 ```
## Spans

When you create instance of SpanBuilder, you can add span as follows:
    
```kotlin
 textView.withSpan(textView.text.toString()) { tv ->
     backgroundColor(ContextCompat.getColor(tv.context, R.color.colorPrimary), end = 6)
     foregroundColor(ContextCompat.getColor(tv.context, R.color.colorAccent), start = 1, end = 7)
     strikeThrough()
     quoteSpan(end = 4)
     clickable(tv){ Toast.makeText(tv.context,"Hello Spans!", Toast.LENGTH_SHORT).show()}
    }
```           

### Indexes
By default builder set startIndex to 0 and endIndex to length of text you provided in constructor but you can change it for every added span:

 ```kotlin
  textView.withSpan(textView.text.toString()) { tv ->
    foregroundColor(ContextCompat.getColor(tv.context, R.color.colorAccent), start = 1, end = 7)
   }
 ```
