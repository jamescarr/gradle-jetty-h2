# simple-gradle-jetty-jndi-example
This is a simple example of using jndi with gradle's jettyRun plugin. At
my workplace we use JNDI excessively on the serverside (for good reason)
and this was the best way to leverage the jettyRun plugin for local
development. 

## The layout
The build.gradle references a jetty configuration used to configure
jndi. In our example I have put an ImmutableMap in JNDI to represet
using it to store objects outside the core java libraries. 90% of the
time we store platform specific DataSources in JNDI but I did not want
to tie the example to any specific platform or implementation.

Note that the gauva jar is listed as providedCompile. This is because
you rarely need to ship jars for classes in JNDI as the server will
provide them for you. 
