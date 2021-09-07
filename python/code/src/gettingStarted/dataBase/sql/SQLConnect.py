import sqlite3
from src.gettingStarted.dataBase.sql.Query import Query


def main():
    print('Connecting to SQL Database...')
    dbHandle = sqlite3.connect('Dummy.db')
    cursor = dbHandle.cursor()
    print('connected.')
    query = Query()
    cursor.execute(query.dropTable('DummyTable'))
    cursor.execute(query.createTable('DummyTable'))
    cursor.execute(query.insertRow('DummyTable', 'Raghav', '12345'))
    cursor.execute(query.insertRow('DummyTable', 'Test', '11111'))
    cursor.execute(query.insertRow('DummyTable', 'Test2', '11112'))
    cursor.execute(query.insertRow('DummyTable', 'Test3', '11113'))
    count = cursor.execute(query.countRows('DummyTable'))
    print(f'count of rows is: {count}')
#     iterating over row:
    for record in cursor.execute(query.selectAll('DummyTable')):
        print(record)


if __name__ == '__main__':
    main()