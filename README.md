# Inspiration API

An experimental API designed to improve my own skills at using both [Scala](https://www.scala-lang.org/) and the [Play Framework](https://www.playframework.com/).

<img src="http://menschworks.org/wp-content/uploads/2017/12/Inspiration.jpg"/>

## Running Locally

The service depends on the use of [SBT](https://www.scala-sbt.org/). 

To run the service locally:
- In one terminal run the command `sbt run`
- In another terminal curl the inspiration endpoint: `curl localhost:9000/inspiration`

A basic html page is provided at the index route if you load up `localhost:9000` in a browser you will see instructions for the available endpoints

## Available Endpoints

GET
/inspiration - returns a single string containing a random quote featuring the author.
