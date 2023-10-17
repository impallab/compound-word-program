# compound-word-program 

The program uses a trie to store and search words. A trie is a tree where each node has a map of child nodes for each character. A node also has a flag to mark the end of a word. The program reads words from two files, sorts them by length, and checks if they are compound words by finding smaller words in the files. The program prints the longest and second longest compound words and the time taken for each file.

# Steps to  run the program 
1) open terminal 
2) move to the compound-word-program directory
3) compile the Solution.java file to class files by typing :-->  javac Solution.java  
4) run the program by typing :--> java Solution

# Output :

File:=> input_01.txt
Longest compound word is :=> ratcatdogcat
Second longest compound word is :=> catsdogcats
Time taken :=> 0.0071093 sec
File:=> input_02.txt
Longest compound word is :=> ethylenediaminetetraacetates
Second longest compound word is :=> electroencephalographically
Time taken :=> 0.3076906 sec