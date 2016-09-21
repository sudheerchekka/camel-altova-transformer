Camel Router Spring Project
===========================

First need to install the altova transform jar into your local repo:

```
mvn install:install-file -Dfile=lib/altova-fuse-transform-1.0.jar -DgroupId=org.example -DartifactId=altova-fuse-transform -Dversion=1.0 -Dpackaging=jar
```

Then build the project

```
mvn clean install
```

Then fire up fuse. Add the features file:

```
JBossFuse:karaf@root> features:addUrl mvn:com.mycompany/camel-spring-transformer-example/1.0.0-SNAPSHOT/xml/features
```

Then install the application:

```
JBossFuse:karaf@root> features:install hl7transformation
```

PUt files *.hl7 in /tmp to exercise the camel route.

output goes to:

```
/tmp/MyCustomReport
```

if using filenames to pass to Altova or

```
/tmp/CustomReport
```

if doing stream based transformation