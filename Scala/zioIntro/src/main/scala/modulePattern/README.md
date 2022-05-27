## Module Pattern:

Module pattern is how we define services in zio.

**What is service?** <BR>
A service is a group of functions that deals with only one concern. 
Keeping the scope of each service limited to a single responsibility
helps in development, debugging and maintenance of the codebase.

In the functional Scala as well as in object-oriented programming 
the best practice is to Program to an Interface, Not an Implementation. 
This is the most important design principle in software development 
and helps us to write maintainable code.

It is not mandatory but ZIO encourages us to follow this
principle by bundling related functionality as an interface 
by using _Module Pattern_.

Just like in object-oriented programming:
<UL>
<LI>
<B>Service Definition</B>> is done by using interfaces (Scala trait or Java Interface).
<LI>
<B>Service Implementation</B> is done by implementing interfaces using classes or creating new object of the interface.
<LI>
<B>Defining Dependencies</B> is done by using constructors. They allow us to build classes, give their dependencies. This is called constructor-based dependency injection. <BR> <BR>
</UL>

We have a similar analogy in Module Pattern, 
except instead of using constructors for defining dependencies, 
we use ZLayer to define dependencies. 
So in ZIO fashion, we can think of ZLayer as a service constructor.


This module has two folders namely- version1 and version2.
These are two different ways of creating and using module pattern.

Note: <BR>
<ol>
<li>
Writing services with Module Pattern 2.0 is much easier than v1. 
It removes some level of indirection from version1, 
and is much more similar to the object-oriented approach for writing services.
</li>



</ol>
