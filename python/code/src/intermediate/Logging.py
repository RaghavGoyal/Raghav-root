"""
    for enabling logging in the application, import the module `logging`
    it provides 5 levels of logging:
        debug
        info
        warning
        error
        critical
    by default, logging module outputs warning or higher level of logs.
    however, this default behaviour can be customised as needed by using:
        logging.basicConfig(level=logging.INFO)
"""

import logging

if __name__ == '__main__':
    # change the default log level to info:
    # logging.basicConfig(level=logging.INFO)

    # creating a file logger:
    # logging.basicConfig(filename="output.log")

    # creating custom formatted logger:
    # formatter = "%(asctime)s: %(levelname)s: %(funcName)s Line:%(lineno)d %(message)s"
    # logging.basicConfig(
    #     filename= "custom.log",
    #     level= logging.DEBUG,
    #     format= formatter
    # )

    logging.debug('This is debug level log')
    logging.info('This is info level log')
    logging.warning('This is warning level log')
    logging.error('This is error level log')
    logging.critical('This is critical level log')