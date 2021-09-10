### **Task 2**

##### As monitoring tools were used Jmap and Java VisualVM



1. 
    Heap should be divided to Old and Young generations of equal size, where areas of
    Young generation are in following ratio: 3-Eden, 1-S0, 1-S1

    _Vm options: -XX:NewRatio=1 -XX:SurvivorRatio=3_


2. Heap should be of 512MB and divided to Old and Young generations of equal size,
   where areas of Young generation are in following ratio: 2-Eden, 1-S0, 1-S1

   _Vm options: -Xms512m -Xmx512m -XX:NewRatio=1 -XX:SurvivorRatio=2_

3. Heap should be of 512MB with Old generation of 128MB and Young generation with
   areas in following ratio: 3-Eden, 1-S0, 1-S1

    _Vm options: -Xms512m -Xmx512m -XX:NewSize=384m -XX:SurvivorRatio=3_


4. Heap should be divided to Old generation of 128MB and Young generations with
   areas: Eden of 384MB, S0 of 128MB, S1 of 128MBc
   
    _Vm options: -Xms768m -Xmx768m -XX:NewSize=640m -XX:SurvivorRatio=3_


### **Task 3**

Using first task was thrown "OutOfMemoryError: Java heap" exception 
through creating big objects for small heap. In heap dump i noticed that 
big objects took the most part of heap, so they are the reason of error

### **Task 5**

**Vm options:** _-XX:+UseG1GC -XX:+UseStringDeduplication -XX:+PrintStringDeduplicationStatistics_

   String is immutable class which give us opportunity to use String pool. 
   If we create String object with "" literal, that object will be placed in the pool
   and if pool already have this one, pool will return the link instead of duplication.
   Also if we create String object with "new" we can call intern() to check on duplication.
   But it about compile creation, if we want to create objects in runtime, they will be created in heap.
   String deduplication compares hash of char[] and if finds that they are the same, compares theirs char[] 
   and if they are the same too, return the link on the one, and another will be collected by gc.
   So, in conclusion i could say, that if i know that my application will be have a lot of String duplications
   i would recommend myself to use String deduplication.
   
   