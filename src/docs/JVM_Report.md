# Class Loader

The Class Loader is a part of the JVM. It is responsible for loading .class files into memory when they are needed. 
It follows a hierarchical delegation model where it first asks the parent loader to load a class before attempting to load it itself. 
The class loading process consists of Loading, Linking (Verification, Preparation, Resolution), and Initialization. 
This mechanism allows Java to load classes dynamically at runtime instead of loading everything at startup.

# Runtime Data Areas

1. Heap

The Heap is the runtime memory area where all objects and arrays are stored. 
It is shared among all threads in the application and is managed by the Garbage Collector (GC). 
Since most object creation happens here, the heap is typically the largest memory area in a Java application.

2. Stack

Each thread has its own Stack, which stores method call information in the form of stack frames. 
A frame contains local variables, method parameters, return values, etc. 
Whenever a method is called, a new frame is pushed onto the stack, and it is removed when the method completes.

3. Method Area

The Method Area is a shared memory region that stores class-level information such as class metadata, 
method definitions, static variables, etc.

4. PC Register

The PC Register is a small memory area that exists separately for each thread. 
It stores the address of the current JVM instruction being executed. When a thread is paused and later resumed, 
the PC Register helps the JVM continue execution from the correct instruction.

# Execution Engine

The Execution Engine is the component of the JVM that executes the bytecode loaded into memory. 
It reads bytecode instructions and converts them into machine code that the underlying operating system can understand. 
The execution engine mainly consists of the Interpreter, which executes bytecode line by line, and the Just-In-Time (JIT) Compiler, 
which identifies frequently executed code ("hot spots") and compiles it into native machine code for better performance. 
It also works closely with the Garbage Collector to manage memory efficiently during execution.

# JIT Compiler vs Interpreter

The Interpreter executes Java bytecode line by line, which allows quick startup but slower execution. 
The JIT Compiler identifies frequently executed code and compiles it into native machine code, 
significantly improving performance. Modern JVMs use both together: code is initially interpreted, 
and hot spots are later compiled by the JIT for faster execution.

# Write Once, Run Anywhere

JVM acts as a Runtime engine to run Java applications. JVM is a part
of JRE. JVM is the one that actually calls the main method present
in java code.

In Java unlike other languages, program is not converted to code directly
understood by hardware. It is converted to bytecode which is
interpreted by JVM, so once compiled it generates bytecode file, which
can be run anywhere (on any machine) which has JVM.

This is called Write Once and Run Anywhere.









