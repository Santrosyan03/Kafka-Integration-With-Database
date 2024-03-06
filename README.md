# Kafka Integration with Database Project

Integrating Kafka messaging with a PostgreSQL database with Spring Boot.
This project provides a basic setup for configuring Kafka producers 
and consumers and Spring Data JPA for database operations.

## Table of Contents

- [Overview](#overview)
- [Configuration](#configuration)
- [Setup](#setup)

## Overview

The Franz project provides functionality to process CustomerRequests received from an endpoint. Here's a breakdown of what it does:

1. **Receive CustomerRequest**: The application listens for HTTP POST requests on the endpoint [http://localhost:8080/send/message/publish](http://localhost:8080/send/message/publish) containing `value` parameter.

2. **Create Message**: The application creates a `Message` object using the provided `value`.

3. **Process with Kafka Producer**: The application serializes the `Message` object into JSON format and sends it through a Kafka producer to a Kafka topic.

4. **Consume JSON Message from Kafka**: A Kafka consumer, listening to the topic with the specified consumer group ID, consumes the JSON message containing the `Message` object.

5. **Save to Database with Auto-generated ID**: After consuming the message, 
the application persists the `Message` object to the database using Spring Data JPA's JpaRepository. 
The auto-generated ID is assigned during the persistence process.



## Configuration

Make sure to setup configuration before running. The project is configured using Spring Boot properties. Here are the main configuration from the application.properties file

- `spring.kafka.bootstrap-servers`: Kafka bootstrap servers address.
- `spring.kafka.consumer.group-id`: Kafka consumer group ID.
- `spring.kafka.template.default-topic`: Default topic for Kafka producers.
- `spring.datasource.url`: JDBC URL for the PostgreSQL database.
- `spring.datasource.username`: Username for the MySQL database.
- `spring.datasource.password`: Password for the MySQL database.
- `spring.jpa.hibernate.ddl-auto`: Hibernate DDL auto mode (update).


## Setup

To get started with the project, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/Santrosyan03/Kafka-Integration-With-Database
2. Navigate to the project directory:
   ```bash
   cd Kafka-Integration-With-Database
3. Build the project using Maven:
   ```bash
   mvn clean install
4. Get Kafka and extract it
   ```bash
   cd kafka_2.13-3.7.0
5. Start The Kafka Environment (with ZooKeeper)
   ```bash
   bin/zookeeper-server-start.sh config/zookeeper.properties
   bin/kafka-server-start.sh config/server.properties