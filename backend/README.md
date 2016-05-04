# AVOP.fi backend

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.
Running PostgreSQL is needed to host data.

[1]: https://github.com/technomancy/leiningen

## Configuration

Before running application needs configuration. App follows (some) principles of [12 factor application][1] development that advises to use environment variables to configure application (see stuff [about config][2]). To set env variables in local dev environment create `profiles.clj` with proper database configuration. Use `profiles_tpl.clj` as a starting point.

[1]: http://12factor.net
[2]: http://12factor.net/config

Database config looks like this:
```clojure
{
    ;; ...other stuff
    :database-url "jdbc:postgresql://mydbhost/avopfi?user=avopfi&password=avopfi"
}
```
**Note!!!**

To be able to map HAKA user creds to schools, app needs one DB entry to it's `organization_mappings` table after DB tables are created in the first migration (see next section). Currently this row needs to be inserted by hand. **TODO:** create a script.

| id | domain | code
| ---- | ---- | ----
| 1 | yliopisto.fi | 10065


## Running

To start a web server for the application, run:

    $ lein run

You can also start application from REPL by running first `lein repl` and then `(start)` in the REPL.

**Note:** database migrations are executed in ring handler's init at startup.

### Deploying

Application supports uberjars with embedded Jetty, but if there's a need to use AJP protocol with Tomcat + Shibboleth, compile uberwar:

    $ lein uberwar  
    $ cp target/avopfi.war /my/tomcat/webapps/dir

For the reference this is an example how uberjar with proper env variables is created. You must provide every required environment variable to Tomcat if uberwar is used. See current profiles_tpl.clj for reference of environment variables.

```shell
$ # Note: use Tomcat in production
$ java -Dis-dev="true" -Dvirta-tunnus="avopfi" \
    -Dvirta-jarjestelma="avopfi" -Dvirta-salaisuus="salaisuus" \
    -Dvirta-url="http://virtawstesti.csc.fi/luku/opiskelijatiedot.wsdl" \
    -Dopintopolku-base-url="https://testi.virkailija.opintopolku.fi/" \
    -Darvo-api-url=http://avoptest.csc.fi/api/ \
    -Darvo-answer-url=http://avopvastaustest.csc.fi/ \
    -Ddatabase-url="jdbc:postgresql://192.168.99.100/avopfi?user=avopfi&password=avopfi" \
    -jar avopfi.jar
```

## Testing

Run unit tests

    $ lein test

Run integration tests

    $ lein test :integration

Integration tests are marked with `^:integration` metadata.

## About authentication

Production setup is using Apache + Shibboleth NativeSP, uberwar (see section Deploying) deployed
to Tomcat and AJP protocol between Apache and Tomcat.

If the real Apache Shibboleth NativeSP proxy is not used, there's a
possibility to spoof Shibboleth auth headers in dev mode with browser
plugin.

| Header | Example value |
| ---- | ---- |
| shib-national-identification-number | 010280-123A |
| shib-home-organization | yliopisto.fi |  

## About generated VIRTA classes

`wsimport` tools was used to generated Java files from VIRTA WS.

    $ wsimport -s src/java/ -keep -Xnocompile -p fi.csc.virta src/java \
      http://virtawstesti.csc.fi/luku106/opiskelijatiedot.wsdl

## License

Copyright © 2016 CSC
