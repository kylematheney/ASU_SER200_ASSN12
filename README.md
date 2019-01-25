# ASU_SER200_ASSN12
Assignment 12 at ASU (SER 200)
In this project, you will be implementing a railroad yard simulation program. The user will provide a set of incoming cars, and then a desired outgoing order. Your program will determine if the given incoming cars can be rearranged to the desired outgoing order or not. [50 points]

Background: This is an example of a control/management system: in order to deliver specific resources to specific destinations, we have to guarantee that those resources are available at their destinations. Consider: the easiest car to detact from a train transporting materials is the back most one. Thus, it would ideal to arrange the train's cars in such a way that the order of destinations visited, matches the order of the cars. If the required car is in the middle of the train, there will be trouble! Our goal is to address this by trying to arrange the cars into the order of the destinations they will visit ("desired outgoing order").


Problem: Imagine that the rail yard looks like this:

Incoming cars                                                    Outgoing cars (based on destination order)

>----------------------------------------------------------------------------------->

A B C D E                                                         E D C B A

>-----------------------------\                 /----------------------------------->
                                \             /
                                 |           |
                                 |           |
                                 |           |
                                 |           |
                                 |           |

                                                                       ----------------
                                  Waiting Line


In this example, the incoming cars come in the order E, D, C, B and A. The desired outgoing order (since the track moves only to the right) is A, B, C, D and E. Our program considers the first incoming car, vs the desired outgoing car. Since E != A, E must go into the waiting line. Now our program will consider both the car at the top of the waiting line (since it is blocking all the others cars) as well as the incoming car each time. Again, E != A but also D != A, so D gets put in the waiting line, blocking E in the process. This will continue until A is the only car left in the incoming line, and it will be sent out. This leaves nothing incoming, but B would be the top car in the waiting line. Since B == B, B gets taken from the waiting line and sent out. This will repeat until all cars are gone, meaning the input was successfully matched to the output. An example that does NOT match is UGTA to AGTU. A, T and G would go into the waiting line. U would be sent out, but then the next required outgoing car is T. There would be nothing left in the incoming line, and the top car in the waiting line would be G. So, the match fails.

Program Features:

You must take in incoming cars from the user until they input "DONE".
You must take in outgoing cars from the user until they have given as many cars as they did in step 1.
You must print out whether or not the given input cars can be matched to the given output.
Java API Usage Requirements:

You may import the following packages: Scanner, Stack, Queue, LinkedList. No other packages are allowed.
For LinkedList, you may only use it via Queue interface. Your program must not use lists directly but instead rely on stacks and queues.
When using the Queue collection, use only the following methods: add, remove, peek, isEmpty, size.
When using the Stack collection, use only the following methods: push, pop, peek, isEmpty, size.
Requirements and Notes:

Don't use arrays to store trains and move cars. Use stack(s) and queue(s).
You may not ask the user to specify the number of cars ahead of time.
The user must provide at least one incoming car. Print a message if they don't and then allow the user to type in incoming cars again.
"Cars" is a loose term. The user should be allowed to type in anything as a car. An example of three incoming cars might be: A, honda, 10101
You may not reorder the incoming, outgoing or waiting line.
Cars cannot go from the waiting line back to the incoming line.
You do not need to verify that the user typed in the same outgoing items as incoming. (i.e. They said the only incoming car is A and the only outgoing one is B. Your program should report that it cannot be matched, but you do not need to display a special error message or anything else)
Make sure you test your program thoroughly. You are encouraged to use the provided examples, but you should verify that your program works with several of your own examples.
Sample Outputs:

Sample 1

HW12 sol output1

Sample 2

HW12 sol output2

Sample 3

HW12 sol output3

Give this problem some thought. Spend some time, a day or two, thinking through this problem before posting questions about it in the discussion board. The directions are not as direct cut as previous programming assignments, but all the information you need to solve this problem has been provided. 

In addition, don't jump straight to implementation. The first step is understand the problem thoroughly - spend time on it without opening an IDE. Try to run an example on a piece of paper. Forget about input/output, arrays, etc. Just focus on the problem. Once you have a grasp on the problem, then turn to implementation.


Submission Process: The file/class containing your main method MUST be named LastNameRailroad.java. You may create other files as you see fit. Please zip all of your source code (.java) files together as "LastNameProject.zip" (e.g. " BaronProject.zip"). Be sure that you use the correct compression format - if you do not use the right format, we may be unable to open your submission. Do NOT include your project files.

