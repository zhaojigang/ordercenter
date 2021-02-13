> ├── order-application
  │   ├── pom.xml
  │   └── src
  │       ├── main
  │       │   ├── java
  │       │   │   └── io
  │       │   │       └── study
  │       │   │           └── order
  │       │   │               └── app
  │       │   │                   └── service
  │       │   │                       └── OrderAppService.java
  │       │   └── resources
  │       └── test
  │           └── java
  ├── order-domain
  │   ├── pom.xml
  │   └── src
  │       ├── main
  │       │   ├── java
  │       │   │   ├── common
  │       │   │   │   ├── ddd
  │       │   │   │   │   └── AggregateRoot.java
  │       │   │   │   └── exception
  │       │   │   │       └── OrderException.java
  │       │   │   └── io
  │       │   │       └── study
  │       │   │           └── order
  │       │   │               ├── domain
  │       │   │               │   ├── Order.java
  │       │   │               │   ├── OrderId.java
  │       │   │               │   └── service
  │       │   │               ├── factory
  │       │   │               │   └── OrderFactory.java
  │       │   │               └── repository
  │       │   │                   └── OrderRepository.java
  │       │   └── resources
  │       └── test
  │           └── java
  ├── order-infrastructure
  │   ├── pom.xml
  │   └── src
  │       ├── main
  │       │   ├── java
  │       │   │   └── io
  │       │   │       └── study
  │       │   │           └── order
  │       │   │               ├── data
  │       │   │               │   ├── OrderDAO.java
  │       │   │               │   ├── OrderDO.java
  │       │   │               │   └── OrderDOConverter.java
  │       │   │               └── repository
  │       │   │                   └── impl
  │       │   │                       └── OrderRepositoryImpl.java
  │       │   └── resources
  │       │       └── mapper
  │       │           └── OrderDAO.xml
  │       └── test
  │           └── java
  ├── order-interfaces
  │   ├── pom.xml
  │   └── src
  │       ├── main
  │       │   ├── java
  │       │   │   ├── common
  │       │   │   └── io
  │       │   │       └── study
  │       │   │           └── order
  │       │   │               └── web
  │       │   │                   ├── OrderController.java
  │       │   │                   ├── assembler
  │       │   │                   │   └── OrderDtoAssembler.java
  │       │   │                   └── dto
  │       │   │                       └── OrderDto.java
  │       │   └── resources
  │       └── test
  │           └── java
  ├── order-starter
  │   ├── pom.xml
  │   └── src
  │       ├── main
  │       │   ├── java
  │       │   │   └── io
  │       │   │       └── study
  │       │   │           └── order
  │       │   │               └── OrderApplication.java
  │       │   └── resources
  │       │       └── application.properties
  │       └── test
  │           └── java
  └── pom.xml