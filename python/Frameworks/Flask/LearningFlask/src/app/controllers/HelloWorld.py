# pip install Flask
# import Flask
from flask import Flask

# creating application using Flask constructor
app = application.get


# decorator for binding the route with controller method
@app.route('/')
def helloWorld():
    return 'Hello World'


# alternatively, thee controller method can be bound with path as:
# app.add_url_rule('/', '/', helloWorld)

if __name__ == '__main__':
    # running the application
    # default host: localhost
    # default port 5000
    app.run()
