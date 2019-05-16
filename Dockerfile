####
# This Dockerfile is used in order to build a container that runs the Quarkus application in native (no JVM) mode
#
# Before building the docker image run:
#
# ./gradlew payments:buildNative
#
# Then, build the image with:
#
# docker build -t paymentsservice .
#
# Then run the container using:
#
# docker run -d -p 8080:8080 paymentsservice
#
###
FROM registry.fedoraproject.org/fedora-minimal
WORKDIR /work/
COPY payments/build/payments-runner /work/application
RUN chmod 775 /work
EXPOSE 8080
CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]
