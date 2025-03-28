# java-http-client-demo (Java HttpClient exception handling)
Demonstrates automatic establishment of new connections by HttpClient on exceptions during interactions with server.

## Command
```console
./gradlew clean test
```

## Logging samples

### For HttpTimeoutException (configured for 30s)
```text
11:04:38.188 [Test worker] DEBUG c.a.j.n.h.c.JavaHttpClientExceptionHandlingUnitTest - WireMock pre-configured for TIMEOUT.
11:04:38.356 [qtp1140202235-32] DEBUG o.e.jetty.server.HttpConnection - New HTTP Connection HttpConnection@6f73e799::NetworkTrafficSocketChannelEndPoint@5ceff12c[{l=/127.0.0.1:37099,r=/127.0.0.1:35198,OPEN,fill=-,flush=-,to=98/30000}{io=0/0,kio=0,kro=0}]->[<null>]
...
11:05:08.228 [qtp1140202235-32] DEBUG o.e.jetty.server.HttpConnection - New HTTP Connection HttpConnection@30c3ff55::NetworkTrafficSocketChannelEndPoint@2e1b33cd[{l=/127.0.0.1:37099,r=/127.0.0.1:47524,OPEN,fill=-,flush=-,to=0/30000}{io=0/0,kio=0,kro=0}]->[<null>]
...
11:05:08.275 [Test worker] DEBUG c.a.j.n.h.c.JavaHttpClientExceptionHandlingUnitTest - Making assertions & exiting from TIMEOUT test.
11:05:08.283 [Test worker] DEBUG c.a.j.n.h.c.JavaHttpClientExceptionHandlingUnitTest - All URLs before supplementary assertion: [http://localhost:37099/first, http://localhost:37099/first]
...
```

### For IOException (testable on Linux (not tested on Windows & Mac))
```text
11:05:08.858 [Test worker] DEBUG c.a.j.n.h.c.JavaHttpClientExceptionHandlingUnitTest - WireMock pre-configured for RESET.
11:05:08.874 [qtp1579015748-45] DEBUG o.e.jetty.server.HttpConnection - New HTTP Connection HttpConnection@39f1f56e::NetworkTrafficSocketChannelEndPoint@3dce7688[{l=/127.0.0.1:33647,r=/127.0.0.1:33458,OPEN,fill=-,flush=-,to=8/30000}{io=0/0,kio=0,kro=0}]->[<null>]
...
11:05:08.918 [qtp1579015748-47] DEBUG o.e.jetty.server.HttpConnection - New HTTP Connection HttpConnection@5710e4::NetworkTrafficSocketChannelEndPoint@339a182c[{l=/127.0.0.1:33647,r=/127.0.0.1:33462,OPEN,fill=-,flush=-,to=0/30000}{io=0/0,kio=0,kro=0}]->[<null>]
...
11:05:08.949 [Test worker] DEBUG c.a.j.n.h.c.JavaHttpClientExceptionHandlingUnitTest - Making assertions & exiting from RESET test.
11:05:08.956 [Test worker] DEBUG c.a.j.n.h.c.JavaHttpClientExceptionHandlingUnitTest - All URLs before supplementary assertion: [http://localhost:33647/first, http://localhost:33647/first]
```
