#include <cstdio>
#include <iostream>

using namespace std;

int main(void) {
  const int i = 3;
  //! int* x = &i;
  const int* y = &i;
  int* c = const_cast<int*>(&i);
  (*c) ++;
  cout << "i = "  << i  << endl;
  cout << "*c = " << *c << endl;

  int* z = (int*) &i; // directly cast, deprecated
  (*z) ++;
  cout << "i = "  << i  << endl;
  cout << "*z = " << *z << endl;

  // Modifying i through c and z is undefined behavior, and
  // the results can vary between different compilers and systems.
  //
  // It's generally not recommended to use const_cast or
  // directly cast away const qualifiers, as it can lead to
  // unpredictable results and potential security vulnerabilities.
  printf("&i = %p, c = %p, z = %p\n", &i, c, z);

}
