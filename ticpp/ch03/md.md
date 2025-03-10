When declaring and defining a function, you must use a description of the types of arguments, called function prototyping. When the function is called, the compiler uses the prototype to ensure that the proper arguments are passed in and that the return value is treated correctly. If the programmer makes a mistake when calling the function, the compiler catches the mistake.

Essentially, function prototyping is called function declaration (without naming it as such) in ch02. In a function prototype, the argument list contains the types of arguments that must be passed to the function and (optionally for the declaration) identifiers for the arguments. The order and type of the arguments must match in the declaration, definition, and function call.
  * int translate(float x, float y, float z);
  * int translate(float, float, float);
Since the compiler doesn’t do anything but check for types when the function is called, the identifiers are only included for **clarity** when someone is reading the code.

If you have an empty argument list, you can declare it as func( ) in C++, which tells the compiler there are exactly zero arguments.
In C func( ) means “an indeterminate number of arguments (which is a “hole” in C since it disables type checking in that case).
In both C and C++, the declaration func(void); means an empty argument list.

A variable argument list is represented by ellipses (...). The uncertainty of variable argument list disables the error checks of function prototyping. Because of this, you should restrict your use of variable argument lists to C and avoid them in C++ (in which, as you’ll learn, there are much better alternatives).

Quirk. **Unamed function argument**.  In C++, an argument may be unnamed in the argument list of the function definition. Since it is unnamed, you cannot use it in the function body, of course. Unnamed arguments are allowed to give the programmer a way to “reserve space in the argument list.” Whoever uses the function must still call the function with the proper arguments. However, the person creating the function can then use the argument in the future without forcing modification of code that calls the function. This option of ignoring an argument in the list is also possible if you leave the name in, but you will get an annoying warning message about the value being unused every time you compile the function. The warning is eliminated if you remove the name.

A C++ function prototype must specify the return value type of the function (in C, if you leave off the return value type it defaults to int).


Many compilers include a lot of extra functions that make life even easier and are tempting to use, but are not part of the Standard C library. If you are certain you will never want to move the application to another platform (and who is certain of that?), go ahead - use those functions and make your life easier. If you want your application to be **portable**, you should restrict yourself to Standard library functions. If you must perform platform-specific activities, try to **isolate that code in one spot** so it can be changed easily when **porting to another platform**. In C++, **platform-specific activities are often encapsulated in a class**, which is the ideal solution.

In C, an expression is "true" if it evaluates to a nonzero value. Other conditional operators are >, <, >=, etc.

A switch statement selects from among pieces of code based on the value of an integral expression. Its form is:
switch(selector) {
    case integral-value1 : statement; break;
    case integral-value2 : statement; break;
    case integral-value3 : statement; break;
    case integral-value4 : statement; break;
    case integral-value5 : statement; break;
    (...)
    default: statement;
}
Selector is an expression that produces an integral value. The switch compares the result of selector to each integral value. If it finds a match, the corresponding statement (simple or compound) executes. If no match occurs, the default statement executes.

bool is short for “Boolean,” which is a type you’ll find only in C++. It can have only the keyword values true or false.

Use goto to break multiple layer loops, but why to create multi-layer loop?
An example that might make a plausible candidate to use goto
```java
//: C03:gotoKeyword.cpp
// The infamous goto is supported in C++
#include <iostream>
using namespace std;

int main() {
  long val = 0;
  for(int i = 1; i < 1000; i++) {
    for(int j = 1; j < 100; j += 10) {
      val = i * j;
      if(val > 47000)
        goto bottom;
        // Break would only go to the outer 'for'
    }
  }
  bottom: // A label
  cout << val << endl;
} ///:~
```
The alternative would be to set a Boolean that is tested in the outer for loop, and then do a break from the inner for loop. However, if you have several levels of for or while this could get awkward.


Data types define the way you use memory in the programs you write. By specifying a data type, you tell the compiler how to create a particular piece of storage, and also how to manipulate that storage.

Data types can be built-in or abstract. A built-in data type is one that the compiler intrinsically understands, one that is wired directly into the compiler. The types of built-in data are almost identical in C and C++. In contrast, a user-defined data type is one that you or another programmer create as a class. These are commonly referred to as abstract data types. The compiler knows how to handle built-in types when it starts up; it “learns” how to handle abstract data types by reading header files containing class declarations.

The Standard C specification for built-in types (which C++ inherits) doesn’t say how many bits each of the built-in types must contain. Instead, it stipulates the minimum and maximum values that the built-in type must be able to hold. When a machine is based on binary, this maximum value can be directly translated into a minimum number of bits necessary to hold that value. However, if a machine uses, for example, binary-coded decimal (BCD) to represent numbers, then the amount of space in the machine required to hold the maximum numbers for each data type will be different. The minimum and maximum values that can be stored in the various data types are defined in the system header files limits.h and float.h (in C++ you will generally #include <climits> and <cfloat> instead).

Specifiers modify the meanings of the basic built-in types. There are four specifiers: long, short, signed, and unsigned. When you are modifying an int with short or long, the keyword int is optional, as shown above.
  * long unsigned int;

```
  int a = 47;
  int* ipa = &a;
  // dereference the pointer with * that is used to define the pointer
  *ipa = 100;
```
pass-by-value
pass-by-address pointers
pass-by-reference
```
  void f(int& r) {
    r = 5;
  }
  ...

  int main(void) {
    int a = 47;
    f(a); // Looks like pass-by-value,
          // is actually pass by reference
  }
```

The difference between references and pointers is that calling a function that takes references is cleaner, syntactically, than calling a function that takes pointers (and it is exactly this syntactic difference that **makes references essential in certain situations**).

If you state that a pointer is a void*, it means that any type of address at all can be assigned to that pointer (whereas if you have an int*, you can assign only the address of an int variable to that pointer).

Once you assign to a void\* you lose any information about what type it is. This means that before you can use the pointer, you must cast it to the correct type.

In general, void pointers should be avoided, and used only in rare special cases, the likes of which you won’t be ready to consider

If the existence of a global variable in one file is declared using the extern keyword in another file, the data is available for use by the second file. 


static specifier
