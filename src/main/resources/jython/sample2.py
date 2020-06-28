from com.training.jython import HttpRequest

class TestRunner:
    def __init__(self):
        print 'init method is called'
        pass

    def before(self):
        print 'before method is called'

    def __call__(self):
        self.before()

        mapParams = {"name":"Iron Man","age":200}
        stringParams = "{\"name\":\"Iron Man\",\"age\":200}"

        HttpRequest.POST(mapParams)

