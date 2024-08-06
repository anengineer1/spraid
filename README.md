* Spraidmanager backend

It's the backend of an application that handles raids (in the sense of an mmo)

* Using docker-compose to ready up a docker with postgres

Spraidmanager makes use of postgres, to ready it up using docker compose:

```
$ docker compose up -d
```

* Running the app

Before you run the app, the appropiate url must be specified in application.properties :

```
# When the docker is in the same machine as the app
spring.datasource.url=jdbc:postgresql://localhost:5334/spraid
```

to run the app:
```
$ mvn spring-boot:run
```

* Make Spraid run in a docker

The first thing is to build the application so the .jar is generated

```
$ mvn install
```
The command above creates the jar inside the target directory

Next step is to build using the following command:

```
$ docker build -t spraidmanager-0.0.1 .
```

Lastly, run the app with the following command:

```
$ docker run --add-host=host.docker.internal:host-gateway -p 8080:8080 --name spraidmanager-back spraidmanager-0.0.1
```


* Endpoints TODO
