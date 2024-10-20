#include <iostream>

using namespace std;

int main(void) {
   char c = 'H';
   void* vp = &c;
   *((char*) vp) = 'I';

   int i = 9;
   vp = &i;
   // the cast (int*)vp takes the void* and
   // tells the compiler to treat it as an int*
   // Thus vp can be successfully dereferenced
   *((int*) vp) = 10;

   float f = 3.14;
   vp = &f;
   *((float*) vp) = 4.14;

   double d = 3.14159;
   vp = &d;
   *((double*) vp) = 4.14159;

   cout << "c, " << c << endl;
   cout << "i, " << i << endl;
   cout << "f, " << f << endl;
   cout << "d, " << d << endl;
}
