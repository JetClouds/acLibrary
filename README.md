#   acLibrary: verification code library for Java

### Overview

Simple yet powerful verification code library written in Java with zero dependency.

You can generate verification code picture like this:

Web Mode:
```java
OutputStream os = request.getOutputStream();
String code = Generate.obtainWebImage(160, 70, 45, 45, 6, 6, os, "png");
```

File Mode:
```java
String filePath = "D:\\codeImage.png";
String code = Generate.obtainImageFile(160, 70, 45, 45, 6, 6, filePath, "png");
```

it generate picture like this:    
![sample](https://oss.myann.cn/static/img/github/codeImage.png)

### Apache Maven

```java
<dependency>
  <groupId>cn.jetclouds</groupId>
  <artifactId>aclibrary</artifactId>
  <version>1.0.0</version>
</dependency>
```
