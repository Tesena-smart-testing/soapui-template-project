import groovy.sql.*
def sql = Sql.newInstance('jdbc:mysql://localhost:3306/demo', 'root', 'root', 'com.mysql.jdbc.Driver')  
    sql.eachRow('select * from BLZ_DATA'){ row ->  
        log.info row[0]  
    } 