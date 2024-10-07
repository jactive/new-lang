The most fundamental tool for breaking a program up into pieces is the ability to create named subroutines or subprograms. In C and C++, a subprogram is called a function, and functions are the pieces of code that can be placed in different files, enabling separate compilation. Put another way, the function is the **atomic unit** of code, since you cannot have part of a function in one file and another part in a different file; `the entire function must be placed in a single file`.


To create a program with multiple files, functions in one file must access functions and data in other files. When compiling a file, the C or C++ compiler must know about the functions and data in the other files, in particular their names and proper usage. The compiler ensures that functions and data are used correctly. This process of “telling the compiler” the names of external functions and data and what they should look like is called **declaration**. Once you declare a function or variable, the compiler knows how to check to make sure it is used properly.

Essentially all C and C++ programs require declarations. Before you can write your first program, you need to understand the proper way to write a declaration.

A declaration introduces a name – an identifier – to the compiler. It tells the compiler “This function or this variable exists somewhere, and here is what it should look like.”

A definition, on the other hand, says: “Make this variable here” or “Make this function here.” It allocates storage for the name. This meaning works whether you’re talking about a variable or a function; in either case, at the point of definition the compiler allocates storage. For a variable, the compiler determines how big that variable is and causes space to be generated in memory to hold the data for that variable. For a function, the compiler generates code, which ends up occupying storage in memory.

You can declare a variable or a function in many different places, but there must be only one definition in C and C++ (this is sometimes called the ODR: one-definition rule). When the linker is uniting all the object modules, it will usually complain if it finds more than one definition for the same function or variable.

A definition can also be a declaration. If the compiler hasn’t seen the name x before and you define int x;, the compiler sees the name as a declaration and allocates storage for it all at once.

There is a significant difference between C and C++ for functions with empty argument lists. In C, the declaration:
  int func2();
means "a function with any number and type of argument." This prevents type-checking, so in C++ it means "a function with no arguments."

A variable declaration tells the compiler what a variable looks like. It says, “I know you haven’t seen this name before, but I promise it exists someplace, and it’s a variable of X type.”

The keyword *extern* means the definition is external to the file, or that the definition occurs later in the file. Declaring a variable without defining it means using the extern keyword before a description of the variable, like this:
  extern int a;
extern can also apply to function declarations. For func1( ), it looks like this:
  extern int func1(int length, int width);
This statement is equivalent to `int func1(int, int);` declarations. Since there is no function body, the compiler must treat it as a function declaration rather than a function definition. The extern keyword is thus superfluous and optional for function declarations. It is probably unfortunate that the designers of C did not require the use of extern for function declarations; it would have been more consistent and less confusing (but would have required more typing, which probably explains the decision).

A header file is a file containing the external declarations for a library.

The programmer who creates the library provides the header file. To declare the functions and external variables in the library, the user simply includes the header file.

\#include <header> cause the preprocessor to search for the file in the "include search path" specified in your environment or on the compiler command line. The mechanism for setting the search path varies between machines, operating systems, and C++ implementations, and may require some investigation on your part.

\#include "local.h" tell the preprocessor to search for the file relative to the current directory. If the file is not found, then the include directive is reprocessed as if it had angle brackets instead of quotes.

\#include <iostream.h> => \#include <iostream>
\#include <stdio.h> => \#include <cstdio>

To use a library:
  Include the library’s header file.
  Use the functions and variables in the library.
  Link the library into the executable program.

C effectively has a single arena where all the identifier and function names live, this means that all the developers must be careful not to accidentally use the same names in situations where they can conflict. This rapidly becomes tedious, time-wasting, and, ultimately, expensive.

`using namespace std;` means that you want to expose all the elements from the namespace called std. After this statement, you don’t have to worry that your particular library component is inside a namespace, since the using directive makes that namespace available throughout the file where the using directive was written.

Exposing all the elements from a namespace after someone has gone to the trouble to hide them may seem a bit counterproductive, and in fact you should be careful about thoughtlessly doing this (as you’ll learn later in the book). However, the using directive exposes only those names for the **current** file, so it is not quite as drastic as it first sounds.

\#include <iostream.h>
 means
\#include <iostream>
using namespace std;

In C, text inside double quotes (like "hello") is called a "string." However, the Standard C++ library has a powerful class called string for manipulating text. In C++, a precise term for "hello" is called **character array**.


