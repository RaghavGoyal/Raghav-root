class Query:

    def dropTable(self, tableName):
        return f"DROP TABLE IF EXISTS {tableName}"

    def createTable(self, tableName):
        query = f"""
        CREATE TABLE {tableName} (
            id INTEGER PRIMARY KEY, string TEXT, number INTEGER
        )
        """

        return query

    def insertRow(self, tableName, strValue, numValue):
        query = f"""
        INSERT INTO {tableName} (string, number) VALUES ('{strValue}', {numValue})
        """
        return query

    def countRows(self, tableName):
        query = f"""
        SELECT COUNT(*) FROM {tableName}
        """
        return query

    def selectAll(self, tableName):
        query = f"""
        SELECT * FROM {tableName}
        """
        return query
