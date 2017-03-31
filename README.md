Group: 
- Joachim Dittman Jepsen
- Mathias Meldgaard Pedersen
- Nikolai Hansen
- Jonathan Egebak Carlsen
----------------------------------------------------------
Exercise3_Sql_Graph

- Setup a MySQL and a Neo4j database respectively.
- Import the data from the social network (endorsement graph https://github.com/HelgeCPH/db_course_nosql/blob/master/social_network/archive_graph.tar.gz) into a Neo4J database and into a MySQL database repectively.
- Construct queries in SQL and in Cypher, which find
- all persons that a person endorses, i.e., endorsements of depth one.
- all persons that are endorsed by endorsed persons of a person, i.e., endorsements of depth two.
- endorsements of depth three.
- endorsements of depth four.
- endorsements of depth five.
- Write a Java program that executes the above queries for twenty random nodes against the two respective databases.
-Extend your Java program, so that it measures the execution times of each query, i.e., you run a benchmark for the two databases.
- You collect your measurement results and present them with an evaluation of your experiment in a Markdown file on your Github account. That is, you hand in this assignment via Github, with one hand-in per group.
- Present the execution time of each query each of the 20 random nodes/persons per database.
- Present the average and the median runtime of each of the queries per database.
- Push your solution, source, code, and presentation of the results to a Github repository per group and inform Helge about that.

