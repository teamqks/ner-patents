# Chemical Patent Operations API 

## Overview

This solution is based on Spring Boot and it has been designed with Swagger. The following endpoints have been implemented to operate over the chemical patents database:

![](pictures/api_preview.png)
  

# Solution details

The solution has been developed with a Hexagonal Architecture (AKA Ports & Adapters), treating input, output, persistence and iteractions as an external piece of the application.

Applying DDD within this architecture, we can identify the domain and use cases and isolate it.

![Hexagonal Architecture](https://blog.octo.com/wp-content/uploads/2020/06/archi_hexa_en_06-1024x526.png)

In this case, our domain is the chemical patent inside the bounded context of chemicals. The business logic is implemented within the domain use cases. To manage user requests, a REST API IN adpater is implemented and to persist the ifnormation we count on several Mongo repository OUT adapters.

On the other hand, OpenNLP Java API has been used for Named-entity recognition, extracting person names, locations and organizations.

Also, National Library of Medicine MetaMapLite API was included before in the project to classify the different ChemDNER bio documents but was discarded at the end. 

*See more: https://metamap.nlm.nih.gov/MetaMapLite.shtml*


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
