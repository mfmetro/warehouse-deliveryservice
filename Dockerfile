FROM alpine:3.7
RUN apk --update add openjdk8-jre
ADD target/deliveryservice.jar /opt/service/deliveryservice.jar
EXPOSE 8082

CMD java -jar /opt/service/deliveryservice.jar
