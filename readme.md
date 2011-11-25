# Gradle Jetty JNDI with Embedded H2 Example
This is a simple example of using jndi with gradle's jettyRun plugin. At
my workplace we use JNDI excessively on the serverside (for good reason)
and this was the best way to leverage the jettyRun plugin for local
development. 

## The layout
The build.gradle is documented and basically does the following:

* configures jetty to use the config file at src/test/resources/jetty-env.xml
* starts an instance of the H2 server when running jettyRun or jettyWarRun
* defines providedRuntime for the runtime classes needed for jetty's jndi lookups

The file jetty-env.xml configures a single h2 datasource using the tcp
server (so that you can use the interactive console) and runs the init
script at src/test/resources/create.sql.

Have fun!
