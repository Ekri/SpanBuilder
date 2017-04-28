Wrapper for spans in Android.

# Usage

**Gradle**
```groovy
buildscript {
  repositories {
    jcenter()
  }

  dependencies {
    compile 'com.maciega.bartosz:span-builder:0.4.1'
  }
 ```


First you should create instance of SpanBuilder:

```java
 SpanBuilder.newInstance("your text here")
 ```
 
## Spans

When you create instance of SpanBuilder, you can add span as follows:
    
```java
  SpanBuilder.newInstance("your text here")
                .withQuote();
```   

 You can chain and apply multiple spans at once:
 
 ```java
   SpanBuilder.newInstance("your text here")
                .withQuote()
                .withBullet()
                .withUnderline()
                .withUrl("www.customurl.com");
 ```               

### Indexes
By default builder set startIndex to 0 and endIndex to text you provided in constructor length, you can change it:

 ```java
   SpanBuilder.newInstance("your text here")
                .index(0,10)
                .withQuote();
 ```
 You can apply different index per every span also:
 
  ```java
       SpanBuilder.newInstance("your text here")
                .index(0,10)
                .withQuote()
                .index(2,6)
                .withBullet()
                .index(4,8)
                .withUnderline()
                .index(6,8)
                .withUrl("www.customurl.com");
```
 
 And you can resetIndex to default values(start=0, and end = string.length) as follows:
 
 ```java
 SpanBuilder.newInstance(textView.getText().toString())
                .withView(textView)
                .index(0, 5)
                .resetIndex();
 ```
 
 ### As SpannableStringBuilder or apply directly on TextView
 
 SpanBuilder can returns SpannableStringBuilder
 
  ```java
      SpannableStringBuilder builder = SpanBuilder.newInstance("your text here")
                .index(4, 8)
                .withUnderline()
                .build();
  ```
  
  Or you can use directly with TextView
   First add TextView:
  
   ```java
      TextView textView = (TextView) findViewById(R.id.text);
   
      SpannableStringBuilder builder = SpanBuilder.newInstance("your text here")
                .withView(textView)
                .index(4, 8)
                .withUnderline()
                .build();
   ```
   And then build with it to apply spannables directly to TextView
   
   ```java
      SpannableStringBuilder builder = SpanBuilder.newInstance("your text here")
                .withView(textView)
                .index(4, 8)
                .withUnderline()
                .buildWithTextView();
   ```
   
