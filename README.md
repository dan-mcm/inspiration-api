# Inspiration API

An experimental API designed to improve my own skills at using both [Scala](https://www.scala-lang.org/) and the [Play Framework](https://www.playframework.com/).

<img src="https://www.runsociety.com/wp-content/uploads/2012/04/30-Inspirational-Posters-For-Runners-thumb-960x540.jpg"/>

## Running Locally

The service depends on the use of [SBT](https://www.scala-sbt.org/) and [Docker](https://www.docker.com/).

### Docker Setup

Launch a PSQL docker image exposed on port 5432
- `docker-compose up -d`

Setup default tables automatically with provided script
- `psql -h localhost -U user inspiration_db -f dbsetup.sql`

####

Note that the JDBC DB connection requires 2 env vars to be set:

* DB_USER
* DB_PASS

These will vary depending on your local postgres setup.

```scala
val connectionUrl = s"jdbc:postgresql://localhost:5432/inspiration_db?user=${sys.env("DB_USER")}&password=${sys.env("DB_PASS")}"
```

### API Start

- In one terminal run the command `sbt run`
- In another terminal curl the inspiration endpoint: `curl localhost:9000/inspiration`

A basic html page is provided at the index route if you load up `localhost:9000` in a browser you will see instructions for the available endpoints

## Available Endpoints

### GET
/inspiration - returns a single string containing a random quote featuring the author.
```
curl localhost:9000/inspiration
```

### POST
/inspiration - adds post data to postgres DB - requires user to specify author and quote
```
curl -X POST -H 'Content-Type: application/json' -d '{"author": "dmcm", "quote": "quotation of the year"}' localhost:9000/inspiration
```

### PUT
/inspiration - updates data in postgres DB - requires user to specify index, author and quote
```
curl -X PUT -H 'Content-Type: application/json' -d '{"index": 5, "author": "dmcm", "quote": "quotation of the year"}' localhost:9000/inspiration
```

### DELETE
/inspiration/:index - deletes entry from postgres DB - requires user to specify index within url
```
curl -X DELETE localhost:9000/inspiration/6
```

## Docker
The service can be run from a Docker container:

```
# build and tag image locally
docker build -t inspiration_api:v1 .

# port forwarding Docker to localhost:9000
docker run -ti -p 9000:9000 --network="host" <docker-image-id>

# publish docker image to docker hub
docker push <docker-repo>
```
