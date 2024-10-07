The most fundamental tool for breaking a program up into pieces is the ability to create named subroutines or subprograms. In C and C++, a subprogram is called a function, and functions are the pieces of code that can be placed in different files, enabling separate compilation. Put another way, the function is the **atomic unit** of code, since you cannot have part of a function in one file and another part in a different file; `the entire function must be placed in a single file`.

To create a program with multiple files, functions in one file must access functions and data in other files. When compiling a file, the C or C++ compiler must know about the functions and data in the other files, in particular their names and proper usage. The compiler ensures that functions and data are used correctly. This process of “telling the compiler” the names of external functions and data and what they should look like is called **declaration**. Once you declare a function or variable, the compiler knows how to check to make sure it is used properly.

Essentially all C and C++ programs require declarations. Before you can write your first program, you need to understand the proper way to write a declaration.

A declaration introduces a name – an identifier – to the compiler. It tells the compiler “This function or this variable exists somewhere, and here is what it should look like.” 

A definition, on the other hand, says: “Make this variable here” or “Make this function here.” It allocates storage for the name. This meaning works whether you’re talking about a variable or a function; in either case, at the point of definition the compiler allocates storage. For a variable, the compiler determines how big that variable is and causes space to be generated in memory to hold the data for that variable. For a function, the compiler generates code, which ends up occupying storage in memory.

You can declare a variable or a function in many different places, but there must be only one definition in C and C++ (this is sometimes called the ODR: one-definition rule). When the linker is uniting all the object modules, it will usually complain if it finds more than one definition for the same function or variable.

A definition can also be a declaration. If the compiler hasn’t seen the name x before and you define int x;, the compiler sees the name as a declaration and allocates storage for it all at once.
