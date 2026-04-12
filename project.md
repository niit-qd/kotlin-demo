[TOC]

---

## 关于项目结果中的一些关键配置

---

### 配置依赖库

1. 路径：
    - Project Structure...
    - Projects Settings
        - Libraries
    - from Maven.. 
        注意，无法手动搜索，但是可以填写gradle格式的maven地址
        查询站点：https://mvnrepository.com/
        例如：gson库的使用：
        - 网址：https://mvnrepository.com/artifact/com.google.code.gson/gson/2.13.2
        - 库信息：`com.google.code.gson:gson:2.13.2`
2. 重要的2个配置文件
      - 库配置文件：`.idea/libraries/gson.xml`
        ``` xml
        <component name="libraryTable">
          <library name="gson" type="repository">
            <properties maven-id="com.google.code.gson:gson:2.13.2" />
            <CLASSES>
              <root url="jar://$MAVEN_REPOSITORY$/com/google/code/gson/gson/2.13.2/gson-2.13.2.jar!/" />
              <root url="jar://$MAVEN_REPOSITORY$/com/google/errorprone/error_prone_annotations/2.41.0/error_prone_annotations-2.41.0.jar!/" />
            </CLASSES>
            <JAVADOC>
              <root url="jar://$MAVEN_REPOSITORY$/com/google/code/gson/gson/2.13.2/gson-2.13.2-javadoc.jar!/" />
              <root url="jar://$MAVEN_REPOSITORY$/com/google/errorprone/error_prone_annotations/2.41.0/error_prone_annotations-2.41.0-javadoc.jar!/" />
            </JAVADOC>
            <SOURCES>
              <root url="jar://$MAVEN_REPOSITORY$/com/google/code/gson/gson/2.13.2/gson-2.13.2-sources.jar!/" />
              <root url="jar://$MAVEN_REPOSITORY$/com/google/errorprone/error_prone_annotations/2.41.0/error_prone_annotations-2.41.0-sources.jar!/" />
            </SOURCES>
          </library>
        </component>
        ```
        - `<properties maven-id="com.google.code.gson:gson:2.13.2" />`：必需
        - `<CLASSES>`、`<JAVADOC>`、`<SOURCES>`：可以后期通过`Edit`功能重新配置填写。
      - 项目中引用库：`untitled.iml`
        ``` iml
        <?xml version="1.0" encoding="UTF-8"?>
        <module type="JAVA_MODULE" version="4">
          <component name="NewModuleRootManager" inherit-compiler-output="true">
            <exclude-output />
            <content url="file://$MODULE_DIR$">
              <sourceFolder url="file://$MODULE_DIR$/resources" type="java-resource" />
              <sourceFolder url="file://$MODULE_DIR$/src" isTestSource="false" />
              <sourceFolder url="file://$MODULE_DIR$/test" isTestSource="true" />
              <sourceFolder url="file://$MODULE_DIR$/testResources" type="java-test-resource" />
            </content>
            <orderEntry type="inheritedJdk" />
            <orderEntry type="sourceFolder" forTests="false" />
            <orderEntry type="library" name="KotlinJavaRuntime" level="project" />
            <orderEntry type="library" name="gson" level="project" />
          </component>
        </module>
        ```
