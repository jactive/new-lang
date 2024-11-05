#define PTR char*
#include <iostream>
#include <typeinfo>

using namespace std;

typedef char* ptr;

int main(void) {
  ptr a, b;
  PTR c, d;

  cout << "a's typeid name " << typeid(a).name() << endl;
  cout << "b's typeid name " << typeid(b).name() << endl;
  cout << "c's typeid name " << typeid(c).name() << endl;
  cout << "d's typeid name " << typeid(d).name() << endl;
}
