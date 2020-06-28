from com.training.jython import HttpRequest

httpRequest = HttpRequest()

# httpRequest.normalPrintHello()
# HttpRequest.staticPrintHello()

mapParams = {"name":"Iron Man","age":200}
stringParams = "{\"name\":\"Iron Man\",\"age\":200}"

HttpRequest.POST(mapParams)
HttpRequest.POST(bytearray(stringParams.encode('utf-8')))
HttpRequest.POST(stringParams)
