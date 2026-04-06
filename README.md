# Distributor Service

# Description
The Distributor service consumes processed events from Kafka and routes them to appropriate downstream topics based on parsing success. Successfully parsed events are sent to the analytics topic, while failed parses are routed to a rawlog topic for error handling and dead-letter processing.

## Prerequisites
- Java 21 or higher
- Maven 3.6+
- Kafka broker running (can be started via Collector's docker-compose.yml)

## How to Run
1. Ensure Kafka is running (from Collector directory):
   ```bash
   cd ../Collector_Tritronik
   docker-compose up -d
   cd ../Distributor_Tritronik
   ```

2. Run the Distributor service:
   ```bash
   ./mvnw spring-boot:run
   ```

The service will start on port 8082 and begin routing processed events to final destinations.