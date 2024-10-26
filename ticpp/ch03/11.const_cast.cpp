#include <iostream>

using namespace std;

int main(void) {
  const int i = 3;
  //! int* x = &i;
  const int* y = &i;
  int* j = const_cast<int*>(&i);
  (*j) ++;
  cout << "i = "  << i  << endl;
  cout << "*j = " << *j << endl;
}
