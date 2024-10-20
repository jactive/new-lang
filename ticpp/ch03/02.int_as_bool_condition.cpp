#include <iostream>

using namespace std;

int main(void) {
  cout << "use 0, 1, 2 in if-condition" << endl;
  for (int i=0; i< 3; i++) {
    if (i) {
      cout << "hello i, " << i << endl;
    }
  }
}
