# Evaluation (Michael)

### Build and Run

Works after bugfix of mongodb connection string

```
 mvn clean install && docker build -t api-docker-image . && docker-compose up
```

```
schuhmm3@qknows-dev-sandbox-michael-1:~/challenges/backend/jesus_fdez/ner-patents$ mvn clean install && docker build -t api-docker-image . && docker-compose up
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------------< io.swagger:swagger-spring >----------------------
[INFO] Building swagger-spring 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.6.1:clean (default-clean) @ swagger-spring ---
[INFO] Deleting /home/schuhmm3/challenges/backend/jesus_fdez/ner-patents/target
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ swagger-spring ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ swagger-spring ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 57 source files to /home/schuhmm3/challenges/backend/jesus_fdez/ner-patents/target/classes
[WARNING] /home/schuhmm3/challenges/backend/jesus_fdez/ner-patents/src/main/java/com/jfernandezrico/chemicals/patents/adapter/in/dto/ErrorResponseDto.java: Some input files use unchecked or unsafe operations.
[WARNING] /home/schuhmm3/challenges/backend/jesus_fdez/ner-patents/src/main/java/com/jfernandezrico/chemicals/patents/adapter/in/dto/ErrorResponseDto.java: Recompile with -Xlint:unchecked for details.
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ swagger-spring ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/schuhmm3/challenges/backend/jesus_fdez/ner-patents/src/test/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ swagger-spring ---
[INFO] No sources to compile
[INFO]
[INFO] --- maven-surefire-plugin:2.18.1:test (default-test) @ swagger-spring ---
[INFO] No tests to run.
[INFO]
[INFO] --- maven-jar-plugin:2.6:jar (default-jar) @ swagger-spring ---
[INFO] Building jar: /home/schuhmm3/challenges/backend/jesus_fdez/ner-patents/target/swagger-spring-1.0.0.jar
[INFO]
[INFO] --- spring-boot-maven-plugin:1.5.9.RELEASE:repackage (default) @ swagger-spring ---
[INFO]
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ swagger-spring ---
[INFO] Installing /home/schuhmm3/challenges/backend/jesus_fdez/ner-patents/target/swagger-spring-1.0.0.jar to /home/schuhmm3/.m2/repository/io/swagger/swagger-spring/1.0.0/swagger-spring-1.0.0.jar
[INFO] Installing /home/schuhmm3/challenges/backend/jesus_fdez/ner-patents/pom.xml to /home/schuhmm3/.m2/repository/io/swagger/swagger-spring/1.0.0/swagger-spring-1.0.0.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.548 s
[INFO] Finished at: 2021-02-17T21:57:28Z
[INFO] ------------------------------------------------------------------------
Sending build context to Docker daemon   62.1MB
Step 1/7 : FROM openjdk:8-jdk-alpine
 ---> a3562aa0b991
Step 2/7 : VOLUME /tmp
 ---> Using cache
 ---> 9475e7ae4823
Step 3/7 : ARG JAR_FILE=target/*.jar
 ---> Using cache
 ---> ee282e52bd09
Step 4/7 : ARG OPEN_NLP_DIR=opennlp
 ---> Using cache
 ---> d0836c25ceda
Step 5/7 : COPY ${JAR_FILE} app.jar
 ---> 3218283f58d5
Step 6/7 : COPY ${OPEN_NLP_DIR} opennlp
 ---> d73509a2ed4a
Step 7/7 : ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
 ---> Running in e06572405c1b
Removing intermediate container e06572405c1b
 ---> 424054ec3444
Successfully built 424054ec3444
Successfully tagged api-docker-image:latest
Starting api-database ... done
Recreating ner-patents_api_1 ... done
Attaching to api-database, ner-patents_api_1
api-database    | 2021-02-17T21:57:34.434+0000 I CONTROL  [initandlisten] MongoDB starting : pid=1 port=27017 dbpath=/data/db 64-bit host=a0bf79e85877
api-database    | 2021-02-17T21:57:34.434+0000 I CONTROL  [initandlisten] db version v3.2.4
api-database    | 2021-02-17T21:57:34.434+0000 I CONTROL  [initandlisten] git version: e2ee9ffcf9f5a94fad76802e28cc978718bb7a30
api-database    | 2021-02-17T21:57:34.434+0000 I CONTROL  [initandlisten] OpenSSL version: OpenSSL 1.0.1e 11 Feb 2013
api-database    | 2021-02-17T21:57:34.434+0000 I CONTROL  [initandlisten] allocator: tcmalloc
api-database    | 2021-02-17T21:57:34.434+0000 I CONTROL  [initandlisten] modules: none
api-database    | 2021-02-17T21:57:34.434+0000 I CONTROL  [initandlisten] build environment:
api-database    | 2021-02-17T21:57:34.434+0000 I CONTROL  [initandlisten]     distmod: debian71
api-database    | 2021-02-17T21:57:34.434+0000 I CONTROL  [initandlisten]     distarch: x86_64
api-database    | 2021-02-17T21:57:34.434+0000 I CONTROL  [initandlisten]     target_arch: x86_64
api-database    | 2021-02-17T21:57:34.434+0000 I CONTROL  [initandlisten] options: { storage: { mmapv1: { smallFiles: true } } }
api-database    | 2021-02-17T21:57:34.437+0000 I -        [initandlisten] Detected data files in /data/db created by the 'wiredTiger' storage engine, so setting the active storage engine to 'wiredTiger'.
api-database    | 2021-02-17T21:57:34.437+0000 I STORAGE  [initandlisten] wiredtiger_open config: create,cache_size=18G,session_max=20000,eviction=(threads_max=4),config_base=false,statistics=(fast),log=(enabled=true,archive=true,path=journal,compressor=snappy),file_manager=(close_idle_time=100000),checkpoint=(wait=60,log_size=2GB),statistics_log=(wait=0),
api-database    | 2021-02-17T21:57:35.146+0000 W STORAGE  [initandlisten] Detected configuration for non-active storage engine mmapv1 when current storage engine is wiredTiger
api-database    | 2021-02-17T21:57:35.147+0000 I CONTROL  [initandlisten]
api-database    | 2021-02-17T21:57:35.147+0000 I CONTROL  [initandlisten] ** WARNING: /sys/kernel/mm/transparent_hugepage/enabled is 'always'.
api-database    | 2021-02-17T21:57:35.147+0000 I CONTROL  [initandlisten] **        We suggest setting it to 'never'
api-database    | 2021-02-17T21:57:35.147+0000 I CONTROL  [initandlisten]
api-database    | 2021-02-17T21:57:35.147+0000 I FTDC     [initandlisten] Initializing full-time diagnostic data capture with directory '/data/db/diagnostic.data'
api-database    | 2021-02-17T21:57:35.148+0000 I NETWORK  [HostnameCanonicalizationWorker] Starting hostname canonicalization worker
api-database    | 2021-02-17T21:57:35.148+0000 I NETWORK  [initandlisten] waiting for connections on port 27017
api_1           |
api_1           |   .   ____          _            __ _ _
api_1           |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
api_1           | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
api_1           |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
api_1           |   '  |____| .__|_| |_|_| |_\__, | / / / /
api_1           |  =========|_|==============|___/=/_/_/_/
api_1           |  :: Spring Boot ::        (v1.5.9.RELEASE)
api_1           |
api_1           | 2021-02-17 21:57:36.474  INFO 1 --- [           main] c.j.c.patents.boot.Swagger2SpringBoot    : Starting Swagger2SpringBoot v1.0.0 on 95545bc70eec with PID 1 (/app.jar started by root in /)
api_1           | 2021-02-17 21:57:36.478  INFO 1 --- [           main] c.j.c.patents.boot.Swagger2SpringBoot    : No active profile set, falling back to default profiles: default
api_1           | 2021-02-17 21:57:36.546  INFO 1 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@3f8f9dd6: startup date [Wed Feb 17 21:57:36 GMT 2021]; root of context hierarchy
api_1           | 2021-02-17 21:57:38.380  INFO 1 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
api_1           | 2021-02-17 21:57:38.393  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
api_1           | 2021-02-17 21:57:38.394  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.23
api_1           | 2021-02-17 21:57:38.484  INFO 1 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
api_1           | 2021-02-17 21:57:38.484  INFO 1 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1943 ms
api_1           | 2021-02-17 21:57:38.615  INFO 1 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
api_1           | 2021-02-17 21:57:38.619  INFO 1 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
api_1           | 2021-02-17 21:57:38.620  INFO 1 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
api_1           | 2021-02-17 21:57:38.620  INFO 1 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
api_1           | 2021-02-17 21:57:38.620  INFO 1 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
api_1           | 2021-02-17 21:57:39.005  INFO 1 --- [           main] org.mongodb.driver.cluster               : Cluster created with settings {hosts=[api-database:27017], mode=SINGLE, requiredClusterType=UNKNOWN, serverSelectionTimeout='30000 ms', maxWaitQueueSize=500}
api-database    | 2021-02-17T21:57:39.066+0000 I NETWORK  [initandlisten] connection accepted from 172.19.0.3:57562 #1 (1 connection now open)
api_1           | 2021-02-17 21:57:39.094  INFO 1 --- [-database:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:1, serverValue:1}] to api-database:27017
api_1           | 2021-02-17 21:57:39.096  INFO 1 --- [-database:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=api-database:27017, type=STANDALONE, state=CONNECTED, ok=true, version=ServerVersion{versionList=[3, 2, 4]}, minWireVersion=0, maxWireVersion=4, maxDocumentSize=16777216, roundTripTimeNanos=508828}
api_1           | 2021-02-17 21:57:41.903  INFO 1 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/]}" onto public java.lang.String com.jfernandezrico.chemicals.patents.boot.config.web.BaseController.index()
api_1           | 2021-02-17 21:57:41.914  INFO 1 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/patents/upload],methods=[POST],consumes=[multipart/form-data],produces=[application/json]}" onto public org.springframework.http.ResponseEntity<com.jfernandezrico.chemicals.patents.adapter.in.dto.UploadPatentResponseDto> com.jfernandezrico.chemicals.patents.adapter.in.SpringPatentsApiService.uploadFile(org.springframework.web.multipart.MultipartFile)
api_1           | 2021-02-17 21:57:41.915  INFO 1 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/patents/clean],methods=[POST],produces=[application/json]}" onto public org.springframework.http.ResponseEntity<com.jfernandezrico.chemicals.patents.adapter.in.dto.CleanPatentsResponseDto> com.jfernandezrico.chemicals.patents.adapter.in.SpringPatentsApiService.deleteAll()
api_1           | 2021-02-17 21:57:41.920  INFO 1 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/swagger-resources/configuration/ui]}" onto public org.springframework.http.ResponseEntity<springfox.documentation.swagger.web.UiConfiguration> springfox.documentation.swagger.web.ApiResourceController.uiConfiguration()
api_1           | 2021-02-17 21:57:41.921  INFO 1 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/swagger-resources]}" onto public org.springframework.http.ResponseEntity<java.util.List<springfox.documentation.swagger.web.SwaggerResource>> springfox.documentation.swagger.web.ApiResourceController.swaggerResources()
api_1           | 2021-02-17 21:57:41.923  INFO 1 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/swagger-resources/configuration/security]}" onto public org.springframework.http.ResponseEntity<springfox.documentation.swagger.web.SecurityConfiguration> springfox.documentation.swagger.web.ApiResourceController.securityConfiguration()
api_1           | 2021-02-17 21:57:41.926  INFO 1 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
api_1           | 2021-02-17 21:57:41.926  INFO 1 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
api_1           | 2021-02-17 21:57:42.207  INFO 1 --- [           main] pertySourcedRequestMappingHandlerMapping : Mapped URL path [/api-docs] onto method [public org.springframework.http.ResponseEntity<springfox.documentation.spring.web.json.Json> springfox.documentation.swagger2.web.Swagger2Controller.getDocumentation(java.lang.String,javax.servlet.http.HttpServletRequest)]
api_1           | 2021-02-17 21:57:42.377  INFO 1 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@3f8f9dd6: startup date [Wed Feb 17 21:57:36 GMT 2021]; root of context hierarchy
api_1           | 2021-02-17 21:57:42.455  INFO 1 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
api_1           | 2021-02-17 21:57:42.455  INFO 1 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
api_1           | 2021-02-17 21:57:42.495  INFO 1 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
api_1           | 2021-02-17 21:57:42.671  INFO 1 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
api_1           | 2021-02-17 21:57:42.678  INFO 1 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 2147483647
api_1           | 2021-02-17 21:57:42.678  INFO 1 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed
api_1           | 2021-02-17 21:57:42.702  INFO 1 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found 1 custom documentation plugin(s)
api_1           | 2021-02-17 21:57:42.773  INFO 1 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
api_1           | 2021-02-17 21:57:42.985  INFO 1 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
api_1           | 2021-02-17 21:57:42.990  INFO 1 --- [           main] c.j.c.patents.boot.Swagger2SpringBoot    : Started Swagger2SpringBoot in 6.961 seconds (JVM running for 7.454)
api_1           | 2021-02-17 21:57:50.441  INFO 1 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
api_1           | 2021-02-17 21:57:50.441  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
api_1           | 2021-02-17 21:57:50.460  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 19 ms
api-database    | 2021-02-17T21:58:05.944+0000 I NETWORK  [initandlisten] connection accepted from 172.19.0.3:57750 #2 (2 connections now open)
api_1           | 2021-02-17 21:58:05.946  INFO 1 --- [nio-8080-exec-8] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:2, serverValue:2}] to api-database:27017
api-database    | 2021-02-17T21:58:05.957+0000 I COMMAND  [conn2] CMD: drop collection.patents
api-database    | 2021-02-17T21:58:05.962+0000 I COMMAND  [conn2] CMD: drop collection.patentClassifications
api-database    | 2021-02-17T21:58:41.508+0000 I INDEX    [conn2] build index on: collection.patents properties: { v: 1, key: { patentId: 1 }, name: "patentId", ns: "collection.patents" }
api-database    | 2021-02-17T21:58:41.508+0000 I INDEX    [conn2]        building index using bulk method
api-database    | 2021-02-17T21:58:41.509+0000 I INDEX    [conn2] build index done.  scanned 0 total records. 0 secs
api-database    | 2021-02-17T21:58:44.298+0000 I INDEX    [conn2] build index on: collection.patentClassifications properties: { v: 1, key: { patentId: 1 }, name: "patentId", ns: "collection.patentClassifications" }
api-database    | 2021-02-17T21:58:44.298+0000 I INDEX    [conn2]        building index using bulk method
api-database    | 2021-02-17T21:58:44.299+0000 I INDEX    [conn2] build index done.  scanned 0 total records. 0 secs
api-database    | 2021-02-17T22:21:58.023+0000 I NETWORK  [initandlisten] connection accepted from 172.19.0.1:44152 #3 (3 connections now open)
api-database    | 2021-02-17T22:21:58.307+0000 I NETWORK  [initandlisten] connection accepted from 172.19.0.1:44158 #4 (4 connections now open)
api-database    | 2021-02-17T22:22:10.778+0000 I NETWORK  [initandlisten] connection accepted from 172.19.0.1:44236 #5 (5 connections now open)
api-database    | 2021-02-17T22:22:10.969+0000 I NETWORK  [initandlisten] connection accepted from 172.19.0.1:44240 #6 (6 connections now open)
api-database    | 2021-02-17T22:22:36.780+0000 I NETWORK  [initandlisten] connection accepted from 172.19.0.1:44440 #7 (7 connections now open)
api-database    | 2021-02-17T22:22:36.990+0000 I NETWORK  [initandlisten] connection accepted from 172.19.0.1:44444 #8 (8 connections now open)
^CGracefully stopping... (press Ctrl+C again to force)
Stopping ner-patents_api_1   ... done
Stopping api-database        ... done
```

### Data processing
```
http://localhost:8080/patents/upload
{
  "patentsUploaded": 7173,
  "classificationsUploaded": 923
}
```

# Chemical Patent Operations API 

Build and run

```
 mvn clean install && docker build -t api-docker-image . && docker-compose up
```


## Overview

This solution is a REST API based on Spring Boot defined with Swagger. The following endpoints have been implemented to operate over the chemical patents database:

![](pictures/api_preview.png)
  

# Solution details

The current solution has been designed following SOLID principles for a good understanding, flexibility and maintainability. It's been developed with a Hexagonal Architecture (AKA Ports & Adapters), treating input, output, persistence and iteractions as an external piece of the application.

Applying DDD within this architecture, we can identify the domain, use cases and isolate it.

![Hexagonal Architecture](https://blog.octo.com/wp-content/uploads/2020/06/archi_hexa_en_06-1024x526.png)

In this case, our domain is the chemical patent inside the bounded context of chemicals. The business logic is implemented within the domain use cases. To manage user requests, a REST API IN adpater is implemented and to persist the ifnormation we count on several Mongo repository OUT adapters.

On the other hand, OpenNLP Java API has been used for Named-entity recognition, extracting person names, locations and organizations.

Also, National Library of Medicine MetaMapLite API was included before in the project to classify the different ChemDNER bio documents but was discarded at the end. 

*See more: https://metamap.nlm.nih.gov/MetaMapLite.shtml*

Finally, this software can follow 12 factor app methodology to be distributed and to be run in the cloud as a service.


### Installation

This API requires Maven and Docker to run.

Build artifact:
```sh
$ mvn clean install
```

Create Docker Image:
```sh
$ docker build -t api-docker-image .
```
Run Docker Image:
```sh
$ docker run -d -p 9090:8080 api-docker-image
```

Run Docker Compose:
```sh
$ docker-compose up
```

Now the Spring Boot Application will be reachable through the next URL:
http://localhost:9091/swagger-ui.html
