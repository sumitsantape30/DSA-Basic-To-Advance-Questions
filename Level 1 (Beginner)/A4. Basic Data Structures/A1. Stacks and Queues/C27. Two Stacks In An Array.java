Two Stacks In An Array

1. You are required to complete the code of our TwoStack class. The class should implement LIFO behaviours for two stacks in the same array.
2. Here is the list of functions that you are supposed to complete
    2.1. push1, push2 -> Should accept new data for appropriate stack if there is 
    space available in the underlying array or print "Stack overflow" otherwise.
    2.2. pop1, po2 -> Should remove and return data from appropriate stack if 
    available or print "Stack underflow" otherwise and return -1.
    2.3. top1, top2 -> Should return data from appropriate stack if available or print 
    "Stack underflow" otherwise and return -1.
    2.4. size1, size2 -> Should return the number of elements available in appropriate 
     stack.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1. All fns should be constant in time.
2. Memory should be optimally used i.e. one of the stacks can use more elements in array but overflow should not happen before whole array is used.
Sample Input
5
push1 10
push1 20
push2 30
push2 40
push2 50
push1 60
top1
pop1
top1
pop1
top2
pop2
top2
pop2
top1
pop1
top2
pop2
quit
Sample Output
Stack overflow
20
20
10
10
50
50
40
40
Stack underflow
Stack underflow
30
30

