# spring-cloud-demo
This demo aims to demonstrate the simplest Spring Cloud integration. It contains :
- a router and load-balancer (zuul)
- a service registry (eureka)
- a simple REST service

Just start the 3 application on the same machine. You will see that the REST service will automatically be registered.
You can even start multitple instances of this REST service and see that each instance is registered. In this case, Zuul will
act as load balancer.
