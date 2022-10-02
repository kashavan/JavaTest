This application allows users to concurrently upload bulk data sets, insert data records and query for stocks. It utilizes Spring Boot, Java and MySQL.
The stock data will be saved in a database called stockentrydata which is a MySQL databse on local host, port 3306.

Note: All text file and JSON formats are according to the files provided in stocks-api.zip

Steps to start Application:
	1. Navigate to src/main/java -> com.rbc.javatest -> RBCJavaTest.
	2. Right click on RBCJavaTest and run as Java application
	3. Go to an API platform like Post Man and you can upload bulk data sets, insert data records and query for stocks using the REST APIs and steps 
	   below:

To upload a bulk data set, users would POST to the REST API: http://localhost:6666/stockdata/uploadDataSet and provide the data set in the body 
 (in text format).
To upload a data record, users would POST to the REST API: http://localhost:6666/stockdata/uploadDataRecord and provide the data record in the body
 (in JSON format).
To query for a stock, users would initiate a GET request to the REST API: http://localhost:6666/stockdata/queryStock/{stockticker} and provide the
stock ticker that they would like to query as part of the URL.

Steps to run JUnit Test:
	1. Navigate to src/test/java -> com.rbc.javatest -> RBCJavaTestApplicationTests
	2. Right click on RBCJavaTestApplicationTests and run as JUnit Test