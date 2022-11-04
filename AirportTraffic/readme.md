a file containing daily air traffic data of Budapest airport. The file aims to store information about every outbound flight from Budapest. Each
line of the file contains two strings and an integer number, separated by whitespaces:
- name of the airline that operates the given flight
- destination of the flight
- number of passengers transported by the flight
The airline and the destination (name of a city) do not contain space character. The file is sorted by airline in ascending alphabetical order.
For example, the lines of the given file can be as follows:

  Alitalia Rome 180
  Alitalia Pisa 82
  Germanwings Munich 96
  Germanwings Frankfurt 163
  NorwegianAir Bergen 202
  Wizzair London 184
  Wizzair Frankfurt 83
  Wizzair Lisbon 198
  
 
we read the data from the standard input or from an input file called input.txt
  
we have four tasks:
  Task 1:
    How many flights are there to "Frankfurt"?
  Task 2:
    Which flight has the most passengers?
  Task 3:
    Find the first flight with passengers less than 100.
  Task 4:
    Name the airline with the most total number of passengers. Print out the total number of passengers carried by the airline as well.
