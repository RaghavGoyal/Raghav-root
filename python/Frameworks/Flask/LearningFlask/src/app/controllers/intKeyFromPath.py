"""
    this controller depicts how the integer value can be accepted from the path
"""

from flask import Flask

app = Flask(__name__)


@app.route('/intKey/<int:key>')
def intKey():
    return f'the entered key is: {key}'


if __name__ == '__main__':
    app.run()
