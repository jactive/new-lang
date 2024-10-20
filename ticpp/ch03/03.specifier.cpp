#include <iostream>

using namespace std;

int main(void) {
  long unsigned lu;
  unsigned long ul;
  long unsigned int lui;
  unsigned long int uli;

  cout
    << "char = " << sizeof(char) << " bytes" << endl
    << "unsigned char = " << sizeof(unsigned char) << endl
    << "int = " << sizeof(int) << endl
    << "unsigned int = " << sizeof(unsigned int) << endl
    << "short = " << sizeof(short) << endl
    // When modifying an int with short or long, the keyword int is optional
    << "short int = " << sizeof(short int) << endl
    << "unsigned short = " << sizeof(unsigned short) << endl
    << "unsigned short int = " << sizeof(unsigned short int) << endl
    << "long = " << sizeof(long) << endl
    << "long int = " << sizeof(long int) << endl
    << "unsigned long int = " << sizeof(unsigned long int) << endl
    << "float = " << sizeof(float) << endl
    << "double = " << sizeof(double) << endl
    << "long double = " << sizeof(long double) << " bytes"
    << endl;
}
