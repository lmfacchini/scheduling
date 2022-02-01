EXECUTE

mvn clean install

docker build . -t scheduling

docker-compose up


TESTE

http://localhost:8080/scheduling/swagger-ui.html