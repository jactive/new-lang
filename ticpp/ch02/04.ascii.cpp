#include <iostream>

using namespace std;

int main() {
   for (int i=1; i < 256; i++) {
      cout << char(i) << " ";

      if (0 == i % 10) cout << endl;
   }
   cout << endl;
}
