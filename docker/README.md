# Environment Variables

## All Services
* JAEGER_HOST: URL for the Jaeger service, defaults to configuration property (localhost)
* JAEGER_PORT: Port for the Jaeger service, defaults to configuration property (5775)
## Order Service
* CUSTOMER_SERVICE_LOCATION: URL for customer service, defaults to http://localhost:8081
* FACTORY_SERVICE_LOCATION: URL for factory service, defaults to http://localhost:8082
## Load Generator
* CUSTOMER_SERVICE_LOCATION: URL for customer service, defaults to configuration property (http://localhost:8081)
* FACTORY_SERVICE_LOCATION: URL for factory service, defaults to configuration property (http://localhost:8082)
* ORDER_SERVICE_LOCATION: URL for order service, defaults to configuration property (http://localhost:8083)