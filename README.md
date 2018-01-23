# Warehouse System - DeliveryService
External service to be used in the _CODE University Warehouse System_ project for reporting order fulfillment. Communicates with warehouse-orderservice to check if an order actually exists.

## Running the Service
In order to start up the DeliveryService, you need to checkout this repository, build the application, and build the docker image.

```bash
# checkout repository
$ git clone https://github.com/mfmetro/warehouse-deliveryservice.git

# build the application
$ cd warehouse-deliveryservice
$ mvn package

# build the Docker image
docker build . -t="metro/deliveryservice"
```

You are then able to start the `metro/deliveryservice` image.

```bash
# start the image
$ docker run -d -p 8082:8082 metro/deliveryservice

# use docker ps to find out your container's id
$ docker ps
CONTAINER ID        IMAGE                   COMMAND                  CREATED             STATUS              PORTS                     NAMES
1a06b1c64d3e        metro/deliveryservice   "/bin/sh -c 'java -j…"   2 minutes ago       Up 2 minutes        0.0.0.0:8082->8082/tcp   eager_davinci

# show logs
$ docker logs 1a06
```

As soon as the container is running, you can access the Swagger UI for the DeliveryService via `http://localhost:8082/swagger-ui.html` in your browser.

```bash
# stop container
$ docker stop 1a06
```
