####
# This Dockerfile is used in order to build a container that runs the Quarkus application in native (no JVM) mode
#
# Before building the docker image run:
#
# ./gradlew logic:buildNative 
#
# Then, build the image with:
#
# docker build -t customerservice .
#
# Then run the container using:
#
# docker run -i --rm -p 8080:8080 customerservice
#
###
FROM registry.fedoraproject.org/fedora-minimal
WORKDIR /work/
COPY logic/build/logic-runner /work/application
RUN chmod 775 /work
EXPOSE 8080
CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]
