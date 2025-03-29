# java-http-client-demo (Java HttpClient exception handling)
Demonstrates automatic establishment of new connections by HttpClient on exceptions during interactions with server.

## Command
```console
./gradlew clean test
```

## Logging samples

### For HttpTimeoutException
See [related code](https://github.com/haqer1/java-http-client-demo/blob/7902a47f6a4eea7f7e715fdd13d970fff4cf717f/app/src/test/java/com/adazes/java/net/http/client/JavaHttpClientExceptionHandlingUnitTest.java#L140).
```text
01:20:33.337 [Test worker] DEBUG c.a.j.n.h.c.JavaHttpClientExceptionHandlingUnitTest - WireMock pre-configured for TIMEOUT (30 seconds).
01:20:33.525 [qtp468950278-32] DEBUG o.e.jetty.server.HttpConnection - New HTTP Connection HttpConnection@1ef07399::NetworkTrafficSocketChannelEndPoint@2f1a9f8c[{l=/127.0.0.1:39383,r=/127.0.0.1:33270,OPEN,fill=-,flush=-,to=84/30000}{io=0/0,kio=0,kro=0}]->[<null>]
...
01:21:03.379 [qtp468950278-32] DEBUG o.e.jetty.server.HttpConnection - New HTTP Connection HttpConnection@4bca0415::NetworkTrafficSocketChannelEndPoint@541180b[{l=/127.0.0.1:39383,r=/127.0.0.1:54296,OPEN,fill=-,flush=-,to=0/30000}{io=0/0,kio=0,kro=0}]->[<null>]
...
01:21:03.443 [Test worker] DEBUG c.a.j.n.h.c.JavaHttpClientExceptionHandlingUnitTest - Making assertions & exiting from TIMEOUT test.
01:21:03.452 [Test worker] DEBUG c.a.j.n.h.c.JavaHttpClientExceptionHandlingUnitTest - All URLs before supplementary assertion: [http://localhost:39383/first, http://localhost:39383/first]
...
```

### For IOException (testable on Linux (not tested on Windows & Mac))
See [related code](https://github.com/haqer1/java-http-client-demo/blob/7902a47f6a4eea7f7e715fdd13d970fff4cf717f/app/src/test/java/com/adazes/java/net/http/client/JavaHttpClientExceptionHandlingUnitTest.java#L95).
```text
01:21:04.052 [Test worker] DEBUG c.a.j.n.h.c.JavaHttpClientExceptionHandlingUnitTest - WireMock pre-configured for RESET.
01:21:04.060 [qtp580979398-45] DEBUG o.e.jetty.server.HttpConnection - New HTTP Connection HttpConnection@410ae71c::NetworkTrafficSocketChannelEndPoint@45357be5[{l=/127.0.0.1:38429,r=/127.0.0.1:51588,OPEN,fill=-,flush=-,to=1/30000}{io=0/0,kio=0,kro=0}]->[<null>]
...
01:21:04.137 [qtp580979398-47] DEBUG o.e.jetty.server.HttpConnection - New HTTP Connection HttpConnection@668e30ce::NetworkTrafficSocketChannelEndPoint@6849d26f[{l=/127.0.0.1:38429,r=/127.0.0.1:51598,OPEN,fill=-,flush=-,to=0/30000}{io=0/0,kio=0,kro=0}]->[<null>]
...
01:21:04.165 [Test worker] DEBUG c.a.j.n.h.c.JavaHttpClientExceptionHandlingUnitTest - Making assertions & exiting from RESET test.
...
01:21:04.174 [Test worker] DEBUG c.a.j.n.h.c.JavaHttpClientExceptionHandlingUnitTest - All URLs before supplementary assertion: [http://localhost:38429/first, http://localhost:38429/first]
```
